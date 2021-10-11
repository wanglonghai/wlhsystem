package com.wanglonghai.wlhsystem.controller.manage;

import com.wanglonghai.wlhsystem.entity.common.ResponseData;
import com.wanglonghai.wlhsystem.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/manage/ueditor/")
public class UeditorController {
    @Value("${webappfile.articleImagePath}")
    private String resourceLocation;

    /**
     * 返回给前端ueditor配置用的。
     * @param request
     * @return
     */
    @RequestMapping(value = "/imgUpload2")
    @ResponseBody
    public String imgUpload(HttpServletRequest request) {
        //获取网站根路径
        StringBuffer url = request.getRequestURL();
        String contentPath = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
        //imageUrlPrefix 通过“imageUrlPrefix”与“imagePathFormat”这两个属性去拼凑路径前台上传图片后的回显在内容框
        String config= "{" +
                "\"imageActionName\":\"uploadimage\"," +
                "\"imageFieldName\":\"upfile\"," +
                "\"imageMaxSize\": 2048000," +
                "\"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"]," +
                "\"imageCompressEnable\": true," +
                "\"imageUrlPrefix\": \""+contentPath+"\",\n" +
                "\"imagePathFormat\":\"\""+
                "}";
        return config;
    }
    @RequestMapping(value = "/imgUpload3")
    @ResponseBody
    public String imgUpload3(MultipartFile upfile,HttpServletRequest request) {
        String pictureUri = this.imgUpdate(upfile).getData();
        String config =
                "{\n" +
                        " \"state\": \"SUCCESS\",\n" +
                        "\"url\": \""+pictureUri+"\",\n" +
                        "\"title\": \"path\",\n" +
                        "\"original\": \"path\"\n" +
                        " }";
        return config;
    }
    @RequestMapping(value = "/imgUpdate", produces = "application/json; charset=utf-8" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> imgUpdate(@RequestParam(value = "file") MultipartFile multiFile) {
        if (multiFile.isEmpty()) {
            return ResponseUtils.returnError("文件不能为空");
        }
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        String filePath = resourceLocation;
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multiFile.transferTo(dest);
            System.out.println("图片上传成功路径:"+dest.getAbsolutePath());
            return ResponseUtils.returnSuccess("文件成功",fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseUtils.returnError("文件上传失败","failUpload.jpg");
    }
}

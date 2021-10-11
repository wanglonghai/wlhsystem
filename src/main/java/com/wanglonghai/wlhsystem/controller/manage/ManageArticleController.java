package com.wanglonghai.wlhsystem.controller.manage;

import com.wanglonghai.wlhsystem.entity.WlhArticle;
import com.wanglonghai.wlhsystem.entity.common.LayUIResponseData;
import com.wanglonghai.wlhsystem.entity.common.PageTableFeignResponse;
import com.wanglonghai.wlhsystem.entity.common.ResponseData;
import com.wanglonghai.wlhsystem.entity.vo.WlhArticleDto;
import com.wanglonghai.wlhsystem.service.ArticleService;
import com.wanglonghai.wlhsystem.util.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/manage/article")
@Controller
public class ManageArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/add")
    @ResponseBody
    private ResponseData addArticle(@RequestBody WlhArticle wlhArticle)
    {
        articleService.addArticle(wlhArticle);
        return ResponseUtils.returnSuccess("添加文章成功");
    }
    @PostMapping("/update")
    @ResponseBody
    private ResponseData updateArticle(@RequestBody WlhArticle wlhArticle)
    {
        articleService.updateArticle(wlhArticle);
        return ResponseUtils.returnSuccess("修改文章成功");
    }
    @PostMapping("/list")
    @ResponseBody
    private LayUIResponseData<WlhArticle> listArticle(HttpServletRequest request)
    {
        WlhArticleDto wlhArticleDto=new WlhArticleDto();
        Integer page=1;
        Integer limit=10;
        String pageStr=request.getParameter("page");
        if(!StringUtils.isEmpty(pageStr)){
            page=Integer.parseInt(pageStr);
        }
        String limitStr=request.getParameter("limit");
        if(!StringUtils.isEmpty(limitStr)){
            limit=Integer.parseInt(limitStr);
        }
        wlhArticleDto.setPageNum(page);
        wlhArticleDto.setPageSize(limit);
        PageTableFeignResponse<List<WlhArticle>> response=articleService.selectArticles(wlhArticleDto);
        LayUIResponseData<WlhArticle> layUIResponseData =new LayUIResponseData(response.getMessage(),0,response.getData());
        return layUIResponseData;
    }
}

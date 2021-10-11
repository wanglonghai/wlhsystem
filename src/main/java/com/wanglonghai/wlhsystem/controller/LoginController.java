package com.wanglonghai.wlhsystem.controller;

import com.wanglonghai.wlhsystem.entity.common.ResponseData;
import com.wanglonghai.wlhsystem.entity.vo.LoginUser;
import com.wanglonghai.wlhsystem.util.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    private String login(){
        return "manage/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(@RequestBody LoginUser user,  HttpServletRequest request, HttpSession session){
        //获取用户名和密码
        String username=user.getUserName();
        String password=user.getPassWord();
        //些处横板从数据库中获取对用户名和密码后进行判断
        if(username!=null&&username.equals("wanglonghai")&&password!=null&&password.equals("wlh1314525")){
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION",user);
            //重定向到主页面的跳转方法
            StringBuffer url = request.getRequestURL();
            //String urlStr = url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
            //return "redirect:"+urlStr+"/swagger-ui.html";
            return ResponseUtils.returnSuccess("登录成功");
        }
        return ResponseUtils.returnError("用户名或密码错误，请重新登录！");
    }
}

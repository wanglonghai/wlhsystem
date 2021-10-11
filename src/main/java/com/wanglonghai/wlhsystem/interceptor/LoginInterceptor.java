package com.wanglonghai.wlhsystem.interceptor;

import com.wanglonghai.wlhsystem.entity.vo.LoginUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
/**
 * 本拦截器用于登录微信接口后台管理界面的安全校验
 */
public class LoginInterceptor implements HandlerInterceptor {
 
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
    //获取请求的RUi:去除http:localhost:8080这部分剩下的
    String uri = request.getRequestURI();
    String appid=request.getHeader("appid");
    if (uri.indexOf("/login") >= 0) {
      return true;
    }
    //获取session
    HttpSession session = request.getSession();
    LoginUser user = (LoginUser) session.getAttribute("USER_SESSION");
    //判断session中是否有用户数据，如果有，则返回true，继续向下执行
    if (user != null) {
      return true;
    }
    //不符合条件的给出提示信息，并转发到登录页面
    request.setAttribute("msg", "您还没有登录，请先登录！");
    StringBuffer url = request.getRequestURL();
    String urlStr = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/login").toString();
    response.sendRedirect(urlStr);
    return false;
  }
 
  @Override
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
 
  }
 
  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
 
  }
}
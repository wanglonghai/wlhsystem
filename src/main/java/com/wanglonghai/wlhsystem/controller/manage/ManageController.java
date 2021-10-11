package com.wanglonghai.wlhsystem.controller.manage;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wanglonghai.wlhsystem.entity.WlhArticle;
import com.wanglonghai.wlhsystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/manage")
@Controller
public class ManageController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/frame")
    private String login(){
        return "manage/frame";
    }
    @GetMapping("/tgls/qdAPI.html")
    private String qdAPI(){
        return "manage/tgls/qdAPI";
    }
    @GetMapping("/tgls/iconfont.html")
    private String iconfont(){
        return "manage/tgls/iconfont";
    }
    @GetMapping("/tgls/article/article_add.html")
    private String article_add(@RequestParam(value = "id",required = false) Integer id, Model model){

        if(id!=null){
            WlhArticle wlhArticle=articleService.getArticle(id);
            model.addAttribute("article",wlhArticle);
        }
        return "manage/tgls/article/article_add";
    }
    @GetMapping("/tgls/article/article_list.html")
    private String article_list(){
        return "manage/tgls/article/article_list";
    }

}

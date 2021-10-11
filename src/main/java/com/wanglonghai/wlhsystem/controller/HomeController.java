package com.wanglonghai.wlhsystem.controller;

import com.wanglonghai.wlhsystem.entity.WlhArticle;
import com.wanglonghai.wlhsystem.entity.common.PageTableFeignResponse;
import com.wanglonghai.wlhsystem.entity.vo.WlhArticleDto;
import com.wanglonghai.wlhsystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/")
    private String index(Model model){
        WlhArticleDto pa=new WlhArticleDto();
        pa.setPageSize(4);
        pa.setPageNum(1);
        PageTableFeignResponse<List<WlhArticle>>  result=articleService.selectArticles(pa);
        model.addAttribute("pageCount",result.getPageCount());
        model.addAttribute("articles",result.getData());
        return "index";
    }
    @GetMapping("/index")
    private String index2(Model model){
       return index(model);
    }
    @GetMapping("/about")
    private String aboutme(){
        return "about";
    }
    @GetMapping("/mood")
    private String mood(){
        return "mood";
    }
    @GetMapping("/board")
    private String board(){
        return "board";
    }
    @GetMapping("/goodLife")
    private String goodLife(){
        return "redirect:https://mp.weixin.qq.com/s/IPxrP4UQ0n_5L02yl32Miw";
    }
}

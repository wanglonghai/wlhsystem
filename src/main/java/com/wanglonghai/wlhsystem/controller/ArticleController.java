package com.wanglonghai.wlhsystem.controller;

import com.wanglonghai.wlhsystem.entity.WlhArticle;
import com.wanglonghai.wlhsystem.entity.common.PageTableFeignResponse;
import com.wanglonghai.wlhsystem.entity.common.ResponseData;
import com.wanglonghai.wlhsystem.entity.vo.WlhArticleDto;
import com.wanglonghai.wlhsystem.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/article")
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/{arcticleId}")
    private String getArticle(@PathVariable Integer arcticleId,Model model){
        WlhArticle article=articleService.getArticle(arcticleId);
        if(article.getHits()==null){
            article.setHits(0);
        }
        article.setHits(article.getHits()+1);
        articleService.updateArticle(article);
        model.addAttribute("article",article);
        if(article!=null&& !StringUtils.isEmpty(article.getKeyword())){
            model.addAttribute("keywords", Arrays.asList(article.getKeyword().split(",")));
        }
        return "article_detail";
    }
    @PostMapping("/list")
    @ResponseBody
    private PageTableFeignResponse list(@RequestBody WlhArticleDto dto){
        PageTableFeignResponse<List<WlhArticle>>  result=articleService.selectArticles(dto);
        return result;
    }
}

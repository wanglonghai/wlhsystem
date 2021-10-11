package com.wanglonghai.wlhsystem.service;

import com.wanglonghai.wlhsystem.entity.WlhArticle;
import com.wanglonghai.wlhsystem.entity.common.PageTableFeignResponse;
import com.wanglonghai.wlhsystem.entity.vo.WlhArticleDto;

import java.util.List;

public interface ArticleService {
    PageTableFeignResponse<List<WlhArticle>> selectArticles(WlhArticleDto wlhArticleDto);
    WlhArticle getArticle(Integer id);
    void addArticle(WlhArticle wlhArticle);
    void updateArticle(WlhArticle wlhArticle);
}

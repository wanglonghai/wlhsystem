package com.wanglonghai.wlhsystem.service.impl;

import com.wanglonghai.wlhsystem.dao.WlhArticleMapper;
import com.wanglonghai.wlhsystem.dao.WlhArticleMapperSelf;
import com.wanglonghai.wlhsystem.entity.WlhArticle;
import com.wanglonghai.wlhsystem.entity.common.PageTableFeignResponse;
import com.wanglonghai.wlhsystem.entity.common.ResponseCode;
import com.wanglonghai.wlhsystem.entity.vo.WlhArticleDto;
import com.wanglonghai.wlhsystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private WlhArticleMapperSelf wlhArticleMapperSelf;
    @Autowired
    private WlhArticleMapper wlhArticleMapper;
    @Override
    public  PageTableFeignResponse<List<WlhArticle>> selectArticles(WlhArticleDto wlhArticleDto){
        PageTableFeignResponse pageTableFeignResponse=new PageTableFeignResponse();
        Integer count=wlhArticleMapperSelf.countByParams(wlhArticleDto);
        List<WlhArticle> wlhArticles=null;
        if(count>0){
            wlhArticles=wlhArticleMapperSelf.selectByParams(wlhArticleDto);
        }
        pageTableFeignResponse=new PageTableFeignResponse(count,wlhArticleDto.getPageNum(), wlhArticleDto.getPageSize(),wlhArticles);
        return pageTableFeignResponse;
    }

    @Override
    public WlhArticle getArticle(Integer id) {
        WlhArticle wlhArticle= wlhArticleMapper.selectByPrimaryKey(id);
        return wlhArticle;
    }
    @Override
    public  void addArticle(WlhArticle wlhArticle){
        wlhArticleMapper.insertSelective(wlhArticle);
    }
    @Override
    public void updateArticle(WlhArticle wlhArticle){
        wlhArticleMapper.updateByPrimaryKeySelective(wlhArticle);
    }

}

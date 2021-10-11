package com.wanglonghai.wlhsystem.dao;

import com.wanglonghai.wlhsystem.entity.WlhArticle;
import com.wanglonghai.wlhsystem.entity.vo.WlhArticleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WlhArticleMapperSelf {
    Integer countByParams(WlhArticleDto params);
    List<WlhArticle> selectByParams(WlhArticleDto params);
}
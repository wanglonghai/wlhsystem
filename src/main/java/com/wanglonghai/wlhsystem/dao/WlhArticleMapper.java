package com.wanglonghai.wlhsystem.dao;

import com.wanglonghai.wlhsystem.entity.WlhArticle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WlhArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WlhArticle record);

    int insertSelective(WlhArticle record);

    WlhArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WlhArticle record);

    int updateByPrimaryKeyWithBLOBs(WlhArticle record);

    int updateByPrimaryKey(WlhArticle record);
}
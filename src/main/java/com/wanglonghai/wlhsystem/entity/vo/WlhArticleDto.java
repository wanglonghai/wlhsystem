package com.wanglonghai.wlhsystem.entity.vo;

import com.wanglonghai.wlhsystem.entity.WlhArticle;
import lombok.Data;

import java.util.Date;

@Data
public class WlhArticleDto extends WlhArticle {

    private Date beginPublishTime;
    private Date endPublishTime;

    private String orderBy;
    private Integer pageNum;
    private Integer pageSize;
    private  Integer offset;
    public Integer getOffset() {
        if(getPageSize()!=null&&getPageNum()!=null&&getPageSize()>0&&getPageNum()>0){
            offset=((getPageNum()-1)*getPageSize());
        }
        return offset;
    }
}

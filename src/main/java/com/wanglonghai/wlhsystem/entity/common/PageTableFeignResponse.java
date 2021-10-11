package com.wanglonghai.wlhsystem.entity.common;

/**
 * 分页查询返回
 *
 */
public class PageTableFeignResponse<T> extends ResponseData<T> {

    private static final long serialVersionUID = 620421858510718076L;

    private Integer pageNum;
    private Integer pageSize;
    private Integer pageCount;
    private Integer recordsTotal;
    private Integer recordsFiltered;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public PageTableFeignResponse(){

    }
    public PageTableFeignResponse(Integer recordsTotal, Integer recordsFiltered, String message, Integer code, String remark, T data) {
        super();
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        super.setCode(code);
        super.setMessage(message);
        super.setRemark(remark);
        super.setData(data);
    }
    public PageTableFeignResponse(Integer recordsTotal,Integer pageNum,Integer pageSize,T data){
        super();
        if(pageNum == null || pageNum== 0) {
            pageNum = 1;
        }
        if(pageSize == null || pageSize== 0) {
            pageSize = 10;
        }
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
        super.setData(data);
        super.setCode(ResponseCode.SUCCESS);
        this.pageNum = pageNum;
        this.pageSize = pageSize;

        pageCount = 0;//共有几页
        if(recordsTotal % pageSize > 0){
            pageCount = recordsTotal / pageSize +1;
        }else{
            pageCount = recordsTotal / pageSize;
        }

    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }


}
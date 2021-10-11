package com.wanglonghai.wlhsystem.entity.common;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel(value = "服务调用数据返回")
public class ResponseData<T> {

	//@ApiModelProperty(value = "返回信息")
	private String message;
	//@ApiModelProperty(value = "返回详细信息")
	private String detailMessage;
	//@ApiModelProperty(value = "返回状态码，1请求成功，0请求失败，80000token过期或为空,-10000系统异常,-20000微服务降级")
	private Integer code;
	//@ApiModelProperty(value = "返回详细信息，就是detailMessage")
	private String remark;
	//@ApiModelProperty(value = "返回具体数据")
	private T data;
	
	public ResponseData() {
		super();
	}
	public ResponseData(String message, Integer code, String remark, T data) {
		super();
		this.message = message;
		this.code = code;
		this.remark = remark;
		this.data = data;
		if(code < 0) {
			System.out.println("ResponseData类发现错误信息：[message]-"+message+",[remark]-"+remark);
		}
			
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}

package com.wanglonghai.wlhsystem.entity.common;

import lombok.Data;

import java.util.List;

@Data
public class LayUIResponseData<T> {
	private String msg;
	private Integer code;
	private List<T> data;
	//总记录数
	private Integer count;
	public LayUIResponseData() {
		super();
	}
	public LayUIResponseData(String message, Integer code,List<T> data) {
		super();
		this.msg = message;
		this.code = code;
		this.data = data;
	}
}

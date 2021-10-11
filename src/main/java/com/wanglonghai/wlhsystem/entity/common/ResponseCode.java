package com.wanglonghai.wlhsystem.entity.common;

public class ResponseCode {
	/**
	 * 请求成功
	 */
	public static Integer SUCCESS = 1;
	/**
	 * 请求失败
	 */
	public static Integer FAIL = 0;
	
	/**
	 * 业务异常 BussinessException
	 */
	public static Integer BUSSINESS_EXCEPTION = -30000;
	
	/**
	 * 微服务异常，熔断器返回失败消息
	 */
	public static Integer SERVICE_EXCEPTION = -20000;
	
	/**
	 * 系统异常
	 */
	public static Integer SYSTEM_EXCEPTION = -10000;
	
	//-----------------------具体业务异常 10000-49999---------------start-------------------
	/**
	 * 参数非法
	 */
	public static Integer PARAMS_VALID=10000;
	/**
	 * 认证房源：产权人身份证号和产权人姓名至少输入一个
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_PROPERTY_NAME_NEEDONE=40011;
	/**
	 * 认证房源：房源唯一编号必填
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_HOUSEID_NEED=40012;
	/**
	 *认证房源：产权证号必填
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_PROPERTY_NONULL=40013;
	/**
	 *认证房源：经纪人唯一标识不能为空或0
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_BROKERID_NONULL=40014;
	/**
	 *认证房源：房源 和 经纪人 不对应 ！
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_HOUSEBROKER_NOTMATCH=40015;
	/**
	 *认证房源：房源不存在
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_HOUSE_NOTEXITS=40016;

	/**
	 *认证房源：查询不到该人员所在（公司）机构
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_COMPANYOFBROKER_NOTEXITS=40018;

	/**
	 *认证房源：该产权证号在该机构下已被认证过！
	 */
	public static Integer PARAMS_VALID_AUTHHOUSE_PROPERTY_ISAUTHED=40019;
	/**
	 *系统用户未绑定微信
	 */
	public  static  Integer SYSUSER_NOT_BIND_WEIXIN=40079;

	//-----------------------具体业务异常 10000-49999---------------end-------------------
	
	
	/**
	 * token过期或为空
	 */
	public static Integer TOKEN_EXPIRE_OR_NONE = 80000;
	/**
	 * 当前用户对访问的地址没有权限
	 */
	public static Integer HREF_HAS_NO_AUTH = 80080;
}

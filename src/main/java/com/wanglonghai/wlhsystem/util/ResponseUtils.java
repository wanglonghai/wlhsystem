//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wanglonghai.wlhsystem.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wanglonghai.wlhsystem.entity.common.ResponseCode;
import com.wanglonghai.wlhsystem.entity.common.ResponseData;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class ResponseUtils {
    public ResponseUtils() {
    }
    /**
     * 系统异常返回
     * @param msg
     * @param detailMessage
     * @return
     */
    public static ResponseData returnException(String msg, String detailMessage) {
        ResponseData result = new ResponseData();
        result.setCode(ResponseCode.SYSTEM_EXCEPTION);
        result.setMessage(msg);
        result.setDetailMessage(detailMessage);
        result.setRemark(detailMessage);
        return result;
    }
    public static  ResponseData returnError(String msg,String detailMessage) {
        ResponseData result = new ResponseData();
        result.setCode(ResponseCode.FAIL);
        result.setMessage(msg);
        result.setDetailMessage(detailMessage);
        result.setRemark(detailMessage);
        return result;
    }
    /**
     * 服务降级消息返回
     * @param msg
     * @return
     */
    public static  ResponseData returnHyStrixError(String msg) {
    	ResponseData result = new ResponseData();
    	result.setCode(ResponseCode.SERVICE_EXCEPTION);
    	result.setMessage(msg);
    	return result;
    }

    public static ResponseData returnError(BindingResult bindingResult) {
        ResponseData result = new ResponseData();
        result.setCode(ResponseCode.FAIL);
        result.setMessage(bindingResult.getFieldError().getDefaultMessage());
        return result;
    }

    public static <T> ResponseData returnError(Set<ConstraintViolation<T>> constraintViolations) {
        ResponseData result = new ResponseData();
        result.setCode(ResponseCode.FAIL);
        result.setMessage(((ConstraintViolation)constraintViolations.iterator().next()).getMessage());
        return result;
    }
    
    public static ResponseData returnError(String msg) {
        ResponseData result = new ResponseData();
        result.setCode(ResponseCode.FAIL);
        result.setMessage(msg);
        return result;
    }

    public static ResponseData returnSuccess(String msg) {
        ResponseData result = new ResponseData();
        result.setCode(ResponseCode.SUCCESS);
        result.setMessage(msg);
        return result;
    }

    public static <T> ResponseData<T> returnSuccess(String msg, T object) {
        ResponseData result = new ResponseData();
        result.setCode(ResponseCode.SUCCESS);
        result.setMessage(msg);
        result.setData(object);
        return result;
    }
    public static <T> ResponseData<T> returnSuccess(T object) {
    	ResponseData result = new ResponseData();
    	result.setCode(ResponseCode.SUCCESS);
    	result.setData(object);
    	return result;
    }
}

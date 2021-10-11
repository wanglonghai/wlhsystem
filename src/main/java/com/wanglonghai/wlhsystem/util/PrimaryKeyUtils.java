package com.wanglonghai.wlhsystem.util;

import java.util.Date;

/**
 * Key生成工具
 * @author Damen
 * @Data: Created in 11:58 2019/8/1
 */
public class PrimaryKeyUtils {

    /**
     * 获取key
     * @param preKey 前缀符号
     * @param bitNum 位数
     * @param valNum 位数值
     * @return
     */
    public static String getKey(String preKey,int bitNum,long valNum) {
        return preKey+String.format("%0"+bitNum+"d", valNum);
    }
    public static String getRandom(int bitNum) {
        StringBuffer randomStr = new StringBuffer();
        if(bitNum<=0){
            return randomStr.toString();
        }
        for(int i=0;i<bitNum;i++){
            randomStr.append((int)(1+Math.random()*10)-1);
        }
        return randomStr.toString();
    }

    public static void main(String[] args) {
        String str =  "C"+DateUtil.format(new Date(),"yyyyMMddHHmmssSSS");
        System.out.println(str);
    }
}

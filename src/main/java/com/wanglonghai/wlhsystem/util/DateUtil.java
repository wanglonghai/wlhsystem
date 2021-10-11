package com.wanglonghai.wlhsystem.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
//	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	private static SimpleDateFormat dateFormatYMD = new SimpleDateFormat("yyyyMMdd");
//	private static SimpleDateFormat dateFormatYMDHMS = new SimpleDateFormat("yyyyMMddhhmmss");
	
	private static SimpleDateFormat getDateTimeFormat(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	private static SimpleDateFormat getDateFormat(){
		return new SimpleDateFormat("yyyy-MM-dd");
	}
	private static SimpleDateFormat getDateYMDFormat(){
		return new SimpleDateFormat("yyyyMMdd");
	}
	private static SimpleDateFormat getDateYMDHMSFormat(){
		return new SimpleDateFormat("yyyyMMddhhmmss");
	}
	private static SimpleDateFormat getYMdDateFormat(){
		return new SimpleDateFormat("yyyy年MM月dd日");
	}
	public static Date parseDateTime(String dateTimeStr) {
		try {
			return getDateTimeFormat().parse(dateTimeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Date parseDate(String dateStr) {
		try {
			return getDateFormat().parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Date parseDateYMD(String dateStr) {
		try {
			return getDateYMDFormat().parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 时间格式转换
	 * @param date
	 * @param fmt	yyyy-MM-dd HH:mm:ss,SSS
	 * @return
	 */
	public static String format(Date date,String fmt) {
		SimpleDateFormat format = new SimpleDateFormat(fmt);
		return format.format(date);
	}
	public static String formatDateTime(Date dateTime) {
		return getDateTimeFormat().format(dateTime);
	}
	public static String formatDate(Date date) {
		return getDateFormat().format(date);
	}
	public static String formatDateYMD(Date date) {
		return getDateYMDFormat().format(date);
	}
	/**
	 * 将时间转成yyyymmddhhmmss字符
	 * @param date
	 * @return
	 */
	public static String formatDateYMDHMS(Date date) {
		return getDateYMDHMSFormat().format(date);
	}
	/**
	 * 返回加几天后的日期
	 * @param Date
	 * @param days
	 * @return 
	 */
	public static String dateAddDayToStr(String date,Integer days){
		Date parseDate = parseDate(date);
		long time = parseDate.getTime();
		time = time + (days*86400000l );
		return getDateFormat().format(new Date(time));
	}
	/**
	 * 返回加几天后的日期
	 * @param Date
	 * @param days
	 * @return 
	 */
	public static Date dateAddDay(Date date,Integer days){
		
		long time = date.getTime();
		time = time + (days*86400000l );
		return new Date(time);
	}
	/**
	 * 返回加几天后的日期
	 * @param Date YYYYMMDD
	 * @param days
	 * @return 
	 */
	public static String dateYMDAddDayToStr(String date,Integer days){
		Date parseDate = parseDateYMD(date);
		long time = parseDate.getTime();
		time = time + (days*86400000l );
		return getDateYMDFormat().format(new Date(time));
	}
	/**
	 * 返回加几天后的日期
	 * @param Date YYYYMMDDHHMMSS
	 * @param days
	 * @return 
	 */
	public static String dateYMDHMSAddDayToStr(String date,Integer days){
		Date parseDate = parseDateTime(date);
		long time = parseDate.getTime();
		time = time + (days*86400000l );
		return formatDateTime(new Date(time));
	}
	public static String parserDateToMd(String date){
		Date parseDate = parseDateTime(date);
		return getYMdDateFormat().format(parseDate);
	}
	public static void main(String[] args) {
		//System.out.println(DateUtil.formatDateYMDHMS(new Date()));
		String date = DateUtil.parserDateToMd("2015-12-3 13:52:24");
		System.out.println(date);
	}
}

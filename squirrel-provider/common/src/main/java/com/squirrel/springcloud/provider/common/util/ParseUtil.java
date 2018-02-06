package com.squirrel.springcloud.provider.common.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 统一转换工具类
 * @author JoinHan on 2017/04/19
 *
 */
public class ParseUtil {

	public static int getInt(String key) {
		int i = 0;
		try {
			i = Integer.parseInt(key);
		} catch (Exception e) {
		}
		return i;
	}
	
	public static Integer getInteger(String key) {
		Integer i = null;
		try {
			i = Integer.parseInt(key);
		} catch (Exception e) {
		}
		return i;
	}

	public static Long getLong(String key) {
		Long i = null;
		try {
			i = Long.parseLong(key);
		} catch (Exception e) {
		}
		return i;
	}

	public static Double getDouble(String key) {
		Double i = null;
		try {
			i = Double.parseDouble(key);
		} catch (Exception e) {
			return 0.0;
		}
		return i;
	}

	public static Date getDate(String key,String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);//小写的mm表示的是分钟
		Date date = null;
		try {
			date = sdf.parse(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String parseDate(Date date,String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);//小写的mm表示的是分钟
		try {
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取某个日期的年度
	 */
	public static String getYear(Date date){
		  Calendar cal = Calendar.getInstance();  
		  cal.setTime(date); 
		  return cal.get(Calendar.YEAR)+"";
	}
	
	/**
	 *获取某个日期的上一年 
	 */
	public static Date getLastYear(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
	    c.add(Calendar.YEAR, -1);
	    Date y = c.getTime();
		return y;
	}
	
	/**
	 * 获取某个日期上个月
	 */
	public static Date getPreMonthr(Date date){
		int month=getMonth(date);
		if (month==0) {
			return date;
		}
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置日期
		calendar.add(Calendar.MONTH, -1);// 月份减一
		Date m = calendar.getTime();
		return m;
	}
	/**
	 * 获取某个日期月份
	 */
	public static int getMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return 	calendar.get(Calendar.MONTH);
	}
	/**
	 *获取某个日期的上一年度
	 */
	public static int getLastYearToInt(Date date){
		Date time=	getLastYear(date);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(time);
		return cal.get(Calendar.YEAR);
	}
	/**
	 *根据传入的值获取日期
	 */
	public static Date getTime(int value,int month,int day){
	    YearMonth yearMonth = YearMonth.of(value,month);  
	    yearMonth.atEndOfMonth();
        LocalDate localDate = yearMonth.atDay(day); 
        
        LocalDateTime startOfDay = localDate.atStartOfDay();  
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));  
  
        return Date.from(zonedDateTime.toInstant());  
	}
	/**
	 * Double保留两位小数 四舍五入
	 * @return Double
	 */
	public static Double getDoubleTwo(Double value){
		BigDecimal b = new BigDecimal(value).setScale(2,BigDecimal.ROUND_HALF_UP);
		return Double.valueOf(b.toString());
	}
	/**
	 * 长春取整数，尾数第一位为0向下，尾数不为0，向上
	 * @return Double
	 */
	public static Double getDouble(Double value){
		String stringVal=value.toString();
		String [] newString=stringVal.split("[.]");
		String NS=newString[1];
		char fir = NS.charAt(0);
		if (fir=='0') {
			return Double.valueOf(newString[0]);
		}
		return  Math.ceil(value);
	}
	/**
	 * Double截取两位小数
	 * @return Double
	 */
	public static Double returnDoubleTwo(Double value){
		BigDecimal b = new BigDecimal(value).setScale(2,BigDecimal.ROUND_DOWN);
		return b.doubleValue();
	}
	public static void main(String[] args) {
		//System.out.println( Math.round(12.51));
		System.out.println(Math.ceil(12.001));
	}
	/**
	 * 两个日期相差几个月
	 * @return Double
	 */
	public static Integer subMonth(Date start,Date end){
		 long month=(end.getTime()-start.getTime())/60/1000/60/24/30;
		 return Integer.valueOf(month+"");
	}
	public static List<String> timeList(String minTm,String maxTm)  {
		List<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		try {
			min.setTime(sdf.parse(minTm));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

			max.setTime(sdf.parse(maxTm));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}
		return result;
	}
}

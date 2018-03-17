package com.fangjian.framework.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
* Copyright  jeisai All right reserved.
* @ClassName: DateUtils 
* @author dengwm
* @since 2014-2-20 上午11:18:58 
* Description:  // 日期工具类
* Modify History: // 代码重构,将DateUtils与DateFormateUtils合并(dengwm)
 */
public class DateUtils {

	public static final String YMD = "yyyyMMdd";
	
	public static final String YMDHMS = "yyyyMMdd HH:mm:ss";
	
	public static final String Y_M_D = "yyyy-MM-dd";
	
	public static final String Y_M_DHMS = "yyyy-MM-dd HH:mm:ss";
	
	public static String getTime(Long millseconds) {
		String time = "";
		if (millseconds == null) {
			return "";
		}
		int days = (int) millseconds.longValue() / 1000 / 60 / 60 / 24;
		if (days > 0) {
			time = time + days + "天";
		}
		long hourMillseconds = millseconds.longValue() - days * 1000 * 60 * 60 * 24;
		int hours = (int) hourMillseconds / 1000 / 60 / 60;
		if (hours > 0) {
			time = time + hours + "小时";
		}
		long minuteMillseconds = millseconds.longValue() - days * 1000 * 60 * 60 * 24 - hours * 1000 * 60 * 60;

		int minutes = (int) minuteMillseconds / 1000 / 60;
		if (minutes > 0) {
			time = time + minutes + "分钟";
		}
		
		long secondMillseconds = millseconds.longValue() - days * 1000 * 60 * 60 * 24 - hours * 1000 * 60 * 60 - minutes * 1000 * 60;
		int second = (int) secondMillseconds / 1000;
		if (second > 0) {
			time = time + second + "秒";
		}
		return time;
	}
	
	/**
	 * 获取当前时间字符串
	* Copyright  jeisai All right reserved.
	* @Title: getCurrTimeForString  
	* @author dengwm
	* @since 2014-2-20 上午11:17:45
	* @return String    返回类型  
	* Description:  // 获取当前时间字符串
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static String getCurrTimeForString(){
		return formatDate(new Date(), Y_M_DHMS);
	}
	
	/**
	 * 获取当前日期字符串
	* Copyright  jeisai All right reserved.
	* @Title: getCurrTimeForString  
	* @author dengwm
	* @since 2014-2-20 上午11:17:45
	* @return String    返回类型  
	* Description:  // 获取当前时间字符串
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static String getCurrDateForString(){
		return formatDate(new Date(), YMD);
	}
	
	/**
	 * 格式化日期成字符串
	* Copyright  jeisai All right reserved.
	* @Title: formatDate  
	* @author dengwm
	* @since 2014-2-20 下午1:43:29
	* @param date
	* @param pattern
	* @return String    返回类型  
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static String formatDate(Date date,String pattern)
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
	/**
	 * 将格式日期的字符串解析成Date
	* Copyright  jeisai All right reserved.
	* @Title: parseDate  
	* @author dengwm
	* @since 2014-2-20 下午1:43:49
	* @param dateStr
	* @param pattern
	* @return Date    返回类型  
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date parseDate(String dateStr,String pattern)
	{
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 计算两个时间的时间差
	* Copyright  jeisai All right reserved.
	* @Title: getIntervalForTwoDate  
	* @author dengwm
	* @since 2014-2-20 上午11:29:35
	* @param startDate  开始时间
	* @param endDate    结束时间
	* @return String    返回类型  
	* Description:  // 计算两个Date类型时间的时间差
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static String getIntervalForTwoDate(Date startDate,Date endDate)
	{
		if(null!=startDate&&null!=endDate)
		{
			long t1 = startDate.getTime();
			long t2 = endDate.getTime();
			int hours=(int) ((t2 - t1)/3600000);
	        int minutes=(int) (((t2 - t1)/1000-hours*3600)/60);
	        int second=(int) ((t2 - t1)/1000-hours*3600-minutes*60);
	        return ""+hours+"小时"+minutes+"分"+second+"秒";
		}
		return "";
	}
	/**
	 * 
	* 方法名: getIntervalBetweenTwoDate 
	* 方法描述: 俩个时间的时间差
	* 创建人：fangjian 
	* 创建时间：2016年2月29日 下午1:54:40   
	* 修改人：fangjian   
	* 修改时间：2016年2月29日 下午1:54:40   
	* 修改备注：   
	* 参数 @param startDate
	* 参数 @param endDate
	* 参数 @return
	* 返回类型 int
	* throws
	 */
	public static int getIntervalBetweenTwoDate(Date startDate,Date endDate)
	{
		if(null!=startDate&&null!=endDate)
		{
			long t1 = startDate.getTime();
			long t2 = endDate.getTime();
			int hours=(int) ((t2 - t1)/3600000);
	        
	        return hours;
		}
		return 0;
	}
	
	/**
	 * 按calendar的类型获取时间数
	* Copyright  jeisai All right reserved.
	* @Title: getDateField  
	* @author dengwm
	* @since 2014-2-20 上午11:32:49
	* @param date   日期
	* @param field  Calendar支持字段类型 
	* @return int    返回类型  
	* Description:  // 按calendar的类型获取时间数，如：年、月、日等calendar支持的类型
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static int getDateField(Date date,int field) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(field);
	}
	/**
	 * 计算两个时间的相差年数
	* Copyright  jeisai All right reserved.
	* @Title: getYearsBetweenDate  
	* @author dengwm
	* @since 2014-2-20 上午11:35:44
	* @param begin 开始时间
	* @param end   结束时间
	* @return int    返回类型  
	* Description:  // 计算两个时间的相差年数，支持连个Date类型的日期计算
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static int getYearsBetweenDate(Date begin,Date end){
		int bYear = getDateField(begin,Calendar.YEAR);
		int eYear = getDateField(end,Calendar.YEAR);
		return eYear - bYear;
	}
	/**
	 * 计算两个时间相差的月数
	* Copyright  jeisai All right reserved.
	* @Title: getMonthsBetweenDate  
	* @author dengwm
	* @since 2014-2-20 上午11:35:48
	* @param begin   开始时间
	* @param end     结束时间
	* @return int    返回类型  
	* Description:  // 计算两个时间相差的月数
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static int getMonthsBetweenDate(Date begin,Date end){
		int bMonth = getDateField(begin,Calendar.MONTH);
		int eMonth = getDateField(end,Calendar.MONTH);
		return eMonth - bMonth;
	}
	/**
	 * 计算两个时间相差的周数
	* Copyright  jeisai All right reserved.
	* @Title: getWeeksBetweenDate  
	* @author dengwm
	* @since 2014-2-20 上午11:35:57
	* @param begin   开始时间
	* @param end     结束时间
	* @return int    返回类型  
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static int getWeeksBetweenDate(Date begin,Date end){
		int bWeek = getDateField(begin,Calendar.WEEK_OF_YEAR);
		int eWeek = getDateField(end,Calendar.WEEK_OF_YEAR);
		return eWeek - bWeek;
	}
	/**
	 * 计算两个时间相差的天数
	* Copyright  jeisai All right reserved.
	* @Title: getDaysBetweenDate  
	* @author dengwm
	* @since 2014-2-20 上午11:36:01
	* @param begin   开始时间
	* @param end     结束时间
	* @return int    返回类型  
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static int getDaysBetweenDate(Date begin,Date end){
		int bDay = getDateField(begin,Calendar.DAY_OF_YEAR);
		int eDay = getDateField(end,Calendar.DAY_OF_YEAR);
		return eDay - bDay;
	}

	/**
	 * 获取date年后(前)的amount年的第一天的开始时间
	* Copyright  jeisai All right reserved.
	* @Title: getSpecficYearStart  
	* @author dengwm
	* @since 2014-2-20 上午11:40:19
	* @param date  
	* @param amount  
	* @return Date    返回类型  
	* Description:  // 获取date年后的amount年的第一天的开始时间
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getSpecficYearStart(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, amount);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		return getStartDate(cal.getTime());
	}
	/**
	 * 获取date年后的amount年的最后一天的终止时间
	* Copyright  jeisai All right reserved.
	* @Title: getSpecficYearEnd  
	* @author dengwm
	* @since 2014-2-20 上午11:41:43
	* @param date
	* @param amount
	* @return  
	* @return Date    返回类型  
	* @throws 
	* Description:  // 获取date年后的amount年的最后一天的终止时间
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getSpecficYearEnd(Date date,int amount) {
		Date temp = getStartDate(getSpecficYearStart(date,amount + 1));
		Calendar cal = Calendar.getInstance();
		cal.setTime(temp);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getFinallyDate(cal.getTime());
	}
	/**
	 * 获取date月后的amount月的第一天的开始时间
	* Copyright  jeisai All right reserved.
	* @Title: getSpecficMonthStart  
	* @author dengwm
	* @since 2014-2-20 上午11:41:50
	* @param date
	* @param amount
	* @return  
	* @return Date    返回类型  
	* @throws 
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getSpecficMonthStart(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, amount);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return getStartDate(cal.getTime());
	}
	/**
	 * 获取当前自然月后的amount月的最后一天的终止时间
	* Copyright  jeisai All right reserved.
	* @Title: getSpecficMonthEnd  
	* @author dengwm
	* @since 2014-2-20 上午11:41:54
	* @param date
	* @param amount
	* @return  
	* @return Date    返回类型  
	* @throws 
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getSpecficMonthEnd(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getSpecficMonthStart(date,amount + 1));
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getFinallyDate(cal.getTime());
	}
	/**
	 * 获取date周后的第amount周的开始时间（这里星期一为一周的开始）
	* Copyright  jeisai All right reserved.
	* @Title: getSpecficWeekStart  
	* @author dengwm
	* @since 2014-2-20 上午11:41:59
	* @param date
	* @param amount
	* @return Date    返回类型  
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getSpecficWeekStart(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
		cal.add(Calendar.WEEK_OF_MONTH, amount);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return getStartDate(cal.getTime());
	}
	/**
	 *  获取date周后的第amount周的最后时间（这里星期日为一周的最后一天）
	* Copyright  jeisai All right reserved.
	* @Title: getSpecficWeekEnd  
	* @author dengwm
	* @since 2014-2-20 上午11:44:20
	* @param date
	* @param amount
	* @return  
	* @return Date    返回类型  
	* @throws 
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getSpecficWeekEnd(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
		cal.add(Calendar.WEEK_OF_MONTH, amount);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getFinallyDate(cal.getTime());
	}
	/**
	 * 得到指定日期的一天的的最后时刻23:59:59
	* Copyright  jeisai All right reserved.
	* @Title: getFinallyDate  
	* @author dengwm
	* @since 2014-2-20 上午11:44:31
	* @param date
	* @return  
	* @return Date    返回类型  
	* @throws 
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getFinallyDate(Date date) {
		String temp = formatDate(date,YMD);
		temp += " 23:59:59";
		return parseDate(temp,YMDHMS);
	}
	/**
	 * 得到指定日期的一天的开始时刻00:00:00
	* Copyright  jeisai All right reserved.
	* @Title: getStartDate  
	* @author dengwm
	* @since 2014-2-20 上午11:44:36
	* @param date
	* @return Date    返回类型  
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getStartDate(Date date) {
		String temp = formatDate(date,YMD);
		temp += " 00:00:00";
		return parseDate(temp, YMDHMS);
	}
	/**
	 * 拿到当前月的最后一天
	* Copyright  jeisai All right reserved.
	* @Title: getLastDayOfMonth  
	* @author dengwm
	* @since 2014-2-20 上午11:48:51
	* @return Date    返回类型  
	* Description:  // 拿到当前月的最后一天
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static Date getLastDayOfMonth(){
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  
		 return calendar.getTime();
	}
	
/**
 * 判断传入的日期是否是周末
* Copyright  jeisai All right reserved.
* @Title: isWeek  
* @author wanghl
* @since 2014-4-30 下午1:28:26
* @param currentDate
* @return  
* @return boolean    返回类型  
* @throws 
* Description:  // 用于详细说明此程序文件完成的主要功能
* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
 */
	public static boolean isWeek(Date currentDate) {  
		int currentDay = 9  ;  
		if(null!=currentDate){
 			currentDay = currentDate.getDay();
		}  
		if(currentDay==0||currentDay==6)  {  
			return true ;  
		}  
		return false; 
	} 
	
	/**
	 * 将未指定格式的日期字符串转化成
	* Copyright  jeisai All right reserved.
	* @Title: parseStringToDate  
	* @author dengwm
	* @since 2014-2-20 下午2:09:41
	* @param date
	* @return Date    返回类型  
	* Description:  // 用于未知日期格式转换
	* Modify History: // 重构代码（张三军引入）
	 */
    public static Date parseStringToDate(String date) {  
        Date result = null;  
        String parse = date;  
        parse = parse.replaceFirst("^[0-9]{4}([^0-9]?)", "yyyy$1");  
        parse = parse.replaceFirst("^[0-9]{2}([^0-9]?)", "yy$1");  
        parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1MM$2");  
        parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}( ?)", "$1dd$2");  
        parse = parse.replaceFirst("( )[0-9]{1,2}([^0-9]?)", "$1HH$2");  
        parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1mm$2");  
        parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1ss$2");  
        DateFormat format = new SimpleDateFormat(parse);  
        try {
			result = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        return result;  
    } 

    public  static long getNextTime(int timeUnit, int interval, long timeMill)
      {
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(timeMill);
        switch (timeUnit) {
        case 0:
          ca.add(13, interval);
          break;
        case 1:
          ca.add(12, interval);
          break;
        case 2:
          ca.add(10, interval);
          break;
        case 3:
          ca.add(5, interval);
          break;
        case 4:
          ca.add(2, interval);
          break;
        default:
          return 0L;
        }
        return ca.getTimeInMillis();
      }
    
    public static Date getMillis(Date startTime,int timeMill){
		 Calendar cal = Calendar.getInstance();
		 cal.setTimeInMillis(startTime.getTime());
		 cal.add(Calendar.MINUTE,timeMill);
		return cal.getTime();
    }
    
    /** 
    * 获得指定日期的几天 
    * @param specifiedDay 
    * @return 
    */ 
    public static Date getSpecifiedDayAfter(Date specifiedDate,int number){ 
		Calendar c = Calendar.getInstance();     
		c.setTime(specifiedDate); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+number); 
		
		return c.getTime(); 
    } 
 
    public static java.sql.Timestamp getTimestamp(Date date) {
    	return new java.sql.Timestamp(date.getTime());
    }
    
    public static Long getSecondDiff(Date startTime,Date endTime){
        long start = startTime.getTime();
        long end = endTime.getTime();
        return end - start;

    }
    
    /** 
     * 判断当前日期是星期几 
     *  
     * @param pTime 修要判断的时间 
     * @return dayForWeek 判断结果 
     * @Exception 发生异常 
     */
    public static String dayForWeek(Date date) throws Throwable {  
        
    	  // String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    	  // Calendar cal = Calendar.getInstance();
    	  // cal.setTime(date);
    	  // int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
    	  // if(week_index<0){
    	  // week_index = 0;
    	  // }
    	  // return weeks[week_index];
    	  SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    	  String week = sdf.format(date);
    	  return week;
    }
    
    public static void main(String[] args) throws Throwable{
      Date eDate= DateUtils.parseDate("2014-05-20", DateUtils.Y_M_D);
      System.out.println(DateUtils.formatDate(getSpecifiedDayAfter(eDate, 1), DateUtils.Y_M_D).substring(8));
      
      System.out.println(DateUtils.dayForWeek(getSpecifiedDayAfter(eDate, 12)).substring(2));
      
    }
    
    
   
}

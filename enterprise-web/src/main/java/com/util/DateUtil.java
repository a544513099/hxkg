package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * 实现Date类型和String类型相互转换
 *
 * @author zhouzhihao
 *         2014年4月29日
 */
public class DateUtil {
	
	public final static String YMDHMS = "yyyy-MM-dd HH:mm:ss";
	public final static String YMD = "yyyy-MM-dd";
	public final static String YMD1 = "yyyy.MM.dd";
	
	/**
	 * String转Date
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
    public static Date string2Date(String str, String format) throws Exception {
        SimpleDateFormat formatDate = new SimpleDateFormat(format);
        return formatDate.parse(str);
    }

    /**
     * 将Date类型数据转化为字符串
     * zhouzhihao
     *
     * @param date 日期类型数据
     * @return
     */
    public static String date2String(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    //返回两个时间的相差天数
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }  

    /**
     * 将字符串转化为Date类型
     * zhouzhihao
     *
     * @param str 字符串 格式为 yyyy-MM-dd
     * @return
     * @throws Exception
     */
    public static Date string2Date(String str) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(str);
    }

    /**
     * 返回字符型日期
     *
     * @param date 日期
     * @return 返回字符型日期
     */
    public static String getDate(Date date) {
        return format(date, "yyyy/MM/dd");
    }

    /**
     * 格式化输出日期
     *
     * @param date   日期
     * @param format 格式
     * @return 返回字符型日期
     */
    public static String format(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    /**
     * 日期相减
     *
     * @param date 日期
     * @param day  天数
     * @return 返回相减后的日期
     */
    public static Date diffDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) - ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 格式化日期
     *
     * @param dateStr 字符型日期
     * @param format  格式
     * @return 返回日期
     */
    public static Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(format);
            String dt = dateStr.replaceAll("-", "/");
            if ((!dt.equals("")) && (dt.length() < format.length())) {
                dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]", "0");
            }
            date = df.parse(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取两个日期之间的时间间隔
     *
     * @param currentDate
     * @param dateEnd
     * @return 1秒  1分钟  1小时 1天
     */
    public static String getTwoDay(Object currentDate, Object dateEnd) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long day = 0;
        String days = "";
        try {
            Date dateS = null;
            if (currentDate instanceof String) {
                dateS = myFormatter.parse((String) currentDate);
            } else if (currentDate instanceof Date) {
                dateS = (Date) currentDate;
            } else {
                return "";
            }
            Date dateE = null;
            if (dateEnd instanceof String) {
                dateE = myFormatter.parse((String) dateEnd);
            } else if (dateEnd instanceof Date) {
                dateE = (Date) dateEnd;
            } else {
                return "";
            }
            day = (dateS.getTime() - dateE.getTime()) / (24 * 60 * 60 * 1000); //天
            if (day == 0) {
                day = (dateS.getTime() - dateE.getTime()) / (60 * 60 * 1000); //时
                if (day == 0) {
                    day = (dateS.getTime() - dateE.getTime()) / (60 * 1000); //分
                    if (day == 0) {
                        day = (dateS.getTime() - dateE.getTime()) / (1000); //秒
                        days = day + " 秒";
                    } else {
                        days = day + " 分钟";
                    }
                } else {
                    days = day + " 小时";
                }
            } else {
                days = day + " 天";
            }
        } catch (Exception e) {
            return "";
        }
        return days + "";
    }

    /**
     * 返回年份
     *
     * @param date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 返回月份
     *
     * @param date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日份
     *
     * @param date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }
    
    /**
     * 
     * @Title: dateToTimestamp 
     * @Description: 将Date日期转换成日期戳 
     * @param     
     * @return String
     */
	public static String dateToTimestamp(Date date,String format) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(date);
		Date d;
		try {
			d = sdf.parse(strDate);
			long l = d.getTime();
			String str = String.valueOf(l);
			result = str.substring(0, 10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

    /**
     * 返回秒钟
     *
     * @param date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    public static boolean compareTime(String lastDate) {
        boolean flag = false;
        try {
            Date nowdate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Date d = sdf.parse(lastDate);
            flag = d.before(nowdate);
            if (flag) {
                System.out.print("早于今天");
            } else {
                System.out.print("晚于今天");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static  void main(String[] args){
    	strParseDate("2015-12-31 23:59:59", YMDHMS);
//        compareTime("2015-12-31 23:59:59");
    }
    /**
     * Str ==> date
     * @param args
     */
    public static Date strParseDate(String dt, String format) {
        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(format);
            if ((!dt.equals("")) && (dt.length() < format.length())) {
                dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]", "0");
            }
            date = df.parse(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 比较时间与当前时间相差多少秒以内，返回boolean值,若当前时间与之前时间差大于给的相差秒数则返回true(需要重新调接口),否则反之
     * @param startDateStr
     * @return
     */
    public static boolean calLastedTime(Long startDateTime, int ms) {
    	long a = new Date().getTime();
    	int c = (int)((a - startDateTime) / 1000);
    	if(c >= ms){
    		return true;
    	}
    	return false;
	}
    
    /**
     * 获取今天年月日的时间戳
     * @return
     */
    public static long getTodayTime(){
    	Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(new Date());//把当前时间赋给日历
		calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero.getTime();
    }
    
    /**
     * 根据时间获取不同格式的时间
     * @param date
     * @param format
     * @return
     */
    public static Date getDateByDataAndFormat(Date date, String format){
    	SimpleDateFormat sdf=new SimpleDateFormat(format);
    	Date time = null;
    	try {
			time= sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return time;
    }
    
    /**
     * 与当前时间比较 小于当前时间就返回false
     * @param date
     * @return
     */
    public static boolean compare_date(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date dt1 = df.parse(df.format(date));
        	Date dt2 = df.parse(df.format(new Date()));
            if (dt1.getTime() < dt2.getTime()) {
            	return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
    
    /**
     * 两个日期比较 date1小于date2就返回false
     * @param date
     * @return
     */
    public static boolean compare_date(Date date1, Date date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date dt1 = df.parse(df.format(date1));
        	Date dt2 = df.parse(df.format(date2));
            if (dt1.getTime() < dt2.getTime()) {
            	return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
    
    /**
     * 与当前时间比较 小于当前时间就返回false
     * @param date
     * @return
     */
    public static boolean compare_date(String date, String format) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date dt1 = df.parse(date);
        	Date dt2 = df.parse(df.format(new Date()));
            if (dt1.getTime() < dt2.getTime()) {
            	return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
    
    /**
     * 比较两个日期是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static boolean sameDate(Date d1, Date d2) {  
	    if(null == d1 || null == d2)  
	        return false;  
	    Calendar cal1 = Calendar.getInstance();  
	    cal1.setTime(d1);  
	    cal1.set(Calendar.HOUR_OF_DAY, 0);  
	    cal1.set(Calendar.MINUTE, 0);  
	    cal1.set(Calendar.SECOND, 0);  
	    cal1.set(Calendar.MILLISECOND, 0);  
	    Calendar cal2 = Calendar.getInstance();  
	    cal2.setTime(d2);  
	    cal2.set(Calendar.HOUR_OF_DAY, 0);  
	    cal2.set(Calendar.MINUTE, 0);  
	    cal2.set(Calendar.SECOND, 0);  
	    cal2.set(Calendar.MILLISECOND, 0);  
	    return  cal1.getTime().equals(cal2.getTime());  
	}  
    
}


package com.zoomkey.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * 这个类提供各种日期格式的处理函数，我们这个项目标准的日期字符串写法：yyyy-MM-dd 或 yyyy-MM-dd HH:mm
 * 
 * @author <a href="mailto:songran.li@berheley.com">songran.li </a> For caculate difficult date and
 *         time
 */
public class DateHelper
{

	private static Logger		logger							= Logger.getLogger(DateHelper.class);

	static final String			DEFAULT_DATE_FORMAT			= "yyyy-MM-dd HH:mm:ss";

	public static final String	DEFAULT_DAY_FORMAT			= "yyyy-MM-dd";

	/**把当前时间格式化成yyyyMMddHHmmss格式*/
	public static final String	FORMATE_DATE_NOW				= "yyyyMMddHHmmss";

	public static final String	FORMATE_DATE_NOW_SPECIAL	= "yyyyMMdd";

	/**
	 * 比较计算日期是否在开始日期和结束日期之间(不包括开始和结束)
	 * @param date 计算的日期
	 * @param begin 开始日期
	 * @param end 结束日期
	 * @return 如果计算日期在开始日期和结束日期之间，则返回true。否则返回false。
	 */
	public static boolean isDateBetween(Date date, Date begin, Date end)
	{
		if (date.after(begin) && date.before(end))
		{
			return true;
		}
		return false;
	}

	/**
	 * @function:比较计算日期是否在开始日期和结束日期之间(包括开始不包括结束)
	 * @param date 计算的日期
	 * @param begin 开始日期
	 * @param end 结束日期
	 * @return 如果计算日期在开始日期和结束日期之间，则返回true。否则返回false。
	 * @author: Wang Cheng [HNXLBC-51] 2010-9-30 上午11:33:30
	 */
	public static boolean isDateEqualAfterBeginBeforeEnd(Date date, Date begin, Date end)
	{
		if (date.equals(begin) || date.after(begin) && date.before(end))
		{
			return true;
		}
		return false;
	}

	/**
	 * @function:如果前者早于后者则返回true
	 * @param beforeTime
	 * @param afterTime
	 * @return
	 * @author: juchen 2008-7-12 下午01:19:07
	 */
	public static boolean compareTime(Calendar beforeTime, Calendar afterTime)
	{
		boolean flag = false;
		if (beforeTime.before(afterTime))
		{
			flag = true;
		}
		return flag;
	}

	/**
	 * @function：将日期字符串增加一年
	 * @param dateStr 输入日期格式的字符串 如2010-07-18
	 * @return 2011-07-18
	 * @author: likun 2010-4-8 下午04:27:21
	 */
	public static String addOneYear(String dateStr)
	{
		Calendar cal = getCalendarByStr(dateStr);
		cal.add(Calendar.YEAR, 1);
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
		return dateFormat.format(date);
	}

	/**
	 * @function：将日期字符串减少一年
	 * @param dateStr 输入日期格式的字符串 如2010-07-18
	 * @return 2009-07-18
	 * @author: Wang Cheng [HNXLBC-51] 2010-9-30 上午08:54:50
	 */
	public static String subOneYear(String dateStr)
	{
		Calendar cal = getCalendarByStr(dateStr);
		cal.add(Calendar.YEAR, -1);
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
		return dateFormat.format(date);
	}

	/**
	 * @function:计算日期相差天数， 例如： 2010-3-15 - 2010-3-15 = 1； 2010-3-15 - 2010-3-14 = 2； 2010-3-15 -
	 *                     2010-3-16 = -2；
	 * @param startTime 开始日期
	 * @param endTime 结束日期
	 * @return
	 * @author: likun 2010-4-8 下午01:47:40
	 */
	public static Integer diffDays(String startTime, String endTime)
	{
		long day = (getCalendarByStr(endTime).getTimeInMillis() - getCalendarByStr(startTime).getTimeInMillis())
					/ (1000 * 60 * 60 * 24);
		int intDay = new Long(day).intValue();
		return intDay >= 0 ? intDay + 1 : intDay - 1;
	}

	/**
	 * @function 计算两天是时间差，参考上面的函数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Integer diffDays(Date startDate, Date endDate)
	{
		return diffDays(getFormatedDayStr(startDate), getFormatedDayStr(endDate));
	}

	/**
	 * @function:将字符串转为Calendar类型
	 * @param dateTime 默认：当前系统时间
	 * @param formatString 默认：yyyy-MM-dd
	 * @return
	 * @author: juchen 2008-7-2 上午09:27:41
	 */
	public static Calendar getCalendarByStr(String dateTime)
	{
		Calendar cal = Calendar.getInstance();
		if (dateTime == null || "".equals(dateTime))
		{
			cal.setTime(new Date());
		} else
		{
			SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
			try
			{
				cal.setTime(df.parse(dateTime));
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
		return cal;
	}

	/**
	 * 将日期字符串转化成日期类型
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param now String 日期时分 'yyyy-MM-dd HH:mm' 或 'yyyy-MM-dd'
	 * @return Date 日期
	 */
	public static Date getDate(String now)
	{
		// 若传过来的字符串是长度为10的类型：yyyy-MM-dd，则先把它改为16位的类型
		if (now != null && now.length() == DEFAULT_DAY_FORMAT.length())
		{
			now = now + " 00:00:00";
		}
		DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		Date date = null;
		try
		{
			date = now == null || now.length() != DEFAULT_DATE_FORMAT.length() ? null : df.parse(now);
		} catch (Exception e)
		{
			logger.debug("date transfer error", e);
		}
		return date;
	}

	/**
	 * @function:将字符串转换为日期，可以输入格式
	 * @param date 日期类型字符串
	 * @param format 日期类型格式
	 * @return
	 * @author: yanghongna Jan 17, 2008 4:28:04 PM
	 */
	public static Date getDateByStr(String date, String format)
	{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(format);
		Date d = new Date();
		try
		{
			d = dateFormat.parse(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 过虑掉日期中的时分秒等
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param today Date 时间
	 * @return Date 修正时间
	 */
	public static Date getDay(Date now)
	{
		DateFormat df = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
		String day = df.format(now);
		Date newDay = null;
		try
		{
			newDay = df.parse(day);
		} catch (ParseException e)
		{
			logger.debug("date transfer error", e);
		}
		return newDay;
	}

	/**
	 * Parse formated date string 'yyyyMMdd'
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param today String 日期
	 * @return Date 日期
	 */
	public static Date getDay(String today)
	{
		DateFormat df = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
		Date day = null;
		try
		{
			day = today == null || today.length() != 10 ? null : df.parse(today);
		} catch (Exception e)
		{
			logger.debug("date transfer error", e);
		}
		return day;
	}

	/**
	 * @function: 获取下个月的第一天的日期字符串
	 * @param strDate 日期字符串
	 * @return
	 */
	public static String getFirstDayOfNextMonth(String strDate)
	{
		String str = "";
		try
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(getDate(strDate));
			// ///////////////modify by jiangjun
			cal.add(Calendar.MONTH, 1);
			str = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + "01";
			// ////////////////
		} catch (Exception ex)
		{
			logger.error("得到默认中文日期格式发生异常", ex);
		}
		return str;
	}

	/**
	 * @function:根据格式得到当前时间 “yyyy-MM-dd HH:mm:ss”
	 * @param format
	 * @return 当前时间字符串
	 * @author: hanmeng 2008-7-24 下午05:05:01
	 */
	public static String getFormatedDateNow(String format)
	{
		Date now = new java.util.Date();
		DateFormat df = new SimpleDateFormat(format);
		String str = now == null ? null : df.format(now);
		return str;
	}

	/**
	 * 获取当前时间的字符串，格式为'yyyy-MM-dd HH:mm:ss'
	 * 
	 * @param now
	 * @return 返回格式为 'yyyy-MM-dd HH:mm:ss' 的字符串
	 */
	public static String getFormatedDateStr(Date now)
	{
		DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String str = now == null ? null : df.format(now);
		return str;
	}

	/**
	 * 将日期对象按照格式，格式化为日期字符串。
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param now Date 日期对象
	 * @param format String 日期格式
	 * @return String 日期字符串
	 */
	public static String getFormatedDateStr(Date now, String format)
	{
		DateFormat df = new SimpleDateFormat(format);
		String str = now == null ? null : df.format(now);
		return str;
	}

	/**
	 * 获取默认格式的当前日期字符串
	 * 
	 * @param now 日期对象
	 * @return 返回格式为 'yyyy-MM-dd' 的当前日期字符串
	 */
	public static String getFormatedDayStr(Date now)
	{
		DateFormat df = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
		String str = now == null ? null : df.format(now);
		return str;
	}

	/**
	 * 通过天数差得到新的日期
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param today Date 日期对象
	 * @param interval int 天数差
	 * @return Date 修正日期对象
	 */
	public static Date getInterval(Date today, int interval)
	{
		long time = today.getTime();
		time += interval * 24 * 3600 * 1000;
		return new Date(time);
	}

	/**
	 * 返回当前时间，格式为“yyyy-MM-dd HH:mm:ss”
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @return String
	 */
	public static String getSimpleFormatedDateNow()
	{
		Date now = new java.util.Date();
		return getFormatedDateStr(now);
	}

	/**
	 * @function: 返回当前时间，格式为“yyyy-mm-dd”
	 * @return
	 * @author: Liujuan 2009-2-24 上午09:50:36
	 */
	public static String getSimpleFormatedDayNow()
	{
		Date now = new java.util.Date();
		return getFormatedDayStr(now);
	}

	/**
	 * convert java.util.Date with formated 'yyyy-MM-dd' to java.sql.Date
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param today java.util.Date 日期
	 * @return java.sql.Date 日期
	 */
	public static java.sql.Date getSqlDay(java.util.Date today)
	{
		java.sql.Date sqld = java.sql.Date.valueOf(getFormatedDateStr(today, DEFAULT_DAY_FORMAT));
		return sqld;
	}

	/**
	 * convert string formated 'yyyy-MM-dd' to java.sql.Date
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param today String 日期
	 * @return java.sql.Date 日期
	 */
	public static java.sql.Date getSqlDay(String today)
	{
		java.sql.Date sqld = java.sql.Date.valueOf(today);
		return sqld;
	}

	/**
	 * 返回当天 string formated 'yyyy-MM-dd' to java.sql.Date
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param
	 * @return java.sql.Date 日期
	 */
	public static java.sql.Date getSqlToday()
	{
		return getSqlDay(new java.util.Date());
	}

	/**
	 * 通过日期、日期差和时间字符串得到到达时间
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param today Date 不含时分秒的日期
	 * @param interval int 日期差
	 * @param hhmm String 时间字符串
	 * @return Date 到达时间
	 */
	public static Date getSta(Date today, int interval, String hhmm)
	{
		int hh = Integer.parseInt(hhmm.substring(0, 2));
		int mm = Integer.parseInt(hhmm.substring(2, 4));
		long time = today.getTime();
		time += interval * 24 * 3600 * 1000;
		time += hh * 3600 * 1000;
		time += mm * 60 * 1000;
		return new Date(time);
	}

	/**
	 * 通过日期、日期差和时间字符串得到出发时间
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param today Date 不含时分秒的日期
	 * @param interval int 日期差
	 * @param hhmm String 时间字符串
	 * @return Date 出发时间
	 */
	public static Date getStd(Date today, int interval, String hhmm)
	{
		int hh = Integer.parseInt(hhmm.substring(0, 2));
		int mm = Integer.parseInt(hhmm.substring(2, 4));
		long time = today.getTime();
		time -= interval * 24 * 3600 * 1000;
		time += hh * 3600 * 1000;
		time += mm * 60 * 1000;
		return new Date(time);
	}

	// ************************************************************ //
	/**
	 * 通过DATE类型得到当前DATE星期
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param date 当前日期
	 * @return int (1~7 , 1 代表星期日, 7 代表星期六)，如果出现错误，则返回零
	 */
	public static int getWeekByDate(Date date)
	{
		int a = 0;
		GregorianCalendar cal = new GregorianCalendar();
		try
		{
			cal.setTime(date);
			a = cal.get(Calendar.DAY_OF_WEEK);
		} catch (Exception ex)
		{
			logger.error("通过Date得到week发生异常", ex);
		}
		return a;
	}

	/**
	 * 按照指定日期格式解析字符串
	 * 
	 * @param now 日期字符串
	 * @param format 日期格式
	 * @return 日期对象
	 */
	public static Date parseStringToDate(String now, String format)
	{
		DateFormat df = new SimpleDateFormat(format);
		Date nowDate = null;
		try
		{
			nowDate = df.parse(now);
		} catch (ParseException e)
		{
			logger.debug("无法解析" + now);
			e.printStackTrace();
		}
		return nowDate;
	}

	/**
	 * @function:返回格式化后的日期时间函数
	 * @param format 兼容系统中的JS时间控件
	 * @return
	 * @author: changyue 2008-7-4 下午05:26:16
	 */
	public static String returnTime(String format)
	{
		String str[] = format.split("%");
		String javaFormat = "";
		for (int i = 1; i < str.length; i++)
		{
			if (str[i].startsWith("Y"))
			{
				javaFormat = "yyyy";
				if (str[i].length() > 1)
				{
					javaFormat = javaFormat + str[i].substring(1);
				}
			}
			if (str[i].startsWith("M"))
			{
				javaFormat = javaFormat + "MM";
				if (str[i].length() > 1)
				{
					javaFormat = javaFormat + str[i].substring(1);
				}
			}
			if (str[i].startsWith("D"))
			{
				javaFormat = javaFormat + "dd";
				if (str[i].length() > 1)
				{
					javaFormat = javaFormat + str[i].substring(1);
				}
			}
			if (str[i].startsWith("H"))
			{
				javaFormat = javaFormat + "HH";
				if (str[i].length() > 1)
				{
					javaFormat = javaFormat + str[i].substring(1);
				}
			}
			if (str[i].startsWith("h"))
			{
				javaFormat = javaFormat + "hh";
				if (str[i].length() > 1)
				{
					javaFormat = javaFormat + str[i].substring(1);
				}
			}
			if (str[i].startsWith("m"))
			{
				javaFormat = javaFormat + "mm";
				if (str[i].length() > 1)
				{
					javaFormat = javaFormat + str[i].substring(1);
				}
			}
			if (str[i].startsWith("s"))
			{
				javaFormat = javaFormat + "ss";
				if (str[i].length() > 1)
				{
					javaFormat = javaFormat + str[i].substring(1);
				}
			}
		}
		java.util.Date d = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(javaFormat);
		return sdf.format(d);
	}

	/**
	 * 得到当前日期的中文格式
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @return 2010年9月15日
	 */
	public String getCNDefaultDate()
	{
		String str = "";
		try
		{
			Calendar cal = Calendar.getInstance();
			str = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE) + "日";
			str = str + getCNWeek((cal.get(Calendar.DAY_OF_WEEK) - 1));
		} catch (Exception ex)
		{
			logger.error("得到默认中文日期格式发生异常", ex);
		}
		return str;
	}

	/**
	 * 得到中文星期，根据输入数字获取
	 * 注意：这个与上面的getWeekByDate函数，所代表的日期不同。
	 * 需要经过简单的换算。
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param a 数字（1,2,3,4,5,6,7）
	 * @return
	 */
	public String getCNWeek(int a)
	{
		String str_week = "";
		switch (a)
		{
			case 1 :
				str_week = "星期一";
				break;
			case 2 :
				str_week = "星期二";
				break;
			case 3 :
				str_week = "星期三";
				break;
			case 4 :
				str_week = "星期四";
				break;
			case 5 :
				str_week = "星期五";
				break;
			case 6 :
				str_week = "星期六";
				break;
			case 7 :
				str_week = "星期日";
				break;
		}
		return str_week;
	}

	/**
	 * 通过一个yyyy－MM-dd类型的日期字符串得到 日期对象
	 * 
	 * @author <a href="mailto:songran.li@berheley.com">songran.li </a>
	 * @param d1 日期字符串
	 * @return
	 */
	public static Date getDateByStr(String d1)
	{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(DEFAULT_DAY_FORMAT);
		Date d = new Date();
		try
		{
			d = dateFormat.parse(d1);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 获取当前的年份，例如2010
	 * 
	 * @return 年份字符串，例如2010
	 * @author: Yuan Nan 2010-7-7 上午10:05:31
	 */
	public static String getCurrentYear()
	{
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(d);
	}

	// modified by Wang Cheng 2011-1-31 [ZKP-121] begin
	/**
	 * 获取今年与明年组成的年度字符串
	 * 例如：当前是2010年，则供暖年度字符串为：2010-2011
	 * @return 供暖年度字符串，例如：2010-2011
	 * @author: Yuan Nan 2010-7-7 上午10:05:31
	 */
	// [ZKP-121] end
	public static String getCurrentHeatingSeason()
	{
		String currentYear = getCurrentYear();
		Integer iCurrYear = Integer.parseInt(currentYear);
		Integer iNextYear = iCurrYear + 1;
		String nextYear = iNextYear.toString();
		return iCurrYear + "-" + nextYear;
	}

	/**
	* @function:获取上个月的第一天日期
	* @return String 例如：yyyy-mm-dd
	* @author: LiuLinKun    2011-5-17 下午12:53:26
	*/
	public static String getPreviousMonthFirst()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DAY_FORMAT);
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天
		String str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	* @function:获取上个月的最后一天日期
	* @return String 例如：yyyy-mm-dd
	* @author: LiuLinKun    2011-5-17 下午12:53:26
	*/
	public static String getPreviousMonthEnd()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		String str = sdf.format(lastDate.getTime());
		return str;
	}
}
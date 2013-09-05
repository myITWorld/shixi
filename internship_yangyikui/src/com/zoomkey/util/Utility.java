/*
 * Copyright: Tianjin Zoomkey  Software Dev Co,.ltd, China
 * hcms
 * com.berheley.hcms.util.JsonUtil.java
 * Created on 2009-2-1-下午03:43:56
 */

package com.zoomkey.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/**
 * 类功能描述：工具类
 * 
 * @author <a href="mailto:kun.li@berheley.com">LiKun</a>
 */
public class Utility
{

	/**
	 * 在生成json字符串的时候，有些情况下，需要将java对象，集合，列表中的某些属性过滤掉。 如级联对象，这个时候就需要传入需要过滤的属性字符串数组。
	 * 
	 * @param propArray 需要过滤的属性字符串数组
	 * @return JsonConfig对象，用于在<code>JSONArray.fromObject(String, JsonConfig)</code> 的，第二个参数使用。
	 * @author: LiKun 2009-2-1 下午03:38:49
	 */
	public static JsonConfig excludeJsonProperty(String[] propArray)
	{
		JsonConfig config = new JsonConfig();
		final String[] array = propArray;
		config.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object source, String name, Object value)
			{
				for (String propName : array)
				{
					if (name.equals(propName))
					{
						return true;
					}
				}
				return false;
			}
		});
		return config;
	}

	/**
	 * 在进行json转换时,把需要的属性设置到json中，也就是说，只保留需要的属性。 与上述函数相对应。
	 * 
	 * @param propArray 需要保留的属性列表
	 * @return JsonConfig对象，用于在<code>JSONArray.fromObject(String, JsonConfig)</code> 的，第二个参数使用。
	 * @author: LiKun 2009-2-1 下午03:38:49
	 */
	public static JsonConfig includeJsonProperty(String[] propArray)
	{
		JsonConfig config = new JsonConfig();
		final String[] array = propArray;
		config.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object source, String name, Object value)
			{
				for (String propName : array)
				{
					if (name.equals(propName))
					{
						return false;
					}
				}
				return true;
			}
		});
		return config;
	}

	/**
	 * 得到数组转化后的json串，只保留"id"和"name"两个属性 <p><code>
	 * String str= "[{'id':5, 'name':'a', 'gender':'m'}]";<br/>
		String a = getArrayJson(str);<br/>
		System.out.println(a);<br/>
		//print [{"id":5,"name":"a"}]<br/>
	 * </code></p>
	 * 
	 * @param obj
	 * @return 转化后的json字符串
	 * @author: LiKun 2009-3-12 上午11:00:45
	 */
	public static String getArrayJson(Object obj)
	{
		JsonConfig config = Utility.includeJsonProperty(new String[]{
					"id", "name"});
		return JSONArray.fromObject(obj, config).toString();
	}

	/**
	 * 得到数组转化后的json串,需传入自定义的转化属性的数组。可参考上述例子。
	 * 
	 * @param obj
	 * @param array
	 * @return
	 * @author: LiKun 2009-3-12 上午11:00:47
	 */
	public static String getArrayJson(Object obj, String[] array)
	{
		JsonConfig config = Utility.includeJsonProperty(array);
		return JSONArray.fromObject(obj, config).toString();
	}

	/**
	 * 给选择下拉框新建“全部”首选项
	 * 
	 * @param list
	 * @return
	 * @author: LiKun 2009-2-3 上午11:39:01
	 */
	public static List<Map<String, String>> appendOption(List<Map<String, String>> list)
	{
		if (list != null && list.size() > 0)
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "全部");
			map.put("id", "");
			list.add(0, map);
		}
		return list;
	}

	/**
	 * 把含有满足该reg正则表达式分隔符的原串分解为","形式的串如：一："1-3",转为:",1,2,3,4,"二："3" 转为",3,"
	 * 
	 * @param src
	 * @return 正确：返回分解后串信息 否则：null
	 * @author: zhangyongjie 2009-3-12 上午10:17:32
	 */
	public static String getStrBreakInfo(String str)
	{
		String result = getStrSplitComma(str);
		return isNullOrEmpty(result) ? result : "," + result + ",";
	}

	/**
	 * @function: 将字符串“1-5”，分解成“1,2,3,4,5”
	 * @param str 字符串 格式为1-5的
	 * @return “1,2,3,4,5”
	 * @author: Yuan Nan 2010-7-7 下午02:03:35
	 */
	public static String getStrSplitComma(String str)
	{
		if (isNullOrEmpty(str))
		{
			return "";
		}
		str = str.trim();
		// 用正则判断原串的合法性：两种格式
		// 1.判断是否符合1,2,3格式
		String result = "";
		String regex = "(\\d)+([,](\\d))*";
		Pattern p = Pattern.compile(regex);
		if (p.matcher(str).matches())
		{// 若匹配，直接返回
			result = str;
		} else
		{
			// 否则，判断第二种格式
			// 2.判断是滞符合1-3格式
			regex = "(\\d)+([-](\\d))?(\\d)*";
			p = Pattern.compile(regex);
			if (p.matcher(str).matches())
			{
				// 若匹配第二种形式
				String[] details = str.split("-");
				int begin = Integer.parseInt(details[0]);
				int end = Integer.parseInt(details[1]);
				StringBuffer buffer = new StringBuffer();
				for (int k = begin; k <= end; k++)
				{
					if (k == end)
					{
						buffer.append(k);// 最后一个不用","
					} else
					{
						buffer.append(k).append(",");
					}
				}
				result = buffer.toString();
			}
		}
		return result;
	}

	/**
	 * 把含有满足该reg正则表达式分隔符的原串分解为","形式的串如：1-3,转为:'1','2','3'
	 * 
	 * @param src
	 * @return
	 * @author: zhangyongjie 2009-2-5 下午04:22:44
	 */
	public static String getStrDetails(String src)
	{
		if (isNullOrEmpty(src))
		{
			return "";
		}
		src = src.trim();
		// 用正则判断原串的合法性：两种格式
		// 1.判断是否符合1,2,3格式
		String backInfo = null;
		String regex = "(\\d)+([,](\\d))*";
		Pattern p = Pattern.compile(regex);
		if (p.matcher(src).matches())
		{// 若匹配，直接返回
			backInfo = src;
		} else
		{
			// 否则，判断第二种格式
			// 2.判断是滞符合1-3格式
			regex = "(\\d)+([-](\\d))?(\\d)*";
			p = Pattern.compile(regex);
			if (!p.matcher(src).matches())
			{// 若不匹配
				backInfo = null;
			} else
			{
				// 若匹配第二种形式
				String[] details = src.split("-");
				int begin = Integer.parseInt(details[0]);
				int end = Integer.parseInt(details[1]);
				StringBuffer buffer = new StringBuffer();
				for (int k = begin; k <= end; k++)
				{
					if (k == end)
					{
						buffer.append(k);// 最后一个不用","
					} else
					{
						buffer.append(k).append(",");
					}
				}
				backInfo = buffer.toString();
			}
		}
		// 为返回值加引号处理
		StringBuffer backBuffer = new StringBuffer();
		if (backInfo != null)
		{
			String[] info = backInfo.split(",");
			for (int k = 0; k < info.length; k++)
			{
				if (k == info.length - 1)
				{
					backBuffer.append("'").append(info[k]).append("'");// 最后一个不用","
				} else
				{
					backBuffer.append("'").append(info[k]).append("'").append(",");
				}
			}
		}
		return backBuffer.toString();
	}

	/** ********************************精确的金额计算 START******************************* */
	/**
	 * 保留小数点后二位
	 * 
	 * @param number
	 * @return 处理后的数值
	 * @author: lilinhui 2009-2-13 上午11:48:07
	 */
	public static double saveTwoDecimalFraction(double number)
	{
		return roundHalfUp(number, 2);
	}

	/**
	 * 精确的加法运算（支持多个数相加）
	 * 
	 * @param number 数字组成的数组
	 * @return 加法运算后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double add(double[] number)
	{
		BigDecimal sum = new BigDecimal(0d);
		for (double num : number)
		{
			sum = sum.add(new BigDecimal(Double.toString(num)));
		}
		return sum.doubleValue();
	}

	/**
	 * 精确的加法运算（两个数相加）
	 * 
	 * @param v1 加数
	 * @param v2 被加数
	 * @return 加法运算后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double add(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 精确的减法运算
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 减法运算后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double subtract(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1 乘数
	 * @param v2 被乘数
	 * @return 乘法运算后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double multiply(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	// modified by Wang Cheng 2010-12-15 [ZKP-93] begin
	/**
	 * 提供精确的除法运算
	 * 
	 * @param v1 除数
	 * @param v2 被除数
	 * @return 结果保留10为小数，四舍五入。
	 * @author yuannan
	 */
	public static double division(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	// [ZKP-92] end
	/**
	 * 提供精确的四舍五入处理.
	 * 
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 处理后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double roundHalfUp(double v, int scale)
	{
		BigDecimal b = new BigDecimal(Double.toString(v));
		return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向下舍入的舍入模式
	 * 
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 处理后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double roundHalfDown(double v, int scale)
	{
		BigDecimal b = new BigDecimal(Double.toString(v));
		return b.setScale(scale, BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}

	/**
	 * 接近正无穷大的舍入模式（向上舍入）
	 * 
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 处理后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double ceiling(double v, int scale)
	{
		BigDecimal b = new BigDecimal(Double.toString(v));
		return b.setScale(scale, BigDecimal.ROUND_CEILING).doubleValue();
	}

	/**
	 * 接近负无穷大的舍入模式（向下舍入）
	 * 
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 处理后的结果
	 * @author Liujuan 2009-6-25 下午02:14:25
	 */
	public static double floor(double v, int scale)
	{
		BigDecimal b = new BigDecimal(Double.toString(v));
		return b.setScale(scale, BigDecimal.ROUND_FLOOR).doubleValue();
	}

	/** ********************************精确的金额计算 END******************************* */
	/**
	 * @function: 判断字符是否为整数类型
	 * @param s 字符串
	 * @return
	 * @author: Yuan Nan 2010-7-7 下午02:12:56
	 */
	public static boolean isInteger(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * @function: 判断整数对象是否为null
	 * @param i 整数对象
	 * @return null返回true，否则返回true
	 * @author: Yuan Nan 2010-7-7 下午02:18:59
	 */
	public static boolean isNull(Integer i)
	{
		return i == null ? true : false;
	}

	/**
	 * @function: 判断字符串对象是否为null
	 * @param s 字符串对象
	 * @return null返回true，否则返回true
	 * @author: Yuan Nan 2010-7-7 下午02:19:35
	 */
	public static boolean isNull(String s)
	{
		return s == null ? true : false;
	}

	/**
	 * @function: 判断字符串是否为null或者空串或者为‘null’字符串
	 * @param s 要判断的字符串
	 * @return 结果
	 * @author: Yuan Nan 2010-7-7 下午02:20:58
	 */
	public static boolean isNullOrEmpty(String s)
	{
		return s == null || s.trim().equals("") || s.trim().equals("null") ? true : false;
	}

	/**
	 * @function:将null转换为空串。
	 * @param s null
	 * @return 空串
	 * @author: Yuan Nan 2010-7-7 下午02:21:56
	 */
	public static String nullToString(String s)
	{
		return s == null ? "" : s;
	}

	/**
	 * @function: 将null对象转为空串
	 * @param o null对象
	 * @return 空串
	 * @author: Yuan Nan 2010-7-7 下午02:22:38
	 */
	public static String nullObjectToString(Object o)
	{
		return o == null ? "" : o.toString();
	}

	/**
	 * @function: 将null对象，转为0.0d
	 * @param o
	 * @return
	 * @author: Yuan Nan 2010-7-7 下午02:23:52
	 */
	public static Double nullObjectToDouble(Object o)
	{
		if (o == null)
		{
			return 0.0;
		} else
		{
			try
			{
				return Double.parseDouble(o.toString());
			} catch (Exception e)
			{
				return 0.0;
			}
		}
	}

	/**
	 * @function: 将空字符串转为字符串0.00
	 * @function:
	 * @param o
	 * @return String 0.00
	 * @author: Wang Cheng    2010-9-6 下午05:31:20
	 */
	public static String emptyStringToZero(String str)
	{
		return str.length() == 0 ? "0.00" : str;
	}

	public static Integer nullObjectToInteger(Object o)
	{
		if (o == null)
		{
			return 0;
		} else
		{
			try
			{
				return Integer.parseInt(o.toString());
			} catch (Exception e)
			{
				return 0;
			}
		}
	}

	/**
	 * Return whether the given array is empty: that is, <code>null</code> or of zero length.
	 * 
	 * @param array the array to check
	 * @return whether the given array is empty
	 */
	public static boolean isEmpty(Object[] array)
	{
		return array == null || array.length == 0;
	}

	/**
	 * Convenience method to return a String array as a delimited (e.g. CSV) String. E.g. useful for
	 * <code>toString()</code> implementations.
	 * 
	 * @param arr the array to display
	 * @param delim the delimiter to use (probably a ",")
	 * @return the delimited String
	 */
	public static String arrayToDelimitedString(Object[] arr, String delim)
	{
		if (isEmpty(arr))
		{
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
		{
			if (i > 0)
			{
				sb.append(delim);
			}
			sb.append("'" + arr[i] + "'");
		}
		return sb.toString();
	}

	/**
	 * 强制double显示为正常形式的数字，防止出现科学技术法
	 * 
	 * @param d
	 * @return
	 * @author: likun 2010-7-7 下午03:15:26
	 */
	public static String noScientific(double d)
	{
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
		return df.format(d);
	}

	/**
	 * 票号位数处理
	 * 
	 * @param 票号
	 * @return 票号,票数位数
	 * @author: liulinkun  2011-04-15 下午03:15:26
	 */
	public static String formatInvoiceNo(Integer invoiceNumber, Integer median)
	{
		String invoiceNo = invoiceNumber.toString();
		while (invoiceNo.length() < median)
		{
			invoiceNo = "0" + invoiceNo;
		}
		return invoiceNo;
	}

	/**
	 * @function:看看前台的多选框是选中了呢还是没选中呢?
	 * @param checked 多选框的选中情况
	 * @return true:选中；false:未选中
	 * @author: zhaoxinchun    2011-12-21 下午03:03:07
	 */
	public static Boolean isCheckedCheckBox(String checked)
	{
		if (checked == null)
		{
			return false;
		} else
		{
			return true;
		}
	}
}

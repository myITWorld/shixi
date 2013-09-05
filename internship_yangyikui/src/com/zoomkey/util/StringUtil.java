/*
 * 创建日期 2005-7-20
 *
 * 
 */

package com.zoomkey.util;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qiaoli.xu
 * @version 1.0 字符串方法
 */
public class StringUtil
{

	/**
	 * 获得服务器文件的路径分隔符
	 */
	public static String getSeparator()
	{
		return File.separator;
	}

	/**
	 * 当字符串为null，或者没有值是 返回true,否则返回false
	 * 
	 * @function:判断一个字符串是否为空
	 * @param value
	 * @return true/false
	 */
	public static boolean isEmpty(String value)
	{
		if (value == null || value.trim().length() < 1)
		{
			return true;
		}
		return false;
	}

	/**
	 * @function:将String数组转换为，以separator分隔的字符串
	 * @param s 需要转换的字符串数组
	 * @param separator 分隔符
	 * @return 以separator分隔的字符串
	 * @author: Yuan Nan 2010-7-7 上午10:26:23
	 */
	public static String arrayToString(String[] s, String separator)
	{
		StringBuilder returnValue = new StringBuilder();
		if (s != null && separator != null)
		{
			for (int i = 0; i < s.length; i++)
			{
				returnValue.append(s[i]);
				returnValue.append(separator);
			}
		}
		return returnValue.toString();
	}

	/**
	 * @function: 将字符串以分隔符切割形成字符串数组
	 * @param str 字符串
	 * @param separator 分隔符
	 * @return 对于长度为零的字符串返回null，否则返回由分隔符切割的字符串数组
	 * @author: Yuan Nan 2010-7-7 上午10:28:58
	 */
	public static String[] stringToArray(String str, String separator)
	{
		return str.isEmpty() ? null : str.split(separator);
	}

	/**
	 * @function:判断str是否包含在List&lt;string&gt;中
	 * @param lis 字符列表
	 * @param str 字符
	 * @return 如果字符参数在列表中，则返回true
	 * @author: Yuan Nan 2010-7-7 上午10:31:06
	 */
	public static boolean contains(List<String> lis, String str)
	{
		for (String item : lis)
		{
			if (str.equals(item))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @function: 把特殊字符替换成全角
	 */
	public static String escapeChar(String input)
	{
		if (input == null || input.length() == 0)
		{
			return input;
		}
		String regEx = ">|<|&|\"|'"; // 表示a或f
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(input);
		if (!m.find())
		{
			return input;
		}
		StringBuffer buf = new StringBuffer(input.length() + 6);
		char ch = ' ';
		for (int i = 0; i < input.length(); i++)
		{
			ch = input.charAt(i);
			switch (ch)
			{
				case '>' :
					buf.append("＞");
					break;
				case '<' :
					buf.append("＜");
					break;
				case '&' :
					buf.append("＆");
					break;
				case '"' :
					buf.append("＂");
					break;
				case '\'' :
					buf.append("＇");
					break;
				default :
					buf.append(ch);
			}
		}
		return buf.toString();
	}

	/**
	 * @function: 将html中的特殊字符替换为全角字符，尤其用于textarea
	 * @param strContent 被替换的字符串
	 * @return 替换后的字符串
	 * @author: Yuan Nan 2010-7-7 上午10:34:37
	 */
	public static String MyHtmlEncode(String strContent)
	{
		strContent = strContent.replace("&", "＆");
		strContent = strContent.replace("'", "＇");
		strContent = strContent.replace("<", "＜");
		strContent = strContent.replace(">", "＞");
		strContent = strContent.replace("chr(60)", "＜");
		strContent = strContent.replace("chr(37)", "＞");
		strContent = strContent.replace("\"", "＂");
		strContent = strContent.replace(";", "；");
		strContent = strContent.replace("\r\n", "<br>");
		strContent = strContent.replace(" ", "　");
		return strContent;
	}

	/**
	 * @function: 过滤掉换行符号,用于textarea
	 * @return
	 * @author: wangnan 2008-1-18 下午01:51:50
	 */
	public static String filterEnter(String src)
	{
		if (src == null)
		{
			return "";
		}
		String enter = String.valueOf((char) 13) + String.valueOf((char) 10);
		if (src.endsWith(enter))
		{
			// 存在换行,过滤掉
			return src.substring(0, src.length() - enter.length());
		}
		return src;
	}

	/**
	 * @function:将空串转换为空格
	 * @param str
	 * @return
	 * @author: Wang Cheng [ZKP-84] 2010-9-13 下午12:40:54
	 */
	public static String emptyToSpace(String str)
	{
		if (null == str || str.length() > 0)
		{
			return str;
		}
		return " ";
	}
}

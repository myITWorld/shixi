
package com.zoomkey.components.valuelist;

/**
 * Used by Yang HOng na
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.mlw.vlh.DefaultValueListHandlerImpl;
import net.mlw.vlh.ValueList;
import net.mlw.vlh.ValueListHandler;
import net.mlw.vlh.ValueListInfo;
import net.mlw.vlh.adapter.jdbc.dynabean.DefaultDynaBeanAdapter;
import net.mlw.vlh.web.ValueListRequestUtil;
import net.mlw.vlh.web.mvc.ValueListHandlerHelper;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zoomkey.common.ConstantDefine;
import com.zoomkey.servlet.ApplicationContextKeeper;
import com.zoomkey.util.BasalInfo;

/**
 * 便于在struts中操作valuelist的工具类 USAGE: 在从strtus action继承的类中 ValueListUtil vlu = new
 * ValueListUtil(getServlet().getServletContext()); Map params = new HashMap();
 * params.put("loginID","1"); vlu.handleValueList("queryEntry",params,request)
 * 
 * @author Albert Song
 */
public class ValueListUtil {

	protected static ValueListHandlerHelper	valueListHelper;

	// 限制查询条件（只显示用户所在供热站的信息）
	protected static String							VL_QUERY_KEY_USER_HEATING_ID	= "limitUserHeatingId";

	/**调试模式缓存名称*/
	private static final String					DEBUG_MODE_CACHE					= "debugMode";

	/**项目配置文件名*/
	private static final String					PROPERTIES_FILE_NAME				= "projectsettings.properties";

	/**
	 * @function:返回通过valuelist查询记录   //modify by likun 20101201  返回所有记录，需要返回指定行数纪录时再添加重构方法
	 */
	public static List getValueListResult(String adapter, Map queries, HttpServletRequest request) {
		// get valueListHelper
		valueListHelper = (ValueListHandlerHelper) ApplicationContextKeeper.getService("valueListHelper");
		reloadValueListContext(request, valueListHelper);
		// get table info
		Map map = new HashMap();
		// put table info and query info together
		map.putAll(queries);
		ValueListInfo info = new ValueListInfo(map);
		ValueList valueList = valueListHelper.getValueList(adapter, info);
		return valueList.getList();
	}

	/**
	 * @function:Ext前台传入开始记录数和结束记录数，返回通过valuelist查询的结果
	 * @param adapter
	 * @param queries
	 * @param request
	 * @return
	 * @author: likun 2010-5-12 下午05:30:55
	 */
	public static JSONObject getJsonForExt(String adapter, Map queries, HttpServletRequest request) {
		// 通过valuelist查询出记录信息
		ValueList valueList = getListForExt(adapter, queries, request);
		JSONObject json = fillJson(valueList);
		return json;
	}

	/**
	 * @function: 将查询结果填充到json中
	 * @param valueList
	 * @return 
	 * @author: wangcheng    2013-2-27 下午03:33:59
	 */
	public static JSONObject fillJson(ValueList valueList) {
		JSONObject json = new JSONObject();
		// add by Wang Cheng 2010-11-26 [ZKP-84] begin
		// 置入总记录条数
		json.put("success", true);
		// [ZKP-84] end
		json.put("totalProperty", valueList.getValueListInfo().getTotalNumberOfEntries());
		// 置入当前页记录列表json串
		json.put("root", JSONArray.fromObject(valueList.getList()).toString());
		return json;
	}

	/**
	 * @function: 将查询结果填充到json中（用于对统计store的数据处理）
	 * @param valueList
	 * @param map 统计数据map
	 * @return json串
	 * @author: wangcheng    2013-2-27 下午03:33:59
	 */
	public static String fillJson(ValueList valueList, Map<String, Object> map) {
		JSONObject json = new JSONObject();
		// add by Wang Cheng 2010-11-26 [ZKP-84] begin
		// 置入总记录条数
		json.put("success", true);
		// [ZKP-84] end
		json.put("totalProperty", valueList.getValueListInfo().getTotalNumberOfEntries());
		// 置入当前页记录列表json串
		json.put("root", JSONArray.fromObject(map).toString());
		return json.toString();
	}

	/**
	 * @function: Ext前台传入开始记录数和结束记录数，返回通过valuelist查询的结果
	 * @param adapter
	 * @param queries
	 * @param request
	 * @return
	 * @author: wangcheng    2011-4-1 下午02:45:41
	 */
	public static ValueList getListForExt(String adapter, Map queries, HttpServletRequest request) {
		valueListHelper = (ValueListHandlerHelper) ApplicationContextKeeper.getService("valueListHelper");
		reloadValueListContext(request, valueListHelper);
		Map map = ValueListRequestUtil.getRequestParameterMap(request, null);
		map.putAll(queries);
		handleSortAndDirection(queries, map);
		ValueListInfo info = new ValueListInfo(map);
		// 获得开始记录数以及每页条数
		if (request.getParameter("limit") != null) {
			info.setPagingNumberPer(Integer.parseInt(request.getParameter("limit")));
		}
		if (request.getParameter("start") != null) {
			info.setPagingPage(Integer.parseInt(request.getParameter("start")) / info.getPagingNumberPer() + 1);
		}
		// 通过valuelist查询处记录信息
		ValueList valueList = valueListHelper.getValueList(adapter, info);
		return valueList;
	}

	/**
	 * @function:默认查询，查询结果放到request的list变量中
	 * @param adapter
	 * @param queries
	 * @param tableId
	 * @param request
	 */
	public static void setValueListToRequest(String adapter, Map queries, String tableId, HttpServletRequest request) {
		// get valueListHelper
		valueListHelper = (ValueListHandlerHelper) ApplicationContextKeeper.getService("valueListHelper");
		reloadValueListContext(request, valueListHelper);
		// get table info
		Map map = ValueListRequestUtil.getRequestParameterMap(request, tableId);
		// put table info and query info together
		map.putAll(queries);
		ValueListInfo info = new ValueListInfo(map);
		ValueList valueList = valueListHelper.getValueList(adapter, info);
		int totalNumberOfEntries = info.getTotalNumberOfEntries();
		int intPagingPage = info.getPagingPage();
		if (totalNumberOfEntries == 0 && intPagingPage > 1) {
			info.setPagingPage(intPagingPage - 1);
			valueList = valueListHelper.getValueList(adapter, info);
			valueListHelper.setValueListTo(request, valueList, "list");
		}
		valueListHelper.backupInfoFor(request, info, tableId);
		valueListHelper.setValueListTo(request, valueList, "list");
	}

	/**
	 * 通过定义新的listname来支持一次进行多个查询
	 * 
	 * @param adapter
	 * @param queries
	 * @param tableId
	 * @param request
	 * @param listDefault
	 * @param listName
	 */
	public static void setValueListToRequest(String adapter, Map queries, String tableId, HttpServletRequest request, boolean listDefault, String listName) {
		// get valueListHelper
		valueListHelper = (ValueListHandlerHelper) ApplicationContextKeeper.getService("valueListHelper");
		reloadValueListContext(request, valueListHelper);
		// get table info
		Map map = ValueListRequestUtil.getRequestParameterMap(request, tableId);
		// put table info and query info together
		map.putAll(queries);
		ValueListInfo info = new ValueListInfo(map);
		ValueList valueList = null;
		try {
			valueList = valueListHelper.getValueList(adapter, info);
		} catch (Exception e) {
			// 当页面HIDDEN了当前页码，在删除一页的最后一条数据时，查询会出现问题,这里进行屏蔽，由下面重新查询, ：《现在无效
		}
		info.getTotalNumberOfEntries();
		int intPagingPage = info.getPagingPage();
		if ((valueList == null || valueList.getList() == null || valueList.getList().size() == 0) && intPagingPage > 0) {
			info.setPagingPage(intPagingPage - 1);
			valueList = valueListHelper.getValueList(adapter, info);
		}
		valueListHelper.backupInfoFor(request, info, tableId);
		if (listDefault) {
			valueListHelper.setValueListTo(request, valueList, "list");
		} else {
			// 采用其他request属性保存list
			valueListHelper.setValueListTo(request, valueList, listName);
		}
	}

	/**
	 * @function:在默认查询的基础上，根据传入的参数修改每页显示的记录数，查询结果放到request的list变量中
	 * @param adapter
	 * @param queries
	 * @param tableId
	 * @param request
	 * @param pageingNum每页显示的记录数
	 */
	public static void setValueListToRequest(String adapter, Map queries, String tableId, HttpServletRequest request, int pageingNum) {
		// get valueListHelper
		valueListHelper = (ValueListHandlerHelper) ApplicationContextKeeper.getService("valueListHelper");
		reloadValueListContext(request, valueListHelper);
		// get table info
		Map map = ValueListRequestUtil.getRequestParameterMap(request, tableId);
		// put table info and query info together
		map.putAll(queries);
		ValueListInfo info = new ValueListInfo(map);
		info.setPagingNumberPer(pageingNum);
		ValueList valueList = valueListHelper.getValueList(adapter, info);
		int totalNumberOfEntries = info.getTotalNumberOfEntries();
		int intPagingPage = info.getPagingPage();
		if (totalNumberOfEntries == 0 && intPagingPage > 1) {
			info.setPagingPage(intPagingPage - 1);
			valueList = valueListHelper.getValueList(adapter, info);
			valueListHelper.setValueListTo(request, valueList, "list");
		}
		valueListHelper.backupInfoFor(request, info, tableId);
		valueListHelper.setValueListTo(request, valueList, "list");
	}

	/**
	 * 从ActionServlet里取出来的ServletContext
	 */
	private ServletContext	sc							= null;

	private String				sql						= null;

	/**
	 * 保存配置文件中的valuelist handler bean id
	 */
	private String				valueListHandlerName	= "valueListHandler";

	/**
	 * @param sc
	 */
	public ValueListUtil(ServletContext sc) {
		this.sc = sc;
	}

	/**
	 * @param sc
	 * @param vlh 配置文件中对应的ValueListHandler id
	 */
	public ValueListUtil(ServletContext sc, String valueListHandlerName) {
		this.sc = sc;
		this.valueListHandlerName = valueListHandlerName;
	}

	/**
	 * @function:为ValueList新建统计字段，新字段名成为summaryColumnName+"Sum"
	 * @param valueList
	 * @param summaryColumnName 需统计的字段名称
	 * @return 拼加字段后的valueList
	 * @author: hanmeng 2008-2-2 下午04:25:05
	 */
	public List<Map<String, Object>> addSummaryColumnForValueList(ValueList valueList, String summaryColumnName) {
		// 得到list
		List<Map<String, Object>> orignList = valueList.getList();
		// 配置的每页显示条数
		int numPerPage = valueList.getValueListInfo().getPagingNumberPer();
		// 用于指定统计字段的个数统计
		Integer num = 0;
		// 待操作的valueList长度
		int listLength;
		// valueList的每一条记录的Map
		Map<String, Object> currenResultM = null;
		// 统计字段集合
		Map<String, Object> summaryColumnMap = new HashMap<String, Object>();
		if (null == orignList || 0 == orignList.size() || null == (currenResultM = orignList.get(0))) {
			return orignList;
		}
		if (orignList.size() < numPerPage) {
			listLength = orignList.size();
		} else {
			listLength = numPerPage;
		}
		// 统计生成统计字段集合summaryColumnMap
		for (int index = 0; index < listLength; index++) {
			currenResultM = orignList.get(index);
			// 统计字段名称
			String columnName = (String) currenResultM.get(summaryColumnName);
			if (summaryColumnMap.get(columnName) != null) {
				num = (Integer) summaryColumnMap.get(columnName);
			} else {
				num = 0;
			}
			summaryColumnMap.put(columnName, ++num);
		}
		// 将统计字段集合summaryColumnMap填充到ValueList的新字段中去，新字段名成为summaryColumnName+"Sum"
		for (int index = 0; index < listLength; index++) {
			currenResultM = orignList.get(index);
			// 统计字段名称
			String columnName = (String) currenResultM.get(summaryColumnName);
			Set<String> keys = summaryColumnMap.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String key = it.next();
				if (key.equals(columnName)) {
					Integer serviceNum = (Integer) summaryColumnMap.get(key);
					currenResultM.put(summaryColumnName + "Sum", serviceNum);
				}
			}
		}
		return orignList;
	}

	/**
	 * default getValueListHandler
	 */
	public ValueListHandler getValueListHandler() {
		return getValueListHandler(this.valueListHandlerName);
	}

	/**
	 * getValueListHandler
	 */
	public ValueListHandler getValueListHandler(String handlerID) {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.sc);
		return (ValueListHandler) context.getBean(handlerID, ValueListHandler.class);
	}

	/**
	 * @param request
	 * @param valueListEntry valuelist 配置文件中的Entry
	 */
	public void handleValueList(String valueListEntry, HttpServletRequest request) {
		Map params = new HashMap();
		handleValueList(valueListEntry, params, request, "valueListInfo", "list");
	}

	/**
	 * @param valueListEntry
	 * @param request
	 * @param valueListInfoName
	 * @param valueListName
	 */
	public void handleValueList(String valueListEntry, HttpServletRequest request, String valueListInfoName, String valueListName) {
		Map params = new HashMap();
		handleValueList(valueListEntry, params, request, valueListInfoName, valueListName);
	}

	/**
	 * @param valueListEntry
	 * @param params
	 * @param request
	 */
	public void handleValueList(String valueListEntry, Map params, HttpServletRequest request) {
		handleValueList(valueListEntry, params, request, "valueListInfo", "list");
	}

	/**
	 * @param valueListEntry 配置文件中sql的Entry
	 * @param params 自定义参数值，可以通过params改变或增加参数
	 * @param request
	 * @param valueListInfoName 设置到request中的valueListInfo的名字
	 * @param valuListName 设置到request中的valueList的名字
	 */
	public void handleValueList(String valueListEntry, Map params, HttpServletRequest request, String valueListInfoName, String valueListName) {
		handleValueList(valueListEntry, params, request, valueListInfoName, valueListName, "");
	}

	/**
	 * @param valueListEntry 配置文件中sql的Entry
	 * @param params 自定义参数值，可以通过params改变或增加参数
	 * @param request
	 * @param valueListInfoName 设置到request中的valueListInfo的名字
	 * @param valuListName 设置到request中的valueList的名字
	 * @param tableID jsp中table的id
	 */
	public void handleValueList(String valueListEntry, Map params, HttpServletRequest request, String valueListInfoName, String valueListName, String tableID) {
		Map parameters = ValueListRequestUtil.getRequestParameterMap(request, tableID);
		parameters.putAll(params);
		if (this.sql != null) {
			DefaultValueListHandlerImpl handler = (DefaultValueListHandlerImpl) getValueListHandler();
			// Hibernate20Adapter adapter =
			// (Hibernate20Adapter)handler.getConfig().getAdapter(valueListEntry);
			DefaultDynaBeanAdapter adapter = (DefaultDynaBeanAdapter) handler.getConfig().getAdapter(valueListEntry);
			adapter.setSql(this.sql);
		}
		ValueList valueList = getValueListHandler().getValueList(valueListEntry, new ValueListInfo(parameters));
		ValueListInfo valueListInfo = valueList.getValueListInfo();
		request.setAttribute(valueListInfoName, valueListInfo);
		request.setAttribute(valueListName, valueList);
	}

	/**
	 * @function:无指定条数限制（默认为系统支持最大数量）,返回查询结果list(可以直接利用)
	 * @param adapter
	 * @param queries
	 * @param tableId
	 * @param request
	 */
	public static List getListNoPagingNumLimit(String adapter, Map queries, String tableId, HttpServletRequest request) {
		valueListHelper = (ValueListHandlerHelper) ApplicationContextKeeper.getService("valueListHelper");
		reloadValueListContext(request, valueListHelper);
		Map map = ValueListRequestUtil.getRequestParameterMap(request, tableId);
		map.putAll(queries);
		handleSortAndDirection(queries, map);
		ValueListInfo info = new ValueListInfo(map);
		info.setPagingNumberPer(ConstantDefine.EXCEL_EXPORT_LIMIT);
		ValueList valueList = valueListHelper.getValueList(adapter, info);
		int totalNumberOfEntries = info.getTotalNumberOfEntries();
		int intPagingPage = info.getPagingPage();
		if (totalNumberOfEntries == 0 && intPagingPage > 1) {
			info.setPagingPage(intPagingPage - 1);
			valueList = valueListHelper.getValueList(adapter, info);
		}
		return valueList.getList();
	}

	public String getSql() {
		return this.sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	/**
	 * @function: 传true时热部署applicationContext-pages.xml，使修改查询语句立即生效
	 * @param request
	 * @param valueListHelper
	 * @author: wangcheng    2012-9-7 下午04:11:55
	 */
	private static void reloadValueListContext(HttpServletRequest request, ValueListHandlerHelper valueListHelper) {
		valueListHelper.reloadValueListContext(isInDebugMode(request));
	}

	/**
	 * @function: 判断是否处在开发模式
	 * @return true：是；false：否
	 * @author: wangcheng    2012-9-10 下午04:29:05
	 */
	private static Boolean isInDebugMode(HttpServletRequest request) {
		Cache debugModeCache = BasalInfo.getCache(DEBUG_MODE_CACHE);
		Element element = debugModeCache.get(DEBUG_MODE_CACHE);
		if (element != null) {
			return (Boolean) element.getValue();
		} else {
			try {
				Boolean isInDebugMode = Boolean.valueOf(BasalInfo.getPropertiesFromFile(request, PROPERTIES_FILE_NAME)
					.getProperty("isInDebugMode"));
				element = new Element(DEBUG_MODE_CACHE, isInDebugMode);
				debugModeCache.put(element);
				return isInDebugMode;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * @function: 处理排序列及排序方向
	 * @param queries 
	 * @param map
	 * @author: wangcheng    2013-2-27 上午09:52:01
	 */
	private static void handleSortAndDirection(Map queries, Map map) {
		if (map.get("sort") != null) {
			map.put("defaultSort", null);
			queries.put("sort", map.get("sort"));
			queries.put("dir", map.get("dir"));
		} else {
			map.put("defaultSort", true);
		}
	}
}

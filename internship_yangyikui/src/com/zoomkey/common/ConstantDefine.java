/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms_SmallBusiness
 * com.berheley.hcms.common.ConstantDefine.java
 * Created on 2009-8-3-上午10:42:45
 */

package com.zoomkey.common;

/**
 * 类功能描述：固定常量定义
 * 
 * @author <a href="mailto:kun.li@berheley.com">LiKun</a>
 */
public class ConstantDefine {

	/** 年度分隔符 */
	public static final String		YEAR_SEPRATOR								= "-";

	/** 批量修改时的分隔符 */
	public static final String		BATCH_INPUT_SEPRATOR						= "-";

	/** 楼单元室分隔符*/
	public static final String		ADDRESS_SEPERATOR							= "~@~";

	/** excel数据导出条数限制 */
	public static final Integer	EXCEL_EXPORT_LIMIT						= 60000;

	/** 批量提交数据库的个数(该参数要与hibernate配置文件中hibernate.jdbc.batch_size一致) */
	public static final Integer	BATCH_SIZE									= 100;

	/**主题："热计量结算短信"*/
	public static final String		HEATING_SETTLE_ACCOUNTS_MSG			= "热计量结算短信";

	/**欠费催缴短信主题*/
	public static final String		PAYMENT_REMINDER_MSG						= "欠费催缴短信";

	/**一个楼层可容纳的最大房间数*/
	public static final int			MAX_PRE_FLOOR_CELL_SUM					= 30;

	/**收费示意图操作*/
	public static final String		CHARGE_DIAGRAM_OPT						= "1";

	/**客户示意图操作*/
	public static final String		CUSTOMER_DIAGRAM_OPT						= "2";

	/**稽查示意图操作*/
	public static final String		CUS_CHECK_DIAGRAM_OPT					= "3";

	/**一个单元最高的楼层数*/
	public static final int			MAX_FLOOR_SUM								= 50;

	/**每条短信字数限制*/
	public static final int			MESSAGE_WORDS_SUM							= 61;

	/**采暖变更操作无时间限制权限CODE*/
	public static final String		PRIVILEGE_HEATING_CHANGE_UNLIMITED	= "HEATING_CHANGE_UNLIMITED";

	/**增减原因树中的优惠节点*/
	public static final String		FAVOURABLE_ITEM							= "favFlag";

	/**费用减免名称*/
	public static final String		FEE_DERATE_NAME							= "费用减免";

	/**费用减免ID*/
	public static final String		FEE_DERATE_ID								= "1";

	/** 未入网客户状态 */
	public static final String		NOT_ACCESS_CUS_STATUS					= "5";

	/** "全部"选项标识 */
	public static final String		ALL											= "all";

	/**"总公司"标识*/
	public static final String		HEAD_COMPANY								= "0";

	/**bo接口参数不符合约定规则时抛出的异常说明*/
	public static final String		INTERFACE_PARAM_ERROR					= "操作失败，请重试";
}

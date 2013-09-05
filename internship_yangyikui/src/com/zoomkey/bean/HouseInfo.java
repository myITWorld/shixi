
package com.zoomkey.bean;

import java.util.List;
import java.util.Map;

/**
 * 类功能描述：单元信息
 * 
 * @author <a href="mailto:zhaoli.li@berheley.com">lilizhao </a>
 */
public class HouseInfo implements java.io.Serializable
{

	/** 序列id */
	private static final long				serialVersionUID	= -5614666265527746209L;

	/** 单元号 */
	private String								houseNo;

	/** 同一单元中的详细信息list */
	private List<Map<String, Object>>	detail;

	public String getHouseNo()
	{
		return this.houseNo;
	}

	public void setHouseNo(String houseNo)
	{
		this.houseNo = houseNo;
	}

	public List<Map<String, Object>> getDetail()
	{
		return this.detail;
	}

	public void setDetail(List<Map<String, Object>> detail)
	{
		this.detail = detail;
	}
}
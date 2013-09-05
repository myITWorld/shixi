/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.bean.CusBatchInfo.java
 * Created on 2009-3-11-下午05:50:37
 */

package com.zoomkey.bean;

import java.io.Serializable;

/**
 * 类功能描述：前台批量操作录入的信息
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public class CusBatchInfo implements Serializable
{

	private static final long	serialVersionUID	= 4094758751392505186L;

	/** 小区名称 */
	private String					cusAreaName;

	/** 小区id */
	private Integer				cusAreaId;

	/** 楼号 数据规格： 1-3 ;3 */
	private String					buildingZone;

	/** 单元号 数据规格： 1-3 ;3 */
	private String					houseZone;

	/** 楼号 数据规格： ,1,2,3, */
	private String					buildingZoneStr;

	/** 单元号 数据规格： ,1,2,3, */
	private String					houseZoneStr;

	public Integer getCusAreaId()
	{
		return this.cusAreaId;
	}

	public void setCusAreaId(Integer cusAreaId)
	{
		this.cusAreaId = cusAreaId;
	}

	public String getBuildingZone()
	{
		return this.buildingZone;
	}

	public void setBuildingZone(String buildingZone)
	{
		this.buildingZone = buildingZone;
	}

	public String getHouseZone()
	{
		return this.houseZone;
	}

	public void setHouseZone(String houseZone)
	{
		this.houseZone = houseZone;
	}

	public String getBuildingZoneStr()
	{
		return this.buildingZoneStr;
	}

	public void setBuildingZoneStr(String buildingZoneStr)
	{
		this.buildingZoneStr = buildingZoneStr;
	}

	public String getHouseZoneStr()
	{
		return this.houseZoneStr;
	}

	public void setHouseZoneStr(String houseZoneStr)
	{
		this.houseZoneStr = houseZoneStr;
	}

	public String getCusAreaName()
	{
		return this.cusAreaName;
	}

	public void setCusAreaName(String cusAreaName)
	{
		this.cusAreaName = cusAreaName;
	}
}

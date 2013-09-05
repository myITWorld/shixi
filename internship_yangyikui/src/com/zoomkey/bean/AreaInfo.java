
package com.zoomkey.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述：小区信息
 * 
 * @author <a href="mailto:zhaoli.li@berheley.com">lilizhao </a>
 */
public class AreaInfo implements java.io.Serializable
{

	/** 序列id */
	private static final long	serialVersionUID	= 7948066979828850888L;

	/** 小区id */
	private int						areaId;

	/** 小区名称 */
	private String					areaName;

	/** 小区中的所有楼的信息list */
	private List<BuildingInfo>	buildingList		= new ArrayList<BuildingInfo>();

	public int getAreaId()
	{
		return this.areaId;
	}

	public void setAreaId(int areaId)
	{
		this.areaId = areaId;
	}

	public String getAreaName()
	{
		return this.areaName;
	}

	public void setAreaName(String areaName)
	{
		this.areaName = areaName;
	}

	public List<BuildingInfo> getBuildingList()
	{
		return this.buildingList;
	}

	public void setBuildingList(List<BuildingInfo> buildingList)
	{
		this.buildingList = buildingList;
	}
}
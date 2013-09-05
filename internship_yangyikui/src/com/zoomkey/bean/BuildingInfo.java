
package com.zoomkey.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 类功能描述：楼信息
 *
 * @author <a href="mailto:zhaoli.li@berheley.com">lilizhao </a>
 */
public class BuildingInfo implements java.io.Serializable
{

	/** 序列id */
	private static final long	serialVersionUID	= -923647911195182713L;

	/** 楼号 */
	private String					buildingNo;

	/** 楼中的所有单元的信息list */
	private List					houseNoAllList		= new ArrayList();

	public String getBuildingNo()
	{
		return this.buildingNo;
	}

	public void setBuildingNo(String buildingNo)
	{
		this.buildingNo = buildingNo;
	}

	public List getHouseNoAllList()
	{
		return this.houseNoAllList;
	}

	public void setHouseNoAllList(List houseNoAllList)
	{
		this.houseNoAllList = houseNoAllList;
	}
}
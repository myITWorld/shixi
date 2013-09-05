
package com.zoomkey.bean;

import java.io.Serializable;

public class AreasSpecialInfo implements Serializable
{

	private static final long	serialVersionUID	= 206799810540804689L;

	/** 换热站Id */
	private Integer				tranHeatingId;

	/** 楼号 */
	private String					buildingNO;

	/** 单元号 */
	private String					houseNO;

	/** 起始楼号 */
	private String					beginBuildingNO;

	/** 终止楼号*/
	private String					endBuildingNO;

	/** 起始单元号 */
	private String					beginHouseNO;

	/** 结束单元号 */
	private String					endHouseNO;

	public String getBeginHouseNO()
	{
		return this.beginHouseNO;
	}

	public void setBeginHouseNO(String beginHouseNO)
	{
		this.beginHouseNO = beginHouseNO;
	}

	public String getEndHouseNO()
	{
		return this.endHouseNO;
	}

	public void setEndHouseNO(String endHouseNO)
	{
		this.endHouseNO = endHouseNO;
	}

	public String getBeginBuildingNO()
	{
		return this.beginBuildingNO;
	}

	public void setBeginBuildingNO(String beginBuildingNO)
	{
		this.beginBuildingNO = beginBuildingNO;
	}

	public String getEndBuildingNO()
	{
		return this.endBuildingNO;
	}

	public void setEndBuildingNO(String endBuildingNO)
	{
		this.endBuildingNO = endBuildingNO;
	}

	public Integer getTranHeatingId()
	{
		return this.tranHeatingId;
	}

	public void setTranHeatingId(Integer tranHeatingId)
	{
		this.tranHeatingId = tranHeatingId;
	}

	public String getBuildingNO()
	{
		return this.buildingNO;
	}

	public void setBuildingNO(String buildingNO)
	{
		this.buildingNO = buildingNO;
	}

	public String getHouseNO()
	{
		return this.houseNO;
	}

	public void setHouseNO(String houseNO)
	{
		this.houseNO = houseNO;
	}
}

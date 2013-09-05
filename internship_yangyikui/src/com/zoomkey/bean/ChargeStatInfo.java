/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.bean.ChargeStatInfo.java
 * Created on 2009-3-18-下午01:46:34
 */

package com.zoomkey.bean;

import java.io.Serializable;

/**
 * 类功能描述：综合查询费用统计信息
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public class ChargeStatInfo implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6271883163757304446L;

	/**
	 * 累计应收金额：sum_年度（供热面积×单价）
	 */
	private Double					deserveMoney;

	/**
	 * 累计实际应收金额：累计应收金额-累计优惠金额-累计减免金额-累计折让金额 sum_收费（实际应收金额）
	 */
	private Double					realDeserveMoney;

	/**
	 * 累计实收金额： sum_收费（实收金额）
	 */
	private Double					realIncomeMoney;

	/**
	 * 累计欠费金额：sum_年度（欠费金额）
	 */
	private Double					oweMoney;

	/**
	 * 累计优惠金额：sum_收费（优惠金额）
	 */
	private Double					favourMoney;

	/**
	 * 累计减免金额：sum_收费（减免金额）
	 */
	private Double					derateMoney;

	/**
	 * 累计滞纳金
	 */
	private Double					realLateFee;

	/**
	 * 累计供热面积：sum_年度（建筑面积）
	 */
	private Double					floorArea;

	/**
	 * 累计供热面积：sum_年度（供热面积）
	 */
	private Double					heatingArea;

	/**
	 * 累计退费金额：sum_收费（退费记录的实际收款金额）
	 */
	private Double					drawMoney;

	/**
	 * 总户数： count_客户数量
	 */
	private Integer				cusCount;

	/**
	 * 欠费户数： count_年度（欠费的客户的数量）
	 */
	private Integer				cusOweMoneyCount;

	/**
	 * 不欠费户数： 总户数-欠费户数
	 */
	private Integer				cusNotOweMoneyCount;

	/**
	 * 面积收费率=已交完费客户年度面积 / 总客户年度面积 （未交齐客户的年度面积不算进去）
	 */
	private Double					areaChargeRate;

	/**
	 * 收费率= 实际已交金额/应收金额（未交齐客户的实收金额需要算进去）
	 */
	private Double					chargeRate;

	/**
	 * 收户率=已交完费客户数/总户数 （未交齐客户不算进去）
	 */
	private Double					cusRate;

	// ~~~~~~~~ 辅助计算字段
	/**
	 * 已交完费客户年度面积
	 */
	private Double					notOweHeatingArea;

	// ~~~~~~~~~~~~~~~ 相关数据分析
	private Integer				cusYearCount;

	private Integer				cusNotOweMoneyYearCount;

	private Double					openFee;

	/**
	 * 累计余额：sum_年度（余额结转）
	 */
	private Double					carryForward;

	public Double getCarryForward() {
		if (this.carryForward == null) {
			this.carryForward = 0d;
		}
		return this.carryForward;
	}

	public void setCarryForward(Double carryForward) {
		this.carryForward = carryForward;
	}

	public Double getOpenFee() {
		return this.openFee;
	}

	public void setOpenFee(Double openFee) {
		this.openFee = openFee;
	}

	// 总停热面积
	public Double	stopHeatingArea;

	// 总强停面积
	public Double	strongHeatingArea;

	public Double getStopHeatingArea() {
		return this.stopHeatingArea;
	}

	public void setStopHeatingArea(Double stopHeatingArea) {
		this.stopHeatingArea = stopHeatingArea;
	}

	public Double getStrongHeatingArea() {
		return this.strongHeatingArea;
	}

	public void setStrongHeatingArea(Double strongHeatingArea) {
		this.strongHeatingArea = strongHeatingArea;
	}

	// 总基本面积
	private Double	baseArea;

	public Double getBaseArea() {
		return this.baseArea;
	}

	public void setBaseArea(Double baseArea) {
		this.baseArea = baseArea;
	}

	// 总超高面积
	private Double	overHeightArea;

	public Double getOverHeightArea() {
		return this.overHeightArea;
	}

	public void setOverHeightArea(Double overHeightArea) {
		this.overHeightArea = overHeightArea;
	}

	public ChargeStatInfo() {
	}

	public void staticYear(Double oweMoney, Double floorArea, Double heatingArea, Double deserveMoney, Integer cusCount, Integer cusOweMoneyCount, Double notOweHeatingArea, Double stopHeatingArea, Double strongHeatingArea, Double baseArea, Double overHeightArea, Double carryForward) {
		this.oweMoney = oweMoney;
		this.floorArea = floorArea;
		this.heatingArea = heatingArea;
		this.deserveMoney = deserveMoney;
		this.cusCount = cusCount;
		this.cusOweMoneyCount = cusOweMoneyCount;
		this.notOweHeatingArea = notOweHeatingArea;
		this.stopHeatingArea = stopHeatingArea;
		this.strongHeatingArea = strongHeatingArea;
		this.baseArea = baseArea;
		this.overHeightArea = overHeightArea;
		this.carryForward = carryForward;
	}

	public void staticCharge(Double realIncomeMoney, Double realDeserveMoney, Double favourMoney, Double derateMoney, Double realLateFee, Double drawMoney, Double openFee) {
		this.realIncomeMoney = realIncomeMoney;
		this.realDeserveMoney = realDeserveMoney;
		this.favourMoney = favourMoney;
		this.derateMoney = derateMoney;
		this.realLateFee = realLateFee;
		this.drawMoney = drawMoney != 0 ? drawMoney * -1 : 0;// 退费记录中的实收金额为负数，统计时进行转换
		this.openFee = openFee;
	}

	public Double getDeserveMoney() {
		if (this.deserveMoney == null) {
			this.deserveMoney = 0d;
		}
		return this.deserveMoney;
	}

	public void setDeserveMoney(Double deserveMoney) {
		this.deserveMoney = deserveMoney;
	}

	public Double getRealDeserveMoney() {
		if (this.realDeserveMoney == null) {
			this.realDeserveMoney = 0d;
		}
		return this.realDeserveMoney;
	}

	public void setRealDeserveMoney(Double realDeserveMoney) {
		this.realDeserveMoney = realDeserveMoney;
	}

	public Double getRealIncomeMoney() {
		if (this.realIncomeMoney == null) {
			this.realIncomeMoney = 0d;
		}
		return this.realIncomeMoney;
	}

	public void setRealIncomeMoney(Double realIncomeMoney) {
		this.realIncomeMoney = realIncomeMoney;
	}

	public Double getOweMoney() {
		if (this.oweMoney == null) {
			this.oweMoney = 0d;
		}
		return this.oweMoney;
	}

	public void setOweMoney(Double oweMoney) {
		this.oweMoney = oweMoney;
	}

	public Double getFavourMoney() {
		if (this.favourMoney == null) {
			this.favourMoney = 0d;
		}
		return this.favourMoney;
	}

	public void setFavourMoney(Double favourMoney) {
		this.favourMoney = favourMoney;
	}

	public Double getDerateMoney() {
		if (this.derateMoney == null) {
			this.derateMoney = 0d;
		}
		return this.derateMoney;
	}

	public void setDerateMoney(Double derateMoney) {
		this.derateMoney = derateMoney;
	}

	public Double getHeatingArea() {
		if (this.heatingArea == null) {
			this.heatingArea = 0d;
		}
		return this.heatingArea;
	}

	public void setHeatingArea(Double heatingArea) {
		this.heatingArea = heatingArea;
	}

	public Double getDrawMoney() {
		if (this.drawMoney == null) {
			this.drawMoney = 0d;
		}
		return this.drawMoney;
	}

	public void setDrawMoney(Double drawMoney) {
		this.drawMoney = drawMoney;
	}

	public Integer getCusCount() {
		if (this.cusCount == null) {
			this.cusCount = 0;
		}
		return this.cusCount;
	}

	public void setCusCount(Integer cusCount) {
		this.cusCount = cusCount;
	}

	public Integer getCusOweMoneyCount() {
		if (this.cusOweMoneyCount == null) {
			this.cusOweMoneyCount = 0;
		}
		return this.cusOweMoneyCount;
	}

	public void setCusOweMoneyCount(Integer cusOweMoneyCount) {
		this.cusOweMoneyCount = cusOweMoneyCount;
	}

	public Integer getCusNotOweMoneyCount() {
		if (this.cusNotOweMoneyCount == null) {
			this.cusNotOweMoneyCount = 0;
		}
		return this.cusNotOweMoneyCount;
	}

	public void setCusNotOweMoneyCount(Integer cusNotOweMoneyCount) {
		this.cusNotOweMoneyCount = cusNotOweMoneyCount;
	}

	public Double getAreaChargeRate() {
		if (this.areaChargeRate == null) {
			this.areaChargeRate = 0d;
		}
		return this.areaChargeRate;
	}

	public void setAreaChargeRate(Double areaChargeRate) {
		this.areaChargeRate = areaChargeRate > 100 ? 100 : areaChargeRate;
	}

	public Double getChargeRate() {
		if (this.chargeRate == null) {
			this.chargeRate = 0d;
		}
		return this.chargeRate;
	}

	public void setChargeRate(Double chargeRate) {
		this.chargeRate = chargeRate > 100 ? 100 : chargeRate;
	}

	public Double getCusRate() {
		if (this.cusRate == null) {
			this.cusRate = 0d;
		}
		return this.cusRate;
	}

	public void setCusRate(Double cusRate) {
		this.cusRate = cusRate > 100 ? 100 : cusRate;
	}

	public Double getNotOweHeatingArea() {
		if (this.notOweHeatingArea == null) {
			this.notOweHeatingArea = 0d;
		}
		return this.notOweHeatingArea;
	}

	public void setNotOweHeatingArea(Double notOweHeatingArea) {
		this.notOweHeatingArea = notOweHeatingArea;
	}

	public Integer getCusYearCount() {
		if (this.cusYearCount == null) {
			this.cusYearCount = 0;
		}
		return this.cusYearCount;
	}

	public void setCusYearCount(Integer cusYearCount) {
		this.cusYearCount = cusYearCount;
	}

	public Integer getCusNotOweMoneyYearCount() {
		if (this.cusNotOweMoneyYearCount == null) {
			this.cusNotOweMoneyYearCount = 0;
		}
		return this.cusNotOweMoneyYearCount;
	}

	public void setCusNotOweMoneyYearCount(Integer cusNotOweMoneyYearCount) {
		this.cusNotOweMoneyYearCount = cusNotOweMoneyYearCount;
	}

	// 计算收费率、面积收费率、收护率等
	public void calculate() {
		setCusNotOweMoneyCount(getCusCount() - getCusOweMoneyCount());
		// this.setRealDeserveMoney(this.getDeserveMoney()
		// - this.getFavourMoney()
		// - this.getDerateMoney()
		// - this.getDiscountMoney());
		if (getHeatingArea() > 0) {
			setAreaChargeRate(getNotOweHeatingArea() * 100 / getHeatingArea());
		} else {
			setAreaChargeRate(0d);
		}
		if (getDeserveMoney() - getFavourMoney() - getDerateMoney() > 0) {
			setChargeRate(getRealIncomeMoney() * 100 / getDeserveMoney());
		} else {
			setChargeRate(0d);
		}
		if (getCusCount() > 0) {
			setCusRate(getCusNotOweMoneyCount() * 100.0d / getCusCount());
		} else {
			setCusRate(0d);
		}
	}

	public Double getRealLateFee() {
		return this.realLateFee;
	}

	public void setRealLateFee(Double realLateFee) {
		this.realLateFee = realLateFee;
	}

	public void setFloorArea(Double floorArea) {
		this.floorArea = floorArea;
	}

	public Double getFloorArea() {
		return this.floorArea;
	}
}

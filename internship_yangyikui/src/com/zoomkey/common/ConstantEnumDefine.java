
package com.zoomkey.common;

public class ConstantEnumDefine {

	/*
	 * 状态枚举类型
	 */
	public static enum STATUS {
		正常("正常", "1"), 屏蔽("屏蔽", "0"), 删除("删除", "0"), 管理员设置("管理员设置", "2");

		private final String	value;

		private final String	label;

		private STATUS(String label, String value) {
			this.value = value;
			this.label = label;
		}

		public String getValue() {
			return this.value;
		}

		public String getLabel() {
			return this.label;
		}
	}

	/**
	 * 
	 * 权限枚举类型
	 * */
	public static enum ROLE {
		用户("正常", 0), 版主("版主", 1), 管理员("管理员", 2);

		private String	label;

		private int		value;

		public void setLabel(String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}

		public int getValue() {
			return this.value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		private ROLE(String label, int value) {
			this.label = label;
			this.value = value;
		}
	}

	public static enum AUDIRING {
		审核通过("审核通过", "1"), 审核不通过("审核不通过", "0");

		private String	label;

		private String	value;

		public String getLabel() {
			return this.label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		private AUDIRING(String label, String value) {
			this.label = label;
			this.value = value;
		}
	}

	public static enum ESS {
		精华("精华", "1"), 非精华("非净化", "0");

		private String	label;

		private String	value;

		private ESS(String label, String value) {
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return this.label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public static enum TOP {
		置顶("置顶", "1"), 非置顶("非置顶", "0");

		private String	label;

		private String	value;

		public String getLabel() {
			return this.label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		private TOP(String label, String value) {
			this.label = label;
			this.value = value;
		}
	}
}

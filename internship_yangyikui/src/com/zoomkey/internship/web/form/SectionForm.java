/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.form.SectionForm.java
 * Created on 2013-5-12-上午09:42:51
 */

package com.zoomkey.internship.web.form;

import java.util.List;
import java.util.Map;

import com.zoomkey.internship.persistence.model.TSection;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-12 上午09:42:51
 */
public class SectionForm extends BaseForm {

	private TSection	tSection	= new TSection();

	private List<Map>	sectionInfoList;				// 存放版块名称

	public TSection gettSection() {
		return this.tSection;
	}

	public void settSection(TSection tSection) {
		this.tSection = tSection;
	}

	public List<Map> getSectionInfoList() {
		return this.sectionInfoList;
	}

	public void setSectionInfoList(List<Map> sectionInfoList) {
		this.sectionInfoList = sectionInfoList;
	}
}

/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.form.ArticleForm.java
 * Created on 2013-5-17-下午05:01:58
 */

package com.zoomkey.internship.web.form;

import com.zoomkey.internship.persistence.model.TArticle;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
 * Create:  2013-5-17 下午05:01:58
 */
public class ArticleForm extends BaseForm {

	private TArticle	tArticle	= new TArticle();

	public TArticle gettArticle() {
		return this.tArticle;
	}

	public void settArticle(TArticle tArticle) {
		this.tArticle = tArticle;
	}
}

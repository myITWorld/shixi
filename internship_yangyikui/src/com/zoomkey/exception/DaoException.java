/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * hcs_wqgh
 * com.berheley.oa.exception.DaoException.java
 * Created on 2013-4-12-下午02:52:32
 */

package com.zoomkey.exception;

/**
 * 类功能描述：DAO层应该抛出的异常类
 *
 * @author <a href="mailto:zhaoxinchun@zoomkey.com.cn">zhaoxinchun</a>
 * Create:  2013-4-12 下午02:52:32
 */
public class DaoException extends AppException {

	private static final long	serialVersionUID	= -2620474866765411885L;

	/**
	 * 提示默认的异常信息
	 */
	public DaoException() {
		super();
	}

	/**
	 * 提示指定异常信息
	 * @param message 异常信息
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * 封装指定异常类信息，并提示默认的异常信息
	 * @param e 异常类信息
	 */
	public DaoException(Exception e) {
		super(e);
	}

	/**
	 * 提示指定的异常信息并封装指定的异常类信息
	 * @param message 异常信息
	 * @param e 异常类信息
	 */
	public DaoException(String message, Exception e) {
		super(message, e);
	}
}

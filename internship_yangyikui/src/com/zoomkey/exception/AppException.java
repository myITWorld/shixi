/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * hcs_wqgh
 * com.berheley.oa.exception.AppException.java
 * Created on 2013-4-12-下午02:32:32
 */

package com.zoomkey.exception;

import com.zoomkey.common.ConstantDefine;

/**
 * 类功能描述：应用系统异常类
 *
 * @author <a href="mailto:zhaoxinchun@zoomkey.com.cn">zhaoxinchun</a>
 * Create:  2013-4-12 下午02:32:32
 */
public class AppException extends RuntimeException {

	private static final long	serialVersionUID	= -5730048613872043394L;

	private Exception				e;

	private String					errorCode;

	private String					keyValue;

	/**
	 * 提示默认的异常信息
	 */
	public AppException() {
		setKeyValue(ConstantDefine.INTERFACE_PARAM_ERROR);
	}

	/**
	 * 提示指定异常信息
	 * @param message 异常信息
	 */
	public AppException(String message) {
		setKeyValue(message);
	}

	/**
	 * 封装指定异常类信息，并提示默认的异常信息
	 * @param e 异常类信息
	 */
	public AppException(Exception e) {
		setE(e);
		setKeyValue(ConstantDefine.INTERFACE_PARAM_ERROR);
	}

	/**
	 * 提示指定的异常信息并封装指定的异常类信息
	 * @param message 异常信息
	 * @param e 异常类信息
	 */
	public AppException(String message, Exception e) {
		setE(e);
		setKeyValue(message);
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getKeyValue() {
		return this.keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public Exception getE() {
		return this.e;
	}

	public void setE(Exception e) {
		this.e = e;
	}
}

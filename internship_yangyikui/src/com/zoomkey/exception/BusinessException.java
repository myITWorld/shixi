
package com.zoomkey.exception;

/**
 * 类功能描述：业务逻辑异常类
 *
 * @author <a href="mailto:zhaoxinchun@zoomkey.com.cn">zhaoxinchun</a>
 * Create:  2013-4-12 下午03:17:30
 */
public class BusinessException extends AppException {

	private static final long	serialVersionUID	= 227418279016766890L;

	/**
	 * 提示默认的异常信息
	 */
	public BusinessException() {
		super();
	}

	/**
	 * 封装指定异常类信息，并提示默认的异常信息
	 * @param e 异常类信息
	 */
	public BusinessException(Exception e) {
		super(e);
	}

	/**
	 * 提示指定的异常信息并封装指定的异常类信息
	 * @param message 异常信息
	 * @param e 异常类信息
	 */
	public BusinessException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * 提示指定异常信息
	 * @param message 异常信息
	 */
	public BusinessException(String message) {
		super(message);
	}
}

/**
 * 同一标签支持的最大验证条数
 */
var validateMax = 5;
/**
 * @function 验证方法
 */
Validator = {
	Require : /.+/,// 必填项
	Password : /^[A-Za-z\d]{1,16}$/,// 16位字符数组
	Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,// 邮箱格式
	Phone : /^(\d{3}-|\d{4}-)?(\d{8}|\d{7})$/,// 电话格式
	Mobile : /^(13[0-9]|15[0-9]|18[0-9])\d{8}$/,// 手机格式
	Tel:/^(((\d{3}-|\d{4}-)?(\d{8}|\d{7}))|((13[0-9]|15[0-9]|18[0-9])\d{8}))$/,//验证带区号和不带区号的固话、手机号码格式
	Fax : /(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{7,8}$)/,// 传真格式
	PostCode : /^[0-9]{6}$/,// 邮编格式
	Url : /^(http[s]:\/\/)?[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,//
	Ip4 : /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,
	Currency : /^\d+(\.\d+)?$/,
	English : /^[A-Za-z]+$/,// 英文
	Chinese : /^[\u0391-\uFFE5]+$/,// 中文
	CnAndEng : /^[A-Za-z\u4e00-\u9fa5_]+$/,// 中英文
	CnEngNum : /^[A-Za-z0-9\u4e00-\u9fa5]+$/,// 中文和数字，字母
	Chineseore : /^[A-Za-z0-9\u4e00-\u9fa5_]+$/,// 中文和字母
	eornumber : /^[A-Za-z0-9_]+$/,//
	RoleControle : /^AUTH_[A-Za-z0-9_]+$/,
	Number : /^[-\+]?\d+$/,// 数字
	PositiveNumber : /^[1-9]\d*$/,// 正整数
	PositiveDouble : /^[+]?([1-9]\d*(\.\d+)?|0\.\d*[1-9]\d*)$/,// 正实数
	ZeroPositiveDouble : /^[+]?([1-9]\d*(\.\d+)?|0\.\d*[0-9]\d*|0)$/,// 0&正实数
	Zip : /^[1-9]\d{5}$/,// 压缩文件
	QQ : /^[1-9]*[1-9][0-9]*$/,// QQ号
	Integer : /^[-\+]?\d+$/,// 整数
	Double : /^[-\+]?\d+(\.\d+)?$/,// 实数
	Username : /^[a-z]\w{3,}$/i,// 用户名
	UnSafe : /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,// 安全
	Year : /^(\d{4}-|\d{4})$/,
	IdCard : "this.IsIdCard(value)",// 是否是身份证号
	Date : "this.IsDate(value, getAttribute('min'), getAttribute('format'))",// 是否是日期
	Repeat : "value == document.getElementsByName('userObj.newPassword')[0].value",// 是否重复
	Range : "getAttribute('min') < (value|0) && (value|0) < getAttribute('max')",// 是否在某一范围
	Compare : "this.compare(value,getAttribute('operator' + j + ''),getAttribute('to' + j + ''),form.id)",// 比较
	CompareLength : "this.compareLength(value,getAttribute('operator' + j + ''),getAttribute('to' + j + ''),form.id)",// 比较长度
	Custom : "this.Exec(value, getAttribute('regexp' + j + ''))",// 正则校验
	Group : "this.MustChecked(getAttribute('name'), getAttribute('min'), getAttribute('max'))",// 组校验
	SafeString : "this.IsSafe(value)",// 是否安全
	Filter : "this.DoFilter(value, getAttribute('accept'))",// 是否是可接受的文件
	ErrorItem : [document.forms[0]],// 错误index
	ErrorMessage : ["error:提示！"],// 错误信息
	// 验证主方法
	Validate : function(theForm) {
		// 表示通过验证，并校验表单的每一个元素是否通过校验
		var mark = true;
		var obj = theForm;
		// 如果表单对象为空，则取第一个表单
		if (theForm == null) {
			obj = document.forms[0] || event.srcElement;
		}
		this.ErrorMessage.length = 1;
		this.ErrorItem.length = 1;
		this.ErrorItem[0] = obj;
		if (obj.action == undefined) {
			// 单元素校验开始
			with (obj) {
				// 根据配置对单个元素进行逐项校验
				for (var j = 0; j < validateMax; j++) {
					// 清空错误提示信息
					this.ClearState(obj);
					// 是否必填项
					var _require = getAttribute("require" + j + "");
					// 数据类型
					var _dataType = getAttribute("dataType" + j + "");
					// 输入长度限制
					var _limit = getAttribute("limit" + j + "");
					// 验证必填项
					if (_require) {
						if (type == 'text' || type == 'password' || type == 'textarea' || type == 'select-one'
								|| type == 'select-multiple') {
							if (!this.Require.test(trimSpace(value))) {
								this.AddGivenItemError(obj, j);
								return false;
							}
						}
					}
					if (_limit != null) {
						if (!this.CheckLimit(value, _limit)) {
							this.AddGivenItemError(obj, j);
							return false;
						}
					}
					// 数据类型验证
					if (_dataType != null) {
						if (_dataType == undefined || typeof(this[_dataType]) == 'undefined') {
							return;
						}
						if (!_require && value.trim().length == 0) {
							// 没有设置必填且该项为空的话不再进行校验（校验通过）
							continue;
						}
						// 匹配数据类型
						switch (_dataType) {
							case "Chinese" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Phone" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Mobile" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Tel" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Number" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "PositiveNumber" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "PositiveDouble" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "ZeroPositiveDouble" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Double" :
								if (!this[_dataType].test(value.trim())) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "IdCard" :
								if (!eval(this.IdCard)) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Date" :
							case "Repeat" :
								if (!eval(this.Repeat)) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Range" :
							case "Compare" :
								if (!eval(this.Compare)) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "CompareLength" :
								if (!eval(this.CompareLength)) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Custom" :
								if (!eval(this.Custom)) {
									this.ClearState(obj);
									this.AddGivenItemError(obj, j);
									return false;
								}
								break;
							case "Group" :
							case "SafeString" :
							case "Filter" :
								if (!eval(this[_dataType])) {
									this.AddError(i, getAttribute("msg" + j + ""));
									return false;
								}
								break;
							default :
								if (!this[_dataType].test(value.trim())) {
									this.AddError(i, getAttribute("msg" + j + ""));
									return false;
								}
								break;
						}
					}
				}
			}
		} else {
			// 表单校验开始
			// 表单元素的长度
			var count = obj.elements.length;
			// 循环每一个元素对其进行校验
			for (var i = 0; i < count; i++) {
				if (obj.elements[i].style.display != 'none') {
					with (obj.elements[i]) {
						// 清空错误提示信息
						this.ClearState(obj.elements[i]);
						// 根据配置对单个元素进行逐项校验
						for (var j = 0; j < validateMax; j++) {
							// 是否必填项
							var _require = getAttribute("require" + j + "");
							// 数据类型
							var _dataType = getAttribute("dataType" + j + "");
							// 输入长度限制
							var _limit = getAttribute("limit" + j + "");
							// 验证必填项
							if (_require) {
								if (type == 'text' || type == 'password' || type == 'textarea' || type == 'select-one'
										|| type == 'select-multiple') {
									if (!this.Require.test(trimSpace(value))) {
										mark = false;
										this.AddGivenItemError(obj.elements[i], j);
									}
								} else if (type == 'checkbox') {
									// 对于复选框，目前只支持在提交时验证是否勾选，对应配置项为require
									var isCheck = this.MultiboxSelected(obj.elements[i]);
									if (isCheck == false) {
										mark = false;
										// 显示提示信息
										showMessage(obj.elements[i].getAttribute("msg" + j + ""), "error");
									}
								}
							}
							if (_limit != null) {
								if (!this.CheckLimit(value, _limit)) {
									mark = false;
									this.AddGivenItemError(obj.elements[i], j);
								}
							}
							// 数据类型验证
							if (_dataType != null) {
								if (_dataType == undefined || typeof(this[_dataType]) == 'undefined') {
									continue;
								}
								if (!_require && value.trim().length == 0) {
									// 没有设置必填且该项为空的话不再进行校验（校验通过）
									continue;
								}
								// 匹配数据类型
								switch (_dataType) {
									case "Chinese" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Phone" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Mobile" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Tel" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Number" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "PositiveNumber" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "PositiveDouble" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "ZeroPositiveDouble" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Double" :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "IdCard" :
										if (!eval(this.IdCard)) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Date" :
									case "Repeat" :
										if (!eval(this.Repeat)) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Range" :
									case "Compare" :
										if (!eval(this.Compare)) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "CompareLength" :
										if (!eval(this.CompareLength)) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Custom" :
										if (!eval(this.Custom)) {
											mark = false;
											this.ClearState(obj.elements[i]);
											this.AddGivenItemError(obj.elements[i], j);
										}
										break;
									case "Group" :
									case "SafeString" :
									case "Filter" :
										if (!eval(this[_dataType])) {
											mark = false;
											this.AddError(i, getAttribute("msg" + j + ""));
										}
										break;
									default :
										if (!this[_dataType].test(value.trim())) {
											mark = false;
											this.AddError(i, getAttribute("msg" + j + ""));
										}
										break;
								}
							}
							if (!mark) {
								break;
							}
						}
					}
				}
			}
		}
		return mark;
	},
	// 提示信息定义
	AddGivenItemError : function(obj, index) {
		showErrorMsg(obj, index);
		obj.style.backgroundColor = "#ffffff";
		obj.style.border = "2px solid #CE0808";
		$("#" + obj.id).addClass("input_validation-failed");
	},
	// 输入项是否是合法
	CheckLimit : function(_value, _limit) {
		var minAndMax = _limit.split(",");
		var min = minAndMax.length == 2 ? minAndMax[0] : 0;
		var max = minAndMax.length == 2 ? minAndMax[1] : minAndMax[0];
		return this.limit(_value.length, min, max);
	},
	// 是否合法
	limit : function(len, min, max) {
		min = min || 0;
		max = max || Number.MAX_VALUE;
		return min <= len && len <= max;
	},
	LenB : function(str) {
		return str.replace(/[^\x00-\xff]/g, "**").length;
	},
	// 是否支持正则
	Exec : function(op, reg) {
		// chrome浏览器(去掉两端"/")
		if (navigator.userAgent.toLowerCase().indexOf("chrome") != -1) {
			reg = reg.replace(/(^\/)|(\/$)/g, "");
		}
		var re = new RegExp(reg);
		return re.test(op);
	},
	// 比较
	compare : function(op1, operator, op2, formId) {
		var op2Value = $("#" + formId + " input[name=" + op2 + "]").attr("value");
		switch (operator) {
			case "!=" :
				return (op1 != op2Value);
			case ">" :
				return (op1 > op2Value);
			case ">=" :
				return (op1 >= op2Value);
			case "<" :
				return (op1 < op2Value);
			case "<=" :
				return (op1 <= op2Value);
			default :
				return (op1 == op2Value);
		}
	},
	// 比较长度
	compareLength : function(op1, operator, op2, formId) {
		var op1Len = op1.length;
		var op2Len = $("#" + formId + " input[name=" + op2 + "]").attr("value").length;
		switch (operator) {
			case "!=" :
				return (op1Len != op2Len);
			case ">" :
				return (op1Len > op2Len);
			case ">=" :
				return (op1Len >= op2Len);
			case "<" :
				return (op1Len < op2Len);
			case "<=" :
				return (op1Len <= op2Len);
			default :
				return (op1Len == op2Len);
		}
	},
	// 过滤验证
	DoFilter : function(input, filter) {
		return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(/\s*,\s*/).join("|")), "gi").test(input);
	},
	// 用户名验证
	MustChecked : function(name, min, max) {
		var groups = document.getElementsByName(name);
		var hasChecked = 0;
		min = min || 1;
		max = max || groups.length;
		for (var i = groups.length - 1; i >= 0; i--)
			if (groups[i].checked)
				hasChecked++;
		return min <= hasChecked && hasChecked <= max;
	},
	// 复选框必选验证
	MultiboxSelected : function(obj) {
		var isCheck = false;
		$("#" + obj.form.id + " input[name='" + obj.name + "']").each(function() {
			if ($(this).attr("checked")) {
				isCheck = true;
			}
		});
		return isCheck;
	},
	// 清除提示信息
	ClearState : function(element) {
		with (element) {
			if (style.backgroundColor == "#ffffff" || style.backgroundColor == "rgb(255, 255, 255)") {
				style.backgroundColor = "";
				style.border = "1px solid #B5B8C8";
				$("#" + form.id + " [name=" + name + "]").removeClass("input_validation-failed");
				if (name != "") {
					// TODO 这里会把小区自动提示的所有事件也卸掉,并且在第二次验证时，验证信息不会提示/
					// 使用hover事件时，unbind单个事件无法实现
					// $("#" + form.id + " [name=" + name + "]").unbind();
					$("#" + form.id + " [name=" + name + "]").unbind("mouseover");
					$("#" + form.id + " [name=" + name + "]").unbind("mouseoout");
					$("#" + form.id + " [name=" + name + "]").unbind("mousemove");
				}
			}
		}
	},
	AddError : function(index, str) {
		this.ErrorItem[this.ErrorItem.length] = this.ErrorItem[0].elements[index];
		this.ErrorMessage[this.ErrorMessage.length] = this.ErrorMessage.length + ":" + str;
	},
	// 是否是身份证
	IsIdCard : function(number) {
		var date, Ai;
		var verify = "10x98765432";
		var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
		var area = ['', '', '', '', '', '', '', '', '', '', '', '北京', '天津', '河北', '山西', '内蒙古', '', '', '', '', '',
				'辽宁', '吉林', '黑龙江', '', '', '', '', '', '', '', '上海', '江苏', '浙江', '安微', '福建', '江西', '山东', '', '', '',
				'河南', '湖北', '湖南', '广东', '广西', '海南', '', '', '', '重庆', '四川', '贵州', '云南', '西藏', '', '', '', '', '', '',
				'陕西', '甘肃', '青海', '宁夏', '新疆', '', '', '', '', '', '台湾', '', '', '', '', '', '', '', '', '', '香港', '澳门',
				'', '', '', '', '', '', '', '', '国外'];
		var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/i);
		if (re == null)
			return false;
		if (re[1] >= area.length || area[re[1]] == "")
			return false;
		if (re[2].length == 12) {
			Ai = number.substr(0, 17);
			date = [re[9], re[10], re[11]].join("-");
		} else {
			Ai = number.substr(0, 6) + "19" + number.substr(6);
			date = ["19" + re[4], re[5], re[6]].join("-");
		}
		if (!this.IsDate(date, "ymd"))
			return false;
		var sum = 0;
		for (var i = 0; i <= 16; i++) {
			sum += Ai.charAt(i) * Wi[i];
		}
		Ai += verify.charAt(sum % 11);
		return (number.length == 15 || number.length == 18 && number == Ai);
	},
	// 是否是日期
	IsDate : function(op, formatString) {
		formatString = formatString || "ymd";
		var m, year, month, day;
		switch (formatString) {
			case "ymd" :
				m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
				if (m == null)
					return false;
				day = m[6];
				month = m[5] * 1;
				year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
				break;
			case "dmy" :
				m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
				if (m == null)
					return false;
				day = m[1];
				month = m[3] * 1;
				year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
				break;
			default :
				break;
		}
		if (!parseInt(month))
			return false;
		month = month == 0 ? 12 : month;
		var date = new Date(year, month - 1, day);
		return (typeof(date) == "object" && year == date.getFullYear() && month == (date.getMonth() + 1) && day == date
				.getDate());
		function GetFullYear(y) {
			return ((y < 30 ? "20" : "19") + y) | 0;
		}
	}
};
/**
 * @function 去除前后空格
 * @param 操作对象
 */
function TrimString(obj) {
	return obj.value.replace(/(^\s*)|(\s*$)/g, "");
}
/**
 * 
 */
String.prototype.trim = function() {
	// 用正则表达式将前后空格
	// 用空字符串替代。
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
function stringTrim(str) {
	for (var i = 0; i < str.length && str.charAt(i) == "  "; i++);
	for (var j = str.length; j > 0 && str.charAt(j - 1) == "  "; j--);
	if (i > j)
		return "";
	return str.substring(i, j);
}
/**
 * @function 根据formId获取form中需要进行校验的元素
 * @param formId 表单Id
 * @param validateArray 表单验证配置项
 * 注：Ext保存按钮需要在单击方法内自行调用Validator.Validate()方法
 */
function injectCommonValidator(formId, validateArray) {
	// 根据用户提供的配置项对要进行校验的元素对象进行装配,初始化
	if (validateArray) {
		// 需要装配的对象
		var element = null;
		// 同一元素校验次数
		var repeatNameIndex = 0;
		for (var item in validateArray) {
			if (validateArray[item - 1] && validateArray[item - 1].name == validateArray[item].name) {
				// 如果其上一个验证定义有该元素，则校验次数+1
				repeatNameIndex++;
			} else {
				// 该元素只校验一次
				repeatNameIndex = 0;
			}
			element = $("#" + formId + " [name=" + validateArray[item].name + "]")[0];
			// 配置项装配
			for (var key in validateArray[item]) {
				if (key != 'name') {
					if (element != null) {
						// 根据校验次数为元素赋属性（如：dataType[1]="Number"）
						element.setAttribute(key + "" + repeatNameIndex + "", validateArray[item][key]);
					}
				}
			}
			// 注册该元素上的校验事件及原有注册事件,这里使用了闭包解决元素validation被后面元素validation覆盖的问题
			(function(element) {
				if (element) {
					var test = element.getAttribute('event' + repeatNameIndex + "");
					if (test) {
						// 注册元素执行事件用
						var validation = null;
						if (repeatNameIndex == 0) {
							validation = eval("element." + test);
						}
						eval("element."
								+ test
								+ "=function (){if(Validator.Validate(this)) {if(validation!=null){validation.call(this);} } else{enableSaveBtn('error');} }");
					}
				}
			})(element);
		}
		// 为button的单击事件注册验证
		// 获取button的dom对象
		objButton = $("#" + formId + " input[name=btn_save]")[0];
		if (objButton != null) {
			// 保存元素的onclick事件
			var event = objButton.onclick;
			if (event.toString().indexOf("Validator.Validate") == -1) {
				// 重新定义onclick事件
				objButton.onclick = function() {
					if (Validator.Validate($("#" + formId)[0])) {
						if (event != null) {
							// 返回执行onclick事件
							event.call(objButton);
						}
					} else{
						// 使保存按钮可用
						enableSaveBtn('error');
					}
				}
			}
		}
	}
}
/**
 * @function 清除无用的错误提示信息
 * @param formId
 */
function clearErrorMessage(formId) {
	$("#" + formId + " input").each(function() {
		if ((this.type == 'text' || this.type == 'password') && !this.readOnly) {
			for (var i = 0; i < validateMax; i++) {
				$(this).css('border', '1px solid #B5B8C8');
				$(this).css('background-color', '#FFFFFF');
				$(this).removeClass("input_validation-failed");
				// TODO 这里同clearState方法一样
				$(this).unbind("mouseover");
				$(this).unbind("mouseout");
				$(this).unbind("mousemove");
				// $(this).unbind();
			}
		}
	});
	$("#" + formId + " textarea").each(function() {
		$(this).css('border', '1px solid #B5B8C8');
		$(this).css('background-color', '#FFFFFF');
		$(this).removeClass("input_validation-failed");
		// TODO 这里同clearState方法一样
		$(this).unbind("mouseover");
		$(this).unbind("mouseoout");
		$(this).unbind("mousemove");
			// $(this).unbind();
		});
	$("#" + formId + " select").each(function() {
		$(this).css('border', '1px solid #B5B8C8');
		$(this).css('background-color', '#FFFFFF');
		$(this).removeClass("input_validation-failed");
		// TODO 这里同clearState方法一样
		$(this).unbind("mouseover");
		$(this).unbind("mouseoout");
		$(this).unbind("mousemove");
			// $(this).unbind();
		});
}

/**
 * @function 清除无用的验证信息
 * @param formId
 */
function clearValidateMessage(formId) {
	$("#" + formId + " input").each(function() {
		for (var i = 0; i < validateMax; i++) {
			$(this).removeAttr("require" + i + "");
			$(this).removeAttr("dataType" + i + "");
			$(this).removeAttr("regexp" + i + "");
			$(this).removeAttr("msg" + i + "");
			$(this).removeAttr("event" + i + "");
			$(this).removeAttr("limit" + i + "");
		}
	});
	$("#" + formId + " textarea").each(function() {
		for (var i = 0; i < validateMax; i++) {
			$(this).removeAttr("require" + i + "");
			$(this).removeAttr("dataType" + i + "");
			$(this).removeAttr("regexp" + i + "");
			$(this).removeAttr("msg" + i + "");
			$(this).removeAttr("event" + i + "");
			$(this).removeAttr("limit" + i + "");
		}
	});
	$("#" + formId + " select").each(function() {
		for (var i = 0; i < validateMax; i++) {
			$(this).removeAttr("require" + i + "");
			$(this).removeAttr("dataType" + i + "");
			$(this).removeAttr("regexp" + i + "");
			$(this).removeAttr("msg" + i + "");
			$(this).removeAttr("event" + i + "");
			$(this).removeAttr("limit" + i + "");
		}
	});
}

/**
 * @function 统计配置项中特定name的数量
 * @param scrstrArray: 配置项validateArray
 * @param armstr: 要匹配的name
 * @return 数量
 */
function getStrCount(scrstrArray, armstr) {
	var count = 0;
	if (scrstrArray) {
		for (var i = 0; i < scrstrArray.length; i++) {
			if (scrstrArray[i].name.indexOf(armstr) >= 0) {
				count++;
			}
		}
		return count;
	}
	return 0;
}

/**
 * @function 显示错误信息
 * @param obj 验证数组的元素
 */
function showErrorMsg(obj, index) {
	var xOffset = -10; // x distance from mouse
	var yOffset = 10; // y distance from mouse
	var msg = obj.getAttribute("msg" + index + "");
	var formId = obj.form.id;
	var name = obj.getAttribute("name");
	// 给表单元素添加hover和mousemove事件用来显示错误信息
	$("#" + formId + " input[name=" + name + "],textarea[name=" + name + "],select[name=" + name + "]")
			.mouseover(function(e) {
				if (msg != undefined) {
					var top = (e.pageY + yOffset);
					var left = (e.pageX + xOffset);
					// TODO 这么是防止提示信息出现两次，至于为什么会出现两次原因还没有找到
					if ($("p#vtip").length > 0) {
						$("p#vtip").remove();
					}
					// TODO 这里会出现在关闭子窗口时，提示信息在父窗口仍然显示的问题，有待能人解决
					$('body').append('<p id="vtip"><span class="validMsg">' + msg + '</span></p>');
					$('p#vtip').css("top", top + "px").css("left", left + "px");
					// $('p#vtip').bgiframe();
				}
			}).mouseout(function() {
				if (msg != undefined) {
					$("p#vtip").remove();
				}
			}).mousemove(function(e) {
				if (msg != undefined) {
					var top = (e.pageY + yOffset);
					var left = (e.pageX + xOffset);
					$("p#vtip").css("top", top + "px").css("left", left + "px");
				}
			});

}

/**
 * 去掉验证数据前后空格(包括全角空格):针对全角空格无法验证情况
 */
function trimSpace(dataStr){
	// /(^\s*)|(\s*$)/g：零次或多次匹配空白字符，若匹配成功替换为空串
	// /(^　*)|(　*$)/g：零次或多次匹配全角空白字符，若匹配成功替换为空串
	return dataStr.replace(/(^\s*)|(\s*$)/g,"").replace(/(^　*)|(　*$)/g,"");
}
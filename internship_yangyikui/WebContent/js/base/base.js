/*
 * 页面基本功能公用js Copyright: Tianjin Berheley Tech Co,.ltd, China hcms
 */

/** **********************checkbox 功能************************************ */
var checkElement = {};
/**
 * Ext表格数据删除时调用的方法（支持批量） 传递到后台的参数为ids，以逗号分隔
 * 
 * @param:{Object} Ext表格gridPanel组件
 * @param:{String} 删除操作的后台url
 * @param:{Boolean} 是否为单选操作（默认为多选）[可选]
 * @msg:{String} 业务操作提示信息（如：作废、撤销，默认为删除）[可选]
 * @msg:{String} 确认提示信息[可选]
 * @param: 成功执行自定义函数（默认为重新加载表格数据）[可选]
 */
checkElement.del = function(grid, url, isSingle, delMsg, confirmMsg, succFn) {
	var isSingleCheck = isSingle ? isSingle : false;// 默认为多选
	var deleteMsg = delMsg ? delMsg : "删除";
	var ids = getGridCheckedValue(grid, "id", isSingleCheck, "需要" + deleteMsg + "的记录");
	if (ids != null) {
		var showMsg = confirmMsg ? confirmMsg : "确定" + deleteMsg + "所选记录？";
		if (confirm(showMsg)) {
			var subUrl = context + url + "&ids=" + ids.toString() + "&date=" + new Date().toLocaleString();
			var json = ajaxRequest(subUrl);
			if (json) {
				succFn ? succFn() : grid.getStore().reload();
			}
		}
	}
}
// 选择全选或者不选
// 参数:(全选框对象,tbodyID，子checkbox名称)
checkElement.selectAllBox = function(checkBox, tbodyId, checkName) {
	var tbody = document.getElementById(tbodyId);
	if (checkBox.checked == true) {// 当选中时,说明全选
		this.selectAllCheck(checkName);
	} else {// 否则,全不选
		this.deleteAllCheck(checkName);
	}
}

// 判断是否有多选－－－修改时使用
// 参数：对应的check组名称
checkElement.justifyCheckedMore = function(checkName) {
	var count = 0;
	var selecters = document.getElementsByName(checkName);
	var flag = false;
	for (i = 0; i < selecters.length; i++)// 先判断是否有选上的项
	{
		if (selecters[i].type == "checkbox" && selecters[i].checked == true) {
			count++;
		}
	}
	return count;
}
// 获取一个打勾的框的value
// 参数：对应的check组名称
checkElement.getCheckedValue = function(checkName) {
	var v = null;
	var selecters = document.getElementsByName(checkName);
	var flag = false;
	for (i = 0; i < selecters.length; i++)// 先判断是否有选上的项
	{
		if (selecters[i].type == "checkbox" && selecters[i].checked == true) {
			v = selecters[i].value;
		}
	}
	return v;
}
// 如果是iframe列表结构的页面，提示信息需要显示在父级页面上
checkElement.showMessage = function(msg, type) {
	if (parent && parent != window && parent.showMessage) {
		parent.showMessage(msg, type);
	} else {
		showMessage(msg, type);
	}
}
// 在checkName对应的check组中获取要修改的ID
// 参数：对应的check组名称
checkElement.getModifyId = function(checkName) {
	var modifyId = '';
	var count = this.justifyCheckedMore(checkName);
	if (count == 0) {
		this.showMessage("请选择需要修改的记录", "warn");
	} else if (count > 1) {
		this.showMessage("请选择一条记录进行修改", "warn");
	} else {
		modifyId = this.getCheckedValue(checkName);
	}
	return modifyId;
}
// 在checkName对应的check组中判断是否可以修改
// 参数：对应的check组名称
checkElement.getDeleteFlag = function(checkName) {
	var deleteFlag = '0';
	var count = this.justifyCheckedMore(checkName);
	if (count == 0) {
		this.showMessage("请选择需要删除的记录信息", "warn");
	} else {
		deleteFlag = "1";
	}
	return deleteFlag;
}
// 点击一行时行高亮
checkElement.trClick = function(obj) {
	// 如果点击的是checkbox本身，则跳过点击行事件，以免事件重复执行，导致选不上的现象
	if (event.srcElement.type == "checkbox") {
		return;
	}
	var checkbox = $(obj).find("input:checkbox")[0];
	if (checkbox.checked == true) {
		checkbox.checked = false;
	} else {
		checkbox.checked = true;
	}
	this.checkAllStatus(checkbox.name);
}

// modified by Wang Cheng 2010-7-30 begin
// 判断是否全选，是返回true，否则返回false
// 参数：对应的check组名称
checkElement.ifAllChecked = function(checkName) {
	var selecters = document.getElementsByName(checkName);
	var flag = true;
	// 1.由单选框判断全选框状态
	for (i = 0; i < selecters.length; i++) {
		flag &= selecters[i].checked;
	}
	return flag;
}
// end

/** ******************json+ajax组装下拉选项公用方法********************* */
/*
 * url:请求级联选项的链接,其中链接中的id值不用填写,例如var url = "<c:url
 * value='******.ao?method=****'/>" +"&pId="; sValue:主选项的id值 obj：被级联的下拉框对象
 * isNeedAllOption：是否需要‘全部’选项,默认为需要
 */
function jsonBuildOption(url, sValue, obj, isNeedAllOption) {
	obj.empty();
	if (sValue == "") {
		return;
	}
	var content = "";
	$.getJSON(url + sValue, function(json) {
		if (json == "") {
			return;
		}
		if (isNeedAllOption) {
			content += "<option value=''>全部</option>";
		}
		if (isNeedAllOption == false) {
			content = "<option value=''>请选择</option>" + content;
		}
		$(json).each(function() {
			content += "<option value='" + this.id + "'>" + this.name + "</option>";
		});
		obj.append(content);
	});
}
/** *****************公用下拉组件********************* */
/**
 * sId:父级下拉选择框的id aId:子级下拉选择框的id sNd：是否需要生成“全部”选项，true为需要，false为不需要
 * aValue：子级下拉选择框的备选项，需要为json形式
 */
var dynamicSelect = {};

dynamicSelect.registerEvent = function(sId, aId, sNd, aValue) {
	var jsonList = aValue;
	var sourceObj = $("#" + sId);
	var aimObj = $("#" + aId);
	var isNeedAll = sNd;
	if (sourceObj) {
		if (sourceObj.val() != "") {
			this.buildOption(sId, aId, jsonList, sourceObj.val());
		}
	}
	// $(this.sourceObj).change(function(){
	$(sourceObj).bind('change', function() {
		dynamicSelect.buildOption(sId, aId, jsonList, this.value, isNeedAll);
	});
}
dynamicSelect.buildOption = function(sId, aId, jsonList, id, isNeedAll) {
	$("#" + aId).empty();
	if ($("#" + sId).val() == "") {
		return;
	}
	var json = this.getJsonById(jsonList, id);
	var content = "";
	if (json) {
		$(json.list).each(function() {
			var array = [];
			for (var key in this) {
				array[array.length] = key;
			}
			content += "<option value='" + this[array[0]] + "'>" + this[array[1]] + "</option>";
		});
	}
	if (content != "" && isNeedAll && isNeedAll != '') {
		content = "<option value=''>全部</option>" + content;
	} else if (content != "" && !isNeedAll) {
		content = "<option value=''>请选择</option>" + content;
	}
	$("#" + aId).append(content);
}
dynamicSelect.getJsonById = function(jsonList, id) {
	var obj;
	$(jsonList).each(function() {
		if (this.pId == id) {
			obj = this;
			return true;
		}
	});
	return obj;
}
/**
 * ***********************************根据拼音快速定位下拉列表内容组件
 * start***************************************
 */
/**
 * 用正则表达式将前后空格用空字符串替代。（包括全角空格）
 */
fn_string_trim = function(obj) {
	var value = obj.replace(/(^\s*)|(\s*$)/g, "");
	return value.replace(/(^　*)|(　*$)/g, "");
}
/**
 * 获取拼音首字母
 */
function getPinYin(c) {
	execScript("tmp=asc(\"" + c + "\")", "vbscript");
	tmp = 65536 + tmp;
	if (tmp >= 45217 && tmp <= 45252)
		return "A";
	if (tmp >= 45253 && tmp <= 45760)
		return "B";
	if (tmp >= 45761 && tmp <= 46317)
		return "C";
	if (tmp >= 46318 && tmp <= 46825)
		return "D";
	if (tmp >= 46826 && tmp <= 47009)
		return "E";
	if (tmp >= 47010 && tmp <= 47296)
		return "F";
	if ((tmp >= 47297 && tmp <= 47613) || (tmp == 63193))
		return "G";
	if (tmp >= 47614 && tmp <= 48118)
		return "H";
	if (tmp >= 48119 && tmp <= 49061)
		return "J";
	if (tmp >= 49062 && tmp <= 49323)
		return "K";
	if (tmp >= 49324 && tmp <= 49895)
		return "L";
	if (tmp >= 49896 && tmp <= 50370)
		return "M";
	if (tmp >= 50371 && tmp <= 50613)
		return "N";
	if (tmp >= 50614 && tmp <= 50621)
		return "O";
	if (tmp >= 50622 && tmp <= 50905)
		return "P";
	if (tmp >= 50906 && tmp <= 51386)
		return "Q";
	if (tmp >= 51387 && tmp <= 51445)
		return "R";
	if (tmp >= 51446 && tmp <= 52217)
		return "S";
	if (tmp >= 52218 && tmp <= 52697)
		return "T";
	if (tmp >= 52698 && tmp <= 52979)
		return "W";
	if (tmp >= 52980 && tmp <= 53688)
		return "X";
	if (tmp >= 53689 && tmp <= 54480)
		return "Y";
	if (tmp >= 54481 && tmp <= 62289)
		return "Z";
	return c.charAt(0);
}

/**
 * 根据拼音快速定位下拉列表内容组件主体部分 PS：使用这个组件给指定的下拉列表，必须将这个组件的init方法放在页面的最底部，
 * 这样就可以为指定的下拉列表注册上这个这个组件。这个组件是依赖于jquery的 el:
 * SelectHelper.init("tranStationId"); 其中tranStationId为下拉列表的ID
 */
SelectHelper = new function() {
	/**
	 * 初始化方法
	 * 
	 * @param objId
	 *            需要绑定这个组件的下拉列表标签的ID
	 */
	this.init = function(objId) {
		// 给指定的控件绑定敲击按键事件。 敲击按键的定义为按下并抬起同一个按键
		$("#" + objId).keypress(SelectHelper.getNextKeyItem);
	}
	// 获取选项文本的首字符
	function getItemKeyChar(option) {
		var text = fn_string_trim(option.text);
		return text.charAt(0).toUpperCase();
	}
	// 查找并选中匹配的选项
	this.getNextKeyItem = function() {
		var elm = event.srcElement;
		var index = elm.selectedIndex + 1;
		do {
			if (index == elm.length)
				index = 0;
			if (index == elm.selectedIndex)
				return false; // 未找到匹配的选项，则退出
		} while (key2Char(event.keyCode) != getPinYin(getItemKeyChar(elm.options[index++])));
		elm.selectedIndex = index - 1; // 选中匹配的选项
		return false; // 取消原有的选择功能
	}
};
/**
 * 返回键盘事件对应的字母或数字 a-z: 97 -> 122 A-Z: 65 -> 90 0-9: 48 -> 57
 */
function key2Char(key) {
	var s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	if (key >= 97 && key <= 122)
		return s.charAt(key - 97);
	if (key >= 65 && key <= 90)
		return s.charAt(key - 65);
	if (key >= 48 && key <= 57)
		return "" + (key - 48);
	return null;
}
/**
 * ***********************************根据拼音快速定位下拉列表内容组件
 * end***************************************
 */

/** *****************查询条件清空******************* */
function clear_(arr) {
	for (var i = 0; i < arr.length; i++) {
		$("select[name=" + arr[i] + "]").attr("value", "");
		$("input[name=" + arr[i] + "]").attr("value", "");
	}
}
/**
 * 窗口"取消"按钮方法
 * 
 * @function：1.作用:清空input和textarea元素中的内容，将select的value还原为option中的第一个元素（支持年度、下拉树和勾选下拉树，不支持日历控件，需要单独处理）
 *            2.调用时机：在点击"取消"按钮时触发该方法
 *            3.作用对象：类型为text、password、hidden元素以及textarea和select元素
 *            4.注意：如果input元素中需要有非空默认值，则需要在调用该组件后向其传递指定默认值;如果没有无需重置的元素，则excludeIdArray参数不需要传递
 * @param formId（目标form对象Id或者table对象Id,格式为字符串）
 * @param excludeIdArray（不需要重置的元素id,格式为字符串数组）
 */
function clearFormData(formId, excludeIdArray) {
	if (excludeIdArray == undefined) {
		excludeIdArray = [];
	}
	// input元素
	$("#" + formId + " input").each(function() {
		if ((this.type == 'text' || this.type == 'password' || this.type == 'hidden')
				&& $.inArray(this.id, excludeIdArray) == -1) {
			// 此处判断目的是换热站等下拉树，小区节点树不进行置空操作，只将文本框置空
			if (typeof(Ext.getCmp(this.id)) != "undefined"
					&& (Ext.getCmp(this.id).superclass().getXType() == "uxtreecombobox" || "combo")) {
				if (typeof(Ext.getCmp(this.id).setDefaultValue) != "undefined") {
					Ext.getCmp(this.id).setDefaultValue();
				}
				if (typeof(Ext.getCmp(this.id).clearValue) != "undefined") {
					Ext.getCmp(this.id).clearValue();
				}
			} else {
				this.value = "";
			}
		}
	});
	// textarea元素
	$("#" + formId + " textarea").each(function() {
		if ($.inArray(this.id, excludeIdArray) == -1) {
			this.value = "";
		}
	});
	// select元素
	$("#" + formId + " select").each(function() {
		// 是否是供热年度条件
		var isHeatingYearExist = $(this).parent().prev().text().indexOf('年度') > -1;
		if ($.inArray(this.id, excludeIdArray) == -1 && this.length > 0 && !isHeatingYearExist) {
			this.value = this[0].value;
		}
		// 重置“供热年度”为当前年度
		if(isHeatingYearExist){
			this.value = currentYear_;
		}
	});
}
/** *****************限制输入字符串的长度******************* */
// 计算字符串长度
function slength(value) {
	// 正则验证是否含有汉字
	var reg = /[\u4e00-\u9fa5]/;
	var length = value.length;
	for (var i = 0; i < value.length; i++) {
		if (reg.exec(value.charAt(i))) {
			length += 1;
		}
	}
	return length;
}

/** *****************快捷键设置******************* */
// 此方法的作用为返回一个一次keydown只执行一次绑定事件的方法，防止重复提交
function getHandler_(keys, fn, isLoading) {
	var temp = function() {
		$(document).unbind('keydown', keys, temp);
		fn();
		// 如果参数中没有设置isLoading，也显示loading图标
		if (typeof(isLoading) == 'undefined' || isLoading) {
			// 通过快捷键查询或保存时显示loading图标
			showLoadingTip();
		}
		$(document).one('keyup', function() {
			$(document).bind('keydown', keys, temp);
		});
	};
	return temp;
}
function queryHotKeys_(fn, isLoading) {// 查询快捷键
	var keys = 'alt+q';
	$(document).bind('keydown', keys, getHandler_(keys, fn, isLoading));
}
function saveHotKeys_(fn) {// 保存快捷键
	var keys = 'alt+s';
	$(document).bind('keydown', keys, getHandler_(keys, fn));
}
function createHotKeys_(fn) {// 新建快捷键
	var keys = 'alt+a';
	$(document).bind('keydown', keys, getHandler_(keys, fn));
}
function deleteHotKeys_(fn) {// 删除快捷键
	var keys = 'alt+d';
	$(document).bind('keydown', keys, getHandler_(keys, fn));
}
function editHotKeys_(fn) {// 编辑快捷键
	var keys = 'alt+m';
	$(document).bind('keydown', keys, getHandler_(keys, fn));
}
function quitHotKeys_(fn) {// 退出快捷键
	var keys = 'alt+c';
	$(document).bind('keydown', keys, getHandler_(keys, fn));
}
/** *****************页面上按回车光标切换******************* */
function cursorSwitch_() {
	$(":text").keydown(enterToTab);
	$("select").keydown(enterToTab);
}

/**
 * enter转换为tab
 */
function enterToTab() {
	if (window.event) {
		if (window.event.keyCode == 13) {
			window.event.keyCode = 9;
		}
	};
}
/** *****************居中弹出窗口******************* */
// url：open链接 w：窗口宽度 h：窗口高度 s：是否有滚动条
function openWindow_(url, width, height, scrollBar) {
	LeftPosition = (screen.width) ? (screen.width - width) / 2 : 0;
	TopPosition = (screen.height) ? (screen.height - height) / 2 : 0;
	var scroll = "no";
	if (scrollBar) {
		scroll = "yes";
	}
	settings = 'height=' + height + ',width=' + width + ',top=' + TopPosition + ',left=' + LeftPosition
			+ ',resizable=no,status=no,menubar=no,scrollbars=' + scroll;
	// 延迟100ms的作用：ext的grod单击一行内部会有focus方法，导致弹出窗口后该窗口失去焦点，通过延迟可解决该问题
	setTimeout(function() {
		window.open(url, '', settings)
	}, 100);
	// win.focus();
}

/**
 * 弹出指定大小并居中的Window窗口
 * 
 * @param:{String} url 链接
 * @param:{String[]} params
 * @param:{Double} width 窗口宽度
 * @param:{Double} height 窗口高度
 */
function openModalDialog_(url, params, width, height) {
	LeftPosition = (screen.width) ? (screen.width - width) / 2 : 0;
	TopPosition = (screen.height) ? (screen.height - height) / 2 : 0;
	settings = 'dialogHeight=' + height + ';dialogWidth=' + width + ';dialogTop=' + TopPosition + ',dialogLeft='
			+ LeftPosition + ';status:0; help: no ;status: no;border: no';
	window.showModalDialog(url, params, settings);
}
/**
 * 为显示票据而弹出模态窗口(实现此方法可以统一处理系统内票据窗口大小,使修改更容易)
 */
function openModalDialogPrint_(url, params) {
	var width = 730;
	var height = 430;

	// 居中显示
	var leftPosition = (screen.width) ? (screen.width - width) / 2 : 0;
	var topPosition = (screen.height) ? (screen.height - height) / 2 : 0;

	// 尺寸和位置设置
	var settings = 'width=' + width + ',height=' + height + ',top=' + topPosition + ',left=' + leftPosition;
	// 窗口工具栏设置
	settings += ',location=0,menubar=0,resizable=0,scrollbars=0,status=0,titlebar=0,toolbar=0';
	// 打开窗口
	window.open(url, '', settings);
}

/** *****************表单提交时自动去左右空格******************* */
function fn_trim(formId) {
	$('#' + formId + ' input:text').each(function(el) {
		$(this).val($.trim($(this).val()));
	});
}

/**
 * *****************iframe列表高度自适应，约束：iframe的id为listContentFrame
 * *******************
 */
function autoAdjustIframeHeight_() {
	var newHeight = $("#listContentFrame").height() + $(parent.window._d_main_content).height()
			- $(window.document.body).height() - 5;
	$("#listContentFrame").height(newHeight);
}

/** *****************PNG图片透明处理******************* */
function correctPNG() // correctly handle PNG transparency in Win IE 5.5 & 6.
{
	var arVersion = navigator.appVersion.split("MSIE")
	var version = parseFloat(arVersion[1])
	if ((version >= 5.5) && (document.body.filters)) {
		for (var j = 0; j < document.images.length; j++) {
			var img = document.images[j]
			var imgName = img.src.toUpperCase()
			if (imgName.substring(imgName.length - 3, imgName.length) == "PNG") {
				var imgID = (img.id) ? "id='" + img.id + "' " : ""
				var imgClass = (img.className) ? "class='" + img.className + "' " : ""
				var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
				var imgStyle = "display:inline-block;" + img.style.cssText
				if (img.align == "left")
					imgStyle = "float:left;" + imgStyle
				if (img.align == "right")
					imgStyle = "float:right;" + imgStyle
				if (img.parentElement.href)
					imgStyle = "cursor:hand;" + imgStyle
				var strNewHTML = "<span " + imgID + imgClass + imgTitle + " style=\"" + "width:" + img.width
						+ "px; height:" + img.height + "px;" + imgStyle + ";"
						+ "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" + "(src=\'" + img.src
						+ "\', sizingMethod='scale');\"></span>"
				img.outerHTML = strNewHTML
				j = j - 1
			}
		}
	}
}

// 处理保留两位小数
function saveTwoDecimalFraction(number) {
	return Math.round(number * 100) / 100;
}

/** *****************EXT checkTree 公用方法开始************************ */
// 根据根节点递归取消所有选中节点
function removeNodeChecked(rootNode) {
	var children = rootNode.childNodes;
	for (var i = 0; i < children.length; i++) {
		var c = children[i].getUI().checkbox;
		c.checked = false;
		// 解决了在IE6下在第一次点父节点时只选择了部分子节点，第二次点击父节点时全选子节点，然后再重复第一次操作时会发生子节点全选的问题，这是IE6的一个bug
		c.defaultChecked = false;
		if (!children[i].isLeaf()) {
			removeNodeChecked(children[i]);
		}
	}
}
// 关闭所有未勾选的父节点
function collapseUncheckedNode(rootNode) {
	var children = rootNode.childNodes;
	for (var i = 0; i < children.length; i++) {
		if (!children[i].isLeaf() && !children[i].getUI().checkbox.checked) {
			children[i].collapse();
		}
	}
}
// 得到选中的节点id
function getCheckedNodeId(tree) {
	var idStr = "";
	if (null != tree.getSelectionModel().getSelectedNode()) {
		idStr = tree.getSelectionModel().getSelectedNode().id;
	}
	return idStr;
}
// 得到选中的节点文本
function getCheckedLeafText(rootNode) {
	var idStr = "";
	var node = rootNode.childNodes;
	for (var i = 0; i < node.length; i++) {
		if (node[i].getUI().checkbox.checked) {
			if (!node[i].isLeaf()) {
				idStr += "\n" + node[i].text + ":" + getCheckedLeafText(node[i]);
			} else {
				idStr += node[i].text + ",";
			}
		}
	}
	return idStr;
}
// 得到选中的叶子节点id
function getCheckedLeafId(rootNode) {
	var idStr = "";
	var node = rootNode.childNodes;
	for (var i = 0; i < node.length; i++) {
		if (node[i].getUI().checkbox.checked) {
			idStr += node[i].id + ",";
		}
		if (!node[i].isLeaf()) {
			idStr += getCheckedLeafId(node[i]);
		}
	}
	return idStr;
}

/** *****************EXT checkTree 公用方法结束************************ */

/**
 * 请求返回json串，ajax请求
 * 
 * @parameter: {String} url请求路径
 * @return: {String} json串
 */
function jqueryAjax(url) {
	var json = $.ajax({
		url : url,
		type : 'POST', // 默认值: "GET")。请求方式 ("POST" 或 "GET")， 默认为 "GET"
		// dataObject:{}, //发送到服务器的数据。将自动转换为请求字符串格式。
		async : false, // 默认值: true。默认设置下，所有请求均为异步请求
		dataType : 'json', // 预期服务器返回的数据类型
		success : function(json) {

		},
		error : function(json) {// 默认值: 自动判断 (xml 或 html)。请求失败时调用此函数。
			showMessage("系统请求失败！", "error");
		}
	}).responseText;
	return eval('(' + json + ')');
}

/**
 * ajax请求并返回json数据或true、false
 * 
 * @parameter: {String} url请求路径
 * @return: {String} 对于json数据串返回json数据，对于消息json进行消息提示并返回true（成功）或false（失败）
 */
function ajaxRequest(url, data) {
	var jsonStr = $.ajax({
		url : url,
		type : 'POST', // 默认值: "GET"。请求方式 ("POST" 或 "GET")， 默认为 "GET"
		async : false, // 默认值: true。默认设置下，所有请求均为异步请求
		dataType : 'json', // 预期服务器返回的数据类型
		data : data,
		success : function(json) {
			if (json && json.state) {
				showJsonMessage(json);
			}
		},
		error : function(json) {// 请求失败时调用此函数。
			showMessage("系统请求失败！", "error");
		}
	}).responseText;
	var json = eval('(' + jsonStr + ')');
	if (json) {
		// 如果json中存在消息状态标识则提示消息并返回true、false
		if (json.state) {
			return showMessageState(json.state);
			// 否则为数据json，直接返回
		} else {
			return json;
		}
	}
	return null;
}

/**
 * 判断是否已经勾选记录并给出相应提示或返回已勾选记录的列值数组
 * 
 * @param：{GridPanel} GridPanel 选择的客户记录所在GridPanel
 * @param：{string} dataIndex 所需值在record中的dataIndex
 * @param：{boolean} isSingle 是否只能选择单一客户,true为单一，false为批量
 * @param：{string} msgName 提示信息的对象名
 * @return recordId[] 已勾选记录的列值数组
 */
function getGridCheckedValue(GridPanel, dataIndex, isSingle, msgName) {
	if (GridPanel) {
		var msg = "客户";
		if (msgName) {
			msg = msgName;
		}
		var selModel = GridPanel.getSelectionModel();
		if (!selModel.hasSelection()) {
			showMessage("请选择" + msg, "warn");
		} else if (isSingle && selModel.getSelections().length > 1) {
			showMessage("只能选择一个" + msg, "warn");
		} else {
			var records = selModel.getSelections();
			var ids = [];
			for (var i = 0; i < records.length; i++) {
				ids.push(records[i].get(dataIndex));
			}
			return ids;
		}
	}
	return null;
}

/**
 * 数字精度转换时误差修正,js进行数字运算后不是我们预期的效果，很多小数位
 * 
 * @param：{Double} left 需要处理的数字
 * @return：{Double} 处理后的数字
 */
function numCorrect(left) {
	var arr = (new String(left)).split(".");
	// 小数点后面的数据遇到都为9的情况会自动向前一位加1
	var xs = arr[1];
	var digit = "";
	if ((xs + "").length > 3) {
		// 取出小数点后的第三位
		if ((xs + "").charAt(2) == '9') {
			// 取出小数点后的 从左向右的第四位开始以后的字符与9做循环比较(第四位等于9就比较下一位，不等于就跳出循环)
			var a = (xs + "").substring(3, (xs + "").length);
			for (var i = 0; i < a.length; i++) {
				if (a.charAt(i) == "9") {
					digit = (Number((xs + "").substring(0, 2)) + 1);
					continue;
				} else {
					digit = (Number((xs + "").substring(0, 2)));
					break;
				}
			}
			if (digit < 10) {
				digit = "0" + digit;
			}
			if (digit == 100) {
				arr[0] = Number(arr[0]) + 1;
				digit = 0;
			}
			left = arr[0] + "." + (digit);
		}
		if ((xs + "").charAt(2) == '0') {
			left = arr[0] + "." + (xs + "").substring(0, 2);
		}
	}
	return Number(left);
}
/**
 * @function: excel导出时的加载效果
 * 
 * 
 */
function showExcelExportLoading() {
	Ext.MessageBox.show({
		msg : '正在导出Excel,请稍候...',
		progressText : '导出中...',
		width : 300,
		wait : true,
		icon : 'icon_common_excelExport'
	});
}

/**
 * @function:创建excel下载面板
 * @params:文件名
 */
function createDownLoadPanel(fileName) {
	var url = encodeURI(context
			+ "/public/basalInfo/query.ao?method=processDownLoadFile&filePath=/download/excel/&fileName=" + fileName
			+ ".xls");
	/**
	 * 导出window定义
	 */
	var downLoadWindow = new Ext.Window({
		title : '下载Excel',
		width : 300,
		height : 105,
		border : false,
		monitorResize : true,
		modal : true,
		resizable : false,
		closeAction : 'hide',
		closable : true,
		plain : true,
		bodyBorder : false,
		buttonAlign : 'center',
		html : '<div style="width:100%;height:100%;font-size:12px;text-align:center;margin-top:11px;"><a id="downLoad" href='
				+ url + ' >' + fileName + '.xls' + '</a></div>',
		buttons : [{
			id : 'downLoad',
			text : '下载',
			handler : function() {
				downLoadWindow.hide();
				window.location.href = url;
			}
		}, {
			id : 'cancel',
			text : '取消',
			handler : function() {
				downLoadWindow.hide();
			}
		}]
	});
	downLoadWindow.show();
	$("a").bind("click", function() {
		downLoadWindow.hide();
	});
}
/**
 *@function :蕴藏导出Excel的加载效果并显示下载面板。<b>该方法已过时，今后调用excelExportDownLoad(url ,gridName)方法</b>
 *@param：请求路径
 */
function excelExportDownLoad(url) {
	showExcelExportLoading();
	$.getJSON(url, function(json) {
		if (json) {
			window.setTimeout(function() {
				Ext.MessageBox.hide();
			}, 200);
			createDownLoadPanel(json.fileName);
		}
	});
}
/**
 * @function :蕴藏导出Excel的加载效果并显示下载面板
 * @param :{String} url 请求路径
 * @param :{String} gridName Grid定义的名称
 */
function excelExportDownLoad(url, gridName) {
	var dateCount;
	if (gridName) {
		dateCount = Ext.getCmp(gridName.getId()).getStore().getCount();
	}
	if (!dateCount && dateCount <= 0) {
		alert("目前没有任何数据可以导出！");
	} else {
		showExcelExportLoading();
		$.getJSON(url, function(json) {
			if (json) {
				window.setTimeout(function() {
					Ext.MessageBox.hide();
				}, 200);
				createDownLoadPanel(json.fileName);
			}
		});
	}
}

/**
 * 计算输入框(文本域)字数
 * 
 * @param sourceId
 *            需要计算字数的输入框(文本域)
 * @param 需要显示字数的label
 */
function charCountFn(sourceId, targetId) {
	$("#" + sourceId).bind('focus keyup input paste', function() { // 采用几个事件来触发（已增加鼠标粘贴事件）
				setTimeout(function() {
					$("#" + targetId).text($("#" + sourceId).attr("value").length)
				}, 250); // 获取评论框字符长度并添加到ID="num"元素上
			});
}

/**
 * @function :鼠标悬停时显示title(用于列表中列内容过长时完整显示列内容)
 * @param:需要显示的内容
 */
function showTitle(value) {
	value = value == null ? '' : value;
	return '<span title=' + value + '>' + value + '</span>';
}

/**
 * @function :蕴藏导出Excel的加载效果并显示下载面板(专门针对无列表格式传参数)
 * @param：请求路径
 */
function excelExportDownLoadForNoList(url, data) {
	showExcelExportLoading();
	$.getJSON(url, data, function(json) {
		if (json) {
			window.setTimeout(function() {
				Ext.MessageBox.hide();
			}, 200);
			createDownLoadPanel(json.fileName);
		}
	});
}

/**
 * @function :Ext列表中显示欠费金额样式
 * @param:需要显示的内容
 */
function oweMoneyRenderer(val) {
	if (val <= 0) {
		return "<span class='date_green' style='float:right;padding-right:10px;'>" + val + "</span>";
	} else {
		return "<span class='date_notice' style='float:right;padding-right:10px;'>" + val + "</span>";
	}
}

/**
 * 给url添加上下文和日期参数
 * @param: {String} 需要处理的路径
 * @return: {String} 处理后的路径
 */
function padUrl(url) {
	url += (url.indexOf("?") == -1 ? "?" : "&") + "d=" + new Date().getTime();
	return context + url;
}
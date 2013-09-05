
/**
 * 
 * 新建一个创建窗口的方法
 * */
var createwin = new Ext.Window({
	title : "新建用户",
	width : 600,
	height : 400,
	resizable : false,
	closeAction : 'hide',
	maximizable : false,
	items : [{
		region : 'center',
		contentEl : 'register',
		frame : true,
		xtype : 'panel',
		baseCls : 'x-plain'
	}]
});

/**
 * 
 * 创建提升版主的窗口 
 * */
var becomewin = new Ext.Window({
	title : "版主修改",
	width : 400,
	height : 140,
	resizable : false,
	closeAction : 'hide',
	maximizable : false,
	items : [{
		region : 'center',
		contentEl : 'bacomeSec',
		frame : true,
		xtype : 'panel',
		baseCls : 'x-plain'
	}]
});

Ext.BLANK_IMAGE_URL = context + "/js/ext/resources/images/default/s.gif";
// 查询客户信息Store
var pageSize = 15;
var store = new Ext.data.JsonStore({
	url : padUrl("/readMsg.ao?method=getInfo"),
	root : 'root',
	method : 'post',
	autoLoad : true,
	totalProperty : 'totalProperty',
	fields : ['id', 'name', 'status', 'registerTime', 'isBm', 'isManager']
});

var sm = new Ext.grid.CheckboxSelectionModel();
var cm = new Ext.grid.ColumnModel([sm, {
	header : '用户名',
	dataIndex : 'name',
	align : 'center'
}, {
	header : '状态',
	dataIndex : 'status',
	align : 'center'
}, {
	header : '注册时间',
	dataIndex : 'registerTime',
	align : 'center'
}, {
	header : '是否版主',
	dataIndex : 'isBm',
	align : 'center'
}, {
	header : '是否管理员',
	dataIndex : 'isManager',
	align : 'center'
}]);

/**
 *分页工具栏
 */
var gridPanelBBar = new Ext.PagingToolbar({
	pageSize : pageSize,
	store : store,
	displayInfo : true
});

/**
 *创建表格
 */
var gridPanel = new Ext.grid.GridPanel({
	autoScroll : true,
	enableHdMenu : true,
	enableColumnResize : true,
	id : 'gridPanel',
	trackMouseOver : true,
	enableColumnHide : true,
	// enableColumnMove : false,
	columnLines : true,
	margins : '5 0 5 5',
	style : 'border:solid 6px #C6D8EA;',
	header : true,
	border : true,
	draggable : false,
	frame : true,
	bbar : gridPanelBBar,
	region : 'center',
	cm : cm,
	sm : sm,
	store : store,
	viewConfig : {
		forceFit : true
	},
	columnLines : true
});

/**
 *创建表单
 */
var form = new Ext.form.FormPanel({
	region : 'north',
	frame : true,
	contentEl : 'top',
	height : 50,
	margin : '5 0 5 5'
});

/**
 *整体布局
 */
Ext.onReady(function() {
	var viewport = new Ext.Viewport({
		layout : 'border',
		items : [form, gridPanel]
	});
	cursorSwitch_();
});

// 查询按钮的方法
function queryUserInfo() {
	var myMask = new Ext.LoadMask(Ext.getCmp("gridPanel").getEl(), {
		msg : "正在加载数据，请稍候……"
	});
	myMask.show();

	Ext.getCmp("gridPanel").getStore().removeAll();

	Ext.getCmp("gridPanel").getStore().baseParams = {
		"attribute(name)" : $("#name").val()
	};
	Ext.getCmp("gridPanel").getStore().load({

		callback : function(o, reps, success) {
			myMask.hide();
		}
	});
}

// 新建用户的方法
function createUser() {
	createwin.show();
}

// 取消按钮的方法

function clearFormData() {

	$("#username").val("");
	$("#sname").text("*");
	$("#sname").css("color", "red");
	$("#password").val("");
	$("#pwd").val("");
	$("#age").val("");
	createwin.hide();
}

// 屏蔽按钮的方法
function shieldUserInfos() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择用户', 'warn');
	} else {
		var ids = "";
		var records = selModel.getSelections();
		for (var i = 0; i < records.length; i++) {
			if (records[i].get("isManager") == '是') {
				showMessage('对不起，管理员无法被屏蔽', 'warn');
				return;
			}
			// 屏蔽按钮可以反复
			// else if(records[i].get("status")=='屏蔽'){
			// showMessage('对不起，改用户已经被屏蔽', 'warn');
			// return;
			// }
			else {
				ids += "," + records[i].get("id");
			}
		}
		if (confirm("确定屏蔽选中用户？")) {
			var url = padUrl("/shield.ao?method=processShieldUserInfo" + "&ids=" + ids.substring(1));
			if (!ajaxRequest(url)) {
									return false;
								} else {
									return true;
									
								}
//			$.post(url, function(json) {
//				showJsonMessage(json);
//				store.reload();
//				Ext.getCmp("gridPanel").getStore().remove(records);
//			}, 'json');
		}
	}
}

/**
 * 
 *  提升为版主按钮方法
 * */
function becomeModerator() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择客户', 'warn');
	} else if (selModel.getSelected().get("status") != '正常') {
		showMessage('该用户被屏蔽，不能提升为版主', 'warn');
	} else if (selModel.getSelected().get("isBm") != '否') {
		showMessage('该用户已经是版主，不能重复提升', 'warn');
	} else if (selModel.getSelections().length > 1) {
		showMessage('只能选择单个客户进行操作', 'warn');
	} else {
		becomewin.show();
	}
}

/**
 * 
 *  成为版主层中"保存"按钮的方法
 * */

function selectSectionName() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var sectionId = $("select[id='section']").val();
	var Id = selModel.getSelected().get("id");
	var url = padUrl("/section/moderator.ao?method=becomeModerator&Id=" + Id + "&sectionId=" + sectionId);
	var options = {
		url : url,
		dataType : 'json',
		success : function(e) {
			if (!showJsonMessage(e)) {
			} else {
				showJsonMessage(e);
				store.reload();
				$("#section").val("");
				becomewin.hide();
			}
		}
	};
	$("#selectSectionNameForm").ajaxSubmit(options);
}
/**
 * 
 *  验证密码是否一致
 * */
function checkForm() {
	var password = $("#password").val();
	var pwd = $("#pwd").val();
	if (password != pwd) {
		showMessage('密码输入不一致', 'warn');
		$("#password").val("");
		$("#pwd").val("");
		return false;
	}
}

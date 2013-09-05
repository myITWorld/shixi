
/**
 * 
 * 创建版块弹出层
 * */ 
var createSectionWin = new Ext.Window({
	title : "新建版块",
	width : 600,
	height : 400,
	resizable : false,
	closeAction : 'hide',
	maximizable : false,
	items : [{
		region : 'center',
		contentEl : 'createSectionWindow',
		frame : true,
		xtype : 'panel',
		baseCls : 'x-plain'
	}]
});

/**
 * 
 * 修改版块弹出层
 * */
var updateSectionWin = new Ext.Window({
	title : "修改版块",
	width : 400,
	height : 270,
	closeAction : 'hide',
	maximizable : false,
	resizable : false,
	items : [{
		region : 'center',
		contentEl : 'updateSectionWindow',
		frame : true,
		xtype : 'panel',
		baseCls : 'x-plain'
	}]
});

Ext.BLANK_IMAGE_URL = context + "/js/ext/resources/images/default/s.gif";
// 查询版块信息Store
var pageSize = 20;
var store = new Ext.data.JsonStore({
	url : padUrl("/section/querySectionInfo.ao?method=getSecInfo"),
	root : 'root',
	method : 'post',
	autoLoad : true,
	totalProperty : 'totalProperty',
	fields : ['id', 'sectionName', 'username', 'createTime', 'isAuditing', 'visitCredits']
});
var sm = new Ext.grid.CheckboxSelectionModel();
var cm = new Ext.grid.ColumnModel([sm, {
	header : '版块名称',
	dataIndex : 'sectionName',
	align : 'center'
}, {
	header : '版主',
	dataIndex : 'username',
	align : 'center'
}, {
	header : '创建时间',
	dataIndex : 'createTime',
	align : 'center'
}, {
	header : '是否审核',
	dataIndex : 'isAuditing',
	align : 'center'
}, {
	header : '访问积分',
	dataIndex : 'visitCredits',
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
 * 创建gridpanel
 * */
var gridPanel = new Ext.grid.GridPanel({
	title : '版块信息',
	autoScroll : true,
	enableHdMenu : true,
	enableColumnResize : true,
	id : 'gridPanel',
	trackMouseOver : true,
	enableColumnHide : true,
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
 * 创建formPanel
 * */
var form = new Ext.form.FormPanel({
	region : 'north',
	frame : true,
	contentEl : 'top',
	height : 50,
	margin : '5 0 5 5'
});

/**
 * 
 *  整体布局
 * */
Ext.onReady(function() {
	var viewport = new Ext.Viewport({
		layout : 'border',
		items : [form, gridPanel]
	});
	cursorSwitch_();
	querySectionInfo();
});

/**
 * 
 * 查询按钮的方法
 * */ 
function querySectionInfo() {
	var userId = $("#userId").val();
	if (userId == 1) {
		userId = null;
	}
	var myMask = new Ext.LoadMask(Ext.getCmp("gridPanel").getEl(), {
		msg : "正在加载数据，请稍候……"
	});
	myMask.show();
	Ext.getCmp("gridPanel").getStore().removeAll();
	Ext.getCmp("gridPanel").getStore().baseParams = {
		"attribute(userId)" : userId,
		"attribute(sectionName)" : $("#name").val()
	};
	Ext.getCmp("gridPanel").getStore().load({

		callback : function(o, reps, success) {
			myMask.hide();
		}
	});
}

/**
 * 
 * "新建版块"按钮的方法
 * */ 
function createSection() {
	createSectionWin.show();
}

/**
 * 
 * 新建版块弹出层中"保存"按钮的方法
 * */ 
function createSectionInfo() {
	var userId = $("select[id='section']").val();
	var url = padUrl("/section/createSection.ao?method=createSection&userId=" + userId);
	var options = {
		url : url,
		dataType : 'json',
		success : function(e) {
			if (!showJsonMessage(e)) {
			} else {
				showJsonMessage(e);
				store.reload();
				clearFormData();
			}
		}
	};
	$("#createSectionForm").ajaxSubmit(options);
}

/**
 * 
 *  新建版块弹出层中"取消"按钮的方法
 * */
function clearFormData() {
	$("#sectionName").val("");
	$("#sectionIntro").val("");
	$("#visitCredits").val("");
	$("#section").val("");
	createSectionWin.hide();
}

/**
 * 
 *  "删除"按钮的方法
 * */
function deleteSection() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择版块', 'warn');
	} else {
		var ids = "";
		var records = selModel.getSelections();
		for (var i = 0; i < records.length; i++) {
			ids += "," + records[i].get("id");
		}
		if (confirm("确定删除选中版块？")) {
			var url = padUrl("/delSectionInfo.ao?method=deleteSectionInfo" + "&ids=" + ids.substring(1));
			if (!ajaxRequest(url)) {
									return false;
								} else {
									store.reload(); 
				               Ext.getCmp("gridPanel").getStore().remove(records);
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
 * "修改"按钮方法
 * */ 
function updateSectionInfo() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择版块', 'warn');
	} else if (selModel.getSelections().length > 1) {
		showMessage('只能对单个版块进行操作', 'warn');
	} else {
		var name = selModel.getSelected().get("sectionName");
		var visitCredits = selModel.getSelected().get("visitCredits");
		$("#upSectionName").val(name);
		if (selModel.getSelected().get("isAuditing") == '是') {
			$("input[id=upAuditing][value=1]").attr("checked", true);
		} else {
			$("input[id=upAuditing][value=0]").attr("checked", true);
		}
		$("#upVisitCredits").val(visitCredits);
		updateSectionWin.show();
	}
}

/**
 * 
 * 修改弹出层中"保存"按钮的方法
 * */ 
function updateSectionSibmit() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var id = selModel.getSelected().get("id");
	var url = padUrl("/section/updateSection.ao?method=updateSectionInfo&id=" + id);
	var options = {
		url : url,
		dataType : 'json',
		success : function(e) {
			if (!showJsonMessage(e)) {
			} else {
				showJsonMessage(e);
				store.reload();
				updateSectionWin.hide();
			}
		}
	};
	$("#updateSectionForm").ajaxSubmit(options);
}

/**
 * 
 *  修改弹出层中"取消"按钮的方法
 * */
function cancelUdate() {
	updateSectionWin.hide();
}

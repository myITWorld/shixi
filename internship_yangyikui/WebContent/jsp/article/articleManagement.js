// 给gridpanel加链接
function showUrl(value) {
	return '<a href="javascript:void(0)" onclick="showDetail()" style="color:blue;" onmouseover="this.style.color=\'red\'" onmouseout="this.style.color=\'blue\'">'
			+ value + '</a>';
}

// 精华
function showEsss(value) {
	if (value == "是") {
		return "<img alt='精华' src='" + context + "/skins/style_1/images/icon/jinghua.png'>";
	} else {
		return "否";
	}
}

// 置顶
function showTop(value) {
	if (value == "是") {
		return "<img alt='精华' src='" + context + "/skins/style_1/images/icon/zhiding.png'>";
	} else {
		return "否";
	}
}
// 创建发文章层
var createArticleWin = new Ext.Window({
	title : "发表文章",
	width : 500,
	height : 460,
	resizable : false,
	closeAction : 'hide',
	maximizable : false,
	items : [{
		region : 'center',
		contentEl : 'createArticleWindow',
		frame : true,
		xtype : 'panel',
		baseCls : 'x-plain'
	}]
});

Ext.BLANK_IMAGE_URL = context + "/js/ext/resources/images/default/s.gif";
// 查询文章信息Store
var pageSize = 20;
var store = new Ext.data.JsonStore({
	url : padUrl("/article/queryArticleInfo.ao?method=getArticleInfo"),
	root : 'root',
	method : 'post',
	autoLoad : true,
	totalProperty : 'totalProperty',
	fields : ['id', 'title', 'author', 'sectionName', 'isAuditing', 'updateTime', 'articleLabel', 'isEssence', 'isTop']
});

var sm = new Ext.grid.CheckboxSelectionModel();
var cm = new Ext.grid.ColumnModel([sm, {
	header : '文章标题',
	dataIndex : 'title',
	width : 140,
	align : 'center',
	renderer : showUrl
}, {
	header : '作者',
	dataIndex : 'author',
	width : 130,
	align : 'center'
}, {
	header : '版块',
	dataIndex : 'sectionName',
	align : 'center'
}, {
	header : '是否审核',
	dataIndex : 'isAuditing',
	align : 'center'
}, {
	header : '修改时间',
	dataIndex : 'updateTime',
	width : 140,
	align : 'center'
}, {
	header : '标签',
	dataIndex : 'articleLabel',
	width : 118,
	align : 'center',
	renderer : showTitle
}, {
	header : '精华',
	dataIndex : 'isEssence',
	align : 'center',
	renderer : showEsss
}, {
	header : '置顶',
	dataIndex : 'isTop',
	align : 'center',
	renderer : showTop
}]);

/**
 *分页工具栏
 */
var gridPanelBBar = new Ext.PagingToolbar({
	pageSize : pageSize,
	store : store,
	displayInfo : true
});
var gridPanel = new Ext.grid.GridPanel({
	autoScroll : true,
	enableHdMenu : true,
	enableColumnResize : true,
	id : 'gridPanel',
	trackMouseOver : true,
	enableColumnHide : true,
	columnLines : true,
	margins : '5 5 5 5',
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

var form = new Ext.form.FormPanel({
	region : 'north',
	frame : true,
	contentEl : 'top',
	height : 50,
	margin : '5 5 0 5'
});

// 整体布局
Ext.onReady(function() {
	var viewport = new Ext.Viewport({
		layout : 'border',
		items : [form, gridPanel]
	});
	cursorSwitch_();
	queryArticleInfo();
});

// 查询按钮的方法
function queryArticleInfo() {
	var userId = $("#userId").val();
	if (userId == 1) {
		userId = null
	}
	var myMask = new Ext.LoadMask(Ext.getCmp("gridPanel").getEl(), {
		msg : "正在加载数据，请稍候......"
	});
	myMask.show();
	Ext.getCmp("gridPanel").getStore().removeAll();
	Ext.getCmp("gridPanel").getStore().baseParams = {
		"attribute(userId)" : userId,
		"attribute(username)" : $("#name").val(),
		"attribute(title)" : $("#title").val(),
		"attribute(sectionName)" : $("#sectionName").val()
	};
	Ext.getCmp("gridPanel").getStore().load({

		callback : function(o, reps, success) {
			myMask.hide();
		}
	});
}

// "发文章"按钮事件
function pubArticle() {
	// createArticleWin.show();//弹窗
	location = context + "/publishArt.ao?method=toPublish";// 进入新界面

}

// "保存"按钮事件
function publishArticleInfo() {
	var sectionId = $("select[id='article']").val();
	var url = padUrl("/article/createArticle.ao?method=createArticle&sectionId=" + sectionId);
	var options = {
		url : url,
		dataType : 'json',
		success : function(e) {
			if (!showJsonMessage(e)) {
			} else {
				showJsonMessage(e);
				store.reload();
				clearFormData();
				createArticleWin.hide();
			}
		}
	};
	$("#createArticleForm").ajaxSubmit(options);
}
// "取消"按钮方法
function canclePub() {
	clearFormData();
	createArticleWin.hide();

}

// 清除form内容
function clearFormData() {
	$("#titleName").val("");
	$("#articleContent").val("");
	$("#articleLabel").val("");
	$("#article").val("");
}

// "审核"按钮的方法
function autiding() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择文章', 'warn');
	} else {
		var ids = "";
		var records = selModel.getSelections();
		for (var i = 0; i < records.length; i++) {
			ids += "," + records[i].get("id");
		}
		if (confirm("确定审核选中的文章？")) {
			var url = padUrl("/article/autiding.ao?method=autidingArticle" + "&ids=" + ids);
			$.post(url, function(json) {
				showJsonMessage(json);
				store.reload();
				Ext.getCmp("gridPanel").getStore().remove(records);
			}, 'json');
		}
	}
}

// "精华"按钮事件
function changeEss() {

	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择文章', 'warn');
	} else {
		var ids = "";
		var records = selModel.getSelections();
		for (var i = 0; i < records.length; i++) {
			ids += "," + records[i].get("id");
		}
		if (confirm("确定设置该文章为精华？")) {
			var url = padUrl("/article/changeEss.ao?method=changeArticleEss" + "&ids=" + ids);
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

// "置顶按钮事件"
function setTop() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择文章', 'warn');
	} else if (selModel.getSelections().length > 1) {
		showMessage('只能对单个文章进行操作', 'warn');
	} else {
		var id = selModel.getSelected().get("id");
		if (confirm("确定对该文章进行操作？")) {
			var url = padUrl("/article/setTop.ao?method=setArticleTop" + "&id=" + id);
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

// "删除"按钮方法
function deleteArticle() {

	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	if (!selModel.hasSelection()) {
		showMessage('请先选择文章', 'warn');
	} else {
		var ids = "";
		var records = selModel.getSelections();
		for (var i = 0; i < records.length; i++) {
			ids += "," + records[i].get("id");
		}
		if (confirm("确定删除选中文章？")) {
			var url = padUrl("/delArticleInfo.ao?method=deleteArticleInfo" + "&ids=" + ids.substring(1));
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

// 显示文章详细信息
function showDetail() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var Id = selModel.getSelected().get("id");
	location = padUrl("/article/articleDetailInfo.ao?method=showArticleDetail&articleId=" + Id);

}
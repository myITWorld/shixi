
/**
 * 给gridpanel文章标题加链接
 * */
function showUrl(value) {
	return '<a href="javascript:void(0)" onclick="showDetail()" style="color:blue;" onmouseover="this.style.color=\'red\'" onmouseout="this.style.color=\'blue\'">'
			+ value + '</a>';
}

/**
 * 给gridpanel作者加链接
 * */
function showAuInfo(value) {
	return '<a href="javascript:void(0)" onclick="showAuthorDetail()" style="color:blue;" onmouseover="this.style.color=\'red\'" onmouseout="this.style.color=\'blue\'">'
			+ value + '</a>';
}

/**
 * 
 * 给gridpanel的版块加链接
 * */
function showArticleOfSection(value) {

	return '<a href="javascript:void(0)" onclick="SectionOfArticle()" style="color:blue;" onmouseover="this.style.color=\'red\'" onmouseout="this.style.color=\'blue\'">'
			+ value + '</a>';

}

/**
 * 
 * 精华
 * */ 
function showEsss(value) {
	if (value == "是") {
		return "<img alt='精华' src='" + context + "/skins/style_1/images/icon/jinghua.png'>";
	} else {
		return "否";
	}
}

/**
 * 
 * 置顶
 * */ 
function showTop(value) {
	if (value == "是") {
		return "<img alt='精华' src='" + context + "/skins/style_1/images/icon/zhiding.png'>";
	} else {
		return "否";
	}
}

Ext.BLANK_IMAGE_URL = context + "/js/ext/resources/images/default/s.gif";
// 查询文章信息Store
var pageSize = 20;
var store = new Ext.data.JsonStore({
	url : padUrl("/article/queryArticleIndexInfo.ao?method=getArticleIndexInfo"),
	root : 'root',
	method : 'post',
	autoLoad : true,
	totalProperty : 'totalProperty',
	baseParams : {
		"attribute(sectionId)" : sectionId
	},
	fields : ['id', 'userId', 'sectionId', 'sectioner', 'credits', 'title', 'author', 'sectionName', 'createTime',
			'updateTime', 'isEssence', 'isTop']
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
	align : 'center',
	renderer : showAuInfo
}, {
	header : '版块',
	dataIndex : 'sectionName',
	align : 'center',
	renderer : showArticleOfSection
}, {
	header : '创建时间',
	dataIndex : 'updateTime',
	width : 140,
	align : 'center'
}, {
	header : '修改时间',
	dataIndex : 'updateTime',
	width : 140,
	align : 'center'
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
}, {
	header : '版块访问积分',
	dataIndex : 'credits',
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
 * 
 * 创建gridpanel
 * */
var gridPanel = new Ext.grid.GridPanel({
	// title:'版块文章',
	autoScroll : true,
	enableHdMenu : true,
	enableColumnResize : true,
	id : 'gridPanel',
	trackMouseOver : true,
	enableColumnHide : true,
	columnLines : true,
	margins : '0 5 5 5',
	style : 'border:solid 6px #C6D8EA;',
	header : true,
	border : true,
	draggable : false,
	frame : true,
	bbar : gridPanelBBar,
	region : 'center',
	width : 800,
	cm : cm,
	sm : sm,
	store : store,
	viewConfig : {
		forceFit : true
	},
	columnLines : true
});

/**
 * 功能按钮
 * 
 * */ 
var btnform = new Ext.form.FormPanel({
	region : 'north',
	frame : true,
	contentEl : 'btnTop',
	height : 45,
	margin : '5 5 0 5'
});

/**
 * 
 * 整体布局
 * */ 
Ext.onReady(function() {
	var viewport = new Ext.Viewport({
		layout : 'border',
		items : [btnform, gridPanel]
	});
	cursorSwitch_();
	queryArticleIndexInfo();
});

/**
 * 模糊查询的方法
 * 
 * */ 
function queryArticleIndexInfo() {
	var myMask = new Ext.LoadMask(Ext.getCmp("gridPanel").getEl(), {
		msg : "正在加载数据，请稍候......"
	});
	myMask.show();
	Ext.getCmp("gridPanel").getStore().removeAll();
	Ext.getCmp("gridPanel").getStore().baseParams = {
		"attribute(content)" : $("#title").val()
	};
	Ext.getCmp("gridPanel").getStore().load({
		callback : function(o, reps, success) {
			myMask.hide();
		}
	});
}

/**
 * 
 * 版块名称链接显示该版块下文章
 * */ 
function SectionOfArticle() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var sectionId = selModel.getSelected().get("sectionId"); // 版块的id
	var userId = selModel.getSelected().get("sectioner"); // 版主
	var visitCredits = selModel.getSelected().get("credits"); // 版块访问积分
	var credits = $("#creditsInfo").val();// 用户积分
	var id = $("#userId").val();// 登录用户id
	// 版块访问积分大于用户积分无法查看
	if (visitCredits != 0) {
		if (id != 1) {
			if (id != userId) {
				if (visitCredits > credits) {
					showMessage('对不起，您的积分太低没有权限查看', 'warn');
					return;
				}
			}
		}
	}
	var myMask = new Ext.LoadMask(Ext.getCmp("gridPanel").getEl(), {
		msg : "正在加载数据，请稍候......"
	});
	myMask.show();
	Ext.getCmp("gridPanel").getStore().removeAll();
	Ext.getCmp("gridPanel").getStore().baseParams = {
		"attribute(sectionId)" : sectionId
	};
	Ext.getCmp("gridPanel").getStore().load({
		callback : function(o, reps, success) {
			myMask.hide();
		}
	});
}

/**
 * "发文章"按钮事件
 * */
function pubArticle() {
	location = context + "/publishArt.ao?method=toPublish";// 进入新界面
}

/**
 * "保存"按钮事件
 * */
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
			}
		}
	};
	$("#createArticleForm").ajaxSubmit(options);
}

/**
 * 
 * "取消"按钮方法
 * */ 
function canclePub() {
	clearFormData();
}

/**
 * 清除form内容
 * */ 
function clearFormData(){
	$("#titleName").val("");
	$("#articleContent").val("");
	$("#articleLabel").val("");
	$("#article").val("");
}

/**
 * 返回按钮方法
 * */ 
function goBack() {
	location = padUrl("/goToArticle.ao?method=toArticleMana");
}

/**
 * 显示文章详细信息
 * */ 
function showDetail() {

	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var userId = selModel.getSelected().get("sectioner"); // 版主
	var author = selModel.getSelected().get("author"); // 文章作者
	var visitCredits = selModel.getSelected().get("credits"); // 版块访问积分
	var credits = $("#creditsInfo").val();// 用户积分
	var name = $("#username").val();// 登录用户名

	var id = $("#userId").val();// 登录用户id
	// 版块访问积分大于用户积分无法查看
	if (name != author) {
		if (visitCredits != 0) {
			if (id != 1) {
				if (id != userId) {
					if (visitCredits > credits) {
						showMessage('对不起，您的积分太低没有权限查看', 'warn');
						return;
					}
				}
			}
		}
	}
	var Id = selModel.getSelected().get("id"); // 文章的id
	location = padUrl("/article/articleDetailInfo.ao?method=showArticleDetail&articleId=" + Id);

}

/**
 * 获取作者的详细信息
 * 
 * */ 
function showAuthorDetail() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();

	var Id = selModel.getSelected().get("userId"); // 作者的id
	top.location = padUrl("/user/UserCenter.ao?method=UserCenter&userId=" + Id);

}

/**
 * 
 * "精华"按钮事件
 * */ 
function changeEss() {

	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var userId = selModel.getSelected().get("sectioner"); // 版主
	var id = $("#userId").val();// 登录用户id
	if (!selModel.hasSelection()) {
		showMessage('请先选择文章', 'warn');
	} else {
		var ids = "";
		var records = selModel.getSelections();
		for (var i = 0; i < records.length; i++) {

			if (id != userId && id != 1) {
				showMessage('对不起，你无权对此文章进行操作', 'warn');
				return;
			} else {
				ids += "," + records[i].get("id");
			}
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

/**
 *  "置顶按钮事件"
 * 
 * */
function setTop() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var userId = selModel.getSelected().get("sectioner"); // 版主
	var id = $("#userId").val();// 登录用户id
	if (!selModel.hasSelection()) {
		showMessage('请先选择文章', 'warn');
	} else if (selModel.getSelections().length > 1) {
		showMessage('只能对单个文章进行操作', 'warn');
	} else if (id != userId && id != 1) {
		showMessage('对不起，你无权对此文章进行操作', 'warn');
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

/**
 *  "删除"按钮方法
 * 
 * */
function deleteArticle() {
	var selModel = Ext.getCmp("gridPanel").getSelectionModel();
	var userId = selModel.getSelected().get("sectioner"); // 版主
	var id = $("#userId").val();// 登录用户id
	if (!selModel.hasSelection()) {
		showMessage('请先选择文章', 'warn');
	} else {
		var ids = "";
		var records = selModel.getSelections();
		for (var i = 0; i < records.length; i++) {
			if (id != userId && id != 1) {
				showMessage('对不起，你无权对此文章进行操作', 'warn');
				return;
			} else {
				ids += "," + records[i].get("id");
			}
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

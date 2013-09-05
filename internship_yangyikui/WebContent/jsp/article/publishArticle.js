/**
 * 
 *  "保存"按钮事件
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
 *  "取消"按钮方法
 * */
function canclePub() {
	clearFormData();
}

/**
 * 清除form内容
 * */ 
function clearFormData() {
	$("#titleName").val("");
	$("#articleContent").val("");
	$("#articleLabel").val("");
	$("#article").val("");
}

/**
 * 
 * 返回按钮方法
 * */ 
function goBack() {
	location = padUrl("/goToArticle.ao?method=toArticleMana");

}

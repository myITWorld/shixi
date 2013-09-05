document.write("<script language='javascript' src='/jsp/article/indexCenter.js'></script>");


/**
 * 
 * 左边树形	
 * */
Ext.onReady(function(){
	 Ext.QuickTips.init();// 浮动信息提示
	 Ext.BLANK_IMAGE_URL = context+"/js/ext/resources/images/default/s.gif"; 
/**
 *  定义根节点
 */ 
var treeRoot = new Ext.tree.AsyncTreeNode({
	id : '0',
	text : '版块文章',
	draggable : false,              //根节点不允许拖动
	leaf : false,
	iconCls : 'icon_distribute',
	expanded : true                 //进入时是否展开
});


/**
 * 定义文章信息树
 */
var articleTreePanel = new Ext.tree.TreePanel({
	title:'树形搜索',
	border : false, 
   width:200,
	minSize:80,
	height:500,   
	maxSize:200, 
	renderTo:'left', 
	frame:true,
	titleCollapse : true,
	hideCollapseTool : false, 
	animCollapse:false, 
   animate: true, //动画效果
	collapseFirst:false,
	onlyLeafCheckable : false,
	containerScroll : true,// 是否支持滚动条
   hideCollapseTool: true, 
 	split:true, 
	doubleClickExpand : true,
	autoScroll: true,//自动滚动条
	collapsible:true, 
	root : treeRoot, 
	//baseCls:'x-plain',
	padding : '2 0 12 25',
	rootVisible : false,// 是否隐藏根节点
	loader : new Ext.tree.TreeLoader({
		dataUrl : padUrl('/article/articleAndSection.ao?method=processQuerySectionInfoJson'),
		method : 'post'
	})
});
 
/**
 * 文章树叶子节点单击事件
 */
articleTreePanel.on('click', function(node) {
	// 存放版块的id
	var treeNode = node.id;  
	// 判断是否是叶子节点 
	if (node.isLeaf()) {
		// 右侧部分跳转到文章详细页面
	
		var urlDetail = padUrl("/article/articleDetailInfo.ao?method=showArticleDetail&articleId=" + treeNode);
	 //确定显示的位置
		parent.frames[2].location.href = urlDetail;
	} else { 
		//获得该版块下的文章
		var urlArticleInfoList = padUrl('/article/showArticle.ao?method=preArticleList&sectionId='+treeNode);
		//确定显示位置
		parent.frames[2].location.replace(urlArticleInfoList);
	}
});


 
/**
 * 版块节点右键菜单
 * */

var sec = new Ext.menu.Menu({
	 items :[{  
                text: '修改',  
                handler : function(){  
                	var id = node_id.attributes.id; 
                   var publishArticle = padUrl('/section/updateSectionInfo.ao?method=updateSection&sectionId='+id);
							//确定显示位置
							parent.frames[2].location.replace(publishArticle); 
                    sec.hide();//隐藏  
                 
                }  
            }   ]  

});
/**
 * 文章叶子节点右键菜单
 * */
var cc = new Ext.menu.Menu({  
            items :[{  
                text: '发文章',  
                handler : function(){  
                   var articleId = node_id.attributes.id;  
                   var publishArticle = padUrl('/publishArt.ao?method=toPublish');
							//确定显示位置
							parent.frames[2].location.replace(publishArticle); 
                    cc.hide();//隐藏  
                 
                }  
            },'-',{  
                text: '删除',  
                handler : function(){  
                    //获得文章id
                   var articleId = node_id.attributes.id;  
                   var publishArticle =padUrl("/article/setTop.ao?method=deleteArticle" + "&id="
						+ articleId); 
							parent.frames[1].location.replace(publishArticle); 
							 cc.hide();//隐藏  
                }  
            },'-',{  
                text: '置顶',  
                handler : function(){  
                	//获得文章id
                   var articleId = node_id.attributes.id;  
                   var publishArticle =padUrl("/article/setTop.ao?method=setTop" + "&id="
						+ articleId); 
							parent.frames[1].location.replace(publishArticle); 
							 cc.hide();//隐藏  
                }  
            },'-',{
                text: '精华',  
                handler : function(){  
                	//获得文章id
                  var articleId = node_id.attributes.id;  
                   var publishArticle =padUrl("/article/setTop.ao?method=setEss" + "&id="
						+ articleId); 
							parent.frames[1].location.replace(publishArticle); 
							 cc.hide();//隐藏  
                } } ]  
        });   
        
    articleTreePanel.on('contextmenu',function(node,e){  
            e.preventDefault();//阻止浏览器默认弹出功能菜单  
            var role = $("#role").val();
             
            //管理员右击显示
            if(role==2){
            if(node.isLeaf()){
            node.select();//选中当前节点  
            var array = e.getXY();//获取事件的页面坐标  
            cc.showAt(array);//在指定的位置显示该菜单  
            node_id = node; 
            }else{
              node.select();//选中当前节点  
            //var array = new Array(500,500);//可以自定义坐标  
            var array = e.getXY();//获取事件的页面坐标  
            sec.showAt(array);//在指定的位置显示该菜单  
            node_id = node; 
            }};
        }) ;
        });
/**
 * @class Ext.ux.tree.TreeGridNodeUI
 * @extends Ext.tree.TreeNodeUI
 */

	
	var autoChecked = '';//用来控制父节点选择了展开的子节点自动选中
 	
	//定义js中 string类型变量replaceAll 的方法
	String.prototype.replaceAll  = function(s1,s2){ 
		return this.replace(new RegExp(s1,"gm"),s2);    
	}
	
	 	/**
	 	*
	 	* 点树节点前面的checkbox时 
	 	*/
	function checkBoxClick(nodePath,nodeId){
		nodePath=nodePath.replaceAll(" ","%20");
		nodeId = nodeId.replaceAll(" ","%20");
		var nodeChecked = document.getElementById(nodePath).checked;
		var tree = Ext.getCmp("bankGrid");
		var node = tree.getNodeById(nodeId);
		if(nodeChecked){
			autoChecked = 'CHECKED';
			node.cascade(function(child){
				var childId = child.getPath().replaceAll(" ","%20");
				document.getElementById(childId).checked = nodeChecked;
			});
		}else{
			autoChecked = '';
			node.cascade(function(child){
				var childId = child.getPath().replaceAll(" ","%20");
				document.getElementById(childId).checked = nodeChecked;
			});
		}
	}
	
	
	Ext.ux.tree.checkBoxTreeGridNodeUI = Ext.extend(Ext.tree.TreeNodeUI, {
    ischeckBoxTreeGridNodeUI: true,
    renderElements : function(n, a, targetNode, bulkRender){
    	autoChecked = '';
        var t = n.getOwnerTree(),
            cols = t.columns,
            c = cols[0],
            i, buf, len;
        this.indentMarkup = n.parentNode ? n.parentNode.ui.getChildIndent() : '';
        //下面三行是为了给checkbox生成一个ID，ID=node.id+node.depth  
        var number = n.id;   
        var dep = n.getDepth();
        var checkboxid = n.getPath().toString();
        checkboxid = checkboxid.replaceAll(" ","%20");
        //展开时判断父节点是否选中，展开的选中状态和父节点的状态一致
        if(n.parentNode!=null){
        	var id = n.parentNode.getPath().replaceAll(" ","%20");
        	var checkbox = document.getElementById(id);
	        if(checkbox!=null){
	        	if(checkbox.checked){
					autoChecked = 'CHECKED';
				}else{
					autoChecked = '';
				}
			}
        }
        var oldColValue= (c.tpl ? c.tpl.apply(a) : a[c.dataIndex] || c.text);
        var newColValue=oldColValue.replaceAll("\"","&quot");
        if(newColValue.length>=60-(dep-1)*3){
        	if(60-dep*3<=0){
        		newColValue="...";
        	}else{
        		newColValue=newColValue.substring(0,(60-dep*3))+"...";
        	}
        }
            
		 
        buf = [
             '<tbody class="x-tree-node">',
                '<tr style="overflow:hidden;height:20;" ext:tree-node-id="', n.id ,'" class="x-tree-node-el x-tree-node-leaf ', a.cls, '">',
                    '<td style="width:450" class="x-treegrid-col" >',
                        '<span class="x-tree-node-indent"> <input '+autoChecked+' type="checkbox" onclick="checkBoxClick(\''+n.getPath()+'\',\''+number+'\')" id='+checkboxid+'>', this.indentMarkup, "</span>",
                        '<img src="', this.emptyIcon, '" class="x-tree-ec-icon x-tree-elbow">',
                        '<img src="', a.icon || this.emptyIcon, '" class="x-tree-node-icon', (a.icon ? " x-tree-node-inline-icon" : ""), (a.iconCls ? " "+a.iconCls : ""), '" unselectable="on">',
                        '<a hidefocus="on" class="x-tree-node-anchor" href="', a.href ? a.href : '#', '" tabIndex="1" ',
                            a.hrefTarget ? ' target="'+a.hrefTarget+'"' : '', '>',
                        '<span style="cursor:hand;overflow:hidden;width:'+this.width+';   height:20;" ext:qtitle="" ext:qtip="'+oldColValue+'" class="complete"  unselectable="on" >',newColValue, '</span></a>',
                    '</td>'
        ];
        for(i = 1, len = cols.length; i < len; i++){
            c = cols[i];
            var oldColValue= (c.tpl ? c.tpl.apply(a) : a[c.dataIndex]);
            var newColValue=oldColValue.replaceAll("\"","&quot");
            if(newColValue.length>=40){
        		newColValue=newColValue.substring(0,40)+"...";
       		}
            buf.push(
                    '<td  style="width:300" class="x-treegrid-col ', (c.cls ? c.cls : ''), '">',
						'<div style="overflow:hidden; height:20;" ext:qtitle="" ext:qtip="'+oldColValue+'"  unselectable="on" class="x-treegrid-text"', (c.align ? ' style="word-break:keep-all;text-align: ' + c.align + ';"' : ''), '>',
                          newColValue,
                        '</div>',
                    '</td>'
            );
        }      

        buf.push(
            '</tr><tr class="x-tree-node-ct"><td colspan="', cols.length, '">',
            '<table class="x-treegrid-node-ct-table" cellpadding="0" cellspacing="0" style="table-layout: fixed; display: none; width: ', t.innerCt.getWidth() ,'px;"><colgroup>'
        );
        
//下面的代码 是批处理很耗性能 去掉了        
//        for(i = 0, len = cols.length; i<len; i++) {
//            buf.push('<col style="width: ', (cols[i].hidden ? 0 : cols[i].width) ,'px;" />');
//        }
        
       buf.push('</colgroup></table></td></tr></tbody>');

        if(bulkRender !== true && n.nextSibling && n.nextSibling.ui.getEl()){
            this.wrap = Ext.DomHelper.insertHtml("beforeBegin", n.nextSibling.ui.getEl(), buf.join(''));
        }else{
            this.wrap = Ext.DomHelper.insertHtml("beforeEnd", targetNode, buf.join(''));
        }

        this.elNode = this.wrap.childNodes[0];
        this.ctNode = this.wrap.childNodes[1].firstChild.firstChild;
        var cs = this.elNode.firstChild.childNodes;
        this.indentNode = cs[0];
        this.ecNode = cs[1];
        this.iconNode = cs[2];
        this.anchor = cs[3];
        this.textNode = cs[3].firstChild;
        this.checkbox = document.getElementById("box");
    },

    // private
    animExpand : function(cb){
        this.ctNode.style.display = "";
        Ext.ux.tree.TreeGridNodeUI.superclass.animExpand.call(this, cb);
    }
});

Ext.ux.tree.TreeGridRootNodeUI = Ext.extend(Ext.tree.TreeNodeUI, {
    ischeckBoxTreeGridNodeUI: true,

    // private
    render : function(){
        if(!this.rendered){
            this.wrap = this.ctNode = this.node.ownerTree.innerCt.dom;
            this.node.expanded = true;
        }

        if(Ext.isWebKit) {
            // weird table-layout: fixed issue in webkit
            var ct = this.ctNode;
            ct.style.tableLayout = null;
            (function() {
                ct.style.tableLayout = 'fixed';
            }).defer(1);
        }
    },

    destroy : function(){
        if(this.elNode){
            Ext.dd.Registry.unregister(this.elNode.id);
        }
        delete this.node;
    },    

    collapse : Ext.emptyFn,
    expand : Ext.emptyFn
});
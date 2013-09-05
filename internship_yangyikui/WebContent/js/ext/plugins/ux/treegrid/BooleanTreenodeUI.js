/**
 * Overrides event onCheckChange to handle checkbox status changing in column
 * tree grid 
 */
Ext.ns('Ext.ux.tree');
Ext.ux.tree.booleanTreenodeUI = Ext.extend(Ext.ux.tree.TreeGridNodeUI, {
	/**
	 * get check box status from html input checkbox element and get
	 * property "dataIndex" from html element to update column value
	 * 
	 * @param {}
	 *            e
	 */
	onCheckChange : function(e) {
		var dataIndex = e.target.getAttribute('dataIndex');
		if (dataIndex) {
			var checked = e.target.checked;
			this.node.attributes[dataIndex] = checked;
			this.fireEvent('checkchange', this.node, checked);
		} else {
			var err = new Ext.Error('[dataIndex] property not found');
			throw err;
		}
	},
	/**
	 * override toggleCheck : do nothing because we can't know wich
	 * column is to be updated
	 * 
	 * @param {}
	 *            value
	 */
	toggleCheck : function(value) {
		return;
	}
});
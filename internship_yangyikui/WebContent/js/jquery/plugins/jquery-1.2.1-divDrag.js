jQuery.extend({zIndex : 100});
jQuery.fn.extend({
berheleyDivDrag : function(callback,func)
{
   this.each(function(){
	this.posRange = {minX:0,minY:0,maxX:(document.compatMode == "CSS1Compat"?document.documentElement.clientWidth:document.body.clientWidth),maxY:(document.compatMode == "CSS1Compat"?document.documentElement.clientHeight:document.body.clientHeight)};
	this.onmousedown = function(e)
	{
	   jQuery.iFlag = false;
	   this.style.zIndex = jQuery.zIndex++;
	   this.style.position = "absolute";
	   this.drag(e,callback,func);
	}
	this.drag = function(e,callback,func)
	{
		var element = this,ev = e || window.event;
		ev.rScreenX = ev.screenX;
		ev.rScreenY = ev.screenY;
		var pos = jQuery(this).offset();
		element.dragConfig = {defaultX : parseInt(pos.left,10),defaultY : parseInt(pos.top,10),defaultW: parseInt(jQuery(this).width(),10),defaultH : parseInt(jQuery(this).height(),10)};
		document.onmouseup = function()
		{
			element.drop();
			callback && callback();
		};
		document.onmousemove = function(e)
		{
			var ev2 = e || window.event;
			if(jQuery.browser.msie&& ev2.button!=1)
			{
				return (element.drop(),callback && callback());
			}
			var mx = element.dragConfig.defaultX + (ev2.screenX - ev.rScreenX),
			my = element.dragConfig.defaultY + (ev2.screenY - ev.rScreenY),
			pr = element.posRange,mw = element.dragConfig.defaultW,mh = element.dragConfig.defaultH;
			with(element.style)
			{
				left = (mx<pr.minX?pr.minX:((mx+mw)>pr.maxX?(pr.maxX-mw):mx)) + "px";
				top = (my<pr.minY?pr.minY:((my+mh)>pr.maxY?(pr.maxY-mh):my)) + "px";
			}
			func && func();
			return false;
		};
		document.onselectstart = function(){return false;};
		
	}
	this.drop = function()
	{
		document.onmousemove = document.onselectstart = document.onmouseup = null;
	}
   });
}
});
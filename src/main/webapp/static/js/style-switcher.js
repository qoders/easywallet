(function(){
	$(function(){
		var btEnable = $.cookie('enableBootstrap');
		var btSwitchPanel = $('<div/>').css({"position":"fixed","right":0,"bottom":0});
		var btnSwitcher = $('<button/>').text('Theme:'+(btEnable=="true"?'on':"off")).click(function(){
			var btEnable = $.cookie('enableBootstrap');
			if (btEnable && btEnable=="true"){
				$.removeCookie('enableBootstrap');
			}else{
				$.cookie('enableBootstrap','true', { path: '/', expires: 7 });
			}
			window.location.href=window.location.href;
		});
		btSwitchPanel.append(btnSwitcher).appendTo('body');
	});
})();
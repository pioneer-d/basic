/**
* Layer Popup Handler 
*
* @Author		: kkang(sinbiweb)
* @Update		: 2018-07-26
* @Description		: Layer Popup Handler javascript & jquery
*/

/**
* board comment password form layer 
*/
var passLayer = {
	arHtm : [], 
	open : function(pobj, code, idx) {
		if($("#CmtPwdLayer").length > 0) $("#CmtPwdLayer").remove();
		this.arHtm = [];
		this.arHtm.push("<form name=\"cmtform\" action=\"/board/password.act.php\" method=\"post\" onsubmit=\"return FHandler.FormChk(this);\" target=\"ifrm\">");
		this.arHtm.push("<input type=\"hidden\" name=\"mode\" value=\"comment\" />");
		this.arHtm.push("<input type=\"hidden\" name=\"act\" value=\"del_comment\" />");
		this.arHtm.push("<input type=\"hidden\" name=\"code\" value=\""+code+"\" />");
		this.arHtm.push("<input type=\"hidden\" name=\"cidx\" value=\""+idx+"\" />");
		this.arHtm.push("<span class=\"m_block\">");
		this.arHtm.push("<input type=\"password\" id=\"pass\" class=\"cm_input\" name=\"cpwd\" title=\"비밀번호를 입력하세요.\" exp=\"비밀번호를\" />");
		this.arHtm.push("<input type=\"image\" src=\"/images/board/btn_board_ok.png\" title=\"확인\" />");
		this.arHtm.push("<img src=\"/images/board/btn_board_cancel.png\" title=\"취소\" data-action=\"cmt_layer_close\" />");
		this.arHtm.push("</span></form>");

		html = this.arHtm.join("\n");
		obj = document.createElement("span");
		obj.id = "CmtPwdLayer";
		obj.style.width = "260px";
		obj.style.padding = "0px";
		obj.style.backgroundColor = "#ffffff";
		obj.style.position = "absolute";
		obj.style.zIndex = "9999999999";

		if(pobj.innerHTML.toLowerCase().indexOf('img') != -1)
		{
			obj.style.marginTop = "0px";
			obj.style.marginLeft = "150px";
		}

		obj.innerHTML = html;
		pobj.parentNode.insertBefore(obj, pobj.previousSibling);
		pobj.style.visibility = "hidden";
	}
};

var LayerPopup = {
	overflow : $("body").css("overflow"), 
	show : function()
	{
	},
	iframe : function(w, h, url)
	{
		var oHeight = (h) ? h : 220;
		var wHeight = $(window).height();
		var oWidth	= (w) ? w : 400;

		// dim layer //
		$("body").append("<div class=\"dim_layer\"></div>");
		// container layer //
		$("<div class=\"container_layer\"></div>").appendTo("body").css({
			position : "fixed", 
			zIndex : "10001", 
			top : (wHeight-oHeight)/2, 
			marginLeft : (-(oWidth/2)), 
			width : oWidth, 
			height : oHeight, 
			visibility : "visible"
		});
		// iframe //
		$("<iframe id=\"ifm\"></iframe>").appendTo(".container_layer").css({
			width : oWidth, 
			height : oHeight
		}).attr("src", url);
	},
	close : function() 
	{
		$(".dim_layer, .container_layer").empty();
		$(".dim_layer, .container_layer").remove();
	}
};

var LayerMessage = {
	arHtml : [], 
	target : 
	{
		alert		: $(".msgbox.alert_msgbox"), 
		confirm		: $(".msgbox.confirm_popup"),
		progress	: $(".msgbox.progress_popup")
		
	}, 
	overflow : $("body").css("overflow"), 
	show : function(target, mode, msg)
	{
		if(msg) target.find(".message").html(msg);

		var oHeight	= target.height();
		var wHeight	= $(window).height();
		var oWidth	= target.width();

		if($(".dim_layer").length < 1) $("body").append("<div class=\"dim_layer\"></div>");
		//$("html,body").css("overflow", "hidden");
		target.css({
			top : (wHeight - oHeight)/2, 
			marginLeft : (-(oWidth/2)), 
			visibility : "visible"
		});

		target.draggable();
		$(".modal_alert_close", target).click(function(e){
			e.preventDefault();
			$("html,body").css("overflow", this.overflow);
			$(".dim_layer").remove();
			$(this).parents(".msgbox").css({top:"-9999px", visibility:"hidden"});
		});
	},
	alert : function(msg, callback)
	{
		if(this.target.alert.length > 0) this.target.alert.remove();

		this.arHtml.push("<div class=\"msgbox s400 alert_msgbox\" draggable=\"true\">");
		this.arHtml.push("	<div class=\"msg_header\"><img src=\"/images/layer/ico_pop_monitor.png\" />알림</div>");
		this.arHtml.push("	<div class=\"msg_container\">");
		this.arHtml.push("		<div class=\"txt_dialog message\"></div>");
		this.arHtml.push("			<p class=\"foot_btn\"><a href=\"#\" class=\"btn_n bg_red modal_alert_confirm\">확인</a></p>");
		this.arHtml.push("	</div>");
		this.arHtml.push("	<a href=\"#\" class=\"msgbox_close modal_alert_close\">닫기</a>");
		this.arHtml.push("</div>");

		Html = this.arHtml.join("\n");
		$("body").append(Html);
		this.target.alert = $(".msgbox.alert_msgbox");
		LayerMessage.show($(".msgbox.alert_msgbox"), "alert", msg);
		if(typeof callback != "undefined" && callback)
		{
			$(".modal_alert_confirm", LayerMessage.target.alert).click(function(e){
				e.preventDefault();
				$("html,body").css("overflow", LayerMessage.overflow);
				$(".dim_layer").remove();
				$(this).parents(".msgbox").css({top:"-9999px", visibility:"hidden"});

				if(typeof callback == "function")
					callback();
				else
				{
					if(callback)
					{
						if(callback.indexOf("(") == -1) eval(callback + "()");
						else eval(callback);
					}
					else
						if(typeof(confirmAfter) == "function") confirmAfter();
				}
				$(this).unbind("click");
			});
		}
		else
		{
			$(".modal_alert_confirm", LayerMessage.target.alert).click(function(e) {
				e.preventDefault();
				$("html,body").css("overflow", LayerMessage.overflow);
				$(".dim_layer:last-child").remove();
				$(this).parents(".msgbox").css({top:"-9999px", visibility:"hidden"});
			});
		}
	}
};

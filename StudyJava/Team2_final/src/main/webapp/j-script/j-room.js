/**
* Shopping Mall Javascript Library
*
* @Author		:	kkang(sinbiweb)
* @Update		:	2017-04-05
* @Description	:	Shopping Mall Javascript Library
*/

// Board Javascript //
var Board = {
	button : 
	{
		write : function(referer) {
			var $form = $("<form></form>");
			$form.attr({"name":"wfm", "method":"post", "action":"/member/login.php"}).appendTo("body");
			$form.append("<input type=\"hidden\" name=\""+referer+"\" />");
			$form.submit();
		}
	}, 
	comment : 
	{
		init : function() {
			$("img[data-action='cmt_layer_close']").live("click", function() { 
				$(this).parentsUntil("#CmtPwdLayer").empty().parent().remove();
				$("a.cm_del").css("visibility", "visible");
			});
		},
		save : function() {
			var f = document.cfm;
			if(FHandler.FormChk(f))
			{
				f.submit();
			}
		},
		del : function(idx) {
			var f = document.commentform;
			if(confirm("해당 댓글을 정말 삭제하시겠습니까?"))
			{
				f.act.value = "del_comment";
				f.cidx.value = idx;
				f.submit();
			}
		}
	}
};

// room javascript //
var room = {
	init : function() {
		// 예약일 변경시 //
		$(":text[name='rdate'], select[name='theme']").on("change", function() {
			$("form[name='sfm']").submit();
		});
		// 테마상세 --- 테마클릭시 //
		$("a[data-code]").on("click", function() {
			var code = $(this).attr("data-code");

			if(code)
			{
				$("form[name='sfm'] :hidden[name='rmcd']").val(code);
				$("form[name='sfm']").submit();
			}
		});
	},
	booking : function(rtime, theme) {
		if(rtime && theme)
		{
			$(":hidden[name='rtime']").val(rtime);
			$(":hidden[name='theme']").val(theme);

			$("form[name='fm']").submit();
		}
	}
};

// reserve javascript //
var reserve = {
	init : function() {
		$("select[name='players']").on("change", function() {
			reserve.calc();
		});
		$(":radio[name='payway']").on("click", function() {
			reserve.calc();
		});
		$("button[data-action='save']").on("click", function() {
			reserve.save();
		});

		this.calc();
	}, 
	calc : function() {
		var players = $("select[name='players'] option:selected").val();
		var payway = $(":radio[name='payway']:checked").val();

		
	},
	save : function() {
		var f = document.fm;

		if(FHandler.FormChk(f))
		{
			if($(":checkbox[name='privacy']").is(":checked") == false)
			{
				alert("개인정보취급방침에 동의해 주세요.");
				$(":checkbox[name='privacy']").focus();
			}
			else if($(":radio[name='payway']:checked").length < 1)
			{
				alert("결제방식을 선택해 주세요.");
				$(":radio[name='payway']").eq(0).focus();
			}
			else
			{
				f.act.value = "save";
				f.submit();
			}
		}
	}
};

var sCommon = {
	change_mail : function() {
		$("select[name='email3']").change(function() { 
			if($(this).val())
			{
				$(":text[name='email2']").val($("select[name='email3']").val());
				$(":text[name='email2']").attr("readonly", true);
			}
			else
			{
				$(":text[name='email2']").val("");
				$(":text[name='email2']").attr("readonly", false);
			}
		});
		$("select[name='mail3']").change(function() { 
			if($(this).val())
			{
				$(":text[name='mail2']").val($("select[name='mail3']").val());
				$(":text[name='mail2']").attr("readonly", true);
			}
			else
			{
				$(":text[name='mail2']").val("");
				$(":text[name='mail2']").attr("readonly", false);
			}
		});
	}, 
	progress : function(type) {
		if(type == 'show')
			$("div#dimmer").css("display", "block");
		else
			$("div#dimmer").css("display", "none");
	}
};

$(function() {
	// 메인레이어 팝업 //
	$("img.popup_close").css("cursor", "pointer").on("click", function() {
		$("#popup_"+$(this).attr("rel")).fadeOut();
	});
	$("label.recruit").on("click", function() {
		ck_name = "ck_popup_"+$(this).attr("rel");
		Common._setCookie(ck_name, "Y", 1);
		$("#popup_"+$(this).attr("rel")).fadeOut();
	});
});

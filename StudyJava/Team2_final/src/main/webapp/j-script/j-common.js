/**
* Common JavaScript Library
*
* @Author		: choe byungkook(sinbiweb)
* @Update		: 2018-05-31
* @Email		: 77kkang@naver.com
* @Description	: Common Javascript Library 
*/
(function(){ 
	String.prototype.trim = function(){	return this.replace(/(^\s*)|(\s*$)/g, "");}		//Trim
	String.prototype.stripspace = function() { return this.replace(/ /g, ""); }			//공백제거
	String.prototype.getExt = function() {												//파일 확장자 구하기
		var ext = this.substring(this.lastIndexOf(".") + 1, this.length);
		return ext;
	};
})(window);

var CHandler = {
	// 회원아이디 유효성 검사 //
	chkUserID : function(obj)
	{
		if($.type(obj) === "string")
			var id = obj;
		else if($.type(obj) === "object")
			var id = obj.val();

		var patten = /^[a-z]{1}[a-zA-Z0-9_-]{3,16}$/;	//영문소문자로 시작하는 4~12자리의 영문(대,소), 숫자, _ 만 허용함. 
		if(!patten.test(id))
			return false;
		else
			return true;
	}, 
	// 이메일 유효성 검사 //
	chkEmail : function(email)
	{
		if(email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
			return true;
		else
			return false;
	},
	// password check //
	chkPassword : function(pw)
	{
		if(!/^[a-zA-Z0-9]{6,16}$/.test(pw) || pw.indexOf(' ') > -1) 
		{
			//alert('비밀번호는 숫자와 영문자 조합으로 10~20자리를 사용해야 합니다.');
			return "111";
		}

		var chk_num = pw.search(/[0-9]/g);
		var chk_eng = pw.search(/[a-z]/ig);

		if(chk_num < 0 || chk_eng < 0)
		{
			//alert('비밀번호는 숫자와 영문자를 혼용하여야 합니다.');
			return "222";
		}

		if(/(\w)\1\1\1/.test(pw))
		{
			//alert('비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.');
			return "333";
		}
		return "000";
	},
	// Alphabet check //
	chkAlphabet : function(str)
	{
		if(str.length < 1) return false;
		str = str.toUpperCase();
		for(var i=0; i < str.length; i++)
		{
			if(!('A' <= str.charAt(i) && str.charAt(i) <= 'Z'))
				return false;
		}

		return true;
	},
	// 한글 check //
	chkHangul : function(str)
	{
		var patten = /[가-힣]/;
		if(!patten.test(str))
			return false;
		else
			return true;
	}, 
	// nickname check //
	chkNickName : function(obj)
	{
		if($.type(obj) === "string")
			var nic = obj;
		else if($.type(obj) === "object")
			var nic = obj.val();

		var patten = /^[A-Za-z0-9_가-힣]{3,20}$/;
		if(!patten.test(nick))
			return false;
		else
			return true;
	},
	// ip check //
	chkIp : function($obj)
	{
		var ip = $obj.val();
		var filter = /^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/;
		if(filter.test(ip) == true)
			return true;
		else
			return false;
	},
	// file check //
	chkFileType : function(obj)
	{
		var ext = obj.value.getExt().toLowerCase();
		var filetype = obj.getAttribute("filetype");

		if(filetype == "image")
		{
			if(ext != "gif" && ext != "jpg" && ext != "jpeg" && ext != "png")
			{
				alert("이미지파일(gif, jpg, png)만 업로드 가능합니다.");
				obj.focus();
				return false;
			}
		}
		else if(filetype)
		{
			if(ext != filetype)
			{
				alert(filetype+" 파일만 업로드 가능합니다.");
				obj.focus();
				return false;
			}
		}

		return true;
	}
};

var NumberHandler = {
	chkNumber : function(number)
	{
		if(/(^\d+$)|(^\d+\.\d+$)/.test(number))
			return true;
		else
			return false;
	}, 
	removePreZero : function(str)
	{
		var i, result;
		if(str == "0") return str;
		for(i=0; i < str.length; i++)
			if(str.substr(i,1) != "0") break;
		
		result = str.substr(i, str.length-i);
		return result;
	}, 
	stripChar : function(val, isDec)
	{
		var i;
		var minus = "-";
		var number = "1234567890"+((isDec) ? "." : "");
		var result = "";
		for(i=0; i < val.length; i++)
		{
			chkno = val.charAt(i);
			if(i == 0 && chkno == minus)
				result += minus;
			else
			{
				for(j=0; j < number.length; j++)
				{
					if(chkno == number.charAt(j))
					{
						result += number.charAt(j);
						break;
					}
				}
			}
		}
		return result;
	},
	stripComma : function(str)
	{
		var reg = /(,)*/g;
		number = String(str).replace(reg, "");
		return number;
	}, 
	NumberFormat : function(number)
	{
		var arr = new Array();
		number = String(number);
		for(var i=1; i <= number.length; i++)
		{
			if(i%3)
				arr[number.length-i] = number.charAt(number.length-i);
			else
				arr[number.length-i] = ","+number.charAt(number.length-i);
		}
		return arr.join('').replace(/^,/,'');
	}, 
	// 소수점 반올림(number:소수, cnt:자릿수) //
	decimalRound : function(number, cnt)
	{
		if(!cnt)
			return Math.round(number);
		else if(cnt > 0)
		{
			for(var i=0; i < cnt; i++)
				number = number * 10;

			number = Math.round(number);
			var avg = 1;
			for(var i=0; i < cnt; i++)
				avg = avg * 10;

			number = number / avg;
			return number;
		}
		else
		{
			for(var i=0; i < cnt*(-1); i++)
				number = number / 10;

			number = Math.round(number);
			for(var i=0; i < cnt*(-1); i++)
				number = number * 10;

			return number;
		}
	}, 
	// 소수점 올림 (number:소수, cnt:자릿수) //
	decimalCeil : function(number, cnt)
	{
		if(!cnt)
			return Math.ceil(number);
		else if(cnt > 0)
		{
			for(var i=0; i < cnt; i++)
				number = number * 10;

			number = Math.ceil(number);
			avg = 1;
			for(var i=0; i < cnt; i++)
				avg = avg * 10;

			number = number / avg;
			return number;
		}
		else
		{
			for(var i=0; i < cnt*(-1); i++)
				number = number / 10;

			number = Math.ceil(number);
			for(var i=0; i < cnt*(-1); i++)
				number = number * 10;

			return number;
		}
	}, 
	decimalFloor : function(number)
	{
		var val = String(number);
		var exval = val.split(".");

		return exval[0];
	},
	// 소수점 있는 수 number_format
	decimalNumerFormat : function(number)
	{
		var val = String(number);
		var tmp = val.split(".");
		if(tmp[0].length > 3)
		{
			var arNum = new Array();
			tmp[0] = String(tmp[0]);
			for(var i=1; i <= tmp[0].length; i++)
			{
				if(i%3)
					arNum[tmpp[0].length-i] = tmp[0].charAt(tmp[0].length-i);
				else
					arNum[tmp[0].length-i] = "," + tmp[0].charAt(tmp[0].length-i);
			}

			if(tmp[1])
				return arNum.join("").replace(/^,/,'') + "." + tmp[1];
			else
				return arNum.join("").replace(/^,/,'');
		}
		else
			return number;
	},
	// 단위 절사 (number:수, unit:단위) //
	digitCut : function(number, unit)
	{
		//unit = unit * 1000
		unit = Math.pow(10, unit);
		//alert(unit);
		number = Math.floor(number/unit) * unit;
		return number;
	}, 
	toCurrency : function(obj)
	{
		if(obj.disabled) return false;
		var num = obj.value.stripspace();
		if(num == "") return false;
		if(!this.chkNumber(this.stripChar(num)))
		{
			num = this.stripChar(num, false);
			obj.blur();
			obj.focus();
		}
		num = this.stripChar(this.stripComma(num), false);
		num = this.removePreZero(num);
		obj.value = this.NumberFormat(num);
	}
};

var FHandler = {
	FormChk : function(form) 
	{
		var ele, expstr, chkval, ele_type, ele_val;
		for(var i=0; i < form.elements.length; i++)
		{
			ele = form.elements[i];	
			expstr = ele.getAttribute("exp");
			chkval = ele.getAttribute("chkval");
			ele_type = ele.type.toLowerCase();
			ele_val = ele.value;

			if(expstr != null && expstr != "")
			{
				switch(ele_type)
				{
					case "hidden" : 
						if(ele_val.replace(/^\s*/,'').replace(/\s*$/, '') == "")
						{
							alert(expstr);
							return false;
							break;
						}
					break;
					case "text" : case "password" : case "textarea" : 
						if(ele_val.replace(/^\s*/,'').replace(/\s*$/, '') == "" && ele.disabled == false)
						{
							alert(expstr + " 입력해 주세요.");
							ele.focus();
							return false;
							break;
						}
					break;
					case "select-one" : 
						if(ele_val == "" && ele.disabled == false)
						{
							alert(expstr + " 선택해 주세요.");
							ele.focus();
							return false;
							break;
						}
					break;
					case "radio" : 
						if($(":radio[name='"+ele.name+"']:checked").length < 1)
						{
							alert(expstr + " 선택해 주세요.");
							$(":radio[name='"+ele.name+"']").eq(0).focus();
							return false;
							break;
						}
					break;
					case "file" : 
						if(ele_val == "" && ele.disabled == false)
						{
							alert(expstr + " 선택해 주세요.");
							ele.focus();
							return false;
							break;
						}
						else if(ele_val != "" && ele.getAttribute("filetype"))
						{
							if(!CHandler.chkFileType(ele))
							{
								return false;
								break;
							}
						}
					break;
				}
			}

			if(chkval != null && ele_val.length > 0)
			{
				switch(chkval)
				{
					case "id" : 
						if(!CHandler.chkUserID(ele_val))
						{
							alert("아이디형식이 맞지 않습니다.");
							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
					case "email" : 
						if(!CHandler.chkEmail(ele_val))
						{
							alert("메일형식이 맞지 않습니다.");
							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
					case "password" : 
						var result = CHandler.chkPassword(ele_val);
						if(result != "000")
						{
							if(result == "111")
								alert("비밀번호는 숫자와 영문자 조합으로 6~16자리를 사용해야 합니다.");
							else if(result == "222")
								alert("비밀번호는 숫자와 영문자를 혼용하셔야 합니다.");
							else if(result == "333")
								alert("비밀번호에 같은 문자를 4번이상 사용하실수 없습니다.");

							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
					case "pass_confirm" : 
						if(form.pass.value != ele_val)
						{
							alert("비밀번호가 일치하지 않습니다.");
							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
					case "alphabet" : 
						if(!CHandler.chkAlphabet(ele_val))
						{
							alert("알파벳으로만 입력해 주세요.");
							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
					case "number" : 
						if(!NumberHandler.chkNumber(ele_val))
						{
							alert("숫자로만 입력해 주세요.");
							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
					case "hangul" : 
						if(!CHandler.chkHangul(ele_val))
						{
							alert("한글만 입력 가능합니다.");
							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
					case "nick" : 
						if(!CHandler.chkNickName(ele_val))
						{
							alert("닉네임 형식이 맞지 않습니다.");
							ele.value = "";
							ele.focus();
							return false;
							break;
						}
					break;
				}
			}
		}
		
		if(typeof(myeditor) == "object") myeditor.outputBodyHTML();
		if(typeof(myeditor1) == "object") myeditor1.outputBodyHTML();
		if(typeof(myeditor2) == "object") myeditor2.outputBodyHTML();
		if(typeof(myeditor3) == "object") myeditor3.outputBodyHTML();
		if(typeof(myeditor4) == "object") myeditor4.outputBodyHTML();
		if(typeof(myeditor5) == "object") myeditor5.outputBodyHTML();
		if(typeof(myeditor6) == "object") myeditor6.outputBodyHTML();
		if(typeof(myeditor7) == "object") myeditor7.outputBodyHTML();
		return true;
	}
};

/**
* 팝업함수 선언
*/
var Popup = {
	open : function(url, name, opt)
	{
		var win = window.open(url, name, opt);
		win.focus();
	},
	open2 : function(url, name, w, h, scroll)
	{
		var win = window.open(url, name, "width="+w+",height="+h+",scrollbars="+scroll);
	},
	// full window popup //
	open_f : function(url, name) 
	{
		var w = screen.availWidth;
		var h = screen.availHeight;

		var win = window.open(url, name, "width="+w+", height="+h+", left=0, top=0, toolbar=no, nenubar=no, scrollbars=yes, resizable=no");
	}
};

/**
* 공통함수 선언
*/
var Common = {
	// toggle : block, none //
	setToggle : function(id, mode) 
	{
		if(mode)
			$("#"+id).css("display", mode);
		else
			$("#"+id).css("display",(($("#"+id).css("display") != "none") ? "none" : "block"));
	},
	// object disabled //
	setDisabled : function($obj, bool) 
	{
		if(bool)
		{
			if($obj.attr("type") == "checkbox")
				$obj.prop("checked", false);

			$obj.attr("disabled", true);
			if($obj.attr("type") != "button")
				$obj.css("backgroundColor", "#f1f1f1");
		}
		else
		{
			$obj.attr("disabled", false);
			if($obj.attr("type") != "button")
				$obj.css("backgroundColor", "#ffffff");
		}
	}, 
	/**
	* hidden add
	* @params : obj : form, name : hidden input 명, val : 값
	*/
	addHidden : function(obj, name, val)
	{
		var input = document.createElement("input");
		input.type = "hidden";
		input.name = name;
		input.value = val;

		obj.appendChild(input);
	}, 
	/**
	* select option all remove
	* @params : object
	*/
	removeAllselectbox : function(obj)
	{
		for(var i=obj.length-1; i >= 0; i--)
			Common.removeSelectList(obj, i);
	}, 
	/**
	* select option one remove
	*/
	removeSelectList : function(obj, i)
	{
		obj.remove(i);
	},
	/**
	* set cookie 
	* @params : cname(쿠키명), cvalue(값), expiredays(기간)
	*/
	_setCookie : function(cname, cvalue, expiredays)
	{
		var cdate = new Date();
		cdate.setDate(cdate.getDate() + Number(expiredays));
		document.cookie = cname + "=" + escape(cvalue) + "; path=/; expires=" + cdate.toGMTString() + ";"
	}, 
	/**
	* get cookie
	* @params : cname -> 쿠키명 
	*/
	_getCookie : function(cname)
	{
		var nameOfCookie = name + "=";
		var x = 0;
		while(x <= document.cookie.length)
		{
			var y = (x + nameOfCookie.length);
			if(document.cookie.substring(x,y) == nameOfCookie)
			{
				if((endOfCookie = document.cookie.indexOf(";", y)) == -1)
					endOfCookie = document.cookie.length;

				return unescape(document.cookie.substring(y, endOfCookie));
			}
			x = document.cookie.indexOf(" ", x) + 1;
			if(x == 0) break;
		}
		return "";
	}, 
	_chgToggle : function(id, mode)
	{
		if(mode)
			$("#"+id).css("display", $mode);
		else
			$("#"+id).css("display", (($("#"+id).css("display") != "none") ? "none" : "block"));
	},
	_all_checked : function(el, bool)
	{
		$(":checkbox[name='"+el+"']:enabled").prop("checked", bool);
	}, 
	_checked_all : function(obj, el) {
		if(obj.checked == true)
			$(":checkbox[name='"+el+"']:enabled").prop("checked", true);
		else
			$(":checkbox[name='"+el+"']:enabled").prop("checked", false);
	}, 
	is_checked : function(el, msg)
	{
		if(!el) return;

		if($(":checkbox[name='"+el+"']:checked").size() > 0)
			return true;
		else
		{
			msg = (msg) ? msg : "선택된 항목이 없습니다.";
			alert(msg);
			$(":checkbox[name='"+el+"']").eq(0).focus();
			return false;
		}
	},
	set_date : function(s, e)
	{
		$(":text[name='sday']").val(s);
		$(":text[name='eday']").val(e);
	}, 
	win_resize : function(w, h)
	{
		var clintAgent = navigator.userAgent;

		if(h == "") h = $("div#pwrap").prop("offsetHeight");
		if(clintAgent.indexOf("MSIE") != -1)
			window.resizeBy(w - $("body").prop("clientWidth"), h - $("body").prop("clientHeight"));
		else
			window.resizeBy(w - window.innerWidth, h - $("body").prop("clientHeight"));
	},
	_add_bookmark : function(url, tit)
	{
		var browser = navigator.userAgent.toLowerCase();
		if(window.sidebar)
			window.sidebar.addPanel(tit, url, "");
		else if(window.external)
		{
			//IE
			if(browser.indexOf("chrome") == -1)
				window.external.AddFavorite(url, tit);
			else
				alert("CTRL + D 또는 Command + D를 눌러 즐겨찾기에 추가해주세요.");
		}
		else if(window.opera && window.print)
			return true;
		else if(browser.indexOf("konqueror") != -1)
			alert("CTRL + B를 눌러 즐겨찾기에 추가해주세요.");
		else if(browser.indexOf("webkit") != -1)
			alert("CTRL + B 또는 Command + B를 눌러 즐겨찾기에 추가해주세요.");
		else
			alert("사용하고 계시는 브라우저에서는 이 버튼으로 즐겨찾기를 추가 할수 없습니다.");
	}
};
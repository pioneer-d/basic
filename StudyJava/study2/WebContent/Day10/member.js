/**
 * 
 */
function infoConfirm(){
	if(document.reg_frm.id.value.length == 0){
		alert("아이디를 입력하세요");
		reg_frm.id.focus();
		return;
		}
		
	if(document.reg_frm.id.value.length < 4){
		alert("아이디는 최소 4글자 이상이여야 합니다");
		reg_frm.id.focus();
		return;
		}
		
	if(document.reg_frm.pw.value.length == 0){
		alert("비밀번호를 입력하세요");
		reg_frm.pw.focus();
		return;
		}
	
	if(document.reg_frm.pw.value.length < 4){
		alert("비밀번호는 최소 4글자 이상이여야 합니다");
		reg_frm.pw.focus();
		return;
		}
		
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다");
		reg_frm.pw.focus();
		return;
		}
	
	if(document.reg_frm.name.value.length == 0){
		alert("이름을 입력하세요");
		reg_frm.name.focus();
		return;
		}
	
	if(document.reg_frm.email.value.length == 0){
		alert("메일을 입력하세요");
		reg_frm.email.focus();
		return;
		}
		
	document.reg_frm.submit();		
	
}

function updateInfoConfirm(){
	if(document.reg_frm.pw.value == ""){
		alert("패스워드를 입력하세요");
		document.reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		alert("패스워드가 일치하지 않습니다");
		document.reg_frm.pw_check.focus();
		return;
	}
	
	if(document.reg_frm.email.value.length == 0){
		alert("메일을 입력하세요");
		reg_frm.email.focus();
		return;
	}
	
	document.reg_frm.submit();
}
























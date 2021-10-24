<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>

<script type="text/javascript">
    function Compare(){
        var RegExp = /^[a-zA-Z0-9]{4,12}$/; //id와 pwassword 유효성 검사 정규식
        var e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;  //이메일 유효성 검사 정규식
        var n_RegExp = /^[가-힣]{2,15}$/; //이름 유효성검사 정규식
        
        
      	
        var objId = document.getElementById("id"); //아이디
        var objPwd = document.getElementById("pwd"); //비밀번호
        var objPwd2 = document.getElementById("pwd2"); //비밀번호확인
        var objEmail = document.getElementById("mail");//메일
        var objName = document.getElementById("name"); //닉네임
        var objTel = document.getElementById("tel")//연락처
        
        // ---------------- ID 유효성검사 ---------------- //
        
        if(objId.value==''){    //공백이면 objId.value값을 리턴하지 않는다
            alert("ID를 입력해주세요.");
            objId.focus();
            return false;
        }
        if(!RegExp.test(objId.value)){ //아이디 유효성검사  test는 대응되는 문자열이 있는지 검사하는 메소드
            alert("ID는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");        
            return false;
        }
        
        // ---------------- PASSWORD 유효성검사 ----------------//
        if(objPwd.value==''){ // 비밀번호 입력여부 검사
            alert("Password를 입력해주세요.");
            objPwd.focus();
            return false;
        }
        if(!RegExp.test(objPwd.value)){ //패스워드 유효성검사
            alert("Password는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
            objPwd.focus();
            return false;
        }
        if(objPwd.value==objId.value){ //패스워드와 ID가 동일한지 검사
            alert("Password는 ID와 동일하면 안됩니다.");
            objPwd.focus();
            return false;
        }
        
        if(objPwd2.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
            alert("비밀번호가 틀립니다. 다시 확인하여 입력해주세요.");
            objPwd2.focus();
            return false;
        }
        
        // ---------------- email 유효성검사 ---------------- //
        if(e_RegExp.value == ''){ // 이메일 입력여부 검사
            alert("이메일을 입력해주세요.");
            objEmail.focus();
            return false;
        }
        
        if(!e_RegExp.test(objEmail.value)){ //이메일 유효성 검사
            alert("올바른 이메일 형식이 아닙니다.");
            objEmail.focus();
            return false;
        }
        
        // ---------------- 닉네임 유효성검사 ---------------- //        
        if(objName.value ==''){
            alert("닉네임을 입력해주세요.");
            objName.focus();
            return false;
        }
        if(objTel.value ==''){
            alert("연락처를 입력해주세요.");
            objTel.focus();
            return false;
        }else{ //형식이 올바르면 회원가입 완료 창 뜨기
            alert("회원가입이 완료 되었습니다")
        	
        }
                
    }
    
</script>
</head>
<body>
    <form name = "f"  method="post" onsubmit="return Compare();" action = "joinCommand">   <!--form의 값을 전송하기전 Compare호출-->
        <table align="center" width="600" height="200" border="1"  cellpadding="3" cellspacing="0" bordercolor=#0872b0>
    	
        <!-- 회원정보 -->
        <tr>
            <td bgcolor=#ccecff align="center" colspan="2"><b>회원 기본 정보</b></td>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>아이디: </b></td>
            <td><input type="text" Name="MEMBER_ID" id="id" SIZE="20" maxlength="12">&nbsp4~12자의 영문 대소문자와 숫자로만 입력</td>
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>비밀번호: </b></td>
            <td><input type="password" Name="MEMBER_PWD" id="pwd" SIZE="20" maxlength="12">&nbsp4~12자의 영문 대소문자와 숫자로만 입력</td>
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>비밀번호 확인:</b></td>
            <td><input type="password" Name="pwd" id="pwd2" SIZE="20" maxlength="12"></td>
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>메일주소: </b></td>
            <td><input type="text" Name="MEMBER_EMAIL" id="mail" SIZE="20">&nbsp예&#41id&#64domain.com</td> <!--/ &#41 = 오른쪽 괄호 / &#64 = - /-->
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>닉네임: </b></td>
            <td ><input type="text" Name="MEMBER_NICK" id="name" SIZE="20"> </td>
        </tr>
                <tr>
            <td bgcolor=#e6e6e6 align="center"><b>연락처: </b></td>
            <td ><input type="text" Name="MEMBER_TEL" id="tel" SIZE="20">&nbsp-없이 숫자만 입력 </td>
        </tr>
    </table>
    <br>
    <div align="center">
        <input type="submit" value="회원가입">
        <input type="reset" value="다시입력">

    </div>
    </form>
</body>
</html>
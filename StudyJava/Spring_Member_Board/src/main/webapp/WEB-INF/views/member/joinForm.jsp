<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>

<script type="text/javascript">
    function Compare(){
        var RegExp = /^[a-zA-Z0-9]{4,12}$/; //id와 pwassword 유효성 검사 정규식
        var e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;  //이메일 유효성 검사 정규식
        var n_RegExp = /^[가-힣]{2,15}$/; //이름 유효성검사 정규식
        
        var jnumArr = new Array(); // 입력 한 주민번호 앞자리를 저장해줄 배열 선언
        var jnumArr2 = new Array(); //입력 한 주민번호 뒷자리를 저장해줄 배열 선언
        var jnumCal = [2,3,4,5,6,7,8,9,2,3,4,5,1]; // 주민번호 계산할때 쓰이는 배열
        var jnumSum = 0; //주민번호 계산에 사용 될 값
        
      	
        var objId = document.getElementById("id"); //아이디
        var objPwd = document.getElementById("pwd"); //비밀번호
        var objPwd2 = document.getElementById("pwd2"); //비밀번호확인
        var objEmail = document.getElementById("mail");//메일
        var objName = document.getElementById("name"); //이름
        var objNum = document.getElementById("num"); //주민번호앞 6
        var objNum2 = document.getElementById("num2"); //주민번호 뒷자리 7
        var objIntro = document.getElementById("introduce"); //자기소개
        
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
        
        // ---------------- 이름 유효성검사 ---------------- //        
        if(objName.value ==''){
            alert("이름을 입력해주세요.");
            objName.focus();
            return false;
        }
        if(!n_RegExp.test(objName.value)){
            alert("특수문자,영어,숫자는 사용할수 없습니다. 한글만 입력하여주세요.");
            objName.focus();
            return false;
        }

        
        // ---------------- 주민등록번호 유효성검사 ---------------- //
        if(objNum.value == "" || objNum2.value == ""){ // 주민번호입력 형식이 알맞은지 검사 
            alert("주민번호 형식이 올바르지 않습니다.");
            objNum.focus();
            return false;
       }
        
        for(var i = 0; i<objNum.value.length;i++){ // 입력받은 주민번호 앞자리 jnumArr배열에 넣기  
            jnumArr[i] = objNum.value.charAt(i);
        }

        for( var i =0; i<objNum2.value.length; i++){		//입력받은 주민번호 뒷자리 jnumArr2배열에 넣기
            jnumArr2[i] = objNum2.value.charAt(i);
        }
        
        jnumArrAll = jnumArr.concat(jnumArr2);  //주민번호 총 자리		
        
        
        for(var i = 0; i<12;i++){
            jnumSum+=jnumArrAll[i]*jnumCal[i];    //jnumplus배열과 입력한 주민번호 순서대로 하나씩 곱하여 jnumSum에 저장
        }
        
        jnumSum = (11-(jnumSum % 11)); //jnumSum저장 값을 11로 나눈 나머지를 11로 뺀 값
		
        if(jnumSum != jnumArrAll[12]){ // 계산되서 나온 결과값(jnumSum)과 입력한 주민번호의 마지막이 맞지 않으면 
            alert("주민번호가 올바르지 않습니다."); //alert 창 띄우기
            
            return false;
        }
        
        var y = String(jnumArrAll[0]);	//생일자동완성 위한 변수선언
        var y1 = String(jnumArrAll[1]);
	    var m = String(jnumArrAll[2]);
	    var m1 = String(jnumArrAll[3]);
	    var d = String(jnumArrAll[4]);
	    var d1 = String(jnumArrAll[5]);
        var tmp = String(jnumArrAll[6]);
      
      
        if( tmp == '1' || tmp == '2'){  //생일 자동완성
    		f.year.value = "19"+y+y1;
    		f.mon.value = m+m1;
    		f.day.value = d+d1;
    	}
    	else if (tmp == '3' || tmp == '4'){
    		f.year.value = "20" +y+y1;
    		f.month.value = m+m1;
    		f.day.value = d+d1;
        }
        
                
        // ---------------- 자기소개란 공백시 알림 ---------------- //
        if(objIntro.value == ""){
            alert("자기소개 해주세요~")
            objIntro.focus();
            return false;
        }else{ //형식이 올바르면 회원가입 완료 창 뜨기
            alert("회원가입이 완료 되었습니다")
            history.back();
        	
        }
    }
    
</script>
</head>
<body>
    <form name = "f"  method="post" onsubmit="return Compare();" action = "./MemberJoinAction.me">   <!--form의 값을 전송하기전 Compare호출-->
        <table align="center" width="600" height="200" border="1"  cellpadding="3" cellspacing="0" bordercolor=#0872b0>
    	
        <!-- 회원정보 -->
        <tr>
            <td bgcolor=#ccecff align="center" colspan="2"><b>회원 기본 정보</b></td>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>아이디: </b></td>
            <td><input type="text" Name="id" id="id" SIZE="20" maxlength="12">&nbsp4~12자의 영문 대소문자와 숫자로만 입력</td>
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>비밀번호: </b></td>
            <td><input type="password" Name="pwd" id="pwd" SIZE="20" maxlength="12">&nbsp4~12자의 영문 대소문자와 숫자로만 입력</td>
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>비밀번호 확인:</b></td>
            <td><input type="password" Name="pwd" id="pwd2" SIZE="20" maxlength="12"></td>
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>메일주소: </b></td>
            <td><input type="text" Name="mail" id="mail" SIZE="20">&nbsp예&#41id&#64domain.com</td> <!--/ &#41 = 오른쪽 괄호 / &#64 = - /-->
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>이름: </b></td>
            <td ><input type="text" Name="name" id="name" SIZE="20"> </td>
        </tr>
    
        <!-- 개인신상정보 -->
        <tr>
            <td bgcolor=#ccecff align="center" colspan="2"><b>개인 신상 정보</b></td>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>주민등록번호: </b></td>
            <td><input type="text" Name="num" id="num" SIZE="10" maxlength="6">&nbsp-
                <input type="password" Name="num2" id="num2" SIZE="10" maxlength="7">
                &nbsp예&#41 1234561234567</td>
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>생일: </b></td>
            <td><input type="text" id ="year" SIZE="10" maxlength="4" readonly>년
                <select name="mon">
                          <option value="1" selected="selected">1</option>
                          <option value="2">2</option>
                           <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
                           <option value="6">6</option>
                           <option value="7">7</option>
                          <option value="8">8</option>
                           <option value="9">9</option>
                           <option value="10">10</option>
                           <option value="11">11</option>
                           <option value="12">12</option>
                     </select>월
                <select name="day">
                          <option value="1" selected="selected">1</option>
                          <option value="2">2</option>
                           <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
                           <option value="6">6</option>
                           <option value="7">7</option>
                          <option value="8">8</option>
                           <option value="9">9</option>
                           <option value="10">10</option>
                           <option value="11">11</option>
                           <option value="12">12</option>
                          <option value="13">13</option>
                           <option value="14">14</option>
                           <option value="15">15</option>
                           <option value="16">16</option>
                           <option value="17">17</option>
                           <option value="18">18</option>
                           <option value="19">19</option>
                           <option value="20">20</option>
                           <option value="21">21</option>
                           <option value="22">22</option>
                           <option value="23">23</option>
                           <option value="24">24</option>
                           <option value="25">25</option>
                           <option value="26">26</option>
                           <option value="27">27</option>
                           <option value="28">28</option>
                           <option value="29">29</option>
                           <option value="30">30</option>
                           <option value="31">31</option>
                     </select>일
            </td>
            
        </tr>
        <tr>
            <td bgcolor=#e6e6e6 align="center"><b>자기소개: </b></td>
            <td><textarea cols="70" rows="7" id="introduce" name="introduce"></textarea></td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resources/js/joinForm.js">
										<!-- 정적이 아닌 동적으로 지정하는 방법. -->
</script>
</head>
<body>
    <form name = "f"  method="post" onsubmit="return Compare()" action = "joinConfirm">   <!--form의 값을 전송하기전 Compare호출-->
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
        <button onclick="history.back()">뒤로가기</button>
    </div>
    </form>
</body>
</html>
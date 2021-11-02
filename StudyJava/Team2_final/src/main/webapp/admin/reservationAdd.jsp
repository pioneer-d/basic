<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input title here</title>
<script type="text/javascript">
	function Compare() {
		var RESERVATION_STATUS = document.getElementById("RESERVATION_STATUS"); //예약여부
		var SUBSCRIBER_NAME = document.getElementById("SUBSCRIBER_NAME"); //예약자
		var SUBSCRIBER_TEL = document.getElementById("SUBSCRIBER_TEL"); //연락처
		var SUBSCRIBER_EMAIL = document.getElementById("SUBSCRIBER_EMAIL"); //이메일
		var RESERVATION_PEOPLE = document.getElementById("RESERVATION_PEOPLE"); //인원
		var PYAMENT_AMOUNT = document.getElementById("PYAMENT_AMOUNT"); //금액
		var PAYMENT_METHOD = document.getElementById("PAYMENT_METHOD"); //결제방식
		var RESERVATION_TIME = document.getElementById("RESERVATION_TIME"); //예약시간
		var ROOM_NUM = document.getElementById("ROOM_NUM"); //방코드

		if (RESERVATION_STATUS.value == '') { //공백검사
			alert("예약여부를 입력해주세요.");
			RESERVATION_STATUS.focus();
			return false;
		}
		if (RESERVATION_NUM.value == '') { //공백검사
			alert("예약번호를 입력해주세요.");
			RESERVATION_NUM.focus();
			return false;
		}
		if (SUBSCRIBER_NAME.value == '') { //공백검사
			alert("예약자를 입력해주세요.");
			SUBSCRIBER_NAME.focus();
			return false;
		}
		if (SUBSCRIBER_TEL.value == '') { //공백검사
			alert("연락처를 입력해주세요.");
			SUBSCRIBER_TEL.focus();
			return false;
		}
		if (SUBSCRIBER_EMAIL.value == '') { //공백검사
			alert("이메일을 입력해주세요.");
			SUBSCRIBER_EMAIL.focus();
			return false;
		}
		if (RESERVATION_PEOPLE.value == '') { //공백검사
			alert("인원을 입력해주세요.");
			RESERVATION_PEOPLE.focus();
			return false;
		}
		if (PYAMENT_AMOUNT.value == '') { //공백검사
			alert("금액을 입력해주세요.");
			PYAMENT_AMOUNT.focus();
			return false;
		}
		if (PAYMENT_METHOD.value == '') { //공백검사
			alert("결제방식을 입력해주세요.");
			PAYMENT_METHOD.focus();
			return false;
		}
		if (RESERVATION_TIME.value == '') { //공백검사
			alert("예약시간를 입력해주세요.");
			RESERVATION_TIME.focus();
			return false;
		}
		if (ROOM_NUM.value == '') { //공백검사
			alert("방코드를 입력해주세요.");
			RESERVATION_TIME.focus();
			return false;
		} else { //형식이 올바르면
			alert("등록이 완료 되었습니다")
			history.back();

		}
	}
</script>
</head>
<body>
	<form onsubmit="return Compare();" action="./ReservationAddAction.ad">
		<table width="50%" height="80" border="1" align="center"
			cellpadding="5" cellspacing="0" bordercolor="lightgrey">
			<tr align="center">
				<td colspan="2" align="center" bgcolor="#339999">
					<div style="font-weight: bold; font-size: 18px">예약자 추가</div>
				</td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
					<div style="font-weight: bold;">예약여부:</div>
				</td>
				<td><input type="text" name="RESERVATION_STATUS" id = "RESERVATION_STATUS"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">예약자:</div></td>
				<td><input type="text" name="SUBSCRIBER_NAME" id ="SUBSCRIBER_NAME"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">연락처:</div></td>
				<td><input type="text" name="SUBSCRIBER_TEL" id = "SUBSCRIBER_TEL"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">이메일:</div></td>
				<td><input type="text" name="SUBSCRIBER_EMAIL" id = "SUBSCRIBER_EMAIL"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">인원:</div></td>
				<td><input type="text" name="RESERVATION_PEOPLE" id = "RESERVATION_PEOPLE"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">금액:</div></td>
				<td><input type="text" name="PYAMENT_AMOUNT" id = "PYAMENT_AMOUNT"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">결제방식:</div></td>
				<td><input type="text" name="PAYMENT_METHOD" id = "PAYMENT_METHOD"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">예약시간:</div></td>
				<td><input type="text" name="RESERVATION_TIME" id = "RESERVATION_TIME"></td>
			</tr>
			<tr>
				<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">방코드:</div></td>
				<td><input type="text" name="ROOM_NUM" id = "ROOM_NUM"></td>
			</tr>
		</table>
		<p align=center>
			<input type="submit" value="등록하기">
		</p>
	</form>
	<p align=center>
		<a href="javascript:window.history.back();">뒤로가기</a>
	</p>
</body>
</html>
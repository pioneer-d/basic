<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<!-- Mirrored from hd.newescape.co.kr/board/check.passform.php?mode=lock&code=1570684154&encData=aWR4PTI0MCZzdGFydD0wJg== by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:12:08 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!-- /Added by HTTrack -->
<head>
<meta charset="utf-8">
<title>패스워드 확인</title>
<style>
* {
	margin: 0;
	padding: 0;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	white-space: normal
}

.layer.s400 {
	width: 400px;
}

.layer .pop_header {
	margin-top: 4px;
	height: 45px;
	line-height: 45px;
	font-size: 18px;
	font-weight: bold;
	border-radius: 5px 5px 0 0;
	background: #f1f3f4;
	border-bottom: 1px solid #cccfd3;
}

.layer .pop_container {
	padding: 20px;
	background: #fff;
	border-radius: 0 0 5px 5px;
}

.layer .pop_container .customer_tab:first-child {
	margin-top: 20px;
}

.layer .popup_close {
	overflow: hidden;
	text-indent: -9999px;
	width: 49px;
	height: 49px;
	display: block;
	z-index: 3200;
	position: absolute;
	right: 0;
	top: 0;
	cursor: pointer;
	background: url(../images/layer/btn_pop_close.png) no-repeat 50% 50%;
}

.layer .txt_message {
	text-align: center;
	padding: 8px 0;
	font-size: 14px;
	color: #333;
	line-height: 18px;
	font-weight: bold;
}

.layer .input_box {
	text-align: center;
	padding: 5px 0;
}

.layer .input {
	width: 70%;
	height: 30px;
	border: solid 1px #bdbdbd;
	background-color: #fff;
	font-size: 13px;
	padding: 5px;
}

.layer .foot_btn {
	font-size: 0;
	line-height: 0;
	padding-top: 18px;
	text-align: center;
}

.layer .btn_n {
	display: inline-block;
	width: 100px;
	height: 38px;
	line-height: 38px;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: #fff;
	border-radius: 4px;
	border-bottom: 2px solid #eee;
	font-size: 14px;
	padding: 0;
}

.layer .btn_ {
	width: 100px;
	height: 38px;
	line-height: 38px;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: #fff;
	border-radius: 4px;
	font-size: 14px;
	padding: 0;
}

.layer .foot_btn .btn_n+.btn_n {
	margin-left: 10px;
}

.layer .bg_red {
	border-color: #d52929;
	background: #fb3939;
}

a, a:visited, a:hover, a:active {
	text-decoration: none;
}
</style>
<script type="text/javascript" src="../j-script/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="../j-script/j-common.js"></script>
</head>
<body>
	<form name="passForm"
		action="http://hd.newescape.co.kr/board/password.act.php"
		method="post" autocomplete="off"
		onsubmit="return FHandler.FormChk(this);">
		<input type="hidden" name="mode" value="lock" /> <input type="hidden"
			name="code" value="1570684154" /> <input type="hidden"
			name="encData" value="aWR4PTI0MCZzdGFydD0wJg==" />
		<div class="layer s400 alert_popup">
			<div class="pop_header">
				<img src="../images/layer/ico_pop_monitor.png" align="absmiddle" />비밀번호확인
			</div>
			<div class="pop_container">
				<div class="txt_message">비밀번호를 입력해 주세요.</div>
				<div class="input_box">
					<input type="password" name="pwd" class="input"
						placeholder="비밀번호를 입력해주세요." exp="비밀번호를" />
				</div>
				<p class="foot_btn">
					<input type="submit" value="확인" class="btn_ bg_red" />
				</p>
			</div>
			<a href="javascript:parent.LayerPopup.close();"
				class="popup_close layer_close">닫기</a>
		</div>
	</form>

	<script type="text/javascript">
		/* 익스에서 안됨 추후확인 요망
		$(document).ready(function(){
			$(".layer_close").on("click", function(){
				alert("adfadfasdf");
				parent.LayerPopup.close();
			});
		});
		 */
	</script>
</body>

<!-- Mirrored from hd.newescape.co.kr/board/check.passform.php?mode=lock&code=1570684154&encData=aWR4PTI0MCZzdGFydD0wJg== by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:12:08 GMT -->
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="room.db.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
ArrayList roomList = (ArrayList) request.getAttribute("roomList");
%>
<!DOCTYPE HTML>
<html lang="ko">

<!-- Mirrored from hd.newescape.co.kr/home/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:10:11 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<!-- /Added by HTTrack -->
<head>
<title>::: 방탈출카페 뉴이스케이프 홍대점 :::</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes, maximum-scale=1.0, minimum-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="publisher"
	content="(주)신비웹,신비웹,sinbiweb,sinbiweb.com,www.sinbiweb.com,webmaster@sinbiweb.com" />
<meta name="keywords" content="방탈출,이스케이프,방탈출카페,홍대방탈출,홍대방탈출카페" />
<meta name="description" content="홍대뉴이스케이프,방탈출카페,테마체험" />
<meta property="og:type" content="website" />
<meta property="og:title" content="::: 방탈출카페 뉴이스케이프 홍대점 :::" />
<meta property="og:url" content="./index.jsp" />
<meta property="og:image" content="./images/ico/logo02.png" />
<meta property="og:description" content="홍대뉴이스케이프,방탈출카페,테마체험" />

<link rel="stylesheet" type="text/css" href="./css/style.css" />
<link rel="stylesheet" type="text/css" href="./css/jquery.bxslider.css" />
<script type="text/javascript" src="./js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./js/jquery.easing.1.3.js"></script>
<!-- script type="text/javascript" src="/js/ui.js"></script -->
<script type="text/javascript" src="./js/jquery.bxslider.js"></script>
<script type="text/javascript" src="./j-script/jquery-migrate-1.2.1.js"></script>

<script type="text/javascript" src="./j-script/j-common.js"></script>
<script type="text/javascript" src="./j-script/j-room.js"></script>
<script type="text/javascript" src="./j-script/j-layer.js"></script>
<script type="text/javascript"
	src="./newescape/zipcode.15440835.com/zipcode.js"></script>
<script type="text/javascript" src="./cheditor/cheditor.js"></script>

</head>

<body>
	<iframe name="ifrm" id="ifrm"
		style="display: none; height: 100px; width: 100%;"></iframe>
	<div id="wrap">
		<dl id="skip">
			<dt class="hide">메뉴 바로가기</dt>
			<dd>
				<a href="#self">주메뉴 바로가기</a>
			</dd>
			<dd>
				<a href="#self">컨텐츠 바로가기</a>
			</dd>
		</dl>

		<header>
			<div id="header">
				<div class="in_Layer">
					<div class="gnb_wrap">
						<h1 class="logo02">
							<a href="./escapeRoom.rm"><img src="./images/ico/logo02.png"
								alt="" /></a>
						</h1>
						<ul class="gnb">
							<li><a href="./about.rm">NEW ESCAPE</a></li>
							<li><a href="./room.rm">ROOMS</a></li>
							<li><a href="./roomList.rm">RESERVATION</a></li>
							<li><a href="./reserveCheck.re">예약확인</a></li>
							<li><a href="./">문의하기</a></li>
							<li><a href="./faqList.fa">FAQ</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- end : id : header -->
		</header>
		<!-- end : header -->

		<div id="popup_9"
			style="position: absolute; z-index: 999999; width: 800px; height: 710px; left: 850px; top: 100px; display:;">
			<div
				style="width: 100%; height: 700px; background: url('./upload/design/81116_1.jpg');">
				<p>&nbsp;</p>
			</div>
			<div
				style="padding: 10px; width: 100%; background-color: #2B2525; position: absolute; bottom: 0; left: 0;">
				<div>
					<label style="color: #fff;" class="recruit" rel="9"><input
						type="checkbox" name="recruit" style="vertical-align: middle;" />
						하루 열지 않음</label>
				</div>
				<div style="position: absolute; top: 5px; right: 5px;">
					<img src="./images/btn/btn_layer_close.gif" border="0" alt="닫기버튼"
						class="popup_close" rel="9" />
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				var popup_id = "popup_9";

				$("#" + popup_id).css("cursor", "move").draggable();
			});
		</script>
		<script type="text/javascript" src="./j-script/jquery-ui.js"></script>
		<div id="visual">
			<div class="main_visual">
				<div
					style="width: 100%; height: 730px; background: url('./upload/design/42304_1.jpg') center no-repeat;"></div>
			</div>
		</div>
		<!-- end : id : visual -->

		<div id="contents">
			<div class="sec01">
				<div class="in_Layer">
					<p class="sec01_tit">
						Rooms <span>테마방소개</span>
					</p>
					<ul>
						<%
						for (int i = 0; i < roomList.size(); i++) {
							RoomBeans rbean = (RoomBeans) roomList.get(i);
						%>
						<li>
							<div class="img_wrap">
								<img src="./themaUpload/<%=rbean.getROOMPHOTO()%>" width="225"
									height="317" />
							</div>
							<p class="theme"><%=rbean.getROOMNAME()%>
								[<%=rbean.getROOMTIME()%>분]
							</p>
							<p class="level">
								난이도 :
								<%
							for (int j = 0; j < rbean.getROOMLEVEL(); j++) {
								out.print("★");
							}
							%>
							</p> <a href="./roomList.rm?theme=<%=rbean.getROOMNUM()%>"
							class="rev_btn" data-code="1575708803">예약하기</a>
						</li>
						<%
						}
						%>

					</ul>
				</div>
			</div>
			<div class="footer_info">
				<div class="in_Layer">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3163.1845161904757!2d126.91799971566198!3d37.550716332790955!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c98da9e9db48d%3A0x14a1f1d80eb1911a!2z7ISc7Jq47Yq567OE7IucIOuniO2PrOq1rCDshJzqtZDrj5kgMzk1LTE3!5e0!3m2!1sko!2skr!4v1574404769234!5m2!1sko!2skr"
						width="780" height="405" frameborder="0"
						style="border: 0; float: left;" allowfullscreen=""></iframe>
					<div class="footer_info_txt">
						<p class="tit">
							차원이 다른 방탈출 <span>뉴이스케이프</span>
						</p>
						<p class="txt">
							주인공이 되어 테마방을 체험해 보세요. <br /> 방을 탈출하기 위해 주어진 시간은 오직 60분! <br />
							모든 단서를 추리하여 방을 탈출해야 합니다.
						</p>
						<p class="txt">
							탈출을 위해선 추리력과 관찰력이 필요하며 <br /> 적극적인 자세와 참가자들간의 소통,역할분담이 <br />
							필요합니다.
						</p>
					</div>
				</div>
			</div>
			<form name="fm" action="http://hd.newescape.co.kr/reserve/"
				method="post">
				<input type="hidden" name="theme" />
			</form>
			<script type="text/javascript">
				$(function() {
					$("a[data-code]").on("click", function() {
						var theme = $(this).attr("data-code");

						$(":hidden[name='theme']").val(theme);
						$("form[name='fm']").submit();
					});
				});
			</script>
			<div id="footer">
				<div class="footer_list">
					<div class="in_Layer">
						<ul class="footer_list">
							<li><a href="./agreement.rm">이용약관</a></li>
							<li><a href="./privacy.rm">개인정보취급방침</a></li>
						</ul>
					</div>
				</div>
				<div class="in_Layer">
					<p class="footer_p01">
						STORE INFO. <span>02-322-1290</span> <br /> 영업시간 [연중무휴] 11:00 -
						24:00
					</p>
					<p class="footer_p02">
						회사명 : 뉴이스케이프 홍대점 / 대표자 : 홍준성 / 사업자등록번호 : 431-48-00472 / 주소 : 서울특별시
						마포구 서교동 395-17 (예랑빌딩 4층) <br /> e-mail : skull007@nate.com / 입금계좌
						: 농협 1163-12-166696 (예금주 : 홍준성) &nbsp;<a href="./AdminLogin.ad">관리자로그인</a>
				</div>
				<!-- end : class : in_Layer -->
			</div>
			<!-- end : id : footer -->
		</div>
		<!-- end : id : contents -->

	</div>
	<!-- end : id : wrap -->

</body>

<!-- Mirrored from hd.newescape.co.kr/home/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:09 GMT -->
</html>
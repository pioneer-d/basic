<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
String name = (String)request.getAttribute("name");
String tel1 = (String)request.getAttribute("tel1");
String tel2 = (String)request.getAttribute("tel2");
String tel3 = (String)request.getAttribute("tel3");
String content = (String)request.getAttribute("content");
%>
<!DOCTYPE HTML>
<html lang="ko">
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
<!-- script type="text/javascript" src="./js/ui.js"></script -->
<script type="text/javascript" src="./js/jquery.bxslider.js"></script>
<script type="text/javascript" src="./j-script/jquery-migrate-1.2.1.js"></script>

<script type="text/javascript" src="./j-script/j-common.js"></script>
<script type="text/javascript" src="./j-script/j-room.js"></script>
<script type="text/javascript" src="./j-script/j-layer.js"></script>
<script type="text/javascript" src="./newescape/zipcode.15440835.com/zipcode.js"></script>
<script type="text/javascript" src="./cheditor/cheditor.js"></script>

</head>

<body style="">
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
							<li><a href="./customer/qna.jsp">문의하기</a></li>
							<li><a href="./faqList.fa">FAQ</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- end : id : header -->
		</header>
		<!-- end : header -->


		<div id="contents" class="sub_contents">
			<div class="in_Layer">
				<p class="sub_tit">
					<br> Reservation <span>예약확인</span>
				</p>

				<ul class="caution_Text">
					<li>※ 예약후 24시간 이전에만 환불되며, 그후에 예약취소, 미방문 시에는 환불되지 않습니다.</li>
					<li>※ 입금 후 게시판, 전화 등으로 입금확인 요청 부탁드립니다.</li>
				</ul>

				<form name="fm" action="./checkResult.re" method="post" autocomplete="off"
					onsubmit="return FHandler.FormChk(this);">
					<input type="hidden" name="act">

					<table cellspacing="0" cellpadding="0" class="themeTable"
						summary="예약정보 입력테이블">
						<caption>예약정보 입력테이블</caption>
						<colgroup>
							<col width="200">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label for="name">예약자</label></th>
								<td><input type="text" id="name" name="name"
									class="inputType" style="width: 400px;" title="예약자명을 입력하세요"
									value="<%=name %>" exp="예약자명을"></td>
							</tr>
							<script>
							var t = "<%= tel1%>";
							var ele = document.getElementById("phonee");
							
							console.log(t);
							for(i=0;i<6;i++){
								console.log(i);
								console.log(ele.options[i].value);
								if(ele.options[i].value == t){
									ele.options[i].selected = true;
									break;
								}
							}
							</script>
							<% System.out.println(tel1); %>
							<tr>
								<th><label for="phone">연락처</label></th>
								<td><select name="phone1" id="phonee" class="select"
									style="width: 100px" exp="연락처를">
										<option value="010" >010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
								</select> <input type="text" name="phone2" class="inputType"
									style="width: 100px;" title="연락처2을 입력하세요" maxlength="4"
									value="<%=tel2 %>" exp="연락처를" chkval="number"> <input
									type="text" name="phone3" class="inputType"
									style="width: 100px" title="연락처3을 입력하세요" maxlength="4"
									value="<%=tel3 %>" exp="연락처를" chkval="number"></td>
							</tr>
						</tbody>
					</table>

					<ul class="caution_Text">
						<li>※ 예약자 정보를 입력하시면 예약조회가 가능합니다.</li>
					</ul>

					<div class="btn_C273_Area">
						<button type="submit" class="buttonType reserve">예약확인</button>
						<a href="./escapeRoom.rm" class="btnStyle cancel">취소</a>
					</div>
				</form>

				<div class="empty mb30"><%=content %></div>
			</div>
		</div>
		<!-- end : id : contents -->
		<script type="text/javascript">
			$(function() {
				reserve.init();
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
					STORE INFO. <span>02-322-1290</span> <br> 영업시간 [연중무휴] 11:00 -
					24:00
				</p>
				<p class="footer_p02">
					회사명 : 뉴이스케이프 홍대점 / 대표자 : 홍준성 / 사업자등록번호 : 431-48-00472 / 주소 : 서울특별시
					마포구 서교동 395-17 (예랑빌딩 4층) <br> e-mail : skull007@nate.com /
					입금계좌 : 농협 1163-12-166696 (예금주 : 홍준성) &nbsp;<a href="./AdminLogin.ad">관리자로그인</a>

				</p>
			</div>
			<!-- end : class : in_Layer -->
		</div>
		<!-- end : id : footer -->
	</div>
	<!-- end : id : contents -->

	<!-- end : id : wrap -->


</body>
</html>
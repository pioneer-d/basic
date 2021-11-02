<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList Num = (ArrayList) request.getAttribute("Num");
ArrayList Title = (ArrayList) request.getAttribute("Title");
ArrayList Content = (ArrayList) request.getAttribute("Content");
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
					<br /> FAQ <span>자주 묻는 질문</span>
				</p>

				<div style="padding-bottom: 50px;">
					<div class="hybrid_boardArea">
						<div class="hybrid_boardArea">
							<div class="hy_faq_Area">
								<dl class="hy_faqType">
									<% for(int i=1;i<Num.size()+1;i++) { %>
									<dt><%=Title.get(i-1) %></dt>
									<dd>
										<p
											style='font-size: 14px; font-family: "Nanum Gothic"; margin-top: 10px; padding: 0px; overflow: hidden; color: #333333'>
											<span lang="ko"
												style="font-size: 12pt; margin: 0px; padding: 0px">
											<%=Content.get(i-1) %>	
											</span>
										</p>
									</dd>
									<% } %>
								</dl>
							</div>
							<!-- end : class : hy_faq_Area -->
						</div>
						<!-- end : class : hybrid_boardArea -->
						<script type="text/javascript">
							//<![CDATA[
							function faq_fn() {
								var $f = $(".hy_faqType>dt"), $q = $(".hy_faqType>dd");

								$f.click(function() {
									var answer = $(this).next("dd");
									if (answer.is(":visible")) {
										$f.removeClass("on");
										answer.slideUp();
									} else {
										$q.hide();
										$f.removeClass("on");
										$(this).addClass("on");
										answer.slideDown();
									}
									;
								});
							};

							$(document).ready(function() {
								faq_fn();
							});
							//]]>
						</script>

						<div class="paging_Layer">
							<div class="hy_paging">
								<a>&lt;&lt;</a> <a>&lt;</a> <span><a class="on">1</a></span> <a>&gt;</a>
								<a>&gt;&gt;</a>
							</div>
						</div>
						<!-- end : class : hy_paging -->

						<!-- ::::: search_Layer ::::: -->
						<form name="sfm"
							action="http://hd.newescape.co.kr/customer/faq.php?"
							method="post" autocomplete="off">
							<div class="hy_search_Layer" style="margin-top: 20px;">
								<div class="inSearch">
									<div class="hy_SelectDiv">
										<select name="skey" id="" class="hy_Select">
											<option value="title">제목</option>
											<option value="content">내용</option>
										</select>
									</div>
									<!-- end : class : hybird_SelectDiv -->
									<div class="hy_InputDiv">
										<div class="hy_Input">
											<input type="text" name="sstr" class="h_InputType"
												title="검색어를 입력하세요" />
										</div>
										<div class="hy_searchBtn">
											<input type="image"
												src="./images/board/hybrid_searchBtn.png" alt="검색버튼" />
										</div>
									</div>
									<!-- end : class : hybird_InputDiv -->
								</div>
								<!-- end : class : innerSearch -->
							</div>
							<!-- end : class : search_Layer -->
						</form>
						<!-- ::::: search_Layer ::::: -->
					</div>
					<!-- end : class : hybrid_boardArea -->
				</div>

			</div>
		</div>
		<!-- end : id : contents -->
		<div id="footer">
			<div class="footer_list">
				<div class="in_Layer">
					<ul class="footer_list">
						<li><a href="agreement.jsp">이용약관</a></li>
						<li><a href="privacy.jsp">개인정보취급방침</a></li>
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

<!-- Mirrored from hd.newescape.co.kr/customer/faq.php by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:34 GMT -->
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="room.db.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
ArrayList<String> namelist = (ArrayList<String>) request.getAttribute("rnameList");
ArrayList timelist = (ArrayList) request.getAttribute("rtimeList");
RoomBeans rbeans = (RoomBeans) request.getAttribute("roomInfo");
String day = (String) request.getAttribute("Date");
int roomCode = (int) request.getAttribute("code");
%>

<!DOCTYPE HTML>
<html lang="ko">

<!-- Mirrored from hd.newescape.co.kr/room/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:12 GMT -->
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

		<script type="text/javascript" src="./j-script/jquery.ui.core.js"></script>
		<script type="text/javascript" src="./j-script/jquery.ui.widget.js"></script>
		<script type="text/javascript"
			src="./j-script/jquery.ui.datepicker.js"></script>
		<link type="text/css" href="./css/jquery-ui-1.8.20.custom.css"
			rel="stylesheet" />
		<style type="text/css">
.ui-datepicker {
	font-size: 15px;
	width: 240px;
	background: #ddebf7;
	color: #333
}

.ui-datepicker select.ui-datepicker-month {
	width: 30%;
	font-size: 15px;
}

.ui-datepicker select.ui-datepicker-year {
	width: 40%;
	font-size: 15px;
}
</style>

		<div id="contents" class="sub_contents">
			<div class="in_Layer">
				<p class="sub_tit">
					<br /> Rooms <span>주인공이 될 수 있는 테마방</span>
				</p>
				<div class="tab_menu">

					<ul>
						<%
						for (int i = 0; i < namelist.size(); i++) {
							String str = namelist.get(i);
							if (roomCode == (i + 1)) {
						%>
						<li class="on"><a
							href="./room.rm?rcode=<%=i + 1%>&rdate=<%=day%>"> <%=str%>
						</a></li>

						<%
						} else {
						%>
						<li><a href="./room.rm?rcode=<%=i + 1%>&rdate=<%=day%>">
								<%=str%>
						</a></li>
						<%
						}
						}
						%>
					</ul>


				</div>
				<br />
				<div class="detail_info">
					<div class="detail_img_wrap">
						<img src="./themaUpload/<%=rbeans.getROOMPHOTO() %>" width="300"
							height="425" />
					</div>
					<div class="detail_txt">
						<p class="detail_tit"><%=rbeans.getROOMNAME()%>
							[<%=rbeans.getROOMTIME()%>분]
						</p>
						<p>
							<%=rbeans.getROOMINTRO()%>
						</p>
					</div>
					<div class="room_tit">
						<ul class="tit_info">
							<li>난이도 : <%
							for (int i = 0; i < rbeans.getROOMLEVEL(); i++) {
								out.print("★");
							}
							%></li>

							<li>추천인원 : 2~6</li>
							<li>진행시간 : <%=rbeans.getROOMTIME()%>분
							</li>
						</ul>
					</div>
					<!-- end : room_tit -->

					<form name="sfm" action="./room.rm" method="post"
						autocomplete="off">
						<input type="hidden" name="rcode" value="<%=roomCode%>" />
						<div class="time_rev">
							실시간 예약
							<div class="sel_box">
								<p class="sel_tit">예약일</p>
								<div class="date">
									<input type="text" name="rdate" class="calendar"
										readonly="readonly"
										style="text-align: center; width: 225px; height: 40px; font-size: 18px; color: #666;"
										value="<%=day%>" />
									<!-- a href="#self">2019-09-23</a -->
								</div>
							</div>
						</div>
						<!-- end : time_rev -->
					</form>
					<br />
					<ul class="rev_list">
						<%
						for (int i = 0; i < timelist.size(); i++) {
							RoomBeans rbean = (RoomBeans) timelist.get(i);

							Timestamp nowtime = new Timestamp(System.currentTimeMillis());
							Timestamp time = rbean.getRESERVATION_TIME();

							if (time.getTime() < nowtime.getTime())
								rbean.setRESERVATION_STATUS("F");

							if (rbean.getRESERVATION_STATUS().equals("F") || rbean.getRESERVATION_STATUS().equals("f")) {
						%>
						<li><a href="javascript:void(0);"><%=new SimpleDateFormat("HH:mm").format(rbean.getRESERVATION_TIME())%>
								<span class="off">예약마감</span></a></li>
						<%
						} else {
						%>
						<li class="on"><a
							href="./reserveForm.re?rcode=<%=rbean.getROOMNUM()%>&rdate=<%=rbean.getRESERVATION_TIME()%>">
								<%=new SimpleDateFormat("HH:mm").format(rbean.getRESERVATION_TIME())%>
								<span class="on">예약가능</span>
						</a></li>
						<%
						}
						}
						%>

					</ul>
					<p class="info_p">
						※ 입장시간 : 예약시간 10분 전 <br /> ※ 환불불가 : 방문일 24시간 이전 취소건만 환불됩니다.
					</p>
				</div>
			</div>
		</div>
		<!-- end : id : contents -->
		<form name="fm" action="./room.rm" method="post" autocomplete="off">
			<input type="hidden" name="rdate" value="<%=day%>" /> <input
				type="hidden" name="rtime" /> <input type="hidden" name="theme" />
			<input type="hidden" name="rcode" value="<%=roomCode%>">
		</form>

		<script type="text/javascript">
			$(function() {
				$('.calendar')
						.datepicker(
								{
									dayNamesMin : [ '일', '월', '화', '수', '목',
											'금', '토' ],
									monthNames : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									dateFormat : 'yy-mm-dd',
									showButtonPanel : true,
									//changeYear: true, 
									hideIfNoPrevNext : true,
									prevText : 'Earlier',
									minDate : 0,
									maxDate : "+2w" // 현재부터 2주까지만 활성화 
								});

				room.init();
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

<!-- Mirrored from hd.newescape.co.kr/room/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:25 GMT -->
</html>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="room.db.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
ArrayList roomList = (ArrayList) request.getAttribute("roomList");
RoomBeans rbeans = (RoomBeans) request.getAttribute("rbeans");
if(request.getAttribute("rbeans")!=null)
	rbeans = (RoomBeans) request.getAttribute("rbeans");
ArrayList timelist = (ArrayList) request.getAttribute("rtimeList");
String day = (String) request.getAttribute("Date");
Integer roomCode = null;
if (request.getAttribute("code") != null) {
	roomCode = (int) request.getAttribute("code");
}
%>
<!DOCTYPE HTML>
<html lang="ko">

<!-- Mirrored from hd.newescape.co.kr/reserve/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:25 GMT -->
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
					<br /> Reservation <span>예약하기</span>
				</p>
				<div class="rev_input">
					<form name="sfm" action="./roomList.rm" method="post"
						autocomplete="off">
						<div class="sel_box">
							<p class="sel_tit">예약일</p>
							<div class="date">
								<input type="text" name="rdate" class="calendar"
									readonly="readonly"
									style="width: 180px; height: 40px; font-size: 18px; color: #666;"
									value="<%=day%>" />
								<!-- a href="">2019-09-23</a></p -->
							</div>
						</div>
						<div class="sel_box">
							<p class="sel_tit">전체룸</p>
							<select name="theme" class="room">
								<option value="0">전체테마룸</option>
								<%
								System.out.println("selected");
								for (int i = 0; i < roomList.size(); i++) {
									RoomBeans rbean = (RoomBeans) roomList.get(i);
									if (roomCode != null && roomCode == rbean.getROOMNUM()) {
								%>
								<option value="<%=rbean.getROOMNUM()%>" selected="selected"><%=rbean.getROOMNAME()%>
									[<%=rbean.getROOMTIME()%>분]
								</option>
								<%
								} else {
								%>
								<option value="<%=rbean.getROOMNUM()%>"><%=rbean.getROOMNAME()%>
									[<%=rbean.getROOMTIME()%>분]
								</option>
								<%
								}
								}
								%>
							</select>
						</div>
					</form>
				</div>
			</div>
			<ul class="room_list">

				<%
				if (roomCode==null||roomCode==0) {
					for (int i = 0; i < roomList.size(); i++) {
						RoomBeans rbean = (RoomBeans) roomList.get(i);
				%>
				<li class="room_list">
					<div class="in_Layer">
						<div class="img_wrap">
							<img src="./themaUpload/<%=rbean.getROOMPHOTO() %>" width="225" height="317" />
						</div>
						<div class="room_info">
							<div class="room_tit">
								<p><%=rbean.getROOMNAME()%>
									[<%=rbean.getROOMTIME()%>분]
								</p>
								<ul class="tit_info">
									<li>난이도 :<%
									for (int j = 0; j < rbean.getROOMLEVEL(); j++) {
										out.print("★");
									}
									%>
									</li>
									<li>추천인원 : 2~6</li>
									<li>진행시간 : <%=rbean.getROOMTIME()%>분
									</li>
								</ul>
							</div>
							<ul class="rev_list">
								<%
								ArrayList time = (ArrayList) timelist.get(i);
								for (int j = 0; j < time.size(); j++) {
									RoomBeans rtbean = (RoomBeans) time.get(j);

									Timestamp nowtime = new Timestamp(System.currentTimeMillis());
									Timestamp settime = rtbean.getRESERVATION_TIME();

									if (settime.getTime() < nowtime.getTime())
										rtbean.setRESERVATION_STATUS("F");

									if (rtbean.getRESERVATION_STATUS().equals("F") || rtbean.getRESERVATION_STATUS().equals("f")) {
								%>
								<li><a href="javascript:void(0);"><%=new SimpleDateFormat("HH:mm").format(rtbean.getRESERVATION_TIME())%>
										<span class="off">예약마감</span></a></li>
								<%
								} else {
								%>
								<li class="on"><a
									href="./reserveForm.re?rcode=<%=rtbean.getROOMNUM()%>&rdate=<%=rtbean.getRESERVATION_TIME()%>">
										<%=new SimpleDateFormat("HH:mm").format(rtbean.getRESERVATION_TIME())%>
										<span class="on">예약가능</span>
								</a></li>
								<%
								}
								}
								%>

							</ul>
						</div>
						<%
						}
						} else {
						
						%>
						<li class="room_list">
							<div class="in_Layer">
								<div class="img_wrap">
									<img src="./themaUpload/<%=rbeans.getROOMPHOTO() %>" width="225" height="317" />
								</div>
								<div class="room_info">
									<div class="room_tit">
										<p><%=rbeans.getROOMNAME()%>
											[<%=rbeans.getROOMTIME()%>분]
										</p>
										<ul class="tit_info">
											<li>난이도 :<%
											for (int j = 0; j < rbeans.getROOMLEVEL(); j++) {
												out.print("★");
											}
											%>
											</li>
											<li>추천인원 : 2~6</li>
											<li>진행시간 : <%=rbeans.getROOMTIME()%>분
											</li>
										</ul>
									</div>
									<ul class="rev_list">
										<%
										
										for (int j = 0; j < timelist.size(); j++) {
											RoomBeans rtbean = (RoomBeans) timelist.get(j);

											Timestamp nowtime = new Timestamp(System.currentTimeMillis());
											Timestamp settime = rtbean.getRESERVATION_TIME();

											if (settime.getTime() < nowtime.getTime())
												rtbean.setRESERVATION_STATUS("F");

											if (rtbean.getRESERVATION_STATUS().equals("F") || rtbean.getRESERVATION_STATUS().equals("f")) {
										%>
										<li><a href="javascript:void(0);"><%=new SimpleDateFormat("HH:mm").format(rtbean.getRESERVATION_TIME())%>
												<span class="off">예약마감</span></a></li>
										<%
										} else {
										%>
										<li class="on"><a
											href="./reserveForm.re?rcode=<%=rtbean.getROOMNUM()%>&rdate=<%=rtbean.getRESERVATION_TIME()%>">
												<%=new SimpleDateFormat("HH:mm").format(rtbean.getRESERVATION_TIME())%>
												<span class="on">예약가능</span>
										</a></li>
										<%
										}
										}
										%>

									</ul>
								</div>
								<%
								}
								%>
							</div>
						</li>
			</ul>
		</div>
		<!-- end : id : contents -->

		<form name="fm" action="./roomReserve.rm"
			method="post" autocomplete="off">
			<input type="hidden" name="rdate" value="" /> <input
				type="hidden" name="rtime" /> <input type="hidden" name="theme" />
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
					: 농협 1163-12-166696 (예금주 : 홍준성)
					&nbsp;<a href = "./AdminLogin.ad">관리자로그인</a>
			</div>
			<!-- end : class : in_Layer -->
		</div>
		<!-- end : id : footer -->
	</div>
	<!-- end : id : contents -->

	</div>
	<!-- end : id : wrap -->

</body>

<!-- Mirrored from hd.newescape.co.kr/reserve/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:25 GMT -->
</html>

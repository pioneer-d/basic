
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
<title>::: ��Ż��ī�� ���̽������� ȫ���� :::</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes, maximum-scale=1.0, minimum-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="publisher"
	content="(��)�ź���,�ź���,sinbiweb,sinbiweb.com,www.sinbiweb.com,webmaster@sinbiweb.com" />
<meta name="keywords" content="��Ż��,�̽�������,��Ż��ī��,ȫ���Ż��,ȫ���Ż��ī��" />
<meta name="description" content="ȫ�봺�̽�������,��Ż��ī��,�׸�ü��" />
<meta property="og:type" content="website" />
<meta property="og:title" content="::: ��Ż��ī�� ���̽������� ȫ���� :::" />
<meta property="og:url" content="./index.jsp" />
<meta property="og:image" content="./images/ico/logo02.png" />
<meta property="og:description" content="ȫ�봺�̽�������,��Ż��ī��,�׸�ü��" />

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
			<dt class="hide">�޴� �ٷΰ���</dt>
			<dd>
				<a href="#self">�ָ޴� �ٷΰ���</a>
			</dd>
			<dd>
				<a href="#self">������ �ٷΰ���</a>
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
							<li><a href="./reserveCheck.re">����Ȯ��</a></li>
							<li><a href="./customer/qna.jsp">�����ϱ�</a></li>
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
					<br /> Reservation <span>�����ϱ�</span>
				</p>
				<div class="rev_input">
					<form name="sfm" action="./roomList.rm" method="post"
						autocomplete="off">
						<div class="sel_box">
							<p class="sel_tit">������</p>
							<div class="date">
								<input type="text" name="rdate" class="calendar"
									readonly="readonly"
									style="width: 180px; height: 40px; font-size: 18px; color: #666;"
									value="<%=day%>" />
								<!-- a href="">2019-09-23</a></p -->
							</div>
						</div>
						<div class="sel_box">
							<p class="sel_tit">��ü��</p>
							<select name="theme" class="room">
								<option value="0">��ü�׸���</option>
								<%
								System.out.println("selected");
								for (int i = 0; i < roomList.size(); i++) {
									RoomBeans rbean = (RoomBeans) roomList.get(i);
									if (roomCode != null && roomCode == rbean.getROOMNUM()) {
								%>
								<option value="<%=rbean.getROOMNUM()%>" selected="selected"><%=rbean.getROOMNAME()%>
									[<%=rbean.getROOMTIME()%>��]
								</option>
								<%
								} else {
								%>
								<option value="<%=rbean.getROOMNUM()%>"><%=rbean.getROOMNAME()%>
									[<%=rbean.getROOMTIME()%>��]
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
									[<%=rbean.getROOMTIME()%>��]
								</p>
								<ul class="tit_info">
									<li>���̵� :<%
									for (int j = 0; j < rbean.getROOMLEVEL(); j++) {
										out.print("��");
									}
									%>
									</li>
									<li>��õ�ο� : 2~6</li>
									<li>����ð� : <%=rbean.getROOMTIME()%>��
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
										<span class="off">���ึ��</span></a></li>
								<%
								} else {
								%>
								<li class="on"><a
									href="./reserveForm.re?rcode=<%=rtbean.getROOMNUM()%>&rdate=<%=rtbean.getRESERVATION_TIME()%>">
										<%=new SimpleDateFormat("HH:mm").format(rtbean.getRESERVATION_TIME())%>
										<span class="on">���డ��</span>
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
											[<%=rbeans.getROOMTIME()%>��]
										</p>
										<ul class="tit_info">
											<li>���̵� :<%
											for (int j = 0; j < rbeans.getROOMLEVEL(); j++) {
												out.print("��");
											}
											%>
											</li>
											<li>��õ�ο� : 2~6</li>
											<li>����ð� : <%=rbeans.getROOMTIME()%>��
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
												<span class="off">���ึ��</span></a></li>
										<%
										} else {
										%>
										<li class="on"><a
											href="./reserveForm.re?rcode=<%=rtbean.getROOMNUM()%>&rdate=<%=rtbean.getRESERVATION_TIME()%>">
												<%=new SimpleDateFormat("HH:mm").format(rtbean.getRESERVATION_TIME())%>
												<span class="on">���డ��</span>
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
									dayNamesMin : [ '��', '��', 'ȭ', '��', '��',
											'��', '��' ],
									monthNames : [ '1��', '2��', '3��', '4��',
											'5��', '6��', '7��', '8��', '9��',
											'10��', '11��', '12��' ],
									dateFormat : 'yy-mm-dd',
									showButtonPanel : true,
									//changeYear: true, 
									hideIfNoPrevNext : true,
									prevText : 'Earlier',
									minDate : 0,
									maxDate : "+2w" // ������� 2�ֱ����� Ȱ��ȭ 
								});

				room.init();
			});
		</script>
		<div id="footer">
			<div class="footer_list">
				<div class="in_Layer">
					<ul class="footer_list">
						<li><a href="./agreement.rm">�̿���</a></li>
						<li><a href="./privacy.rm">����������޹�ħ</a></li>
					</ul>
				</div>
			</div>
			<div class="in_Layer">
				<p class="footer_p01">
					STORE INFO. <span>02-322-1290</span> <br /> �����ð� [���߹���] 11:00 -
					24:00
				</p>
				<p class="footer_p02">
					ȸ��� : ���̽������� ȫ���� / ��ǥ�� : ȫ�ؼ� / ����ڵ�Ϲ�ȣ : 431-48-00472 / �ּ� : ����Ư����
					������ ������ 395-17 (�������� 4��) <br /> e-mail : skull007@nate.com / �Աݰ���
					: ���� 1163-12-166696 (������ : ȫ�ؼ�)
					&nbsp;<a href = "./AdminLogin.ad">�����ڷα���</a>
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

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
					<br /> Rooms <span>���ΰ��� �� �� �ִ� �׸���</span>
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
							[<%=rbeans.getROOMTIME()%>��]
						</p>
						<p>
							<%=rbeans.getROOMINTRO()%>
						</p>
					</div>
					<div class="room_tit">
						<ul class="tit_info">
							<li>���̵� : <%
							for (int i = 0; i < rbeans.getROOMLEVEL(); i++) {
								out.print("��");
							}
							%></li>

							<li>��õ�ο� : 2~6</li>
							<li>����ð� : <%=rbeans.getROOMTIME()%>��
							</li>
						</ul>
					</div>
					<!-- end : room_tit -->

					<form name="sfm" action="./room.rm" method="post"
						autocomplete="off">
						<input type="hidden" name="rcode" value="<%=roomCode%>" />
						<div class="time_rev">
							�ǽð� ����
							<div class="sel_box">
								<p class="sel_tit">������</p>
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
								<span class="off">���ึ��</span></a></li>
						<%
						} else {
						%>
						<li class="on"><a
							href="./reserveForm.re?rcode=<%=rbean.getROOMNUM()%>&rdate=<%=rbean.getRESERVATION_TIME()%>">
								<%=new SimpleDateFormat("HH:mm").format(rbean.getRESERVATION_TIME())%>
								<span class="on">���డ��</span>
						</a></li>
						<%
						}
						}
						%>

					</ul>
					<p class="info_p">
						�� ����ð� : ����ð� 10�� �� <br /> �� ȯ�ҺҰ� : �湮�� 24�ð� ���� ��ҰǸ� ȯ�ҵ˴ϴ�.
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
					: ���� 1163-12-166696 (������ : ȫ�ؼ�) &nbsp;<a href="./AdminLogin.ad">�����ڷα���</a>
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
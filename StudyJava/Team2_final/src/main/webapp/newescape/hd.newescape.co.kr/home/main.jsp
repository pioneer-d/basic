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
							<li><a href="./">�����ϱ�</a></li>
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
						�Ϸ� ���� ����</label>
				</div>
				<div style="position: absolute; top: 5px; right: 5px;">
					<img src="./images/btn/btn_layer_close.gif" border="0" alt="�ݱ��ư"
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
						Rooms <span>�׸���Ұ�</span>
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
								[<%=rbean.getROOMTIME()%>��]
							</p>
							<p class="level">
								���̵� :
								<%
							for (int j = 0; j < rbean.getROOMLEVEL(); j++) {
								out.print("��");
							}
							%>
							</p> <a href="./roomList.rm?theme=<%=rbean.getROOMNUM()%>"
							class="rev_btn" data-code="1575708803">�����ϱ�</a>
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
							������ �ٸ� ��Ż�� <span>���̽�������</span>
						</p>
						<p class="txt">
							���ΰ��� �Ǿ� �׸����� ü���� ������. <br /> ���� Ż���ϱ� ���� �־��� �ð��� ���� 60��! <br />
							��� �ܼ��� �߸��Ͽ� ���� Ż���ؾ� �մϴ�.
						</p>
						<p class="txt">
							Ż���� ���ؼ� �߸��°� �������� �ʿ��ϸ� <br /> �������� �ڼ��� �����ڵ鰣�� ����,���Һд��� <br />
							�ʿ��մϴ�.
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

<!-- Mirrored from hd.newescape.co.kr/home/ by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:09 GMT -->
</html>
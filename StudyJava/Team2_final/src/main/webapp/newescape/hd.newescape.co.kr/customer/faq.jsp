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


		<div id="contents" class="sub_contents">
			<div class="in_Layer">
				<p class="sub_tit">
					<br /> FAQ <span>���� ���� ����</span>
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
											<option value="title">����</option>
											<option value="content">����</option>
										</select>
									</div>
									<!-- end : class : hybird_SelectDiv -->
									<div class="hy_InputDiv">
										<div class="hy_Input">
											<input type="text" name="sstr" class="h_InputType"
												title="�˻�� �Է��ϼ���" />
										</div>
										<div class="hy_searchBtn">
											<input type="image"
												src="./images/board/hybrid_searchBtn.png" alt="�˻���ư" />
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
						<li><a href="agreement.jsp">�̿���</a></li>
						<li><a href="privacy.jsp">����������޹�ħ</a></li>
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

<!-- Mirrored from hd.newescape.co.kr/customer/faq.php by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 23 Mar 2021 15:11:34 GMT -->
</html>
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
					<br> Reservation <span>����Ȯ��</span>
				</p>

				<ul class="caution_Text">
					<li>�� ������ 24�ð� �������� ȯ�ҵǸ�, ���Ŀ� �������, �̹湮 �ÿ��� ȯ�ҵ��� �ʽ��ϴ�.</li>
					<li>�� �Ա� �� �Խ���, ��ȭ ������ �Ա�Ȯ�� ��û ��Ź�帳�ϴ�.</li>
				</ul>

				<form name="fm" action="./checkResult.re" method="post" autocomplete="off"
					onsubmit="return FHandler.FormChk(this);">
					<input type="hidden" name="act">

					<table cellspacing="0" cellpadding="0" class="themeTable"
						summary="�������� �Է����̺�">
						<caption>�������� �Է����̺�</caption>
						<colgroup>
							<col width="200">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label for="name">������</label></th>
								<td><input type="text" id="name" name="name"
									class="inputType" style="width: 400px;" title="�����ڸ��� �Է��ϼ���"
									value="<%=name %>" exp="�����ڸ���"></td>
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
								<th><label for="phone">����ó</label></th>
								<td><select name="phone1" id="phonee" class="select"
									style="width: 100px" exp="����ó��">
										<option value="010" >010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
								</select> <input type="text" name="phone2" class="inputType"
									style="width: 100px;" title="����ó2�� �Է��ϼ���" maxlength="4"
									value="<%=tel2 %>" exp="����ó��" chkval="number"> <input
									type="text" name="phone3" class="inputType"
									style="width: 100px" title="����ó3�� �Է��ϼ���" maxlength="4"
									value="<%=tel3 %>" exp="����ó��" chkval="number"></td>
							</tr>
						</tbody>
					</table>

					<ul class="caution_Text">
						<li>�� ������ ������ �Է��Ͻø� ������ȸ�� �����մϴ�.</li>
					</ul>

					<div class="btn_C273_Area">
						<button type="submit" class="buttonType reserve">����Ȯ��</button>
						<a href="./escapeRoom.rm" class="btnStyle cancel">���</a>
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
						<li><a href="./agreement.rm">�̿���</a></li>
						<li><a href="./privacy.rm">����������޹�ħ</a></li>
					</ul>
				</div>
			</div>
			<div class="in_Layer">
				<p class="footer_p01">
					STORE INFO. <span>02-322-1290</span> <br> �����ð� [���߹���] 11:00 -
					24:00
				</p>
				<p class="footer_p02">
					ȸ��� : ���̽������� ȫ���� / ��ǥ�� : ȫ�ؼ� / ����ڵ�Ϲ�ȣ : 431-48-00472 / �ּ� : ����Ư����
					������ ������ 395-17 (�������� 4��) <br> e-mail : skull007@nate.com /
					�Աݰ��� : ���� 1163-12-166696 (������ : ȫ�ؼ�) &nbsp;<a href="./AdminLogin.ad">�����ڷα���</a>

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
<%@ page import = "room.db.RoomBeans" %>
<%@page import="room.db.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
//int rcode = (int)request.getAttribute("rcode");
String rdate = (String)request.getAttribute("rdate");
String setdate = (String)request.getAttribute("setdate");
String settime = (String)request.getAttribute("settime");
int price = (int)request.getAttribute("price");
System.out.println("price : "+price);
RoomBeans rbean = (RoomBeans)request.getAttribute("rbean");
//String name = (String)request.getAttribute("name");
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

<!-- <script type="text/javascript" src="./js/jquery-1.10.2.min.js"></script> -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
							<a href="./escapeRoom.rm"><img src="/images/ico/logo02.png" alt=""></a>
						</h1>
						<ul class="gnb">
							<li><a href="./about.rm">NEW ESCAPE</a></li>
							<li><a href="./room.rm">ROOMS</a></li>
							<li><a href="./roomList.rm">RESERVATION</a></li>
							<li><a href="./reserveCheck.re">����Ȯ��</a></li>
							<li><a href="/customer/qna.php">�����ϱ�</a></li>
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
					<br> Reservation <span>�����ϱ�</span>
				</p>

				<form name="fm" action="./addReserve.re" method="post"
					autocomplete="off">
					<input type="hidden" name="act"> <input type="hidden"
						name="theme" value="<%=rbean.getROOMNUM() %>"> <input type="hidden"
						name="rdate" value="<%=setdate%>"> <input type="hidden"
						name="rtime" value="<%=settime %>"> <input type="hidden"
						name="price" value="<%=price %>">

					<table cellspacing="0" cellpadding="0" class="themeTable"
						summary="�������� �Է����̺�">
						<caption>�������� �Է����̺�</caption>
						<colgroup>
							<col width="200">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>�׸� (Room)</th>
								<td><%=rbean.getROOMNAME() %> [<%=rbean.getROOMTIME()%>��]</td>
							</tr>
							<tr>
								<th>�����Ͻ� (Date)</th>
								<td><%=setdate %></td>
							</tr>
							<tr>
								<th>�ð�</th>
								<td><%=settime %></td>
							</tr>
							<tr>
								<th><label for="personnel">�ο� (Players)</label></th>
								<td><select name="player" id="person" class="selected"
									style="width: 150px" title="�ο��� �Է��ϼ���" exp="�ο���">
										<option value="2">2 ��</option>
										<option value="3">3 ��</option>
										<option value="4">4 ��</option>
										<option value="5">5 ��</option>
										<option value="6">6 ��</option>
								</select></td>
							</tr>
							<tr>
								<th><label for="name">������</label></th>
								<td><input type="text" id="name" name="name"
									class="inputType" style="width: 400px;" title="�����ڸ��� �Է��ϼ���"
									exp="�����ڸ���"></td>
							</tr>
							<tr>
								<th><label for="phone">����ó</label></th>
								<td><select name="phone1" id="phone" class="select"
									style="width: 100px" exp="����ó��">
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
								</select> <input type="text" name="phone2" class="inputType"
									style="width: 100px;" title="����ó2�� �Է��ϼ���" maxlength="4"
									exp="����ó��" chkval="number"> <input type="text"
									name="phone3" class="inputType" style="width: 100px"
									title="����ó3�� �Է��ϼ���" maxlength="4" exp="����ó��" chkval="number">
								</td>
							</tr>
							<tr>
								<th><label for="email">�̸���</label></th>
								<td><input type="text" id="email" name="email"
									class="inputType" style="width: 400px;" title="�̸����� �Է��ϼ���"></td>
							</tr>
							<script>
								//var one_price=<%=price%>;
								//console.log(one_price);
								$(document).ready(function(){
    							 	 var one_price = <%= price %>;

 							     	console.log(one_price);

								      
								      $("#person").change(function(){
								    	  console.log("uuuu");
								         $("#price").html(one_price * this.value);
								      });
								   });
																
								/* $(function(){
									$("#player").change(function(){
										$("#price").html(one_price*this.value);
									});
								}); */
								//var person_cnt=$("#personnel > option:selected").val();
								//$(".price").html(one_price * person_cnt);
							</script>
							<tr>
								<th>�������</th>
								<td><span class="price" id="price"><%=price*2 %></span></td>
							</tr>
							<tr>
								<th>�������������</th>
								<td>���� 121212121212 �ٶ���</td>
							</tr>
							<tr>
								<th>�������</th>
								<td><label><input type="radio" name="payway"
										value="T" checked="checked"> �������</label>
									&nbsp;&nbsp;&nbsp; <label><input type="radio"
										name="payway" value="F"> �����弱����</label></td>
							</tr>
						</tbody>
					</table>

					<ul class="caution_Text">
						<li>�� �׸����۽ð����� ���� 24�ð� �̳� ��ҽÿ��� �������� ȯ���� ���� ������ ���ǹٶ��ϴ�.</li>
						<li>�� �Ա� �� �Խ���, ��ȭ ������ �Ա�Ȯ�� ��û ��Ź�帳�ϴ�.</li>
					</ul>

					<div class="privacy_Div">
						<p>�������� ����, �̿� �� ���� � ���� ��������</p>
						<p>
							<br>
						</p>
						<p>�̿��� ������ �Ʒ��� ���������� ������� Ȯ���ϸ�, �Ʒ��� ���� ���������� ���� �� �̿��ϴ� �Ϳ�
							�����մϴ�.</p>
						<p>
							<br>
						</p>
						<p>[���������� ���� �� �̿����]</p>
						<p>
							<br>
						</p>
						<p>- ��ȸ�� ���ż��� ����</p>
						<p>
							<br>
						</p>
						<p>- ���� ������ Ȯ�� �� �����ϰ�, �ʿ� �� ���� ���� ���� Ȯ���� ���� �����ڿ��� ������ ���� ���� ��</p>
						<p>
							<br>
						</p>
						<p>[�����ϴ� ���������� �׸�]</p>
						<p>
							<br>
						</p>
						<p>- �ʼ��Է»��� : �̿����� �ĺ��� ���� ����</p>
						<p>
							<br>
						</p>
						<p>- �Է����� : �̸�, �޴�����ȣ, �̸��� �ּ�</p>
						<p>
							<br>
						</p>
						<p>[���������� ���� �� �̿�Ⱓ]</p>
						<p>
							<br>
						</p>
						<p>���������� �������� �Ǵ� ���� ���� ������ �޼��Ǹ� ��� �ı��մϴ�. �ٸ�, ��� �� ���� ������ ������
							���Ͽ� �ŷ����� ���� �ǹ� ������ Ȯ�� ���� ������ ��ݰ�������ȭ�� �ǰ��޿����ѱ�Ͽ� �ǰ� 5�Ⱓ �����մϴ�.</p>
						<p>
							<br>
						</p>
						<p>* ���� ���� ������ �������� ���� �Ǹ��� ������ ���� ���� ������ �������� ���� ��� ��ȸ�� ���񽺴�
							�������� �ʽ��ϴ�.</p>
						<p>
							<br>
						</p>
						<p>&nbsp;</p>
						<p>
							<br>
						</p>
						<p>
							<br>
						</p>
						<p>&nbsp;[�����/������ ��ȣ��å]</p>
						<p>
							<br>
						</p>
						<p>- ��Ż��ī�� ���̽��������� ���� �� ��Ʈ��ũ ���� ���Ƚý����� ���߰� �ֽ��ϴ�. ��ȭ�� �� ��ŷ ��
							�ܺ�ħ�Կ� ����Ͽ� �� �������� ħ�����ܽý��� �� ����� �м��ý��� ���� ���߾� ���̿��ڡ��� ������ ����������ȣ��
							������ ���ϰ� �ֽ��ϴ�. ���� ���� ������� �ּ�ȭ�� ���� �� ������ �������� ���ٱ����� �޸��ϰ�, ���ú��ȱ�����
							���� �� ��ħ�� �ؼ��� �����ϰ� �ֽ��ϴ�.</p>
						<p>
							<br>
						</p>
						<p>- ��Ż��ī�� ���̽��������� ���̿��ڡ� ������ �Ǽ��� �⺻���� ���ͳ��� ���輺 ������ �Ͼ�� �ϵ鿡 ����
							å���� ���� �ʽ��ϴ�.</p>
						<p>
							<br>
						</p>
						<p>- �� �� ���� �������� �Ǽ��� ������� ���� ���� ���� ���������� ���, ����, ����, �Ѽ��� ���ߵ�
							��� ��Ż��ī�� ���̽��������� �ﰢ���̿��ڡ����� ����� �˸��� ������ ��å�� ������ ������ ���Դϴ�.</p>
					</div>
					<p class="privacy">
						<span><input type="checkbox" id="privacy" name="privacy"
							title="����������޹�ħ�� ���ǽ� üũ�ϼ���"> <label for="privacy">����������޹�ħ��
								������</label></span>
					</p>

					<div class="btn_C273_Area">
						<button type="submit" class="buttonType reserve"
							data-action="save">�����ϱ�</button>
						<a href="/room/" class="btnStyle cancel">���</a>
					</div>

				</form>

			</div>
		</div>
		<!-- end : id : contents -->
		<script type="text/javascript">

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
					�Աݰ��� : ���� 1163-12-166696 (������ : ȫ�ؼ�)
					&nbsp;<a href = "./AdminLogin.ad">�����ڷα���</a>

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
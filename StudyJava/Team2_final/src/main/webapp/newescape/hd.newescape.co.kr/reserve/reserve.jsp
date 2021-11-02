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
							<a href="./escapeRoom.rm"><img src="/images/ico/logo02.png" alt=""></a>
						</h1>
						<ul class="gnb">
							<li><a href="./about.rm">NEW ESCAPE</a></li>
							<li><a href="./room.rm">ROOMS</a></li>
							<li><a href="./roomList.rm">RESERVATION</a></li>
							<li><a href="./reserveCheck.re">예약확인</a></li>
							<li><a href="/customer/qna.php">문의하기</a></li>
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
					<br> Reservation <span>예약하기</span>
				</p>

				<form name="fm" action="./addReserve.re" method="post"
					autocomplete="off">
					<input type="hidden" name="act"> <input type="hidden"
						name="theme" value="<%=rbean.getROOMNUM() %>"> <input type="hidden"
						name="rdate" value="<%=setdate%>"> <input type="hidden"
						name="rtime" value="<%=settime %>"> <input type="hidden"
						name="price" value="<%=price %>">

					<table cellspacing="0" cellpadding="0" class="themeTable"
						summary="예약정보 입력테이블">
						<caption>예약정보 입력테이블</caption>
						<colgroup>
							<col width="200">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>테마 (Room)</th>
								<td><%=rbean.getROOMNAME() %> [<%=rbean.getROOMTIME()%>분]</td>
							</tr>
							<tr>
								<th>예약일시 (Date)</th>
								<td><%=setdate %></td>
							</tr>
							<tr>
								<th>시간</th>
								<td><%=settime %></td>
							</tr>
							<tr>
								<th><label for="personnel">인원 (Players)</label></th>
								<td><select name="player" id="person" class="selected"
									style="width: 150px" title="인원을 입력하세요" exp="인원을">
										<option value="2">2 명</option>
										<option value="3">3 명</option>
										<option value="4">4 명</option>
										<option value="5">5 명</option>
										<option value="6">6 명</option>
								</select></td>
							</tr>
							<tr>
								<th><label for="name">예약자</label></th>
								<td><input type="text" id="name" name="name"
									class="inputType" style="width: 400px;" title="예약자명을 입력하세요"
									exp="예약자명을"></td>
							</tr>
							<tr>
								<th><label for="phone">연락처</label></th>
								<td><select name="phone1" id="phone" class="select"
									style="width: 100px" exp="연락처를">
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
								</select> <input type="text" name="phone2" class="inputType"
									style="width: 100px;" title="연락처2을 입력하세요" maxlength="4"
									exp="연락처를" chkval="number"> <input type="text"
									name="phone3" class="inputType" style="width: 100px"
									title="연락처3을 입력하세요" maxlength="4" exp="연락처를" chkval="number">
								</td>
							</tr>
							<tr>
								<th><label for="email">이메일</label></th>
								<td><input type="text" id="email" name="email"
									class="inputType" style="width: 400px;" title="이메일을 입력하세요"></td>
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
								<th>참가요금</th>
								<td><span class="price" id="price"><%=price*2 %></span></td>
							</tr>
							<tr>
								<th>무통장계좌정보</th>
								<td>농협 121212121212 다람쥐</td>
							</tr>
							<tr>
								<th>결제방식</th>
								<td><label><input type="radio" name="payway"
										value="T" checked="checked"> 현장결제</label>
									&nbsp;&nbsp;&nbsp; <label><input type="radio"
										name="payway" value="F"> 무통장선결제</label></td>
							</tr>
						</tbody>
					</table>

					<ul class="caution_Text">
						<li>※ 테마시작시간으로 부터 24시간 이내 취소시에는 선결제액 환불이 되지 않으니 주의바랍니다.</li>
						<li>※ 입금 후 게시판, 전화 등으로 입금확인 요청 부탁드립니다.</li>
					</ul>

					<div class="privacy_Div">
						<p>개인정보 수집, 이용 및 제공 등에 관한 고지사항</p>
						<p>
							<br>
						</p>
						<p>이용자 본인은 아래의 개인정보가 사실임을 확인하며, 아래와 같이 개인정보를 수집 및 이용하는 것에
							동의합니다.</p>
						<p>
							<br>
						</p>
						<p>[개인정보의 수집 및 이용목적]</p>
						<p>
							<br>
						</p>
						<p>- 비회원 예매서비스 제공</p>
						<p>
							<br>
						</p>
						<p>- 예약 정보를 확인 및 관리하고, 필요 시 예약 이행 여부 확인을 위해 예약자에게 연락을 취할 목적 등</p>
						<p>
							<br>
						</p>
						<p>[수집하는 개인정보의 항목]</p>
						<p>
							<br>
						</p>
						<p>- 필수입력사항 : 이용자의 식별을 위한 정보</p>
						<p>
							<br>
						</p>
						<p>- 입력정보 : 이름, 휴대폰번호, 이메일 주소</p>
						<p>
							<br>
						</p>
						<p>[개인정보의 보유 및 이용기간]</p>
						<p>
							<br>
						</p>
						<p>개인정보의 수집목적 또는 제공 받은 목적이 달성되면 즉시 파기합니다. 다만, 상법 등 관련 법령의 규정에
							의하여 거래관련 관리 의무 관계의 확인 등을 이유로 대금결제및재화들 의공급에관한기록에 의거 5년간 보유합니다.</p>
						<p>
							<br>
						</p>
						<p>* 개인 정보 제공에 동의하지 않을 권리가 있으며 개인 정보 제공에 동의하지 않을 경우 비회원 서비스는
							제공되지 않습니다.</p>
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
						<p>&nbsp;[기술적/관리적 보호대책]</p>
						<p>
							<br>
						</p>
						<p>- 방탈출카페 뉴이스케이프는 서버 및 네트워크 관련 보안시스템을 갖추고 있습니다. 방화벽 등 해킹 등
							외부침입에 대비하여 각 서버마다 침입차단시스템 및 취약점 분석시스템 등을 갖추어 ‘이용자’가 제공한 개인정보보호에
							만전을 기하고 있습니다. 개인 정보 취급직원 최소화는 물론 각 직원별 개인정보 접근권한을 달리하고, 수시보안교육을
							통해 본 방침의 준수를 강조하고 있습니다.</p>
						<p>
							<br>
						</p>
						<p>- 방탈출카페 뉴이스케이프는 “이용자” 개인의 실수나 기본적인 인터넷의 위험성 때문에 일어나는 일들에 대해
							책임을 지지 않습니다.</p>
						<p>
							<br>
						</p>
						<p>- 그 외 내부 관리자의 실수나 기술관리 상의 사고로 인해 개인정보의 상실, 유출, 변조, 훼손이 유발될
							경우 방탈출카페 뉴이스케이프는 즉각“이용자”에게 사실을 알리고 적절한 대책과 보상을 강구할 것입니다.</p>
					</div>
					<p class="privacy">
						<span><input type="checkbox" id="privacy" name="privacy"
							title="개인정보취급방침에 동의시 체크하세요"> <label for="privacy">개인정보취급방침에
								동의함</label></span>
					</p>

					<div class="btn_C273_Area">
						<button type="submit" class="buttonType reserve"
							data-action="save">예약하기</button>
						<a href="/room/" class="btnStyle cancel">취소</a>
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
					입금계좌 : 농협 1163-12-166696 (예금주 : 홍준성)
					&nbsp;<a href = "./AdminLogin.ad">관리자로그인</a>

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
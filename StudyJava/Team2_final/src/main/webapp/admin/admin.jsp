<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<String> result = (ArrayList<String>) request.getAttribute("list");
	String page1 = (String)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자페이지</title>
	<style>
		header {
			background-color:lightgrey;
			height:100px;
		}
		nav {
			background-color:#339999;
			color:white;
			width:200px;
			height:300px;
			float:left;
		}
		section {
			width:500px;
			text-align:left;
			float:left;
			padding:10px;
		}
		footer {
			background-color:#FFCC00;
			height:100px;
			clear:both;
		}
		header, nav, section, footer { text-align:center; }
		header, footer { line-height:100px; }
		nav, section { line-height:15px; }
	</style>
</head>

<body>
	<h1>관리자페이지</h1>
	<header>
		<h2>ESCAPE ADMINISTRATOR</h2>
	</header>
		<nav>
		<h5>카테c고리</h5>
		<ul>
			<li><h5><a href = "./ReservationList.ad">예약회원</a></h5></li>
			<li><h5><a href = "./ThemaList.ad">테마관리</a></h5></li>
			<li><h5><a href = "./QnaList.ad">문의관리</a></h5></li>
			<li><h5><a href = "./FaqList.ad">FAQ관리</a></h5></li>
			<li><h5><a href = "./SalesList.ad">매출관리</a></h5></li>		<!-- 아직 미구현 -->
			<li><h5><a href = "./GalleryList.ad">갤러리관리</a></h5></li>
		</ul>
		</nav>
	<section>
		<%
			
				if(page1 == null){	%>	<!-- 맨처음 아무것도 안눌렀을때. -->
					카테고리를 선택하세요
				<% } else if(page1.equals("reservation")){ %>	<!-- 예약회원 클릭시 -->
					<jsp:include page = "reservationAdmin.jsp"></jsp:include>
				<% }else if(page1.equals("thema")){ %>			<!-- 테마관리 클릭시 -->					
					<jsp:include page = "themaAdmin.jsp"></jsp:include>
				<% }else if(page1.equals("qna")){ %>			<!-- 문의관리 클릭시 -->					
					<jsp:include page = "qnaAdmin.jsp"></jsp:include>
				<% }else if(page1.equals("faq")){ %>			<!-- FAQ관리 클릭시 -->					
					<jsp:include page = "faqAdmin.jsp"></jsp:include>
				<% }else if(page1.equals("sales")){ %>			<!-- 매출관리 클릭시 -->					
					<jsp:include page = "salesAdmin.jsp"></jsp:include>
				<% }else if(page1.equals("gallery")){ %>		<!-- 갤러리관리 클릭시 -->					
					<jsp:include page = "galleryAdmin.jsp"></jsp:include>
				<% }
				%>
	</section>
	<footer>
		<h2>2조</h2>
	</footer>

</body>

</html>
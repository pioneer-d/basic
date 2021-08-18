<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage = "true" %>
<!-- 여기는 페이지 예외처리를 한 jsp라는 것을 명시! 기본값이 false이다. true로 하지 않으면 예외처리관련 메소드를 사용할 수 없다. -->
<% response.setStatus(200); %>
<!-- 이렇게 에러코드 지정. 이곳은 에러페이지가 아니므로 꼭 지정해줘야함. -->
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	에러가 나서 이곳으로 예외처리를 했음.
	<br>
	<%= exception.getMessage() %>

</body>
</html>
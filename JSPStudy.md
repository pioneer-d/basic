Day1

프로토콜 : 네트워크상에서 약속한 통신규약 (Http, FTP, SMTP, POP, DHCP)
IP : 네트워크상에서 컴퓨터를 식별할 수 있는 주소
DNS : IP주소를 인간이 쉽게 외우도록 맵핑한 문자열
Port : IP주소가 컴퓨터를 식별할 수 있게 해준다면, Port번호는 해당 컴퓨터의 구동되고 있는 프로그램을 구분할 수 있는 번호

http://www.test.com:80/index
http - 프로토콜
www.test.com - 컴퓨터 주소(DNS를 통한 IP주소로 변경)
80 - port(80이 default)
index - information path

JSP(Java Server Page) - HTML파일 내에 JAVA언어를 삽입한 문서
Servlet(Server Applet) - JAVA언어로 이루어진 웹프로그래밍 문서
MVC패턴 중 주로 V로 사용

웹서버 : 클라이언트의 요청에 의해 정보를 제공해 주는 서버(Apache, IIS)
	별도의 구현이 필요한 로직이 있을 경우 웹어플리케이션 서버에 요청
웹브라우저 : 웹서버에 정보를 요청하고, 웹서버로부터 정보를 받는 매개체. 이때 HTTP프로토콜 사용

client의 요청 -> 웹서버 -> 웹어플리케이션(WAS) -> 데이터 베이스 -> 다시 역순

톰캣 설치(지금은 9버전)

이클립스에서 show window -> sever 한다음
톰캣9로 추가. 톰캣 경로 넣어주고
추가된 서버를 클릭 후 
Location - Use Tomcat installation체크, 
Option - Public module contexts to separate XML files체크
port - Http 포트 번호 8181로 변경(오라클이 기본적으로 8080을 사용하기 때문.)
서버 실행 후 브라우저에 http://localhost:8181 검색. -> 초기 서버 페이지 나옴.(아파치)

JSP아키텍쳐 - jsp파일 -> java파일 -> class파일 그다음 실행.

Servlet - MVC패턴 중 주로 C로 이용됨.


맵핑 방법 2가지 -why : 주소가 너무 길다. 보안에 취약하다
1. servlet의 어노테이션 키워드를 통해 맵핑
2. web.xml을 통한 맵핑

servlet의 메소드
html의 form태그의 method방식이 get일 경우(기본적으로 웹브라우저에서 검색해서 들어가는것들은 get으로)
doGet - get방식은 URL값으로 정보가 전송됨. (주로 검색등 할때)
html의 form태그의 method방식이 post일 경우
doPost - post방식은 header를 이용해 정보가 전송됨. (주로 로그인, 회원가입 할때)

context path는 WAS에서 웹어플리케이션을 구분하기 위한 path.
이클립스에서 프로젝트를 생성하면 자동으로 server.xml에 추가됨.





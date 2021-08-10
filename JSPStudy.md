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


Day2

Servlet 작동순서
Client -> 웹브라우저 -> 웹서버 -> 웹어플리케이션 서버 -> Servlet컨테이너
						1. 스레드 생성
						2. Servlet객체 생성
다른 CGI언어에 비해 서버 부하가 적게 발생한다.(스레드 이용으로 인해)

Servlet 생명주기
Servlet은 최초 요청시 객체가 만즐어져 메모리에 로딩이 되고, 이후 요청시에 기존의 객체를 재활용한다.(동작 속도가 빠름)

Servlet 객체 생성(최초 한번) -> 
init() 호출(최초 한번) -> (init전에 선처리 @PostConstruct 가능하다)
service(), doGet(), doPost() 호출(요청시 매번) -> 
destroy() 호출(마지막 한번) (destroy후에 후처리 @PreDestroy 가능하다)



Day3

HTML의 Form태그
서버쪽으로 정보를 전달할 때 사용하는 테그.
(input의 type submit으로 값을 전달할 수 있다.)
form태그에서 action값과 method값을 지정.
action에서 맵핑명이나 jsp이름 같은거 지정.(주소입력이라고 생각)
method에서 get,post같은거 지정 가능.

form의 submit 버튼을 통해 데이터를 서버로 전송하면, 해당파일(Servlet)에서는 HttpServlet객체를 이용하여 Parameter값을 얻을 수 있다.
getParameter(name) - Value값을 줌
getParameterValues(name) - 값이 여러개 일때 사용
getParameterNames() - 이름들 추출


한글처리 방식
Get방식 - server.xml을 수정한다.
	<Connector URIEncoding = "UTF-8" ......>이거 추가

Post방식 - request.setCharacterEncoding("UTF-8")이거 사용.
















나중에 DB부분 미리 하기

데이터 베이스 연결 순서
(ojdbc6.jar파일 lib폴더에 넣은 후 )

1. JDBC드라이버 로드
	DriverManager
	("oracle.jdbc.driver.OracleDriver"); 
	: 메모리에 OracleDriver가 로드됨

2. 데이터베이스 연결
	Connection
	DriverManager.getConnection(JDBC URL, 계정아이디, 비밀번호);
	: Connection객체 생성함.(DB접근)

3. SQL문 실행
	Statement
	PreparedStatement는 Statement의 진화버전(중복코드를 완화해준다.) - inset 어쩌구 블라블라 ?,?,?,? 이런거
	connection.createStatement();
	: Statement객체를 통해 SQL문이 실행됨.

	ResultSet
	statement.executeQuery(); (SQL문 실행 후 리턴값이 있는경우)
	(이때 반환 값은 ResultSet으로 진행됨.)
	(next(), previous(), first(), last(), getString(), getInt()등등)
	statement.executeUpdate(); (SQL문 실행 후 테이블의 내용만 변경되는 경우)
	: SQL문의 결과값을 ResultSet객체로 받음.

4. 데이터베이스 연결 해제
		close()로 자원해제 해줌.


DAO - Data Access Object (DB로 접근하여 로직 수행하는 객체 코드의 모듈화, 유지보수의 효율성을 위해 사용.)
DTO - Data Transfer Object (데이터를 일반적인 변수가 아닌 데이터 클래스로 만들어 관리하기 위함. Bean말하는 건가?)
	DB에 입력하거나 출력할때 DTO로 일괄적으로 효율적으로 수행.

커넥션 풀(DBCP)
Client에서 다수의 요청이 들어올 경우 데이터베이스에 부하가 발생함.
이를 해결하기 위한 기법이 커넥션 풀.
미리 커넥션을 만들어 놓고 요청이 들어오면 사용하도록 하는 구조.

커넥션 풀을 사용하기 위해 context.xml을 META-INF에 삽입 하던가,(구조는 소스 참고.)
			Server패키지 속 context.cml에 코드 삽입

(이전에 할거 더 있다. 순차적으로 해야하지만 면접이 얼마 안남은 관계로 띄엄띄엄 한다.)

Spring - 프레임워크 = IOC컨테이너

의존 방법 2가지
1. A객체가 B,C객체를 직접 생성한다
	ex) new B(), new C()

2. B,C객체를 외부에서 생성하여 A객체에 넣어준다.
	필드에 b,c를 선언하고, setter로 객체를 주입받거나, 생성자의 매개변수로 받는다.(this.b이런식으로)
	ex) setter() or construct()

2번째 방법이 더 좋은 방법이다. 이것이 객체주입이다. = DI
이것이 부품화!

결국 스프링이란 부품을 조립하는 라이브러리 집합체하고 할 수 있다.
(인터페이스를 통한 부품화)

예시로 xml을 만들어 bean태그에 어쩌구 한다...










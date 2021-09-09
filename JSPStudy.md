여기부터 Study2패키지임!
Day1

프로토콜 : 네트워크상에서 약속한 통신규약 (Http, FTP, SMTP, POP, DHCP)
IP : 네트워크상에서 컴퓨터를 식별할 수 있는 주소
DNS : IP주소를 인간이 쉽게 외우도록 맵핑한 문자열
Port : IP주소가 컴퓨터를 식별할 수 있게 해준다면, Port번호는 해당 컴퓨터의 구동되고 있는 프로그램을 구분할 수 있는 번호

예시 http://www.test.com:80/index
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
: 클라이언트가 웹브라우저로 hi.jsp를 요청하면 JSP컨테이너가 JSP파일을 Servlet파일(.java)로 변환한다.
  그리고 Servlet파일(.java)은 컴파일 된 후 클래스 파일(.class)로 변환되고, 요청한 클라이언트에게 html파일 형태로 응답.

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


Day4

Servlet 초기화 파라미터 : ServletConfig
 : 특정 Servlet이 생성될때 초기에 필요한 데이터(초기화 파라미터)를 web.xml에 기술하여 사용.(Servlet에 직접 사용해도 ㅇㅋ)

  	<init-param>	<!-- 여기서 초기화 파라미터 값을 입력해줄 수 있다. -->
  		<param-name>id</param-name>
  		<param-value>qwe</param-value>
  	</init-param>	
이런식으로 맵핑할 때 넣어준다.

또 다른 한가지 방식은 Servlet에서 직접 기술하여 사용하는 방식이다.(서블릿 맵핑하는 곳에 있다.)
@WebServlet(urlPatterns = {"/Param2"}, initParams = {@WebInitParam(name = "id", value = "qwer"),
					@WebInitParam(name = "pw", value = "qwe1234")})
이런식으로 어노테이션을 활용하여 InitParam을 입력한다.


또한 특정 Servlet이 아닌 여러 Servlet이 공유하는 방식도 있다 : ServletContext
web.xml에 기술하고 Servlet에서 가져가 사용한다.


웹 어플리케이션 생명주기를 감시하는 리스너가 있다.
클래스를 만들어 ServletContextListener을 구현(implement)하고 재정의 하면 된다.
시작과 종료시에 호출된다.
그리고 web.xml에
	<listener>
		<listener-class>com.javalec.ex.서블릿이름</listener-class>
	</listener>
이렇게 서블릿 적어주면 끝.(console에 나온다.)


JSP태그 종류
1. 지시자 : <%@	%> : 페이지 속성(import같은 것 할때)
2. 주석 : <%--	--%> : 주석
3. 선언 : <%!	%> : 변수, 메소드 선언
4. 표현식 : <%=	%> : 결과값 출렷
5. 스크립트릿 : <%	%> : 자바코드
6. 액션태그 : <jsp:action>	</jsp:action> : 자바빈 연결
html의 주석은 페이지 소스보기 하면 볼 수 있다.(jsp주석은 안보임)


JSP의 내부객체
객체를 생성할 필요 없이 바로 사용가능한 객체가 내부객체이다.
(Servlet으로 변환될때 JSP컨테이너가 자동으로 객체 생성해줌)
종류
1. 입출력 객체 : request, response, out
2. 서블릿 객체 : page, config
3. 세션 객체 : session
4. 예외 객체 : exception


Day5

response
response는 내부객체.(jsp내에서 따로 객체생성 할 필요x)
sendRedirect객체가 자주 쓰인다.(데이터와 함께 페이지 이동 가능하게 해주는.)
(?뒤로 데이터를 넘길때 request.getParameter로 받았는데 null이 나왔다...)

액션태그란?
JSP내에서 어떤 동작을 하도록 지시하는 태그.(페이지 이동, 페이지 include등)
1. forward를 사용하면 주소는 그대로 유지하되 페이지 view만 이동한다.
2. include방식을 지시자태그가 아닌 액션태그를 통해서도 활용할 수 있다.
3. forward안에 param태그를 삽입하여 데이터를 넘기는 방식도 있다.

쿠키란?
웹브라우저에서 서버로 어떤 데이터를 요청하면, 서버측에서는 알맞은 로직은 수행한 후 데이터를 웹브라우저에 응답함.
그리고 서버는 웹브라우저와의 관계를 종료한다. -> http프로토콜의 특징임.
이때 연결이 끊겼을때 어떤 정보를 지속적으로 유지하기 위한 수단으로 '쿠키'라는 방식을 사용함.
쿠키는 서버에서 생성하여, 서버가 아닌 클라이언트측에 특정 정보를 저장함. 
그리고 서버에 요청 할 때마다 쿠키의 속성값을 참조, 변경 할 수 있음.

쿠키생성 -> setter로 설정 -> response객체에 쿠키 탑재.(response.addCookie())
유효기간 설정, 쿠키 값 설정, 버전 설정, 등등의 여러 메소드가 있음.


Day6

쿠키객체에 이름,벨류를 넣고, 유지시간을 설정한 뒤 response에 삽입, 다음 request에서 받음.

세션이란?
세션 또한 쿠키와 마찬가지로 서버와의 관계를 유지하는 수단임.
단, 쿠키와 달리 클라이언트측에 특정정보를 저장하는게 아닌, 서버상에 객체로 존재함.
따라서 세션은 서버에서만 접근이 가능하며, 보안이 좋고, 데이터의 한계가 없다.
세션은 내부객체.

클라이언트의 요청 -> session자동 생성 -> session속성 설정.
(아파치 폴더 내부에 web.xml에 기본 세션 유지시간이 30분으로 지정되어 있다.)
setAttribute(), getAttribute()등 여러 메소드가 있다.

이때 get은 Object로 받고 적절히 캐스팅하여 사용한다.
(Enumeration이라는 객체도 사용해봤다.)


JSP내의 예외처리

1. page지시자를 통한 예외처리

//에러난 경우 해당 페이지로 이동
<%@ page errorPage = "errorPage.jsp" %>

//에러페이지 표시.
<%@ page isErrorPage = "true" %> (기본값이 false로 되어있기 때문에 반드시 명시를 해야함.)
true로 명시하면 exception.getMessage()등의 메소드 사용 가능.
response.setStatus(200); -> 오류번호 200 = 정상적인 페이지라는 뜻.(500번이나 404 생각하면 된다)

2. web.xml파일을 이용한 예외처리
<error-page>
  <error-code>404</error-code>
  <location>/error404.jsp</location>
</error-page>
<error-page>
  <error-code>500</error-code>
  <location>/error500.jsp</location>
</error-page>

이런식으로 지정하면 된다.
마찬가지로 오류페이지에
<%@ page isErrorPage = "true" %> 
<% response.setStatus(200); %>이렇게 명시를 해야한다.


Day7

빈이란 - 반복적인 작업을 효율적으로 하기 위한, 데이터 속성과 기능,메소드로 이루어진 클래스

빈 관련 액션태그
//특정 Bean을 사용한다고 명시할때 사용하는 액션태그
<jsp:useBean id = "student" class = "com.javalec.ex.Student" scope = "page" />
	             빈 이름		클래스 이름	    스코프 범위

//데이터 값을 설정 할 때 사용하는 액션태그
<jsp:setProperty name = "student" property = "name" value = "홍길동" />
		빈 이름		속성 이름		value

//데이터 값을 받아올 때 사용하는 액션태그
<jsp:getProperty name = "student" property = "name"/>
		        빈 이름	      속성 이름	

스코프 종류
1. page : 생선된 페이지 내에서만 사용 가능.
2. request : 요청된 페이지 내에서만 사용 가능
3. session : 웹브라우저의 생명주기와 동일하게 사용 가능.
4. application ; 웹 어플리케이션 생명주기와 동일하게 사용 가능.


DBMS : DataBase Management System
이때 오라클은 RDBMS(Relational DBMS)

사용할 DB테이블

//테이블 생성
create table STUDYMEMBER(
S_ID varchar2(20) not null primary key,
S_PW varchar2(20),
S_AGE number
);

//컬럼 추가
alter table STUDYMEMBER add(S_NAME varchar2(20));

//데이터 입력
insert into STUDYMEMBER values('qwe','qwe123',24,'동준영);


JDBC란?
: JAVA프로그램에서 SQL문을 실행하여 데이터를 관리하기 위한 JAVA API임.
우리는 Oracle을 사용하므로, 오라클의 JDBC를 사용.(오라클 설치시 자동으로 설치됨)


이클립스에 JDBC연결
window -> preference -> java -> build path -> classpath variable -> JRE_LIB폴더 위치 찾기
이 폴더에 ext가 있다.(외부 라이브러리를 저장하는 곳.) 이곳에 JDBC를 삽입!
(각각의 프로젝트 lib폴더에 삽입해도 된다..)


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
	statement.executeQuery(); (SQL문 실행 후 리턴값이 있는경우) ex)select
	(이때 반환 값은 ResultSet으로 진행됨.)
	(next(), previous(), first(), last(), getString(), getInt()등등)
	statement.executeUpdate(); (SQL문 실행 후 테이블의 내용만 변경되는 경우) ex)insert, delete, update등
	: SQL문의 결과값을 ResultSet객체로 받음. (반환값이 int형임.)

4. 데이터베이스 연결 해제
		close()로 자원해제 해줌.

DB관련 코드는 예외가 발생할 수 있으므로 try catch로 감싸준다.
그 후 finally로 자원 해제까지.

Tip - "The local variable '변수명' may not have been initialized"이런 오류가 나는 것은 선언만 하고 값이 할당되지 않았기 때문!


Day8

원초적 회원가입 틀 만들어보기.
다이어그램 만듬. 찍어서 올리기
opgg용 이력서, 포트폴리오 만들기
넥슨용 이력서, 포트폴리오. - 엔지니어 부문.
https://www.saramin.co.kr/zf_user/jobs/relay/view?isMypage=no&rec_idx=40993808&recommend_ids=
eJxNz8sRxDAIA9Bq9g4YkDinkPTfxeJMYvv4RiM%2Bo4AK6k3NHy6XChfGZhqBpkyqKDTyptWTpnrK0XUtbL
KGYXzsbiRidRnDvEepvcyiN9%2B02xVHCiOb4yHonSwmRS0WmY6R6wx4b8rjQfZT%2B0gXmR99k82Re1GR6jXP
%2BANw10Bb&view_type=search&searchword=%EC%98%A4%ED%94%BC%EC%A7%80%EC%A7%80&searchType=s
earch&gz=1&t_ref_content=generic&t_ref=search&paid_fl=n#seq=0

Day9

DAO - Data Access Object (DB로 접근하여 로직 수행하는 객체 코드의 모듈화, 유지보수의 효율성을 위해 사용.)
	-DB접근은 모두 DAO로 일괄 사용.
DTO - Data Transfer Object (데이터를 일반적인 변수가 아닌 데이터 클래스로 만들어 관리하기 위함. Bean말하는 건가?)
	-Bean역할.

PreparedStatement - 기존의 Statement의 중복코드를 완화해줌. '?'를 통해서! 예제확인.


커넥션 풀(DBCP)
Client에서 다수의 요청이 들어올 경우 데이터베이스에 부하가 발생함.
이를 해결하기 위한 기법이 커넥션 풀.
미리 커넥션을 만들어 놓고 요청이 들어오면 사용하도록 하는 구조.

커넥션 풀을 사용하기 위해 context.xml을 META-INF에 삽입 하던가,(구조는 소스 참고.)
			Server패키지 속 context.cml에 코드 삽입

DTO, DAO를 활용한, 커넥션풀을 사용한 간단한 프로젝트
 - dao, dto, jsp
추가된 객체 종류
DataSource, Context, InitialContext


Day10

DTO, DAO, PreparedStatement를 활용한 회원가입	회원가입 인증추가.

//테이블 생성
create table STUDYMEMBER2 (
id varchar2(20) not null primary key,
pw varchar2(20),
name varchar2(20),
email varchar2(30),
rdate date,
address varchar2(50)
);

DAO 입출력시 반환값을 final 상수를 통해 관리하기 쉽도록.
싱글톤을 활용. DAO생성자를 변수로 가져옴.


Day11

파일 업로드 라이브러리
www.servlets.com에서 cos.jar파일 다운(이것이 라이브러리다)
form 부분에 enctype = "multipart/form-data" 이것 넣어줘야함. why? - 인코딩의 형식이다.
파일 올리는 태그 <input type = "file">
이클립스에서 fileFolder폴더를 만들어 이 경로를 적어주지만, 
실제 저장되는 fileFolder는 아파치 톰캣 폴더 내부에 있다.
(C:\Program Files\Apache Software Foundation\Tomcat 9.0\wtpwebapps\study2\fileFolder) - 실제 경로

EL(Expresstion Language)
 : 표현식 또는 액션 태그를 개신해서 값을 표현하는 언어.
ex) 표현식 -  <%= value %>
     EL       -  ${ value }

ex) <jsp:getProperty name = "member" property = "name"/>
  -> ${member.name}

ex) String id = request.getParameter("id");
  -> ${param.id} or ${param["id"]}

내장객체로 param, paramValue, initParam, cookie,
	pageScope, requestScope, sessionScope, applicationScope등이 있다.

JSTL
 : JSP의 경우 HTML 태그와 같이 사용되어 전체적인 코드의 가독성이 떨어짐.
  이 단점을 보완하고자 만들어진 태그 라이브러리가 JSTL.
  따로 설치를 해야함. 설치후 아파치의 lib에 삽입.

JSTL은 다섯 가지의 라이브러리를 제공함.
Core, XML Processing, formatting, SQL, Function)

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
이것을 명시하고 c로 시작하면서 태그 사용하면 된다.(Core사용 예시)


Day12

url-pattern

1. 디렉토리 패턴 - 디렉토리 형태로 서버의 해당 컴포넌트(서블릿)을 찾아서 실행하는 구조
//그동안 해오던 패턴. 여러개의 서블릿이 존재

2. 확장자 형태로 서버의 해당 컴포넌트를 찾아 실행하는 구조.(동일한 서블릿으로 간다.)
//새로운 패턴. 하나의 서블릿으로 통일.

FrontController - 클라이언트의 다양한 요청을 한곳으로 집중시킴.(개발, 유지보수 효율성)
구분하는 방식
요청의 URI를 받아온다.	request.getRequestURI();	풀URI
요청의 부분 Path를 받아온다	request.getContextPath();	뒷부분 제외 URI
풀URI에서 Path를 subString한다.
그것으로 구분하여 서블릿이 적절히 배치한다.

이때 FrontController가 if(command.equals(어쩌구))이런식으로 하면 코드가 방대해진다.
이를 방지하기 위해 interface를 사용한다.

추상메소드 excute가 있는 interface를 만들고
각각 기능이 다른 클래스들을 만들어 interface를 구현한다.(클래스에서 dao접근)
객체타입이 같으므로 FrontController에서 통일하여 사용할 수 있다.










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








사용 라이브러리 정리
ojdbc.jar - 오라클 jdbc라이브러리
cos.jar - 파일 업로드 라이브러리
jstl.jar / standard.jar - JSTL태그 라이브러리

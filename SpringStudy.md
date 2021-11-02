Day1(SpringStudy1)

마켓 플레이스에서 sts검색 후 설치
우측 상단에서 open perspective에서 spring으로 변경했음.

Spring - 프레임워크 = IOC컨테이너

의존 방법 2가지
1. A객체가 B,C객체를 직접 생성한다
	ex) new B(), new C()

2. B,C객체를 외부에서 생성하여 A객체에 넣어준다.
	필드에 b,c를 선언하고, setter로 객체를 주입받거나, 생성자의 매개변수로 받는다.(this.b이런식으로)
	ex) setter() or construct()

2번째 방법이 더 좋은 방법이다. 이것이 객체주입이다. = DI(Dependency Injection)
이것이 부품화!

결국 스프링이란 부품을 조립하는 라이브러리 집합체라고 할 수 있다.
(인터페이스를 통한 부품화)

xml에서 객체를 생성한 뒤 xml에서 객체를 주입해준다.
ex) <bean id = "calculator" class = "com.javalec.ex.Calculator"/> - 이게 생성
	<property>태그로 필드값 조정 가능 
		property를 통해 값 입력시 setter,getter,필드명이 property의 name값과 같아야한다!
	<ref>태그로 객체 주입 가능

xml생성과정 - new -> spring검색 -> spring bean configuration file(이것이 xml임)
src/main/resource에 만든다.


Day2(SpringStudy1)

xml에서 setter를 통한 주입 - property
          생성자를 통한 주입 - constructor-args

활용방법으로 
//xml
<bean id = "pencil" class = "com.javalec.ex.Pensil4B"/> 이렇게 xml을 설정하고
//MainClass
pencil pencil = ctx.getBean("pencil",Pencil.class);		이렇게 class를 설정 했을때
이 class를 수정하지 않고 Pensil4B가 아닌 다른 클래스를 주입받고 싶으면(Pencil6B,Pencil6BWhithEraser 등)
이 각각 다른 클래스들을 Pencil이라는 인터페이스로 묶으면 다른 클래스라고 하더라도 객체 타입이 같으므로
xml에서 bean의 class주소값만 변경해주면 된다.

xml의 Namespaces사용법 - xml우클릭 -> open with -> spring config editor선택. 그럼 사용 가능한 Namespaces를 지정할 수 있다.
bean값에 Namespaces를 사용하면 생성자는 c:필드명=""이런식으로, setter는 p:필드명=""이런식으로 입력 가능.
생성자가 여러개 있을때 한개만 Namespaces를 사용하는 것은 안된다. 할거면 전부 사용, 아니면 전부 미사용.

GenericXmlApplicationContext이 파라미터에 여러개의 xml파일을 입력해도 된다.(단 bean의 id값이 달라야하지 않을까?)

A는 xml을 통해 a객체를 주입받고, B는 xml에서 ref를 통해 a를 받은 b의 객체를 주입 받은 뒤 getter를 통해 a를 받는다
이때 A와 B는 같은 객체인가? 맞다. 같은 객체이다.

DI방법은 xml뿐 아니라 java코드로도 가능하다. annotation을 통해서 그리고 두개를 결합시켜 해도 가능하다.

Java코드를 통한 DI설정방법
class위에 @Configuration 어노테이션을 붙인다.
Bean객체 생성시 메소드 형태를 만들고 그 위에 @Bean 어노테이션을 붙인다.
(이때 메소드 형태에서 리턴타입은 해당 bean타입, 메소드명은 bean의 id값을 명시한다.)
나머지는 자바코드와 동일.

이를 사용하기 위해서는 pom.xml에 의존성을 추가해야 하는데,
개발자는 프로젝트에 사용할 라이브러리를 pom.xml에 dependency로 정의만 해두면 
메이븐이 repository에서 검색해서 자동으로 추가해준다. 심지어 참조하고있는 library까지 모두 찾아서 추가해준다. 
이것을 '의존성 전이' 라고 한다
이 dependency는 https://mvnrepository.com/ 여기서 버전을 확인 할 수 있다.


Day3(SpringStudy1)

xml과 java DI 같이 사용하기
1. xml파일에 java DI를 포함시키는 방법
	xml에 <context:annotation-config /> 이 태그 포함하여 
	해당 클래스 <bean class="com.asd.asd"/> 이렇게 넣으면 포함시킬 수 있음

2. 반대로 java파일에 xml 포함 시키는방법
	해당 클래스에 어노테이션 추가
	@ImportResource("classpath:applicationCTX.xml")

스프링 빈 생명주기 관리
1. 인터페이스 구현
implements InitializingBean, DisposableBean
-> 빈 초기화 과정에서 호출되는 메소드, 빈 소멸 과정에서 호출되는 메소드 사용가능.
2. 어노테이션 사용(의존성 추가해줘야 한다. annotation)
@PostConstruct - 빈 초기화 과정에서 호출(메소드명은 사용자 정의)
@PreDestroy - 빈 소멸시 호출


스프링 빈 범위(Scope)
빈은 scope를 가지고 있다. 해당 객체가 어디까지 영향을 미치는지 결정하는 것.
싱글톤: 기본 스코프, 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프이다.
프로토타입: 스프링 컨테이너는 프로토타입 빈의 생성과 의존관계 주입까지만 관여하고 
	더는 관리하지 않는 매우 짧은 범위의 스코프이다 (따라서 빈 콜백중 종료메서드가 호출이 안된다.)

(웹도 스코프가 있었지?)
request: 웹 요청이 들어오고 나갈때 까지 유지되는 스코프이다.
session: 웹 세션이 생성되고 종료될 때 까지 유지되는 스코프이다.
application: 웹의 서블릿 컨텍스와 같은 범위로 유지되는 스코프이다


Environment
여러 환경들을 제어하고 설정하는 기능.
내포되어 있는 property를 사용한다.
 -property생성, 추가, 추출 등을 할 수 있다.
 == 마치 저장소 느낌인듯 하다.

Day33패키지 부분 총정리(SpringStudy1)
main에서 env생성 -> 가져오기 -> 외부 파일을 env에 proeprty로 입력 -> 이를 다른 xml객체에 입력
-> 입력 당한 bean클래스에서 EnvironmentAware 구현 -> env입력 강제 오버라이딩
-> InitializingBean의 오버라이딩 메소드에서 env의 개별 property가져옴(이때 xml에서 value를 입력하지 않는다)

Environment의 도움없이 xml이나 java DI를 통해 properties(외부파일)을 가져올 수 있다.
//xml
	먼저 Namespaces에서 context를 입력한다.
	<context:property-placeholder location = "classpath:admin.properties, classpath:sub_admin.properties"/>
	이렇게 넣고 value는 ${admin.id} 이렇게 EL로 뽑는다.

//java DI
	@Bean어노테이션 아래에 public static PropertySouecesPlaceHolderConfigurer Properties()메소드를 만든다
	Resource객체를 배열로 선언하여 new ClassPathResource로 외부파일을 넣고 입력한다.


개발환경 or 실제 납풉코드 이둘을 나누어 관리할 필요가 있다.
이때 필요한 profile - 이또한 xml과 java Di방법이 나뉜다. 
//xml
	schemaLocation부분에 profile = "profile명 기입" 입력해주면 된다.
	그리고 main딴에서는 ctx.getEnvironment().setActiveProfiles("이곳에 profile명 기입");
	그리고 ctx.load();하면 된다.

//java DI
	간단하게 annotation @Profile("profile명 기입")하면 된다

지금까지
GenericXmlApplicationContext객체 아니면 AbstractApplicationContext객체를 사용하여 config파일을 사용했는데,
xml을 사용하면 GenericXmlApplicationContext객체가 불가피하고, java로만 하려면 AbstractApplicationContext객체로 충분.
GenericXmlApplicationContext객체가 AbstractApplicationContext객체의 하위 객체이다.
(물론 데이터 타입으로서 AbstractApplicationContext가 대신해도 괜찮다. 상위객체이기 때문.)


Day4(SpringAop)
AOP란(Aspect Oriented Programming)(관점 지향 프로그래밍)
상속을 통한 방법에 한계가 있어 등장.(다중상속 불가, 핵심기능 코드와 공통기능 코드가 섞여 있음.)
공통 기능과 핵심 기능을 분리시키고, 공통기능 중 필요 부분을 핵심 부분에 적용하는 것.

관련 용어
Aspect : 공통 기능
Advice : Aspect의 기능 자체
Jointpoint : Advice를 적용해야 되는 부분(ex 필드, 메소드)(스프링에서는 메소드만 해당)
Pointcut : Jointpoint의 부분으로 실제로 Advice가 적용된 부분
Weaving : Advice를 핵심 기능에 적용 하는 행위

AOP구현을 위해 proxy를 사용함.(==대신한다는 뜻)
ex) 공통로직이 핵심로직의 시작,종료부분에 실행되어야 한다면,
proxy를 거쳐 공통로직이 실행 -> 핵심기능 실행 -> 다시 proxy를 거쳐 공통로직 실행
이런식으로 proxy를 거친다.

작업 순서
1. 의존 설정(pom.xml)
2. 공통 기능의 클래스 제작(Advice역할)
3. XML파일에 Aspect 설정(Namespaces에서 aop입력)
(pom.xml에 설정한 라이브러리는 Maven Dependencies에 jar파일로 존재한다.)

Advice종류
1. <aop:before> : 메소드 실행 전에 advice실행
2. <aop:after-returning> : 정상적으로 메소드 실행 후에 advice실행
3. <aop:after-throwing> : 메소드 실행 중 exception발생시 advice실행
4. <aop:after> : 메소드 실행 중 exception이 발생하더라도 advice실행
5. <aop:around> : 메소드 실행 전/후 및 exception 발생시 advice실행 


Day5(SpringAop2)
@Aspect를 사용한 AOP구현

순서
0. pom.xml설정(cglib,org.aspectj)
1. @Aspect를 이용한 Aspect클래스 제작
2. xml에 프록시 설정(<aop:aspectj-autoproxy />)

Aspect Pointcut에는 종류가 상당히 많다.(모두 메소드가 기준이다!)
//execution(세부적)
@Pointcut("execution(public void get*(..))")
	//public void인 모든 get메소드
@Pointcut("execution(* com.javalec.ex.*.*())")
	//com.javalec.ex 패키지에 파라미터가 없는 모든 메소드
@Pointcut("execution(* com.javalec.ex..*.*())")
	//com.javalec.ex 패키지 & com.javalec.ex 하위 패키지에 파라미터가 없는 모든 메소드
@Pointcut("execution(* com.javalec.ex.Worker.*())")
	//com.javalec.ex.Worker 안의 모든 메소드

//within(포괄적)
@Pointcut("within(com.javalec.ex.*")
	//com.javalec.ex 패키지 안에 있는 모든 메소드
@Pointcut("within(com.javalec.ex..*")
	//com.javalec.ex 패키지 및 하위 패키지 안에 있는 모든 메소드
@Pointcut("within(com.javalec.ex.Worker")
	//con.or.sl.Worker의 모든 메소드
@Pointcut("within(com.javalec.ex.*)")	
	//com.javalec.ex의 모든 메소드
	
//bean
@Pointcut("bean(student)")
	//student 빈에만 적용 (얘가 빈인것은 xml이 지정해주고 있음)
@Pointcut("bean(*ker)")
	//~ker로 끝나는 빈에만 적용


Day6(Spring_basic)
Spring MVC게시판 만들때, 패키지 com.javalec.spring_project
이때 spring_project부분이 이 프로젝트의 context명이다.
(이는 Servers폴더의 server파일을 열어 확인 할 수 있다.)
(최초로 Spring 프로젝트를 실행하면
http://localhost:8181/spring_pjt/WEB-INF/classes/com/javalec/spring_pjt/HomeController.java
이런 주소로 서버가 실행이 되는데, 이때 spring_pjt이부분이 context부분이다.)

폴더구조
1. view폴더의 위치(JSP파일 저장.)
	src/webapp/WEB-INF/views
2. web.xml의 위치(맵핑 등 관리, servlert-context위치 정의)
	src/webapp/WEB-INF
3. servlert-context파일 위치(여기서 view페이지 경로 설정, 스프링 컨테이너 설정
	src/webapp/WEB-INF/spring/appServlet
4. 이미지등의 파일 위치(이를 불러올때 context주소를 포함시켜야함. ex) /spring_project/resources/qwe.png)
	src/webapp/resources(resources말고 다른 폴더를 만들경우 servlet-context에서 설정)

맵핑 구조
web.xml에서 url패턴 확인 -> param-value를 통해 servlet-context로 이동
-> servlet-context가 설정해 놓은 패키지 탐색.

인코딩 방식을 web.xml에 설정을 해야한다.

Controller생성 - 클래스에 @Controller 어노테이션을 붙여주면 끝.
맵핑 - @RequestMapping 어노테이션을 붙여주면 끝.(메소드 형태가 와야함.)
	이때 기본,Model,ModelAndView가 있음. 
	Model은 데이터만 담고있음.(반환값이 view경로)
	ModelAndView는 데이터와 view의 정보를 담고있음.(반환값이 객체)(Model에 비해 기능이 다양)
	
	클래스 자체에 RequestMapping 어노테이션을 붙이면, 경로의 기본값이 된다.
	
(톰캣이 실행 안되고 Could not publish server configuration for Tomcat v9.0 Server at localhost. 이 에러가 뜰때.)
서버의 Web Modules에서 지우고 다시 하면 됨.


Day7(Spring_Form)

데이터 처리 방법(모두 get방식으로 데이터 입력하는데, 이때 get방식의 인코딩 해야함.)
1. HttpServletRequest클래스 - Controller에 데이터를 받아오는 역할(Model객체 사용)
	마치 JSP의 request,response == HttpServletRequest,Model 이렇게 대응되는듯 하다.

2. @RequestParam어노테이션 사용.(Model객체 사용)
	(요청 받는 데이터가 많아질 경우 코드량이 많아짐)

3. 데이터 클래스 사용(Model객체 필요 없음, 따로set,get과정을 안해도 됨) 개사기인듯 하다.
	(코드량 간소화 가능)
	이때 @ModelAttribute 어노테이션을 활용하면 커멘드 객체의 이름(데이터 클래스)을 사용자 정의하여 사용가능 하다.
	@ModelAttribute를 사용해 바꾼 이름을 jsp에서 그대로 사용할 수 있다.	

4. @PathVariable사용 - Mapping경로 안에 넣어 사용.(Model객체 사용)
	url경로에 "?key=value" 이런식이 아닌 "경로/value" 이렇게 마치 경로처럼 데이터를 입력함.

@RequestMapping에서의 get방식, post방식
ex) @RequestMapping(method = RequestMethod.GET, value = "/student")
	이때 method가 요청방식, value가 경로
	jsp의 form태그의 method요청방식과 같아야한다.
	get - url에 데이터를 포함시켜 요청
	post - 파일의 헤더에 포함시켜 요청
	++(form태그를 사용할때 Controller에서 request를 받을땐 jsp에서 무조건 name값으로 받는다)
	get과 post를 같이 사용하고 싶을땐 메소드명이 같아도 하나는 Model, 하나는 ModelAndView를 사용하면 됨.(리턴타입이 다르기 때문)

redirect통한 페이지 이동

Day8

기존에 javascript로 했던 유효성 검사는 client측에서 하는것이였다.
이를 server측에서 하는방법

맵핑 메소드 파라미터에 데이터 클래스와 BindingResult클래스 삽입.
유효성 검사를 하는 클래스를 제작하고 그 클래스를 맵핑클래스에서 객체생성.
(유효성 검사를 하는 클래스는 Validator 인터페이스를 구현하고 있음)
(유효성 검사하는 클래스는 에러가 있을경우 Errors객체를 result에 넣어줌)
Validator인터페이스를 사용할때 validate메소드 말고 ValidationUtils의 간편한 클래스도 있다..

맵핑 메소드에서 유효성 검사를 하는 클래스를 직접 생성하지 않고 Spring으로 부터 호출하는 방법
==@Vaild or @Validated, @InitBinder(의존 추가 해야됨)

@@@@@@
[Oracle] ORA-28001 오라클 패스워드 만료오류시
cml창에 sqlplus 들어가서 아이디 비밀번호 입력 누르고 재생성 하면 된다.

MVC패턴 게시판 만들기 준비과정
//테이블 생성
create table STUDY_Spring_BOARD(
bId number(4) primary key,
bName varchar2(20),
bTitle varchar2(100),
bContent varchar2(300),
bDate date default sysdate,
bHit number(4) default 0,
bGroup number(4),
bStep number(4),
bIndent number(4)
);
//시퀀스 생성
create sequence STUDY_Spring_BOARD_seq;
//더미 데이터
Dummy Data
insert into STUDY_Spring_BOARD (bId, bName, bTitle, bContent, bHit, bGroup,bStep, bIndent)
values (STUDY_Spring_BOARD_seq.nextval, 'abcd', 'is title', 'is content', 0, STUDY_Spring_BOARD_seq.currval, 0, 0);

1. indent = list에 나오는 -이다(몇단계의 답변인지 알게해주는)
2. 최신 글이 위로 나오게 하도록 해주는 놈이 step.
	답변을 달게되면 답변달 글(해당글이라 지칭)보다 step이 1증가. 
	그리고 해당글보다 step이 높은 애들 step이 1증가
	한글의 답변들은 모두 group이 같다. 
	group으로 묶어 놓고 indent로 답변 계단 구분하고
	step으로 최신글을 위로 올라오게 한다.(최신 일수록 step이 적음.)
	답변을 달면 달수록 원래 존재하던 답변들의 step이 증가함.

Day9,Day10
Controller맵핑 작업
Command 구조파악
Dto,Dao생성

dto소스입력
dao list부분 입력.
list.jsp생성

write부분 작성 완료
(db사용시 spring은 따로 jdbc라이브러리를 넣지 않았다.
우리는 톰캣폴더 ilb폴더 안에 jdbc를 넣어두었고, db접속시 server의 context를 거치기 때문에 tomcat이 알아서 연결 해주는 것 같다.)
(이방법 말고 직접 pom.xml에 oracle의 jdbc라이브러리를 넣을 수 있다.)

(게시판 부분 구현 후 회원가입을 따로 넣자.)
UI도 직접 넣은 뒤 포트폴리오에 넣기
다음 Spring boot or node.js or android or swift or another

Day11
JDBC Template을 사용하지 않은 Spring MVC 게시판 완성.

DAO부분에서 커넥션풀 가져오고, db접속하고, 입력하고, result가져오고 이런 부분들이 반복됨.
이 반복을 줄이기 위해 Spring Bean사용

순서
1. jdbc의존성 추가
2. controller 필드에 JdbcTeplate변수 생성
3. controller에 2번 변수의 setter생성(이때 이 setter는 @Autowired 어노테이션 붙음)
4. servlet-context.xml에 빈 생성(84강 15:32부분 참고)
5. 패키지 생성(util)후 클래스 이름 Constant생성 후 static변수 JdbcTemplate생성
6. 3번의 setter에서 5번의 static변수 가져옴
7. 이후 Dao에서 미친듯이 반복코드를 줄일 수 있다.

Day12
JdbcTemplate를 활용한 Spring게시판 만들기 과정.
Dao수정중


Day13
처음부터 끝까지 스스로 게시판만들기

개발환경 setting
1. web.xml에 한글 인코딩
	<!-- 한글 인코딩 -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>
			org.springframework.web.filter.CharacterEncodingFilter
		</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

2. pom.xml에 jdbcTemplate의존성 추가
	<!-- jdbcTemplate -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-jdbc</artifactId>
		<version>${org.springframework-version}</version>
	</dependency>

3. servlet-context에 dataSource및 template빈 생성 - 객체주입
	<beans:bean name = "dataSource" class = "org.springframework.jdbc.datasource.DriverManagerDataSource">
		<beans:property name="driverClassName" value = "oracle.jdbc.driver.OracleDriver"/>
		<beans:property name="url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
		<beans:property name="username" value = "hr"/>
		<beans:property name="password" value = "1234"/>
	</beans:bean>
	
	<beans:bean name = "template" class = "org.springframework.jdbc.core.JdbcTemplate">
		<beans:property name="dataSource" ref="dataSource"/>
	</beans:bean>


Day14,15
MEMBER테이블 생성, Member부분 작업

create table S_MEMBER(
m_Id varchar2(12) primary key,
m_Pwd varchar2(12),
m_Email varchar2(50),
m_Name varchar2(20),
m_Num1 number(6),
m_Num2 number(7),
m_Intro varchar2(100),
m_Date timestamp
)


Day16
사용자 정보확인 페이지 구성
main.jsp에서 만약 session값이 없으면 로그인 페이지로 돌아가도록 설정해야함.


Day17
memberInfoUpdate부분 수정
개인정보 수정은 비밀번호 / 메일 / 자기소개부분만 수정가능
회원탈퇴 해야함
관리자의 사용자 관리 페이지 작성

Board테이블 부분 - Member table에서 id를 외부키로 받아오고 / 이름도 받아오고 / 
			indent이런거 수정해서 답변을 게시글이 아닌 한줄의 답변으로 수정해보기


Day18
BOARD테이블 생성
create table S_BOARD(
b_Num number(4) primary key,
m_Id varchar2(12),
b_Title varchar2(100),
b_Content varchar2(2000),
b_Date date default sysdate,
b_Hit number(4) default 0,
b_Group number(4),
b_Step number(4),
b_Indent number(4),
constraint fk_mid foreign key(m_Id) references S_MEMBER(m_Id)
);
시퀀스
create sequence S_BOARD_seq;
더미
insert into S_BOARD(b_Num, m_Id, b_Title,b_Content,b_Hit,b_Group,b_Step,b_Indent)
values (S_BOARD_seq.nextval, 'qwer','is title', 'is content',0,S_BOARD_seq.currval,0,0);

ArrayList를 사용하는 이유는 동적배열, 데이터타입의 자유도 때문!


Day18
(ojdbc.jar파일 톰캣 폴더에 있는 상태로 하는중)
글자세히 보기 완료
a태그에서 파라미터 여러개 보낼때는 &사용
글 수정 수정중

Day19
수정부분 권한주는 부분 하는중


Day20
수정 권한부분 완료
수정 완료
삭제 완료
조회수 증가 완료


Day21
답변 달기
게시판 완료

여기부터 ㄱㄱ
모든과정 서술해보기
1. login.jsp
	최초의 화면. 로그아웃, 회원가입(redirect)을 하면 이 페이지로 이동
	스크립틀릿에 모든 세션을 삭제하는 로직 존재.
	아이디와 비밀번호를 입력하는 text가 있음
	로그인 버튼과 회원가입 버튼이 있음
2. join.jsp
	회원가입 버튼을 클릭하면 페이지 이동.
	js파일 적용(회원가입의 정규식 적용)
	정보 입력후 form태그를 통해 Controller -> HttpServletRequest -> Model
	-> command로 데이터 이동. command에서 Dao객체 생성하여 db로직수행
	template.update
3. MLoginCommand
	

이제 Spring boot에 대해 공부하기.
IntelliJ 알아보기.
이후Spring boot알아보기
이후 포트폴리오에 ERD, 구조 직접 써서, 설명란 따로 만들어서, 기간 입력하고 작성
유튜브에 업로드하기(손코딩 녹화)
aws적용하기



https://mvnrepository.com/ - 라이브러리 버전 확인
cglib - proxy객체 생성해주는 라이브러리
org.aspectj - aop사용 라이브러리
annotation - bean의 annnotation사용 라이브러리(생명주기때 사용했었음)
org.hibernate - 유효성 검사 호출시키는 라이브러리
cos.jar - 파일 업로드 관련
ojdbc - 오라클 jdbc
org.springframework/spring-jdbc - jdbctemplate사용하는 라이브러리

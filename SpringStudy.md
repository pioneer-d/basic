Day1

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


Day2

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


Day3

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

Day33패키지 부분 총정리
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


Day4
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


Day5
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


Day6
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


https://mvnrepository.com/ - 라이브러리 버전 확인
cglib - proxy객체 생성해주는 라이브러리
org.aspectj - aop사용 라이브러리
annotation - bean의 annnotation사용 라이브러리(생명주기때 사용했었음)
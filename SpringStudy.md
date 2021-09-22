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







https://mvnrepository.com/
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









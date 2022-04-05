코틀린

1. 함수관련 메인 함수 : fun main() { }
	함수 형태 : fun 함수명(매개변수명 : 매개변수 타입, 매개변수명 : 매개변수 타입) : 리턴 타입 { } 
	이때 자바의 void같이 리턴값이 없을 경우 Unit을 붙여줌. (생략도 무관)
	 fun compare2(a : Int, b : Int) : Int = if(a>b) a else b 이렇게 대괄호 생략도 가능

2. val vs var
	val은 value -> 불변 변수 
	val a : Int = 10 
	a = 15 (컴파일 에러!)

	var은 -> 가변 변수 
	var b : Int = 15 
	b = 16 (가능)
	
	참고로 데이터 타입을 기입하지 않아도 알아서 인식한다. 
	단, 선언과 동시에 초기화를 하지 않는 경우에는, 데이터 타입을 함께 명시해야함.

3. String Template val name = "test" println("my name is $name") -> $기호로 변수를 출력할 수 있다. 
	-> 여러 변수를 출력해야 할 경우 ${ } 괄호안에 입력하면 됨, 
	-> 온전히 $를 문자열로 사용하고 싶은경우 \로 escape.

4. when 
	마치 Java의 switch같은 조건문. 
	when (변수){ 
	해당1 -> 결과 
	해당2,해당3 -> 결과 
	in 해당4..해당100 -> 결과 
	else -> 결과 
	}
	-> 변수에 값을 입력할때에도 조건식으로 입력이 가능하다. (retuen이라고 생각.)

5. Expression vs Statement
	Expression : 무언가 연산을 하고, 출력을 하면 Expression
	Statement : 다른 무언가를 실행하거나 하면 Statement
	-> Kotlin의 모든 함수는 Expression으로 사용된다. (Unit이라도 return이 되기 때문)
	-> Java의 void는 Statement로 사용된다.
	-> 조건문 등도 Java에서는 Statement로만 사용이 가능한데,
	-> Kotlin에서는 Expression으로도 사용이 가능하다.

6. Array  vs  List
	Array는 크기가 지정되어 사용된다. (개수를 제외하고 수정이 가능)
		val array = arrayOf(1,2,3)

	List는 ImmutableList, mutableList로 나뉜다. (수정 유무 차이)
		val list = listOf(1, "b", 11L)
		이때 List는 immutable List로 수정이 불가하다..!
	
	Array와 List 둘다 알아서 타입이 추론이 되며, 원소에 타입이 다른 여러 원소가 들어와도 된다. (any type)
	
	ArrayList는 mutableList로 수정도 가능하다! (var, val 둘다 선언 가능)
		var arrayList = arrayListOf<타입>(초기화 해도 되고 안해도 되고. )
		arrayList.add(값)

7. 반복문
	val friend = arrayListOf("준영", "계환", "준모")
	
	ex) for(name in friend){
		println("${name}")
	}

	ex) for(i in 1..10){
		println("${i}")
	}

	괄호안에 step, downTo, until, withIndex 등등의 기능도 있음.

	while문은 자바와 동일.

8. NonNull / Nullable

	Nullable한 타입에 ?을 붙여줌. (런타임시 오류 발생 X)
	?: -> 마치 null exception처리 같음.

	반대로 Null일 가능성이 없는 것에는 !!를 붙여 런타임시 오류에서 벗어나도록 할 수 있다.

	관련된 함수 : let
	ex) var email : String? = "test@naver.com"
	email?.let{
		-> email이 null이 아닐경우 람다식으로 내부로 가져옴.
	}

9. Class (기본적으로 final 클래스임)
	Class 파일 명과 Class의 이름이 같지 않아도 된다..?!
	new연산자를 사용하지 않고 객체를 생성할 수 있다.

	생성자가 필요한 경우 클래스 우측에 constructor와 매개변수, 변수타입을 지정해주면 된다.
	(constructor를 생략하고 함수처럼 괄호안에 지정해도 무방! 마치 필드처럼 인식할것.)
	-> 이것이 주 생성자 이다.

	클래스 객체를 생성할때 최초로 실행시키고 싶은 것이 있으면 init()함수에 지정.
	-> 이것은 생성자에 준한다.

	추가로 클래스 내부에 constructor로 부 생성자를 만들 수 있는데,(매개변수가 다르거나 등등)
	-> 이것이 부 생성자이다.

	순서는 주 생성자 + init함수 -> 부 생성자 순으로 생성된다.
	(주 생성자 없이 부 생성자가 있다면, 부 -> 주로 대체하라고 런타임 환경에서 메세지가 나올 것임.)

	생성자의 역할은 필드 초기화, 필요 함수 호출이라고 볼 수 있는데,
	이때 주 생성자와 부 생성자는 초기화를, init함수는 함수 호출을 맡는다고 보면 되겠다.

	추가로 부 생성자는 주 생성자의 존재가 필연적이며, 파라미터 또한 맞춰줘야 하며, 
		사용하지 않는 파라미터는 기본값으로 제한한다.

	주, 부 생성자의 호출은 클래스 생성시 파라미터로 하는 것이겠다.


10. 상속
	Java -> ex) Class Korea{ }	Class NamYangJu Extends Korea { }
	Kotlin -> ex) open class Korea { }	class  NamYangJu : Korea { }

	Kotlin의 class는 기본적으로 final로 생성되기 때문에, 부모 class에 open을 붙여줘야함.
	추가로 자식 클래스에서 override하여 사용할 함수에도 open을 붙여줘야 재정의를 할 수 있음.








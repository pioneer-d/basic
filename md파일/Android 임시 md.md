코틀린

1. 함수관련
	메인 함수 : fun main() { }
	
	함수 형태 : fun 함수명(매개변수명 : 매개변수 타입, 매개변수명 : 매개변수 타입) : 리턴 타입 { }
		이때 자바의 void같이 리턴값이 없을 경우 Unit을 붙여줌. (생략도 무관)

		fun compare2(a : Int, b : Int) : Int = if(a>b) a else b 이렇게 대괄호 생략도 가능

2. val vs var

	val은 value -> 불변 변수
		val a : Int = 10
		a = 15 (컴파일 에러!)

	var은 -> 가변 변수
		var b : Int 15
		b = 16 (가능)

	참고로 데이터 타입을 기입하지 않아도 알아서 인식한다.
	단, 선언과 동시에 초기화를 하지 않는 경우에는, 데이터 타입을 함께 명시해야함.

3. String Template
	val name = "test"
	println("my name is $name")
	-> $기호로 변수를 출력할 수 있다.
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







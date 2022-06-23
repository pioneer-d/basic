package com.basic.kotlin_project.step_9_class

import java.lang.IllegalArgumentException

class KotlinPerson constructor(name : String, age : Int) {
    // 이때 constructor는 생략이 가능하고, (이 생성자가 primary 생성자)
    // 필드도 생성자 Parameter에 입력할 수 있다. (val name : String, var age : Int)
    // getter와 setter는 자동으로 생성해준다.
    val name = name;
    var age = age;

    //=============================================================

    // 생성자에서 로직을 추가하여 초기화하는 작업을 해야할 수 있는데,
    // 이때 사용하는 block이 init : 클래스 생성 시점에 한번 호출된다. (생성자 호출 시점.)

    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 0보다 작을 수 없음!")
        }
    }

    //=============================================================

    // 생성자가 여러개일 경우도 있는데,(생성자 오버로딩)
    // 이때는 constructor 함수를 사용함. (부생성자)
    // primary 생성자를 다시 호출하는 구조
    constructor(name: String) : this(name, 1)  // age의 기본값이 1인 생성자 오버로딩과 같은 로직.

    // 생성자는 역순으로 실행됨. (제일 마지막에 작성한 생성자를 호출해도 init -> 첫번째 부생성자 -> 두번째 부생성자.. -> 마지막 부생성자)
    // 부생성자 보다 default Parameter를 최대한 활용하는 것이 좋음

    //=============================================================

    // custom getter -> 종류가 많은데 몇가지만 정리..! (setter도 custom 가능)  사실상 많이 안씀.
    val isAdult: Boolean
        get() = this.age >= 20
        /*
        get(){
            return this.age >= 20
        }
        */

    // 필드 부분에서도 할 수 있다
    // val name : String = name;
    //  get() = filed.uppercase()   // uppercase() = 대문자화
    //  get() = name.uppercase() 이렇게 사용하면 무한 루프임...

}
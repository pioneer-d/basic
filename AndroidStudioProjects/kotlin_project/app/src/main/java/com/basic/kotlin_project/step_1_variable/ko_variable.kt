package com.basic.kotlin_project.step_1_variable

    fun main(){

    var number1 = 10L // == var number1: Long = 10L
    val number2 = 10L
    // -> 이 둘의 차이는 가변인가 불변인가.


    var number3: Long = 1_000L
    // number3 = null
    // 기본적으로 모든 변수는 null이 될 수 없도록 설정이 되어 있음.
    var number4 : Long? = 1_000L
    number4 = null
    // nullable 하기위해 타입뒤에 ?을 붙여준다


    //코틀린은 primitive type과 reference type을 알아서 판단해줌
    // == box, unboxing 고려하지 않아도 됨.


    var person = Person("동준영")
    //코틀린은 객체생성할때 new 키워드를 사용하지 않는다다

    }
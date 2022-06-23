package com.basic.kotlin_project.step_4_operator

import com.basic.kotlin_project.step_1_variable.Person

    // reference가 같은지 확인하는 연산자
    // ===

    // value가 같은지 확인하는 연산자
    // ==

    var person1 = Person("동준영")
    var person2 = Person("동준영")
    var person3 = person1

    fun main(){
        // reference가 같은지 확인
        println(person1 === person2)  // false
        println(person1 === person3)  // true

        // value가 같은지 확인
        println(person1.name == person2.name)   // true
        println(person1.name == person3.name)   // true

    }

    // a in b / !in
    // a 가 b에 포함 되어 있는지, 아닌지

    // a..b
    // a 부터 b 까지 범위 객체 생성

    // Kotlin은 객체마다 연산자 메소드를 오버로딩하여 사용할 수 있다.

    //이 외에 웬만한 연산자는 Java와 동일!
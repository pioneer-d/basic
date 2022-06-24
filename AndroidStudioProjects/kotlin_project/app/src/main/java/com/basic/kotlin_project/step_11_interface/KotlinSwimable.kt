package com.basic.kotlin_project.step_11_interface

interface KotlinSwimable {

    // Kotlin은 interface에서 프로퍼티를 활용할 수 있다.
    // 대신 getter 같은 것들은 이 interface를 구현하는 곳에서 구현해주는 것을 기대한다.
    val swimAbility : Int
    //get() = 3
    // 여서 default 값으로 넣어 줄 수도 있다.

    // == Java의 default 함수
    fun act(){
        println(swimAbility)
        println("어푸 어푸")
    }

    //fun swim()

}
package com.basic.kotlin_project.step_13_object

class getSingleton(){
    fun main(){
        println(ko_object.a)    // class 이름으로 바로 접근
        ko_object.a += 10
        println(ko_object.a)
    }
}

// 싱글톤 예제
object ko_object {  // class에 object만 붙여주면 됨.
    var a : Int = 1;
}



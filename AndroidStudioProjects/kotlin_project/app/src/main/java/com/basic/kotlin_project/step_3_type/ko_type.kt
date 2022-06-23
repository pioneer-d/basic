package com.basic.kotlin_project.step_3_type

import com.basic.kotlin_project.step_1_variable.Person

    // Kotlin은 무조건 명시적으로 형변환을 해줘야함.
    var number1 : Int = 4
    var number2 : Int? = 3

    // to.타입
     // var number2 : Long = number1 -> mismatch
    var number3 : Long = number1.toLong()
    var number4 : Long = number2?.toLong() ?: 0L

    // is, as
    fun confirmType(obj : Any){
        // Java의 instanceof와 동일.
        // !is, as? 활용 가능.
        if (obj is Person){
            //var person = obj as Person      //person을 Person 타입으로 간주한다.
            println(obj.name)
        }
    }


    // Kotlin에만 있는 Type

    // Any : Java 의 Object
    var obj : Any = "Test"

    // Unit : Java 의 void

    // Nothing : 함수가 정상적으로 끝나지 않았음을 표현하는 타입.
    // 무한루프, 무조건 예외발생을 해야하는 경우에 사용.

    // """ """ 엔터처리를 해줌.
    var str = """
        ABC
        DEF
        $obj
    """.trimIndent()

    //${변수} : 값이 들어간다.
    fun main(){
        var person = Person("동준영")
        println("이름 : ${person.name}")
        println(str)
    }

    var str1 = "ABC"
    // println(str1[0]) == A    == Java 의 str1.charAt(0)
    // println(str1[1]) == B
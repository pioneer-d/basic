package com.basic.kotlin_project.step_5_conditionalStatements

import java.lang.IllegalArgumentException

    //Unit (Java의 void가 생략이 되어도 됨.)
    fun confirmNegativeNum(number : Int){
        if (number < 0){
            throw IllegalArgumentException("0보다 작을 수 없음.")
        }
    }

//=============================================================

    // Kotlin에서는 if-else 조건문이 Expression임.
    // Expression : 하나의 값으로 도출되는 문장
    fun passOrFail(number : Int) : String{
        if (number >= 70){
            return "Pass"
        }else {
            return "Fail"
        }
    }

    // Expression은 하나의 값이기에, 변수에 대입할 수 있겠다.
    // 그러므로 Kotlin에는 삼항 연산자가 존재하지 않는다.

    // Expression을 활용한 위의 조건문 변경
    fun passOrFail2(number : Int) : String{
        return if (number >= 70){
            "Pass"
        }else {
            "Fail"
        }
    }

//=============================================================

    // Java
    // if (0 <= score && score <= 100)

    //Kotlin
    // if(score in 0..100)

//=============================================================

    // Java의 Switch -> Kotlin의 when
    fun switchGrade(score : Int) : String{
        return when(score / 10){
            9 -> "A"
            8 -> "B"
            7 -> "C"
            in 6..1 -> "F" // in 6 downTo 1
            else -> "Z"
        }
    }






package com.basic.kotlin_project.step_7_exception

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

    // try catch Exception
    fun confirmInt(str : String) : Int{
        try {
            return str.toInt()
        } catch (e : NumberFormatException){
            throw IllegalArgumentException("주어진 값이 숫자가 아님")
        }
    }

    // try catch Exception2 (try catch도 Expression이다!)
    fun confirmInt2(str : String) : Int?{
        return try {
            str.toInt()
        }catch (e : NumberFormatException){
            null
        }
    }

    // Java와 달리 throws 구문은 따로 작성하지 않아도 된다.(메소드 옆에 붙는 throws)
    // 모두 unchecked Exception이기 때문임.

    // Kotlin에서는 try with resources가 없어지고, use를 사용함.


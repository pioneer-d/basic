package com.basic.kotlin_project.day_1

import java.lang.IllegalArgumentException

    // Safe Call, Elvis 연산자
    fun main(){
        var str : String? = "ABC"
        //println(str.length)   -> null일 수 있기에 호출할 수 없음.
        println(str?.length)    //-> null이면 null을 반환함.

        var str1 : String? = null
        println(str1?.length ?: 0)  //-> null이면 뒤의 값을 반환함.
    }

//=============================================================

    // 이렇게 되면 parameter에 null이 들어올 수 없고,
    //null이 들어올 경우 Exception이 발생함.
    fun nullCheck(getString : String) : Boolean{
        return getString.startsWith("A")
    }

//=============================================================

    // Exception 방지 1
    // null이 들어올 수 있고, null이 들어올 경우 null을 반환하는 방법
    fun nullCheck1(getString : String?) : Boolean?{
        if (getString == null){
            return null
        }
        return getString.startsWith("A")
    }

    // Exception 방지 1에 Elvis 연산자 활용
    fun nullCheck1Elvis(getString: String?) : Boolean?{
        return getString?.startsWith("A")
    }

//=============================================================

    // Exception 방지 2
    // null이 들어올 수 있고, null이 들어올 경우 false를 반환하는 방법.
    fun nullCheck2(getString : String?) : Boolean{
        if (getString == null){
            return false
        }
        return getString.startsWith("A")
    }

    // Exception 방지 2에 Elvis 연산자 활용
    fun nullCheck2Elvis(getString : String?) : Boolean{
        return getString?.startsWith("A") ?: false
    }

//=============================================================

    // Exception 방지 3
    // null이 들어올 수 있고, null이 들어올 경우 예외처리 하는 방법.
    fun nullCheck3(getString : String?) : Boolean{
        if (getString == null){
            throw IllegalArgumentException("null이 들어옴")
        }
        return getString.startsWith("A")
    }

    // Exception 방지 3에 Elvis 연산자 활용
    fun nullCheck3Elvis(getString : String?) : Boolean{
        return getString?.startsWith("A")
            ?: throw IllegalArgumentException("null이 들어옴")
    }

//=============================================================

    // null이 절대 아닐경우 !!
    fun notNullPromise(getString : String?) : Boolean{
        return getString!!.startsWith("A")
    }

    // 추가로 Java와 병행하여 Kotlin을 사용하는 경우, Java에서 Annotation을 활용하자.
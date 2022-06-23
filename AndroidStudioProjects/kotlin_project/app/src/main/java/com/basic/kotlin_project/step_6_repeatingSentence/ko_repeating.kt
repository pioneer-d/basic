package com.basic.kotlin_project.step_6_repeatingSentence



    fun main(){
        var numbers = listOf(1L, 2L, 3L)
        for (number in numbers){
            println(number)
        }

        //=============================================================
        // for문 종류 (등차수열 - Progression)
        // 이때 downTo, step도 함수다!(중위 호출 함수)

        //1부터 3까지
        for (i in 1..3){
            println(i)
        }

        //3에서 1까지
        for (i in 3 downTo 1){
            println(i)
        }

        // 2씩 건너뛰어
        for (i in 1..5 step 2){
            println(i)
        }

        // while은 java와 동일함!

    }



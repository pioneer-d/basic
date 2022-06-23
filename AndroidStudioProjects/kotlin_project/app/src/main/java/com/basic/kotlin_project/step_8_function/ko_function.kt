package com.basic.kotlin_project.step_8_function


    // 접근제어자는 생략하면 public
    fun maxInt(a : Int, b : Int) : Int{
        return if (a < b){
            b
        }else{
            a
        }
    }

    // 위와 동일한 함수
    // '{}' 대신 '=' 사용 가능
    // 반환 타입 추론 가능 == 생략가능 (block 사용경우 Unit이 아니면 생략 불가!)
    // if-else 문의 {} 생략 가능
    fun maxInt2(a : Int, b : Int) = if (a < b) b else a


    // Kotlin 의 overLoading
    // DefaultParameter 로 대체 가능! -> Parameter에 기본값 지정함으로서
    fun defaultParameter(str : String, num : Int = 1, useNewLine : Boolean = true){
        for (i in 1..num){
            if (useNewLine){
                println(str)
            }else {
                print(str)
            }
        }
    }

    fun main(){
        defaultParameter("동준영1",3,true)
        defaultParameter("이현경1") //1,true
        defaultParameter("동준영2",2)

        // named  argument Parameter == builder를 만들지 않고 builder의 장점을 가지게 됨.
        // Java의 함수를 가져올 때는 사용할 수 없음.
        defaultParameter("이현경2",useNewLine = false) //가운데 값만 default로 사용하고 싶은 경우
    }

//=============================================================

    // 가변인자 vararg
    fun printAll(vararg strings : String){
        for (str in strings){
            println(str)
        }
    }

    // 가변인자 사용방법
    /*
        printAll("A", "B", "C")

        //배열로 가변인자 메소드를 활용할 경우 spread 연산자 *을 사용!
        var array = arrayOf("A", "B", "C")
        printAll(*array)
     */




















package com.basic.kotlin_project.step_15_collection

fun main(){

    // Kotlin은 기본적으로 타입을 추론해줌.
    // 기본적으로 불변 Collection 으로 만들어진다. (Collection의 값 변경 불가.)
    val numbers = listOf(100,200)
    //numbers.add(300)  -> error

    // 이렇게 만들면 가변 Collection
    val numbers2 = mutableListOf(10,20)
    numbers2.add(30)

    // 비어있는 collection을 만들경우에는 명시해줘야함.
    val empty = emptyArray<Int>()

    // 하나 가져오기
    println(numbers[0])

    // for each
    for (number in numbers){
        println(number)
    }

    // index with value
    for ((index, value)in numbers.withIndex()){
        println("${index} , ${value}")
    }

    // 이외에 setOf, mapOf


    //==================================================

    // Collection의 nullable
    /*

    List<Int?>  : 리스트에는 null이 들어갈 수 있지만, 리스트는 null이 아니다.
    List<Int>?  : 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있다.
    List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있다.

     */

    // Java는 Collection을 사용할 때,
    // 가변인지, 불변인지를 구분하지 않고,
    // nullable을 판단하지 않기 때문에 Java와 Kotlin을 병행하여 사용할때 이에 주의해야함.
    // 이를 위해 Collections.unmodifable() 을 사용하여 변경자체를 막는 방법도 있음.


}
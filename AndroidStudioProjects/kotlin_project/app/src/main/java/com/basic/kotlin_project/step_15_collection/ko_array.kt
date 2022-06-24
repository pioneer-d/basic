package com.basic.kotlin_project.step_15_collection

fun main(){

    val array = arrayOf(100,200)
    for (i in array.indices){   //indices == 0부터 lastIndex까지    이외에 withIndex..(= 인덱스와 값을 한번에  )
        println(array[i])
    }
    array.plus(300)
}

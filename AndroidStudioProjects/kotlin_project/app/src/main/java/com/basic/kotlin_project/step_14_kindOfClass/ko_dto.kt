package com.basic.kotlin_project.step_14_kindOfClass

    // DTO 클래스 이외에
    // enum Class
    // Sealed Class 등이 있음. -> when의 진가가 여기서 발휘된다고 함..!

fun main(){
    var dto1 = ko_dto("동준영",100)
    var dto2 = ko_dto("동준영",100)
    var dto3 = ko_dto("이현경",101)

    println(dto1 === dto2)
    println(dto1 == dto2)   // == equals
    println(dto1 === dto3)
    println(dto1 == dto3)
    println(dto1)           // == toString
}

data class ko_dto(
    var name : String,
    var age : Int
) {
}
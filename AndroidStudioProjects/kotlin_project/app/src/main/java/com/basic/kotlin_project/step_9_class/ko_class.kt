package com.basic.kotlin_project.step_9_class

    fun main(){
        // Kotlin Class 사용
        var person = KotlinPerson("동준영",25)
        println(person.name)    //getter 자동생성 및 활용
        person.age = 26         //setter 자동생성 및 활용
        println(person.age)

        // Java Class를 활용할 때도 동일하게 getter, setter 사용 가능하다.
        var person2 = JavaPerson("이현경",25)
        println(person2.name)
        person2.age = 30
        println(person2.age)
}
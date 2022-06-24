package com.basic.kotlin_project.step_13_object

class KotlinPerson private constructor(
    var name : String,
    var age : Int
){

    // companion object에 들어가는 변수, 함수는 static
    // Class의 동행객체
    // 하나의 객체로 간주되기에, 이름을 붙일 수 있고, interface도 구현이 가능하다.
    companion object{
        private const val MIN_AGE : Int = 1
        // const val 과 그냥 val의 차이
        // const val : 컴파일시에 변수가 할당됨
        // val : 런타임시에 변수가 할당됨
        fun newBaby(name : String) : KotlinPerson{
            return KotlinPerson(name, MIN_AGE)
        }
    }

}

class test(){
    fun main(){
        var test : KotlinPerson = KotlinPerson.newBaby("TEST")

        // Companion에 이름이 있으면 Companion 자리에 입력하면 됨.
        var test2 : KotlinPerson = KotlinPerson.Companion.newBaby("동준영")

        // 단 Java에서 Kotlin의 companion object를 사용하려면,
        // Kotlin의 companion object에 @JvmStatic 어노테이션을 붙여야함.

    }
}
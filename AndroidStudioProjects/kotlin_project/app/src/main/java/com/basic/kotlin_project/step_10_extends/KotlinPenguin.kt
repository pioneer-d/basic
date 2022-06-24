package com.basic.kotlin_project.step_10_extends

class KotlinPenguin(
    species : String
) : KotlinAnimal(
    species, 2
) {
    private val wingCount : Int = 2

    override fun move() {
        println("펭귄 꿱꿱")
    }

    /*
    override fun getLegCount() : Int{
        return legCount + wingCount
    }
    */

    // 프로퍼티를 override 할 때는 무조건 해당 변수에 open을 붙여줘야 한다.!
    override val legCount : Int
        get() = super.legCount + this.wingCount


}
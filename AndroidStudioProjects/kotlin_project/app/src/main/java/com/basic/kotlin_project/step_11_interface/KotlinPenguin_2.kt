package com.basic.kotlin_project.step_11_interface

import com.basic.kotlin_project.step_10_extends.KotlinAnimal

class KotlinPenguin_2(
    species : String
) : KotlinAnimal(species, 2), KotlinSwimable, KotlinFlyable {
    // Kotlin 에서의 interface 구현도 extends 처럼 : 를 사용한다.

    private val wingCount : Int = 2

    override fun move() {
        println("펭귄 꿱꿱")
    }

    // 프로퍼티를 override 할 때는 무조건 해당 변수에 open을 붙여줘야 한다.!
    override val legCount : Int
        get() = super.legCount + this.wingCount

    // kotlin의 interface default 함수 사용 법
    override fun act(){
        super<KotlinSwimable>.act()
        super<KotlinFlyable>.act()
    }

    // 구현한 interface의 프로퍼티 중 getter를 구현한다.
    override val swimAbility : Int
        get() = 3


}
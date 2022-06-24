package com.basic.kotlin_project.step_10_extends

abstract class KotlinAnimal(
    protected val species : String,
    protected open val legCount : Int //filed, constructor, getter 모두 한번에 == property
    ) {

    abstract fun move()

}
package com.basic.kotlin_project.step_10_extends

class KotlinCat(
    species : String
) : KotlinAnimal(species,4) {

    // extends 생략, @Override 사용 대신 override 사용.

    override fun move() {
        println("고양이 사뿐사뿐")
    }

}
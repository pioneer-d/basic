package com.basic.kotlin_project.step_13_object


    fun main(){
        moveSomething(object : Movable{
            override fun move() {
                println("move!")
            }

            override fun fly() {
                println("fly!")
            }

        })
    }

    private fun moveSomething(movable: Movable){
        movable.move()
        movable.fly()
    }

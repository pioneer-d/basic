package com.basic.kotlin_project.step_11_interface;

public interface JavaSwimable {

    default void act(){
        System.out.println("어푸 어푸");
    }
    //void swim()

}

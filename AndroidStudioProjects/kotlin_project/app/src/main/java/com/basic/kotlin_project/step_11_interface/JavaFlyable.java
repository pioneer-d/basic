package com.basic.kotlin_project.step_11_interface;

public interface JavaFlyable {

    default void act(){
        System.out.println("파닥 파닥");
    }
    // void fly()
}

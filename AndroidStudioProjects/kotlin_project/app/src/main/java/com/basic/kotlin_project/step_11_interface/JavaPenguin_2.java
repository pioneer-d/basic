package com.basic.kotlin_project.step_11_interface;

import com.basic.kotlin_project.step_10_extends.JavaAnimal;

public class JavaPenguin_2 extends JavaAnimal implements JavaSwimable, JavaFlyable {

    private final int wingCount;

    public JavaPenguin_2(String species){
        super(species,2);
        this.wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("펭귄 꿱꿱");
    }

    @Override
    public int getLegCount(){
        return super.legCount + this.wingCount;
    }



    @Override
    public void act() {
        JavaSwimable.super.act();
        JavaFlyable.super.act();
    }


}

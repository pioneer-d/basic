package com.basic.kotlin_project.step_10_extends;

public class JavaCat extends JavaAnimal {

    public JavaCat(String species){
        super(species,4);
    }

    @Override
    public void move() {
        System.out.println("고양이 사뿐사뿐");
    }
}

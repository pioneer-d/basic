package com.basic.kotlin_project.step_13_object;

public class JavaPerson {

    private static final int MIM_AGE = 1;

    public static JavaPerson newBaby(String name){
        return new JavaPerson(name, MIM_AGE);
    }

    private String name;
    private int age;

    private JavaPerson(String name, int age){
        this.name = name;
        this.age = age;
    }

}

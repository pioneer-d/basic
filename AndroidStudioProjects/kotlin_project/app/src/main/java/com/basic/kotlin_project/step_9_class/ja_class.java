package com.basic.kotlin_project.step_9_class;

public class ja_class {

    public static void main(String[] args) {

        // Java에서 Kotlin Class 사용하는 경우는?
        KotlinPerson person = new KotlinPerson("동준영",25);
        System.out.println(person.getName());
        person.setAge(26);
        System.out.println(person.getAge());

    }

}

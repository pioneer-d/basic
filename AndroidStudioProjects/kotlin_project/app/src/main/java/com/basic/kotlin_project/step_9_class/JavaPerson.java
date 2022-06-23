package com.basic.kotlin_project.step_9_class;

public class JavaPerson {

    /*
    생성자로 2개 초기화
    final String 변수 name -> getter
    int 변수 age -> getter, setter
    프로퍼티 : 필드 + getter, setter
     */

    private final String name;
    private int age;

    public JavaPerson(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

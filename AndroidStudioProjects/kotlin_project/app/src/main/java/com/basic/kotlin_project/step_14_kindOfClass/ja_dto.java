package com.basic.kotlin_project.step_14_kindOfClass;

import java.util.Objects;

public class ja_dto {

    //계층간 데이터를 주고 받기 위한 클래스
    // getter, setter, toString(), equals(), hashCode() 가 일반적임.

    private String name;
    private int age;

    public ja_dto(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ja_dto ja_dto = (ja_dto) o;
        return age == ja_dto.age && Objects.equals(name, ja_dto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "ja_dto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

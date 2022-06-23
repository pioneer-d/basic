package com.basic.kotlin_project.step_1_variable;

public class ja_variable {

    public static void main(String[] args) {

        long number1 = 10L;
        final long number2 = 10L;
        // -> 이 둘의 차이는 가변인가 불변인가 차이.


        long number3 = 10L;
        Long nubmer4 = 1_000L;
        // -> 이 둘의 차이는 primitive type인가, reference type인가.


        Person person = new Person("동준영");
        //자바는 객체를 생성하기 위해 new 키워드를 사용한다.


    }



}

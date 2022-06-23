package com.basic.kotlin_project.step_3_type;

import com.basic.kotlin_project.step_1_variable.Person;

public class ja_type {

    // 크기가 작은 type에서 상대적으로 크기가 큰 type에 값을 넣으면 암시적으로 형 변환이 됨.
    int number1 = 10;
    long number2 = number1;


    public static void printPerson(Object obj){
        // instanceof :  좌측 변수가 우측 타입과 같으면 true, 다르면 false
        if (obj instanceof Person){
            Person person = (Person) obj;
            System.out.println(person.getName());
        }
    }


}

package com.basic.kotlin_project.step_15_collection;

import java.util.Arrays;
import java.util.List;

public class ja_collection {

    public static void main(String[] args) {

        // Java는 타입을 명시해줘야함!
        final List<Integer> numbers = Arrays.asList(100, 200);

        // 하나 가져오기
        System.out.println(numbers.get(0));

        //for each
        for (int number : numbers){
            System.out.println(number);
        }

    }

}

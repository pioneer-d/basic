package com.basic.kotlin_project.step_6_repeatingSentence;

import java.util.Arrays;
import java.util.List;

public class ja_repeating {

    public static void main(String[] args) {

        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        for (long number : numbers){
            System.out.println(number);
        }

        //=============================================================

        for (int i = 0; i<=3; i++){
            System.out.println(i);
        }

    }

}

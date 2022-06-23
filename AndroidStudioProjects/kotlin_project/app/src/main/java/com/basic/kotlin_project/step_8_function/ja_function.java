package com.basic.kotlin_project.step_8_function;

public class ja_function {

    public int maxInt(int a, int b){
        if (a < b){
            return b;
        }else {
            return a;
        }
    }

    //=============================================================

    //가변인자 (같은 type의 parameter가 여러개인 경우)
    public static void printALl(String... strings){
        for (String str : strings){
            System.out.println(str);
        }
    }

}

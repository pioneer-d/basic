package com.basic.kotlin_project.step_13_object;

// 싱글톤 예제
public class ja_object {

    private static final ja_object INSTANCE = new ja_object();

    private ja_object(){
    }

    public static ja_object getInstance(){
        return INSTANCE;
    }

}

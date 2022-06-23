package com.basic.kotlin_project.step_2_null;

public class ja_null {

    // A로 시작하는 지 알기위할 때,
    // null이 들어올 경우 Exception 발생
    public boolean nullCheck(String getString){
        return getString.startsWith("A");
    }

    // Exception 방지 1
    // return type이 Boolean이고, null일 경우 null을 반환하는 방법.
    public Boolean nullCheck1(String getString){
        if (getString == null){
            return null;
        }
        return getString.startsWith("A");
    }

    // Exception 방지 2
    // return type이 boolean이고, null일 경우 false를 반환하는 방법.
    public boolean nullCheck2(String getString){
        if (getString == null){
            return false;
        }
        return getString.startsWith("A");
    }

    // Exception 방지 3
    // return type이 boolean이고, null일 경우 예외처리를 하는 방법.
    public boolean nullCheck3(String getString){
        if (getString == null){
            throw new IllegalArgumentException("null이 들어옴");
        }
        return getString.startsWith("A");
    }





}

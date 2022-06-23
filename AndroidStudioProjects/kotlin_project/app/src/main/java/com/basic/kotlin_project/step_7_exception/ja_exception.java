package com.basic.kotlin_project.step_7_exception;

import org.jetbrains.annotations.NotNull;

public class ja_exception {

    // try catch Exception
    private int confirmInt(@NotNull String str){
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("주어진 값이 숫자가 아님.");
        }
    }

    // try catch Exception2
    private Integer confirmInt2(@NotNull String str){
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    // try with resources도 있음.
}

package com.basic.kotlin_project.step_5_conditionalStatements;

public class ja_statements {

    private void confirmNegativeNum(int number){
        if (number < 0){
            throw new IllegalArgumentException("0보다 작을 수 없음");
        }
    }

    //=============================================================

    // Java에서는 if-else 조건문이 Statement임.
    // Statement : 프로그램의 문장, 하나의 값으로 도출되지 않을 수 있음(Expression을 포함함.)
    private String passOrFail(int score){
        if (score >= 70){
            return "Pass";
        }else {
            return "Fail";
        }
    }

    // Statement는 하나의 값일 수도 있고, 아닐 수도 있음. 즉 상황에 따라 변수에 대입할 수 있음.
    // EX) 삼항 연산자는 Expression이므로 변수에 대입 가능.

    //=============================================================

    private String switchGrade(int score){
        switch (score / 10){
            case 9 : return "A";
            case 8 : return "B";
            case 7 : return "C";
            default : return  "F";
        }
    }

}

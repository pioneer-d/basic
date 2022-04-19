package com.example.mvp_pattern_test.mvp.Presenter;

public interface Contract {

    static String thisName = "Contract";

    interface View {
        void showResult(int answer);        // 값을 보여줄 view 메소드 선언
    }

    interface Presenter {
        void addNum(int num1, int num2);    // 결과 값 구하기 위한 메소드 선언
    }

}

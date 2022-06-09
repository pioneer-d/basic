package com.snaptagScanner.china.main.presenter;

import android.content.Context;

public interface MainContract {

    interface View{
        void callScan();
        void callList();
        void callMore();
        void networkError();
    }

    interface Presenter{
        void controlNavigation(int item, Context context);
    }
}

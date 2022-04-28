package com.snaptag.labcode_china.main.presenter;

import android.content.Context;
import android.view.MenuItem;

import androidx.annotation.NonNull;

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

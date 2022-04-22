package com.snaptag.labcode_china.main.presenter;

import android.content.Context;
import android.view.MenuItem;

import androidx.annotation.NonNull;

public interface MainContract {

    interface View{
        void networkError();
        void callScan();
        void callList();
        void callMore();
    }

    interface Presenter{
        void controlFragment(int item, Context context);
    }
}

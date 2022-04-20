package com.snaptag.labcode_china.splash.presenter;

import android.content.Context;

public interface SplashContract {

    interface View {
        void startMain();
        void finishApp();
    }

    interface Presenter{
        void splashHandler(int sec, Context context);
        boolean confirmNetwork(Context context);
    }


}

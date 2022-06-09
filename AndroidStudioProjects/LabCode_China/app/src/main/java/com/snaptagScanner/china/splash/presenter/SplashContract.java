package com.snaptagScanner.china.splash.presenter;

import android.content.Context;

public interface SplashContract {

    interface View {
        void goCameraAccessRight();
        void networkError();
    }

    interface Presenter{
        void splashHandler(int sec, Context context);
    }


}

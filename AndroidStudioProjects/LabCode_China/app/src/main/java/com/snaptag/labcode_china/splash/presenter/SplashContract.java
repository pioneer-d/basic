package com.snaptag.labcode_china.splash.presenter;

import android.content.Context;

public interface SplashContract {

    interface View {
        void checkCameraRight();
        void networkError();
    }

    interface Presenter{
        void splashHandler(int sec, Context context);
    }


}

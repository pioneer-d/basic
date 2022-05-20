package com.snaptag.labcode_china.accessRight.presenter;

import androidx.annotation.NonNull;

public interface AccessRightContract {

    interface View{

        void notAllowed();
        void goMain();
    }

    interface Presenter{


        //아래로 리뉴얼
        boolean checkPermission();
        void requestPermission();

    }
}

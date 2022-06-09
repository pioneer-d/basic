package com.snaptagScanner.china.accessRight.presenter;

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

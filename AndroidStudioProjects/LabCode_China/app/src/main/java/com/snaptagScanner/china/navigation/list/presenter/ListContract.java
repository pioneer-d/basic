package com.snaptagScanner.china.navigation.list.presenter;


public interface ListContract {

    interface View{
        void goBlank();
        void goList();
        void goDetail();
    }

    interface Presenter{
        void controlView();
        void exist();
        void notExist();
    }

}

package com.snaptag.labcode_china.navigation.list.presenter;

public interface ListContract {

    interface View{
        void showList();
        void showBlank();
        void showDetail();
    }

    interface Presenter{
        int getDate();
        void controlFragment(int listNum);
    }
}

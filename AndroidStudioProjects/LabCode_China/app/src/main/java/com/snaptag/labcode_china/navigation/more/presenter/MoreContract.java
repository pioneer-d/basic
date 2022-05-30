package com.snaptag.labcode_china.navigation.more.presenter;

public interface MoreContract {

    interface View{
        void goFrequentQuestion();
        void goTos();
        void goPersonal();
        void goScanGuide();
        void goCustomer();
    }

    interface Presenter{
        void controlView();
    }
}

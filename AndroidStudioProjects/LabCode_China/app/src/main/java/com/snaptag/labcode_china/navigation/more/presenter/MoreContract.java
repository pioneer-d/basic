package com.snaptag.labcode_china.navigation.more.presenter;

public interface MoreContract {

    interface View{
        void goFrequentQuestion();
        void goTos();
        void goScanGuide();
    }

    interface Presenter{
        void controlView();
    }
}

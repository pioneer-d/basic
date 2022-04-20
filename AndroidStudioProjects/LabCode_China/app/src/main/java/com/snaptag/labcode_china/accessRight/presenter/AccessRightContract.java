package com.snaptag.labcode_china.accessRight.presenter;

public interface AccessRightContract {

    interface View{
        void alertCheckRight();
        void notAllowed();
        void goMain();
    }

    interface Presenter{
        void checkRight();
    }
}

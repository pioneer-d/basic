package com.snaptag.labcode_china.accessRight.presenter;

public interface AccessRightContract {

    interface View{
        void alertCheckRight(boolean camera, boolean location);
        void notAllowed();
        void goMain();
    }

    interface Presenter{
        void controlCheck();
        boolean cameraRightConfirm();
        boolean gpsRightConfirm();
    }
}

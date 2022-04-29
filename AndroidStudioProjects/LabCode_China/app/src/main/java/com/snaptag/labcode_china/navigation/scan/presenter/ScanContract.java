package com.snaptag.labcode_china.navigation.scan.presenter;

import android.hardware.camera2.CameraAccessException;

import com.snaptag.labcode_china.navigation.scan.model.CameraData;

public interface ScanContract {

    interface View{
        void updatePreview(CameraData data) throws CameraAccessException;
    }

    interface Presenter{
        void startBackgroundThread();
        void stopBackgroundThread() throws InterruptedException;
        void openCamera() throws CameraAccessException;
        void createCameraPreview() throws CameraAccessException;
        void controlSetting(int getId) throws CameraAccessException;
        void testAPI();
        void takePicture();
    }
}

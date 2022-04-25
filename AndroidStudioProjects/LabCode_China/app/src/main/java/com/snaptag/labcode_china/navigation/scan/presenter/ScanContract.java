package com.snaptag.labcode_china.navigation.scan.presenter;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;

public interface ScanContract {

    interface View{
        void updatePreview(CameraDevice device, CaptureRequest.Builder builder, CameraCaptureSession captureSession, Handler handler) throws CameraAccessException;
    }

    interface Presenter{
        void startBackgroundThread();
        void stopBackgroundThread() throws InterruptedException;
        void openCamera() throws CameraAccessException;
        void createCameraPreview() throws CameraAccessException;
        void controlSetting();
        void takePicture();
    }
}

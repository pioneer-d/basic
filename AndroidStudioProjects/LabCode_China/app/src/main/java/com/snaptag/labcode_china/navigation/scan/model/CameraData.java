package com.snaptag.labcode_china.navigation.scan.model;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;

public class CameraData {

    private static CameraData instance;

    private CameraDevice device;
    private CaptureRequest.Builder builder;
    private CameraCaptureSession session;
    private Handler handler;

    private boolean flashOnOff = false;
    private float zoomRate = 1.0f;

    private CameraData(){ }

    public static CameraData getInstance(){
        if(instance == null){
            instance = new CameraData();
        }
        return instance;
    }

    public CameraDevice getDevice() {
        return device;
    }

    public void setDevice(CameraDevice device) {
        this.device = device;
    }

    public CaptureRequest.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(CaptureRequest.Builder builder) {
        this.builder = builder;
    }

    public CameraCaptureSession getSession() {
        return session;
    }

    public void setSession(CameraCaptureSession session) {
        this.session = session;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isFlashOnOff() {
        return flashOnOff;
    }

    public void setFlashOnOff(boolean flashOnOff) {
        this.flashOnOff = flashOnOff;
    }

    public float getZoomRate() {
        return zoomRate;
    }

    public void setZoomRate(float zoomRate) {
        this.zoomRate = zoomRate;
    }
}

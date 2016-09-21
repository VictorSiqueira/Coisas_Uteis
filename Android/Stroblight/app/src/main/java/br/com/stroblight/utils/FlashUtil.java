package br.com.stroblight.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import android.view.View;

/**
 * Created by Victor on 12/09/2016.
 */
public class FlashUtil {
    //flag to detect flash is on or off
    private static boolean isLighOn = false;
    private static CameraManager camManager;
    private static String finalCameraId;

    // if device support camera?
    public static void initializateFlashLight(View rootView, View actionView){
        PackageManager pm = rootView.getContext().getPackageManager();
        if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "Device has no camera!");
            return;
        } else{
            mountFlashLightParameters(rootView);
            if(actionView != null) {
                assignFunctionToActionView(actionView);
            }
        }  
    }
    
    private static void mountFlashLightParameters(View rootView) {
        camManager = (CameraManager) rootView.getContext().getSystemService(Context.CAMERA_SERVICE);
        try {
            finalCameraId = camManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private static void assignFunctionToActionView(View actionView) {
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FlashUtil.toggleFlashLight();
            }
        });
    }

    public static void toggleFlashLight() {
        try {
            if (isLighOn) {
                //Log.i("info", "torch is turn off!");
                camManager.setTorchMode(finalCameraId, false);
                isLighOn = false;
            } else {
                //Log.i("info", "torch is turn on!");
                camManager.setTorchMode(finalCameraId, true);
                isLighOn = true;
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}

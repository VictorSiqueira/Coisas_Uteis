package br.com.stroblight.fragments;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.stroblight.R;
import br.com.stroblight.utils.FlashUtil;

/**
 * Created by Victor on 12/09/2016.
 */
public class MainFragment extends Fragment {

    //private Camera camera;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        create(rootView);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        /*if (camera != null) {
            camera.release();
        }*/
    }

    public void create(View view) {
        button = (Button) view.findViewById(R.id.buttonFlashlight);
        FlashUtil.initializateFlashLight(view, button);
    }
}

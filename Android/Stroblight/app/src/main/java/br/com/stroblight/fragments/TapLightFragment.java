package br.com.stroblight.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.stroblight.R;
import br.com.stroblight.utils.FlashUtil;

/**
 * Created by Victor on 12/09/2016.
 */
public class TapLightFragment extends Fragment {
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_strobo, container, false);
        create(rootView);
        return rootView;
    }

    public void create(View view) {
        button = (Button) view.findViewById(R.id.buttonStrobolight);
        FlashUtil.initializateFlashLight(view, button);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        FlashUtil.toggleFlashLight();
                        return true; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        FlashUtil.toggleFlashLight();
                        // RELEASED
                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });
    }
}

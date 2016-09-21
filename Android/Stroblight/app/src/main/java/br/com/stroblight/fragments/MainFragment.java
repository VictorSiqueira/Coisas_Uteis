package br.com.stroblight.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.Timer;
import java.util.TimerTask;

import br.com.stroblight.R;
import br.com.stroblight.utils.FlashUtil;

/**
 * Created by Victor on 12/09/2016.
 */
public class MainFragment extends Fragment {

    //private Camera camera;
    private Button buttonMain;

    //variaveis do fragment Strobo
    private Switch buttonStrobo;
    private boolean loopingLight = false;
    private Timer timer;
    private TimerTask timerTask;
    final Handler handler = new Handler();
    private Context context;

    //variaveis do fragment de taplight
    private Button buttonTap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        createMain(rootView);
        createTap(rootView);
        createStrobo(rootView);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        /*if (camera != null) {
            camera.release();
        }*/
    }

    public void createMain(View view) {
        buttonMain = (Button) view.findViewById(R.id.buttonFlashlight);
        FlashUtil.initializateFlashLight(view, buttonMain);
    }

    public void createStrobo(View view) {
        context = view.getContext();
        buttonStrobo = (Switch) view.findViewById(R.id.switchToggle);
        FlashUtil.initializateFlashLight(view, buttonStrobo);
        //loopLights();
        buttonStrobo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    loopingLight = true;
                    startTimer();
                } else {
                    stoptimertask();
                    loopingLight = false;
                }
            }
        });
    }

    public void startTimer() {
        //set a new Timer
        timer = new Timer();
        //initialize the TimerTask's job
        initializeTimerTask();
        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        timer.schedule(timerTask, 125, 125);

    }

    public void stoptimertask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run(){
                        FlashUtil.toggleFlashLight();
                    }
                });
            }
        };
    }

    public void createTap(View view) {
        buttonTap = (Button) view.findViewById(R.id.buttonStrobolight);
        FlashUtil.initializateFlashLight(view, buttonTap);

        buttonTap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        FlashUtil.toggleFlashLight();
                        return false; // if you want to handle the touch event
                    case MotionEvent.ACTION_UP:
                        FlashUtil.toggleFlashLight();
                        // RELEASED
                        return false; // if you want to handle the touch event
                }
                return false;
            }
        });
    }
}

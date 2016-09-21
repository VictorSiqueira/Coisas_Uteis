package br.com.stroblight.fragments;

import android.content.Context;
import android.hardware.Camera;
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
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import br.com.stroblight.R;
import br.com.stroblight.utils.FlashUtil;

/**
 * Created by Victor on 12/09/2016.
 */
public class StroboFragment extends Fragment {
    private Switch button;
    private boolean loopingLight = false;

    private Timer timer;
    private TimerTask timerTask;
    final Handler handler = new Handler();
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_strobo, container, false);
        create(rootView);
        return rootView;
    }

    public void create(View view) {
        context = view.getContext();
        button = (Switch) view.findViewById(R.id.switchToggle);
        FlashUtil.initializateFlashLight(view, button);

        //loopLights();

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
}

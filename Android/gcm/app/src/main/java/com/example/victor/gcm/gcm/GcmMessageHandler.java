package com.example.victor.gcm.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created by Victor on 20/01/2016.
 */
public class GcmMessageHandler extends IntentService {

    String mes;
    private Handler handler;

    public GcmMessageHandler() {
        super("GcmMessageHandler");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
    }

    /**
     * Manipulador de Intent que recebe os dados da notificação e apresenta em Toast na tela
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();

        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        String messageType = gcm.getMessageType(intent);

        mes = extras.getString("title");
        showToast();
        Log.i("GCM", "Received : (" + messageType + ")  " + extras.getString("title"));

        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    /**
     * Metodo para fazer um toast aparecer em qualquer tela
     */
    public void showToast(){
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(),mes , Toast.LENGTH_LONG).show();
            }
        });
    }
}
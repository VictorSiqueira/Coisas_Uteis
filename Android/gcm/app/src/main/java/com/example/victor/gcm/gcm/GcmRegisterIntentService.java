package com.example.victor.gcm.gcm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.victor.gcm.MainActivity;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by Victor on 13/02/2016.
 */
public class GcmRegisterIntentService extends IntentService {

    GoogleCloudMessaging gcm;
    String regid;
    String PROJECT_NUMBER = "458017685305";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public GcmRegisterIntentService() {
        super("GcmRegisterIntentService");
    }

    /**
     * Manipulador de intents e chama o metodo getRegId
     * @param intent
     * */
    @Override
    protected void onHandleIntent(Intent intent) {
        getRegId();
    }

    /**
     * Realiza uma chamada assincrona ao GCM para obter um registro para notificações
     */
    public void getRegId(){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                    }
                    regid = gcm.register(PROJECT_NUMBER);
                    msg = "Device registered, registration ID=" + regid;
                    Log.i("GCM", msg);
                    sendIdToServer();
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                }
                return msg;
            }
            @Override
            protected void onPostExecute(String msg) {
                //etRegId.setText(msg + "\n");
            }
        }.execute(null, null, null);
    }

    /**
     * Metodo para enviar assicronamente atraves da lib Volley o id registrado no GCM
     */
    public void sendIdToServer(){
        final int[] i = {0};
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.agoravou.com/gcm/index.php?shareRegId=true&regId="+regid;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("FOI", "CARALHO");
                       i[0] = 1;
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ERRO",""+error);
            }
        })/*{
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("regId",regid );
                        return params;
                    }
                }*/;
        queue.add(stringRequest);

        if(i[0] != 0){
            Toast.makeText(this, "enviou o reg id >>>" + regid, Toast.LENGTH_SHORT).show();
        }
    }


}

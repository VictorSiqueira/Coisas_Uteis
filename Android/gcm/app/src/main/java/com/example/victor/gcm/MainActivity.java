package com.example.victor.gcm;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.victor.gcm.gcm.GcmRegisterIntentService;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnRegId;
    EditText etRegId;
    GcmRegisterIntentService register;

   // String PROJECT_NUMBER="AIzaSyCpATmca3T-babbRi2biFCpFie3S7f9AZ0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegId = (Button) findViewById(R.id.btnGetRegId);
        etRegId = (EditText) findViewById(R.id.etRegId);

        //GCM Receiver message
        String str = getIntent().getStringExtra("msg");
        if (str != null) {
           Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Metodo para chamar o service que realiza o registro no GCM
     * @param v
     */
    public void ok(View v) {
        Intent intent = new Intent(this,GcmRegisterIntentService.class);
        startService(intent);
    }
}
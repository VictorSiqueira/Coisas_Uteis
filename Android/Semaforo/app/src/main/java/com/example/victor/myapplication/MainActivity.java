package com.example.victor.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sinalVermelho(View v){
        enviarDado(1);
    }

    public void sinalAmarelo(View v){
        enviarDado(2);
    }

    public void sinalVerde(View v){
        enviarDado(3);
    }


    public void enviarDado(int dado){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://usinadacriacao.cloudbr.net/appFiap/victor.php?" +
                "update&tb=usuario&insert[campo][0]=latitude&insert[valor][0]=" + String.valueOf(dado)
                +"&whereArr[0][condicao]=AND&whereArr[0][campo]=id&whereArr[0][valor]=6";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("FOI", "CARALHO");
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ERRO",""+error);
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

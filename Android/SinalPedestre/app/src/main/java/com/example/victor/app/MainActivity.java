package com.example.victor.app;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    private String jsonResponse;
    private TextView txtResponse;

    private RelativeLayout rl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //img = (ImageView) findViewById(R.id.imageView);
        txtResponse = (TextView) findViewById(R.id.txtResponse);
        rl = (RelativeLayout)findViewById(R.id.back);
        recuperaDado();
    }

    private void recuperaDado() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://usinadacriacao.cloudbr.net/appFiap/victor.php?get&tb=usuario&whereArr[0][condicao]=AND&whereArr[0][campo]=id&whereArr[0][valor]=6";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Resp", response.toString());
                        try {
                            jsonResponse = "";
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject person = (JSONObject) response
                                        .get(i);
                                String id = person.getString("id");
                                String nome = person.getString("nome");
                                String lat = person.getString("latitude");

                                //jsonResponse += "Name: " + id + "\n\n";
                                //jsonResponse += "Email: " + nome + "\n\n";
                                jsonResponse += "Valor " + lat + "\n\n";
                                setActivityBackgroundColor(lat);

                            }
                            txtResponse.setText(jsonResponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error","" + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Adding request to request queue
        queue.add(req);
    }

    private void setActivityBackgroundColor(String color) {
        switch (Integer.parseInt(color)) {
            case 1:
                rl.setBackgroundColor(Color.RED);
                break;
            case 2:
                rl.setBackgroundColor(Color.RED);
                break;
            case 3:
                rl.setBackgroundColor(Color.GREEN);
                break;
            default:
                rl.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

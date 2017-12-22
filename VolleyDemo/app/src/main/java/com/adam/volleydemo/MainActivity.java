package com.adam.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button stringButton;
    TextView textView;

    Button jsonButton;


    String server_url = "http://www.google.com";
    String nut_url = "https://trackapi.nutritionix.com/v2/search/instant?query=apple";

    //192.168.0.101
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stringButton = (Button)findViewById(R.id.bn);
        textView = (TextView) findViewById(R.id.txt);






        stringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.GET, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText("Response is: "+ response.substring(0,50));
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                                textView.setText("Something went wrong...");
                                error.printStackTrace();
                                requestQueue.stop();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });




    }//onCreate close

















}

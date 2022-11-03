package com.example.app.adminfeatures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.R;
import com.example.app.admin_page;

import org.json.JSONException;
import org.json.JSONObject;

public class vendor_register extends AppCompatActivity {

    private TextView msgResponse;
    private Button back;
    private Button register;
    private EditText name;
    private EditText username;
    private EditText location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_register);

        msgResponse = findViewById(R.id.msgResponse);
        back = findViewById(R.id.back);
        register = findViewById(R.id.register);
        name = findViewById(R.id.vendor_name);
        username = findViewById(R.id.maintainer_username);
        location = findViewById(R.id.location);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postReq();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(vendor_register.this, vendor_info.class));
            }
        });
    }

    private void postReq() {
        RequestQueue queue = Volley.newRequestQueue(vendor_register.this);
        String url = "http://coms-309-013.class.las.iastate.edu:8080/vendor/register/";
        JSONObject regDetails = new JSONObject();
        try {
            regDetails.put("VendorID", 1);
            regDetails.put("OC", true);
            regDetails.put("name", name.getText());
            regDetails.put("location", location.getText());
            regDetails.put("maintainer_username", username.getText());
            regDetails.put("menu", null);
        } catch(JSONException e) {
            e.printStackTrace();
        }

        final String request = regDetails.toString();

        StringRequest req = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    msgResponse.setText("You have successfully created a new user!");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(vendor_register.this, vendor_info.class));
                        }
                    }, 2000);
                } catch( Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                msgResponse.setText("Looks like something went wrong. Please try again");
                error.printStackTrace();
            }
        }) {
            @Override
            public byte[] getBody() {
                return request.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        queue.add(req);
    }

}
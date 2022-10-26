package com.example.app.adminfeatures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_register);

        //msgResponse = findViewById(R.id.msgResponse);
    }

    private void postReq() {
        RequestQueue queue = Volley.newRequestQueue(vendor_register.this);
//        String url = "https://26ee0a9a-f41e-41c7-9e14-e30c8ccd3267.mock.pstmn.io/register/";
        String url = "http://coms-309-013.class.las.iastate.edu:8080/vendors/register/";
        JSONObject regDetails = new JSONObject();
        try {
            regDetails.put("name", null);
            regDetails.put("location", null);
            regDetails.put("maintainer_username", null);
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
                            startActivity(new Intent(vendor_info.this, admin_page.class));
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
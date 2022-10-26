package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class concessions_info extends AppCompatActivity {
    private TextView vend_name;
    private TextView location;
    private String id;
    private JSONObject vendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concessions_info);
        vendor = new JSONObject();

        vend_name = findViewById(R.id.vendor_name);
        vend_name.setText(concessions.vendor_name);
        location = findViewById(R.id.location);
//        getVendorReq();
//        try {
//            location.setText(vendor.getString("location"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        getMenuReq();
    }

    private void getVendorReq() {
        RequestQueue queue = Volley.newRequestQueue(concessions_info.this);
        String url = "http://coms-309-013.class.las.iastate.edu:8080/vendors/" + concessions.vendor_name;
        JSONObject json = new JSONObject();
        final String requestBody = json.toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    vendor.put("name", response.getString("name"));
                    vendor.put("location", response.getString("location"));
                    vendor.put("id", response.getString("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public byte[] getBody() {
                return requestBody.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        queue.add(request);
    }

    private void getMenuReq() {
        RequestQueue queue = Volley.newRequestQueue(concessions_info.this);
        String url = null;
        try {
            url = "http://coms-309-013.class.las.iastate.edu:8080/menus/" + vendor.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        final String requestBody = json.toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    json.put("name", response.getString("name"));
                    //something here for menus
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public byte[] getBody() {
                return requestBody.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        queue.add(request);
    }
}
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.AccountDetails;
import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.admin_page;
import com.example.app.login;
import com.example.app.register;

import org.json.JSONException;
import org.json.JSONObject;

public class vendor_info extends AppCompatActivity {
    private Button back;
    private Button login;
    private Button register;
    private EditText vendor_name;
    private EditText maintainer_username;
    public static JSONObject vendor;
    private TextView msgResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_info);

        back = findViewById(R.id.back);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        vendor_name = findViewById(R.id.vendor_name);
        maintainer_username = findViewById(R.id.maintainer_username);
        msgResponse = findViewById(R.id.msgResponse);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), admin_page.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getReq();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), vendor_register.class));
            }
        });
    }

    private void getReq() {
        RequestQueue queue = Volley.newRequestQueue(vendor_info.this);

//        String url = "https://26ee0a9a-f41e-41c7-9e14-e30c8ccd3267.mock.pstmn.io/object/";
        String url = "http://coms-309-013.class.las.iastate.edu:8080/vendors/" + vendor_name;
        JSONObject json = new JSONObject();
        final String requestBody = json.toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getString("maintainer_name").equals(maintainer_username.getText())) {
                        vendor.put("id", response.getString("id"));
                        vendor.put("maintainer_username",response.getString("maintainer_name"));
                        vendor.put("name", response.getString("name"));
                        vendor.put("location", response.getString("location"));
                        startActivity(new Intent(vendor_info.this, MainActivity.class)); //placeholder
                    }
                    else {
                        msgResponse.setText("This is not the correct maintainer username");
                    }
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
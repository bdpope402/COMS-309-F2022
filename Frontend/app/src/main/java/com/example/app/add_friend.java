package com.example.app;

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

import org.json.JSONException;
import org.json.JSONObject;

public class add_friend extends AppCompatActivity {
    private Button add;
    private Button back;
    private TextView msgResponse;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        add = findViewById(R.id.add);
        back = findViewById(R.id.back);
        msgResponse = findViewById(R.id.msgResponse);
        name = findViewById(R.id.name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(add_friend.this, friends_list.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postReq();
            }
        });
    }

    private void postReq() {
        RequestQueue queue = Volley.newRequestQueue(add_friend.this);
        String url = "http://coms-309-013.class.las.iastate.edu:8080/login/register/";
        JSONObject regDetails = new JSONObject();
        try {
            regDetails.put("username", name.getText().toString());
        } catch(JSONException e) {
            e.printStackTrace();
        }

        final String request = regDetails.toString();

        StringRequest req = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    msgResponse.setText("You have successfully added a new friend!");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(add_friend.this, friends_list.class));
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

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

public class roster_add extends AppCompatActivity {

    private Button add;
    private EditText firstName;
    private EditText lastName;
    private EditText number;
    private TextView response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster_add);

        response = findViewById(R.id.response_msg);
        Button back = findViewById(R.id.roster_add_back);
        lastName = findViewById(R.id.input_postion);
        number = findViewById(R.id.input_number);
        firstName = findViewById(R.id.input_name);
        Button submit = findViewById(R.id.roster_add_submit);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), edit_roster.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postReq();
            }
        });

    }
        private void postReq() {
            RequestQueue queue = Volley.newRequestQueue(roster_add.this);
            String url = "http://coms-309-013.class.las.iastate.edu:8080/players/new";
            JSONObject playerDetails = new JSONObject();
            try {
                playerDetails.put("first name", firstName.getText());
                playerDetails.put("last name", lastName.getText());
                playerDetails.put("number", number.getText());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            final String request = playerDetails.toString();

            StringRequest req = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String msgResponse) {
                    try {
                        response.setText("You have successfully created a new player!");
                        //final Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//
//                                startActivity(new Intent(view.getContext(), edit_roster.class));
//                            }
//                        }, 2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    response.setText("Looks like something went wrong. Please try again");
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

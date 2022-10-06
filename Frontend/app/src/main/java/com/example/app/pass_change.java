package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class pass_change extends AppCompatActivity {

    private EditText pass1;
    private EditText pass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_change);

        Button back = findViewById(R.id.back_button);
        Button confirm=findViewById(R.id.confirm_button);
        pass1=(EditText)findViewById(R.id.new_pass1);
        pass2=(EditText)findViewById(R.id.new_pass2);

        putReq();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AccountDetails.class));
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass1.getText().toString().equals(pass2.getText().toString())){
                    putReq();
                }
            }
        });
    }


    private void putReq() {
        RequestQueue queue = Volley.newRequestQueue(pass_change.this);

        String url = "http://coms-309-013.class.las.iastate.edu:8080/users/";



        JSONObject json = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                        json.put("username", pass1.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }
}
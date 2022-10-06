package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class AccountDetails extends AppCompatActivity {

    //private TextView msgResponse;
    private TextView username;
    private TextView password;
    private TextView number;
    private TextView email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        username = (TextView) findViewById(R.id.name_here);
        password = (TextView) findViewById(R.id.password_here);
        number = (TextView) findViewById(R.id.number_here);
        email = (TextView) findViewById(R.id.email_here);
        Button back = findViewById((R.id.back_menu));
        Button change_pass = findViewById((R.id.button_change_pass));

        Req();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), pass_change.class));
            }
        });


    }

    private void Req() {
        RequestQueue queue = Volley.newRequestQueue(AccountDetails.this);

        String url = "http://coms-309-013.class.las.iastate.edu:8080/users/";

        JSONObject json = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    username.setText(response.getString("username"));
                    email.setText(response.getString("email"));
                    number.setText(response.getString("phoneNum"));
                    password.setText(response.getString("password"));
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
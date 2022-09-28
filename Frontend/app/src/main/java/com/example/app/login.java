package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

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

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    private Button login;
    private TextView msgResponse;
    private EditText username;
    private EditText password;

    public static String userInput;
    public static String passInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login);
        msgResponse = (TextView) findViewById(R.id.msgResponse);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getReq();
            }
        });
    }

    private void getReq() {
        RequestQueue queue = Volley.newRequestQueue(login.this);

        userInput = username.getText().toString();
        passInput = password.getText().toString();

        String url = "https://26ee0a9a-f41e-41c7-9e14-e30c8ccd3267.mock.pstmn.io/object/";
        JSONObject json = new JSONObject();
        try {
            json.put("username", userInput);
            json.put("password", passInput);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String requestBody = json.toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                   JSONObject responseObj = response;
                   String correctUser = responseObj.getString("username");
                   String correctPass = responseObj.getString("password");
                   if (correctUser.equals(userInput) && correctPass.equals(passInput)) {
                       Intent intent = new Intent(login.this, activity_menu.class);
                       startActivity(intent);
                   }
                   else {
                       msgResponse.setText("Username or Password is wrong");
                   }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                msgResponse.setText(error.toString());
            }
        });
        queue.add(request);
     }
}

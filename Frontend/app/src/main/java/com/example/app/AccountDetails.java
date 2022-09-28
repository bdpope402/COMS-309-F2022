package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.transform.ErrorListener;

public class AccountDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        Button back = findViewById((R.id.back_menu));
        Button nameEdit=findViewById(R.id.edit_name);
        Button emailEdit=findViewById(R.id.edit_email);
        Button phoneNumberEdit=findViewById(R.id.edit_phoneNumber);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
    }
    private void getReq() {
        RequestQueue queue = Volley.newRequestQueue(AccountDetails.this);

        String url = "https://26ee0a9a-f41e-41c7-9e14-e30c8ccd3267.mock.pstmn.io/object/";
        JSONObject json = new JSONObject();

        final String requestBody = json.toString();


//        JsonObjectRequest request = JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){
//
//        });
    }
}
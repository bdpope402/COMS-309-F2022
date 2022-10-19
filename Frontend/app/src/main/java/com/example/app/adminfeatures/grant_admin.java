package com.example.app.adminfeatures;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.R;
import com.example.app.activity_menu;
import com.example.app.admin_page;
import com.example.app.login;
import com.example.app.pass_change;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

import org.json.JSONException;

public class grant_admin extends AppCompatActivity {

    private Spinner privileges;
    private Button grant_privileges;
    private TextView msgResponse;
    private EditText username;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant_admin);

        privileges = (Spinner) findViewById(R.id.privileges);
        msgResponse = (TextView) findViewById(R.id.msgResponse);
        username = (EditText) findViewById(R.id.username);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.privileges, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        privileges.setAdapter(adapter);

        grant_privileges = (Button) findViewById(R.id.grant_privileges);
        back = (Button) findViewById(R.id.back);

        grant_privileges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String perms = privileges.getSelectedItem().toString();
                String user = username.getText().toString();
                putReq(perms, user);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(grant_admin.this, admin_page.class);
                startActivity(intent);
            }
        });

    }

    private void putReq(String perms, String username) {
        RequestQueue queue = Volley.newRequestQueue(grant_admin.this);

        String url = "http://coms-309-013.class.las.iastate.edu:8080/users/"+username;

        try {
            login.profile.remove("permLv");
            login.profile.put("permLv", perms);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String jsonString = login.profile.toString();
        StringRequest request = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                msgResponse.setText("You have successfully granted permissions!");
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                msgResponse.setText("It looks like something went wrong. Please try again");
                error.printStackTrace();
            }
        }) {
            @Override
            public byte[] getBody() {
                return jsonString.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };

        queue.add(request);
    }
}
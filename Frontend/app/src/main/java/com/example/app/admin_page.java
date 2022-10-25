package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.adminfeatures.grant_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class admin_page extends AppCompatActivity {

    private Button grant_admin;
    private TextView admin_level;
    private Button back;
    private Button vendor_info;
    private TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        grant_admin = (Button) findViewById(R.id.grant_admin);
        admin_level = (TextView) findViewById(R.id.adminlevel);
        back = (Button) findViewById(R.id.back);
        vendor_info = (Button) findViewById(R.id.change_vendor);
        response = (TextView) findViewById(R.id.response);

        try { admin_level.setText("Current admin level: " + login.profile.getString("permLv")); }
        catch (JSONException e) { e.printStackTrace(); }

        grant_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (login.profile.getString("permLv").equals("Admin")) {
                        Intent intent = new Intent(admin_page.this, grant_admin.class);
                        startActivity(intent);
                    }
                    else {
                        response.setText("You don't have the right permission level");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        vendor_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (login.profile.getString("permLv").equals("Vendor") || login.profile.getString("permLv").equals("Admin")) {
                        Intent intent = new Intent(admin_page.this, activity_menu.class); //placeholder for when concessions are made
                        startActivity(intent);
                    }
                    else {
                        response.setText("You don't have the right permission level");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_page.this, activity_menu.class);
                startActivity(intent);
            }
        });
    }
}
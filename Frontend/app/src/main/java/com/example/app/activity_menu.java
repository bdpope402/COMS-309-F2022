package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONException;

public class activity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button page1 = findViewById(R.id.button);
        Button page2 = findViewById(R.id.button2);
        Button page3 = findViewById(R.id.button3);
        Button page4 = findViewById(R.id.button4);
        Button page5 = findViewById(R.id.button5);
        Button page6 = findViewById(R.id.button6);
        TextView response = findViewById(R.id.response);

        Button logout = findViewById(R.id.button_logout);

        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });

        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), concessions.class));
            }
        });

        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });

        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });

        page5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (login.profile.getString("permLv").equals("Admin")) {
                        startActivity(new Intent(view.getContext(), admin_page.class));
                    }
                    else {
                        response.setText("You don't have the permissions to do that");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        page6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AccountDetails.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });


    }
}
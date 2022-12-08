package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.json.JSONException;

public class private_message extends AppCompatActivity {
    private Button back;
    private TextView title;


    private WebSocketClient cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_message);
        back = findViewById(R.id.back);
        title = findViewById(R.id.textView39);

        title.setText(friends_list.friend_name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(private_message.this, friends_list.class));
            }
        });

        try {
            String url = "http://coms-309-013.class.las.iastate.edu:8080/dm/" + login.profile.getString("username") + "/" + friends_list.friend_name;
        } catch (JSONException e) {e.printStackTrace();}

        

    }
}
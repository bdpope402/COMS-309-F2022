package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;

public class game_chat extends AppCompatActivity {

    Button back, send, connect;
    EditText message;
    TextView chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_chat);


        back = (Button) findViewById(R.id.back_button_gamechat);
        send = (Button) findViewById(R.id.button13);
        connect = (Button) findViewById(R.id.connect_button);
        message = (EditText) findViewById(R.id.gamechat_message_input);
        chat = (TextView) findViewById(R.id.chatroom_text);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Draft[] drafts = {
                        new Draft_6455()
                };


            }
        });
    }
}
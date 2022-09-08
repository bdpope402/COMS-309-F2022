package com.example.experiment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton page1 = findViewById(R.id.imageButton);
        ImageButton page2 = findViewById(R.id.imageButton2);
        ImageButton page3 = findViewById(R.id.imageButton3);
        ImageButton page4 = findViewById(R.id.imageButton4);

        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), extraPage_1.class));
            }
        });

        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), extraPage_2.class));
            }
        });

        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), extraPage_3.class));
            }
        });

        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), extraPage_4.class));
            }
        });
    }
}
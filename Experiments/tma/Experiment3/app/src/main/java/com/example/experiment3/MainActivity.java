package com.example.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button fun, semi_fun, not_fun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fun = (Button) findViewById(R.id.fun);
        semi_fun = (Button) findViewById(R.id.semi_fun);
        not_fun = (Button) findViewById(R.id.not_fun);

        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , fun.class);
                startActivity(i);
            }
        });

        semi_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , semi_fun.class);
                startActivity(i);
            }
        });

        not_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , not_fun.class);
                startActivity(i);
            }
        });
    }
}
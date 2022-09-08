package com.example.experiment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class extraPage_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_page1);

        Button backButton = findViewById(R.id.backButton);
        Button randomButton =findViewById(R.id.randomButton);
        TextView text = findViewById(R.id.randNum);
        Random rand = new Random();
        Integer[] count = {0};


        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count[0]=rand.nextInt(100);
                text.setText(count[0].toString());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
    }
}
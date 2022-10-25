package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.app.databinding.ActivityConcessionsBinding;

public class concessions extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concessions);

        ConstraintLayout lin = findViewById(R.id.concessions);
        int y = 100;
        int x = 100;

        Button n = new Button(this);
        n.setId(1);
        lin.addView(n);
        ConstraintSet constraint = new ConstraintSet();
        constraint.clone(lin);
        ConstraintSet.connect(R.id.button1)
        n.setText("hi");
        //n.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("hi");
            }
        });
    }
}
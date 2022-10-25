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

import java.util.ArrayList;

public class concessions extends AppCompatActivity {
    ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concessions);
        buttons = new ArrayList<>();

        ConstraintLayout lin = findViewById(R.id.concessions);
        int y = 100;
        int x = 400;
        int i;

        for (i = 0; i < 4; i++) {
            Button n = new Button(this);
            n.setId(i + 1);
            n.setTag(i + 1);
            n.setText("hi");
            buttons.add(n);
        }

        for (i = 0; i < 4; i++) {
            lin.addView(buttons.get(i));
        }

        ConstraintSet constraint = new ConstraintSet();
        for (i = 0; i < 4; i++) {
            constraint.clone(lin);
            constraint.connect(buttons.get(i).getId(), ConstraintSet.RIGHT, R.id.concessions, ConstraintSet.RIGHT, y);
            constraint.connect(buttons.get(i).getId(), ConstraintSet.TOP, R.id.concessions, ConstraintSet.TOP, (x + (100 * i)));
            constraint.applyTo(lin);
        }

//        n.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.print("hi");
//            }
//        });
//
//        lin.addView(n);
    }
}
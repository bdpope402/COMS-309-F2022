package com.example.app;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;

public class concessions extends AppCompatActivity {
    private ArrayList<Button> buttons;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concessions);
        buttons = new ArrayList<>();
        back = (Button) findViewById(R.id.back);

        ConstraintLayout lin = findViewById(R.id.concessions);
        int y = 400;
        int x = 300;
        int i;
        int count = 10;
        ConstraintSet constraint = new ConstraintSet();

        for (i = 0; i < count; i++) {
            Button n = (Button) LayoutInflater.from(this).inflate(R.layout.button, null);
            n.setId(i + 1);
            n.setTag(i + 1);
            n.setText("hi");
            n.setTextColor(getResources().getColor(R.color.white));
            n.setBackgroundColor(getResources().getColor(R.color.purple_500));
            buttons.add(n);
        }

        for (i = 0; i < count; i++) {
            lin.addView(buttons.get(i));
        }

        for (i = 0; i < count; i++) {
            constraint.clone(lin);
            constraint.connect(buttons.get(i).getId(), ConstraintSet.RIGHT, R.id.concessions, ConstraintSet.RIGHT, y);
            constraint.connect(buttons.get(i).getId(), ConstraintSet.LEFT, R.id.concessions, ConstraintSet.LEFT, y);
            constraint.connect(buttons.get(i).getId(), ConstraintSet.TOP, R.id.concessions, ConstraintSet.TOP, (x + (200 * i)));
            constraint.applyTo(lin);
        }

        constraint.clone(lin);
        constraint.connect(back.getId(), ConstraintSet.RIGHT, R.id.concessions, ConstraintSet.RIGHT, y);
        constraint.connect(back.getId(), ConstraintSet.LEFT, R.id.concessions, ConstraintSet.LEFT, y);
        constraint.connect(back.getId(), ConstraintSet.TOP, buttons.get(count - 1).getId(), ConstraintSet.TOP, 200);
        constraint.applyTo(lin);

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
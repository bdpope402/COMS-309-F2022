package com.example.app.adminfeatures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.R;

public class vendor_change extends AppCompatActivity {
    private EditText menu_item;
    private EditText price;
    private EditText calories;
    private Button add_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_change);
    }
}
package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class concessions extends AppCompatActivity {
    private ArrayList<Button> buttons;
    private Button back;
    private JSONArray vendors = new JSONArray();
    public static String vendor_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concessions);
        buttons = new ArrayList<>();
        back = (Button) findViewById(R.id.back);

        ConstraintLayout lin = findViewById(R.id.concessions);
//        getReq();

        int y = 400;
        int x = 300;
        int i;
//        int count = vendors.length();
        int count = 20;
        ConstraintSet constraint = new ConstraintSet();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(concessions.this, activity_menu.class));
            }
        });

        for (i = 0; i < count; i++) {
            Button n = (Button) LayoutInflater.from(this).inflate(R.layout.button, null);
            n.setId(i + 1);
            n.setTag(i + 1);
            n.setText("hi");
            //n.setText(vendors.get(i).getString("name") + ", location: " + vendors.get(i).getString("location"));
            n.setTextColor(getResources().getColor(R.color.white));
            n.setBackgroundColor(getResources().getColor(R.color.purple_500));
            n.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vendor_name = n.getText().toString();
                    startActivity(new Intent(concessions.this, concessions_info.class));
                }
            });
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

    }

    private void getReq() {
        RequestQueue queue = Volley.newRequestQueue(concessions.this);
        String url = "http://coms-309-013.class.las.iastate.edu:8080/vendors/all";
        JSONObject json = new JSONObject();
        final String requestBody = json.toString();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject responseObj = response.getJSONObject(i);
                        vendors.put(responseObj.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public byte[] getBody() {
                return requestBody.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        queue.add(request);
    }
}
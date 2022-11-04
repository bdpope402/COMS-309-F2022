package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class concessions_info extends AppCompatActivity {
    private TextView vend_name;
    private TextView location;
    private String id;
    private JSONObject vendor;
    private JSONArray menuItems;
    private ArrayList<TextView> item_names;
    private ArrayList<TextView> item_prices;
    private ArrayList<TextView> item_calories;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concessions_info);
        vendor = new JSONObject();
        menuItems = new JSONArray();
        item_names = new ArrayList<>();
        item_prices = new ArrayList<>();
        item_calories = new ArrayList<>();
        int y = 150;
        int x = 200;
        int i;
        int length = 10;
        back = (Button) findViewById(R.id.back);
        //int length = menuItems.length()

        vend_name = findViewById(R.id.vendor_name);
        vend_name.setText(concessions.vendor_name);
        location = findViewById(R.id.location);
        ConstraintLayout lin = findViewById(R.id.menu);
        ConstraintSet constraint = new ConstraintSet();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(concessions_info.this, concessions.class));
            }
        });

//        getVendorReq();
//        try {
//            location.setText(vendor.getString("location"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        getMenuReq();

        for (i = 0; i < length * 3; i += 3) {
            TextView menu = (TextView) LayoutInflater.from(this).inflate(R.layout.textview, null);
            TextView price = (TextView) LayoutInflater.from(this).inflate(R.layout.textview, null);
            TextView calories = (TextView) LayoutInflater.from(this).inflate(R.layout.textview, null);
            menu.setId(i);
            price.setId(i + 1);
            calories.setId(i + 2);
//            try {
//                menu.setText("Item: " + menuItems.getJSONObject((i + 1) / 3).getString("item_name"));
//                price.setText("Price: " + menuItems.getJSONObject((i + 1) / 3).getString("price"));
//                calories.setText("Calories: " + menuItems.getJSONObject((i + 1) / 3).getString("calories"));
                menu.setText("Item: ");
                price.setText("Price: ");
                calories.setText("Calories: ");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            item_names.add(menu);
            item_prices.add(price);
            item_calories.add(calories);
        }

        for (i = 0; i < item_names.size(); i++) {
            lin.addView(item_names.get(i));
            lin.addView(item_prices.get(i));
            lin.addView(item_calories.get(i));
        }

        for (i = 0; i < item_names.size(); i++) {
            constraint.clone(lin);
            constraint.connect(item_names.get(i).getId(), ConstraintSet.LEFT, R.id.menu, ConstraintSet.LEFT, y);
            constraint.connect(item_names.get(i).getId(), ConstraintSet.TOP, R.id.menu, ConstraintSet.TOP, (x + (200 * i)));
            constraint.applyTo(lin);
            constraint.clone(lin);
            constraint.connect(item_prices.get(i).getId(), ConstraintSet.LEFT, R.id.menu, ConstraintSet.LEFT, y);
            constraint.connect(item_prices.get(i).getId(), ConstraintSet.TOP, R.id.menu, ConstraintSet.TOP, (x + 100 + (200 * i)));
            constraint.applyTo(lin);
            constraint.clone(lin);
            constraint.connect(item_calories.get(i).getId(), ConstraintSet.LEFT, R.id.menu, ConstraintSet.LEFT, y);
            constraint.connect(item_calories.get(i).getId(), ConstraintSet.TOP, R.id.menu, ConstraintSet.TOP, (x + 200 + (200 * i)));
            constraint.applyTo(lin);
            x += 100;
        }

        constraint.clone(lin);
        constraint.connect(back.getId(), ConstraintSet.RIGHT, R.id.menu, ConstraintSet.RIGHT, y);
        constraint.connect(back.getId(), ConstraintSet.LEFT, R.id.menu, ConstraintSet.LEFT, y);
        constraint.connect(back.getId(), ConstraintSet.TOP, item_calories.get(length - 1).getId(), ConstraintSet.TOP, 200);
        constraint.applyTo(lin);

    }

    private void getVendorReq() {
        RequestQueue queue = Volley.newRequestQueue(concessions_info.this);
        String url = "http://coms-309-013.class.las.iastate.edu:8080/vendors/" + concessions.vendor_name;
        JSONObject json = new JSONObject();
        final String requestBody = json.toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    vendor.put("name", response.getString("name"));
                    vendor.put("location", response.getString("location"));
                    vendor.put("id", response.getString("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
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

    private void getMenuReq() {
        RequestQueue queue = Volley.newRequestQueue(concessions_info.this);
        String url = null;
        try {
            url = "http://coms-309-013.class.las.iastate.edu:8080/menus/" + vendor.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        final String requestBody = json.toString();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject responseObj = response.getJSONObject(i);
                        menuItems.put(responseObj.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
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
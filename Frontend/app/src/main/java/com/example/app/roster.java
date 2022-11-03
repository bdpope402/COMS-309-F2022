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

public class roster extends AppCompatActivity {

    private JSONArray players = new JSONArray();
    private ArrayList<TextView> firstName;
    private ArrayList<TextView> lastName;
    private ArrayList<TextView> numberList;
    private TextView number_title;
    private TextView first_title;
    private TextView last_title;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);
        players=new JSONArray();
        int i;
        int y= 30;
        int x = 50;
        ConstraintLayout lay=findViewById(R.id.roster_layout);
        ConstraintSet con=new ConstraintSet();
        Button back = findViewById(R.id.back_button_roster);
        Button edit = findViewById(R.id.edit_roster_button);

        getReq();

        //TABLE NO WORK DELETED

        for (i=0;i<players.length()*3;i+=3){
            TextView first = (TextView) LayoutInflater.from(this).inflate(R.layout.activity_roster, null);
            TextView last = (TextView) LayoutInflater.from(this).inflate(R.layout.activity_roster, null);
            TextView number = (TextView) LayoutInflater.from(this).inflate(R.layout.activity_roster, null);
            first.setId(i);
            last.setId(i+1);
            number.setId(i+2);

            try{
                first.setText(players.getJSONObject((i+1)/3).getString("first name"));
                last.setText(players.getJSONObject((i+1)/3).getString("last name"));
                number.setText(players.getJSONObject((i+1)/3).getString("number"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            firstName.add(first);
            lastName.add(last);
            numberList.add(number);
        }


        for(i=0;i<firstName.size();i++){
            lay.addView(firstName.get(i));
            lay.addView(lastName.get(i));
            lay.addView(numberList.get(i));
        }

        for (i = 0; i < firstName.size(); i++) {
            con.clone(lay);
            con.connect(firstName.get(i).getId(), ConstraintSet.LEFT, R.id.roster_layout, ConstraintSet.LEFT, y);
            con.connect(firstName.get(i).getId(), ConstraintSet.TOP, R.id.roster_layout, ConstraintSet.TOP, (x + (200 * i)));
            con.applyTo(lay);
            con.clone(lay);
            con.connect(lastName.get(i).getId(), ConstraintSet.LEFT, R.id.roster_layout, ConstraintSet.LEFT, y);
            con.connect(lastName.get(i).getId(), ConstraintSet.TOP, R.id.roster_layout, ConstraintSet.TOP, (x + 100 + (200 * i)));
            con.applyTo(lay);
            con.clone(lay);
            con.connect(numberList.get(i).getId(), ConstraintSet.LEFT, R.id.roster_layout, ConstraintSet.LEFT, y);
            con.connect(numberList.get(i).getId(), ConstraintSet.TOP, R.id.roster_layout, ConstraintSet.TOP, (x + 200 + (200 * i)));
            con.applyTo(lay);
        }



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), activity_menu.class));
            }
        });

        //TODO make only maintainers can edit
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), edit_roster.class));
            }
        });
    }



    private void getReq() {
        RequestQueue queue = Volley.newRequestQueue(roster.this);


        String url = "http://coms-309-013.class.las.iastate.edu:8080/players";
        JSONObject json = new JSONObject();
        final String requestBody = json.toString();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                //for all player objects, put it in response, then in the players array
                for(int i=0;i<response.length();i++) {
                    try {
                        JSONObject responseObj=response.getJSONObject(i);
                        players.put(responseObj.toString());

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
package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class roster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        Button back = findViewById(R.id.back_button_roster);
        Button edit = findViewById(R.id.edit_roster_button);

//        getReq();

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
                startActivity(new Intent(view.getContext(), activity_menu.class));
            }
        });
    }



//    private void getReq() {
//        RequestQueue queue = Volley.newRequestQueue(roster.this);
//
//        //TODO get right URL from bryan
//        String url = "http://coms-309-013.class.las.iastate.edu:8080/users/" + login.userInput;
//        JSONObject json = new JSONObject();
//        final String requestBody = json.toString();
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
//                //TODO FILL TABLE HERE
//                //how to do scrollable? way too many to fit on one screen but is scrollable easier than mul. pages?
//                try {
//                    username.setText(response.getString("username"));
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        }){
//            @Override
//            public byte[] getBody() {
//                return requestBody.getBytes();
//            }
//
//            @Override
//            public String getBodyContentType() {
//                return "application/json; charset=utf-8";
//            }
//        };
//        queue.add(request);
//    }
}
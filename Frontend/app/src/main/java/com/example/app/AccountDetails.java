package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import javax.xml.transform.ErrorListener;




public class AccountDetails extends AppCompatActivity {

    private TextView msgResponse;
    private EditText username;
    private EditText password;


    public static String userInput;
    public static String passInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);


        Button back = findViewById((R.id.back_menu));
        Button change_pass = findViewById((R.id.button_change_pass));


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
    }
    private void getReq() {
        RequestQueue queue = Volley.newRequestQueue(AccountDetails.this);

        String url = "https://26ee0a9a-f41e-41c7-9e14-e30c8ccd3267.mock.pstmn.io/object/";
        JSONObject json = new JSONObject();

//        try {
//            json.put("username", userInput);
//            json.put("password", passInput);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        final String requestBody = json.toString();


     JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){

         @Override
         public void onResponse(JSONArray response) {

         }
         }, new Response.ErrorListener(){
             @Override
             public void onErrorResponse(VolleyError error) {
                 msgResponse.setText(error.toString());
             }

     });
     queue.add(request);
     }
}
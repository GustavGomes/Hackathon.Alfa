package com.hackathon.alfa;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private String cpf, senha;
    private String URL = "http://192.168.1.110:80/APIHackathon/API.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.btnLogin);
        Button generateRelatorio = (Button) findViewById(R.id.btnGenerateDocument);

        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    login(v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        generateRelatorio.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }


    protected void login(View view) throws Exception {
        TextView message = (TextView)findViewById(R.id.errorMessage);
        EditText cpfText = (EditText) findViewById(R.id.edUsername);
        EditText senhaText = (EditText) findViewById(R.id.edPassword);
        String cpf = cpfText.getText().toString();
        String senha = senhaText.getText().toString();

        JSONObject params = new JSONObject();
        params.put("cpf", cpf);
        params.put("senha", senha);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, URL, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    if (response.getString("success").equals("1")) {
                        message.setTextColor(Color.parseColor("#00FF00"));
                        message.setText("Sucesso!");
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    } else {
                        message.setTextColor(Color.parseColor("#ff0000"));
                        message.setText("Usuário incorreto");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                message.setTextColor(Color.parseColor("#ff0000"));
                message.setText("Dados incorretos!");
            }
        });
        Volley.newRequestQueue(this).add(jsonRequest);
    }

}
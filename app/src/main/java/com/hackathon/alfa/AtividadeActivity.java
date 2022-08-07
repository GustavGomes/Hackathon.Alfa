package com.hackathon.alfa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AtividadeActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AtividadeActivity.this, HomeActivity2.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade);
        Button button2;
        button2 = (Button) findViewById(R.id.button2);





        TextView textView = (TextView) findViewById(R.id.textView);

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AtividadeActivity.this, GravacaoActivity.class));
                String atividade;
                atividade = textView.getText().toString();
            }
        });



    }

}
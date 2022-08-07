package com.hackathon.alfa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



import java.nio.channels.AcceptPendingException;

public class MembrosEquipe extends AppCompatActivity {
    String nome, tempo;

    EditText inputText;
    EditText inputText2;

    ImageButton imageButton2;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MembrosEquipe.this,HomeActivity2.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membros_equipe);

        inputText = (EditText) findViewById(R.id.inputText);
        inputText2 = (EditText) findViewById(R.id.inputText2);

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = inputText.getText().toString();
                tempo = inputText2.getText().toString();
                inputText.getText().clear();
                inputText2.getText().clear();
                ;}
        });
        Button button2;
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MembrosEquipe.this, EquipamentosActivity.class));
            }
        });
    }
}
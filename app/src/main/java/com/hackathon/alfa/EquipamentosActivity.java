package com.hackathon.alfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EquipamentosActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        startActivity(new Intent(EquipamentosActivity.this,HomeActivity2.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamentos);
        Button button2;
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EquipamentosActivity.this, fotoActivity.class));
            }
        });
    }
}
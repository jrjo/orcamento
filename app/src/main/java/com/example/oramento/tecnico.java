package com.example.oramento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tecnico extends Activity {
    Button btngravartecnico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnico);

        btngravartecnico = findViewById(R.id.btngravartecnico);
        btngravartecnico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telapecas = new Intent(getApplicationContext(), pecas.class);
                startActivity(telapecas);
            }
        });
    }
}
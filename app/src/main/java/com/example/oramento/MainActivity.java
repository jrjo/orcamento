package com.example.oramento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button telaorcamenttocliente = (Button) findViewById(R.id.orcamento);
        telaorcamenttocliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela_orcamentocliente = new Intent(getApplicationContext(), tela_orcamento_cliente.class);

                startActivity(tela_orcamentocliente);
            }
        });

        }
    }



package com.example.oramento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tela_orcamento_cliente extends Activity {

    // as variaveis usadas
    RadioGroup clientecpfcnpfrdg;
    RadioButton clientecnpj;
    RadioButton clientecpf;
    EditText edtcliente;
    Button btngravar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_orcamento_cliente);

        // pegando o Id edittext cnpj cpf
        edtcliente = findViewById(R.id.clientecpfcnpjtext);

        //escondendo o edittext cnpj cpf
        edtcliente.setVisibility(View.GONE);

        // pegando id group buttom
        clientecpfcnpfrdg = findViewById(R.id.cpfcnpjclientedg);

        // chamdno a função que mostra o edittext ou cnpj ou cpf conforme a escolha do radio button
        this.verificarradiogrupo();

        //pegando os id dos radio button
        clientecnpj = findViewById(R.id.clientecnpj);
        clientecpf = findViewById(R.id.clientecpf);

        // mascara do campo data
        EditText clientedata = (EditText) findViewById(R.id.clientedata);
       SimpleMaskFormatter smfdata = new SimpleMaskFormatter("NN/NN/NNNN");
       MaskTextWatcher mtwdata = new MaskTextWatcher(clientedata, smfdata);
       clientedata.addTextChangedListener(mtwdata);

       // button gravar e chamar a proxima tela;

        btngravar = findViewById(R.id.btngravar);
        btngravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela_tecnico = new Intent(getApplicationContext(), tecnico.class);
                startActivity(tela_tecnico);
            }
        });

















    }





       // função que chama o editbox cnpj ou cpf conforme escolha no radio button
     public void verificarradiogrupo(){
        clientecpfcnpfrdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // edittext cnpj
                if(checkedId == R.id.clientecnpj){
                    checkedId = 1;
                    if(checkedId == 1){ clientecnpj.postDelayed(tela_orcamento_cliente.this::verificarradiogrupo, 2000);{
                    clientecpf = findViewById(R.id.clientecpf);
                    clientecpf.setChecked(false);
                    edtcliente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
                    edtcliente = findViewById(R.id.clientecpfcnpjtext);
                    edtcliente.setVisibility(View.VISIBLE);
                    edtcliente.setText("");

                    edtcliente.setHint("CNPJ :");}



                }}

                // edittext cpf
                if(checkedId == R.id.clientecpf){
                    checkedId = 1;
                    clientecpf.postDelayed(tela_orcamento_cliente.this::verificarradiogrupo, 2000);{
                    if(checkedId == 1){
                    clientecnpj = findViewById(R.id.clientecnpj);
                    clientecnpj.setChecked(false);
                    edtcliente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                    edtcliente = findViewById(R.id.clientecpfcnpjtext);
                    edtcliente = findViewById(R.id.clientecpfcnpjtext);
                    edtcliente.setVisibility(View.VISIBLE);
                    edtcliente.setText("");
                    edtcliente.setHint("CPF :");}



                }
            }

            }
        });
    }


    public void gravarcliente(View view) {
    }
}









package com.example.davidalexfarina.pedidosmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MesasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);

        Toast.makeText(this,"Selecione a mesa desejada.",Toast.LENGTH_SHORT).show();
    }
    public void abrirPedidosDaMesa(View view){

        Intent intent = new Intent(this, PedidoDaMesaActivity.class);
        startActivity(intent);
    }

}

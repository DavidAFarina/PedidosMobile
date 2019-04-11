package com.example.davidalexfarina.pedidosmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(new MesaAdapters(this, Mesa.getMesas()));

        /*lista.setOnItemClickListener(this);*/

    }
}

package com.example.davidalexfarina.pedidosmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PedidoDaMesaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_da_mesa);

        //Lista
        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(new PizzasAdapters(this, Pizza.getPizzas()));

        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Pizza album = (Pizza) parent.getItemAtPosition(position);

        Toast.makeText(this,"Pizza " + (position+1) + ": "
                + album.nomePizza, Toast.LENGTH_SHORT).show();
    }
}

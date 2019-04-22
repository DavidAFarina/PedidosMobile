package com.example.davidalexfarina.pedidosmobile;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class PedidoDaMesaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Button btnPizzas;
    private Button btnPorcoes;
    private Button btnBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_da_mesa);

        //Lista
        final ListView lista = findViewById(R.id.lista);
        //Lista de Pizza
       lista.setAdapter(new PizzasAdapters(this, Pizza.getPizzas()));
        //Lista de Porcoes
        //lista.setAdapter(new PorcoesAdapters(this, Porcao.getPorcoes()));
        //Lista de Bebidas
       // lista.setAdapter(new BebidasAdapters(this, Bebida.getBebidas()));

        lista.setOnItemClickListener(this);


        btnPizzas = (Button) findViewById(R.id.btnPizzas);
        btnPorcoes = (Button) findViewById(R.id.btnPorcoes);
        btnBebidas = (Button) findViewById(R.id.btnBebidas);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Ainda precisa ser implementado esse método onItemClick ", Toast.LENGTH_LONG).show();
        /*Pizza pizza = (Pizza) parent.getItemAtPosition(position);
        Toast.makeText(this,"Pizza " + (position+1) + ": "
               + pizza.nomePizza, Toast.LENGTH_SHORT).show();

        Bebida bebida = (Bebida) parent.getItemAtPosition(position);
        Toast.makeText(this,"Pizza " + (position+1) + ": "
                + bebida.nomeBebida, Toast.LENGTH_SHORT).show();

        Porcao porcao = (Porcao) parent.getItemAtPosition(position);
        Toast.makeText(this,"Porção " + (position+1) + ": "
                + bebida.nomeBebida, Toast.LENGTH_SHORT).show();*/
    }


    public void abrirListaPizzas(View view){
        final ListView lista = findViewById(R.id.lista);

        lista.setAdapter(new PizzasAdapters(this, Pizza.getPizzas()));
        lista.setOnItemClickListener(this);

    }

    public void abrirListaPorcoes(View view){
        final ListView lista = findViewById(R.id.lista);
        lista.setAdapter(new PorcoesAdapters(this, Porcao.getPorcoes()));
        lista.setOnItemClickListener(this);

    }

    public void abrirListaBebidas(View view){
        final ListView lista = findViewById(R.id.lista);
        lista.setAdapter(new BebidasAdapters(this, Bebida.getBebidas()));
        lista.setOnItemClickListener(this);

    }
}

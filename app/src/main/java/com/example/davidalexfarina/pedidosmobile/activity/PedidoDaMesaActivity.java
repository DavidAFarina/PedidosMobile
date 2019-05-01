package com.example.davidalexfarina.pedidosmobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.adapter.BebidasAdapters;
import com.example.davidalexfarina.pedidosmobile.adapter.PizzasAdapters;
import com.example.davidalexfarina.pedidosmobile.adapter.PorcoesAdapters;

import java.util.ArrayList;
import java.util.List;

public class PedidoDaMesaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Button btnPizzas;
    private Button btnPorcoes;
    private Button btnBebidas;
    private int listaCarregada = 1; //Variavel utilizada para validar a lista atual que esta selecionada e será utilizada no click do item da lista..
    private TextView txtMesaAutal; //Variavel que recebe recebera o valor da mesa que foi selecionada no onclick da tela acticity_mesas
    private TextView txtNomeGarcom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_da_mesa);

        //Lista
        final ListView lista = findViewById(R.id.lista);
        //Lista de PizzaActivity
       lista.setAdapter(new PizzasAdapters(this, PizzaActivity.getPizzas()));
        //Lista de Porcoes
        //lista.setAdapter(new PorcoesAdapters(this, PorcaoActivity.getPorcoes()));
        //Lista de Bebidas
       // lista.setAdapter(new BebidasAdapters(this, BebidaActivity.getBebidas()));

        lista.setOnItemClickListener(this);


        btnPizzas = (Button) findViewById(R.id.btnPizzas);
        btnPorcoes = (Button) findViewById(R.id.btnPorcoes);
        btnBebidas = (Button) findViewById(R.id.btnBebidas);


        //Teste dentro do onCreate
        TextView txtMesaAutal = findViewById(R.id.txtMesaAutal);
        TextView txtNomeGarcom = findViewById(R.id.txtNomeGarcom);
        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        String numeroMesa = parametros.getString("numeroMesa");
        String garcom = parametros.getString("garcom");



       txtMesaAutal.setText(numeroMesa);
       txtNomeGarcom.setText(garcom);





    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,"Ainda precisa ser implementado esse método onItemClick ", Toast.LENGTH_LONG).show();
        if(listaCarregada == 1){
            PizzaActivity pizzaActivity = (PizzaActivity) parent.getItemAtPosition(position);
            Toast.makeText(this,"PizzaActivity " + (position+1) + ": "
                    + pizzaActivity.nomePizza, Toast.LENGTH_SHORT).show();



        }
        if(listaCarregada == 2){
            PorcaoActivity porcaoActivity = (PorcaoActivity) parent.getItemAtPosition(position);
            Toast.makeText(this,"Porção " + (position+1) + ": "
                    + porcaoActivity.nomePorcao, Toast.LENGTH_SHORT).show();
        }
        if(listaCarregada == 3){
            BebidaActivity bebidaActivity = (BebidaActivity) parent.getItemAtPosition(position);
            Toast.makeText(this,"PizzaActivity " + (position+1) + ": "
                    + bebidaActivity.nomeBebida, Toast.LENGTH_SHORT).show();
        }
    }


    public void abrirListaPizzas(View view){
        final ListView lista = findViewById(R.id.lista);

        lista.setAdapter(new PizzasAdapters(this, PizzaActivity.getPizzas()));
        lista.setOnItemClickListener(this);
        listaCarregada = 1;
    }

    public void abrirListaPorcoes(View view){
        final ListView lista = findViewById(R.id.lista);
        lista.setAdapter(new PorcoesAdapters(this, PorcaoActivity.getPorcoes()));
        lista.setOnItemClickListener(this);
        listaCarregada = 2;
    }

    public void abrirListaBebidas(View view){
        final ListView lista = findViewById(R.id.lista);
        lista.setAdapter(new BebidasAdapters(this, BebidaActivity.getBebidas()));
        lista.setOnItemClickListener(this);
        listaCarregada = 3;
    }

}

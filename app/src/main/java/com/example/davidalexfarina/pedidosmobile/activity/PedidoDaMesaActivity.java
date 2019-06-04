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
import com.example.davidalexfarina.pedidosmobile.dialog.LoginDialog;
import com.example.davidalexfarina.pedidosmobile.dialog.TamanhoDialog;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.EditarProdutoActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.SolicitacaoDaMesaActivity;

import java.util.ArrayList;
import java.util.List;

public class PedidoDaMesaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Button btnPizzas;
    private Button btnPorcoes;
    private Button btnBebidas;
    private Button btnConferirPedidos;
    private int listaCarregada = 1; //Variavel utilizada para validar a lista atual que esta selecionada e será utilizada no click do item da lista..
    private TextView txtMesaAutal; //Variavel que recebe recebera o numero da mesa que foi selecionada no onclick da tela acticity_mesas
    private TextView txtNomeGarcom; //Variavel que recebe recebera o nome do uruario que se autenticou e registrou o pedido
    private  int mesa;
    private String ngarcom;
    private String tamanho = "teste";//Variavel que recebe do dialog o tamanho selecionado
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
        Button btnConferirPedidos = (Button) findViewById(R.id.btnConferirPedidos);

        //Teste dentro do onCreate
        TextView txtMesaAutal = findViewById(R.id.txtMesaAutal);
        TextView txtNomeGarcom = findViewById(R.id.txtNomeGarcom);
        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        String numeroMesa = parametros.getString("numeroMesa");
        String garcom = parametros.getString("garcom");

        txtMesaAutal.setText(numeroMesa);
        txtNomeGarcom.setText(garcom);

        Bundle parametroTamanho = intent.getExtras();
        String tamanho = parametroTamanho.getString("paramTamanho");

      mesa = Integer.parseInt(txtMesaAutal.getText().toString());
      ngarcom = txtNomeGarcom.getText().toString();


        /*Toast.makeText(this,"tamanho que retornou do dialog "+tamanho, Toast.LENGTH_LONG).show();*/


        }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,"Ainda precisa ser implementado esse método onItemClick ", Toast.LENGTH_LONG).show();
        if(listaCarregada == 1){
            PizzaActivity pizzaActivity = (PizzaActivity) parent.getItemAtPosition(position);
            Toast.makeText(this,"Pizza " + (position+1) + ": "
                    + pizzaActivity.nomePizza, Toast.LENGTH_SHORT).show();

///////////////////////////////////////////
            TamanhoDialog tamanhoDialog = new TamanhoDialog();
            Bundle data = new Bundle();
            data.putString("paramMesa", String.valueOf(mesa));
            data.putString("paramGarcom", String.valueOf(ngarcom));
            data.putString("paramNome", pizzaActivity.nomePizza);
            data.putString("valorP", String.valueOf(pizzaActivity.valor_p));
            data.putString("valorM", String.valueOf(pizzaActivity.valor_m));
            data.putString("valorG", String.valueOf(pizzaActivity.valor_g));
            tamanhoDialog.setArguments(data);
////////////////////////////////////////

            //TamanhoDialog tamanhoDialog = new TamanhoDialog();
            tamanhoDialog.show(getSupportFragmentManager(),"tamanhoDialog");

            //Toast.makeText(this,"tamanho que retornou do dialog "+tamanho, Toast.LENGTH_LONG).show();

        }
        if(listaCarregada == 2){
            PorcaoActivity porcaoActivity = (PorcaoActivity) parent.getItemAtPosition(position);
            Toast.makeText(this,"Porção " + (position+1) + ": "
                    + porcaoActivity.nomePorcao, Toast.LENGTH_SHORT).show();
            Bundle parametroProduto= new Bundle();
            parametroProduto.putString("paramMesa", String.valueOf(mesa));
            parametroProduto.putString("paramGarcom", ngarcom);
            parametroProduto.putString("paramNome", porcaoActivity.nomePorcao);
            parametroProduto.putString("paramValor", String.valueOf(porcaoActivity.valor));
            Intent intent = new Intent(PedidoDaMesaActivity.this, EditarProdutoActivity.class);
            intent.putExtras(parametroProduto);
            startActivity(intent);
        }
        if(listaCarregada == 3){
            BebidaActivity bebidaActivity = (BebidaActivity) parent.getItemAtPosition(position);
            Toast.makeText(this,"Bebida " + (position+1) + ": "
                    + bebidaActivity.nomeBebida, Toast.LENGTH_SHORT).show();

            //Intent intent = new Intent(PedidoDaMesaActivity.this, SolicitacaoDaMesaActivity.class);
            //startActivity(intent);

            Bundle parametroProduto= new Bundle();
            parametroProduto.putString("paramMesa", String.valueOf(mesa));
            parametroProduto.putString("paramGarcom", ngarcom);
            parametroProduto.putString("paramNome", bebidaActivity.nomeBebida);
            parametroProduto.putString("paramValor", String.valueOf(bebidaActivity.valor));
            Intent intent = new Intent(PedidoDaMesaActivity.this, EditarProdutoActivity.class);
            intent.putExtras(parametroProduto);
            startActivity(intent);

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
    public void conferirPedidos(View view){
        Bundle parametros = new Bundle();
        parametros.putString("numeroMesa", String.valueOf(mesa));
        Intent intent = new Intent(PedidoDaMesaActivity.this, SolicitacaoDaMesaActivity.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }

}

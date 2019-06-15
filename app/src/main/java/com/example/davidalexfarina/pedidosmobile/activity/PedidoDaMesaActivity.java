package com.example.davidalexfarina.pedidosmobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.davidalexfarina.pedidosmobile.dialog.TamanhoDialog;
import com.example.davidalexfarina.pedidosmobile.modulo_imprimir_fatura.PdfCreatorActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.EditarProdutoActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.SolicitacaoDaMesaActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;

import java.text.NumberFormat;
import java.util.Locale;

public class PedidoDaMesaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Button btnPizzas;
    private Button btnPorcoes;
    private Button btnBebidas;
    private Button btnConferirPedidos;
    private Button btnCadastrarUsuario;
    private int listaCarregada = 1; //Variavel utilizada para validar a lista atual que esta selecionada e será utilizada no click do item da lista..
    private TextView txtMesaAutal; //Variavel que recebe recebera o numero da mesa que foi selecionada no onclick da tela acticity_mesas
    private TextView txtNomeGarcom; //Variavel que recebe recebera o nome do uruario que se autenticou e registrou o pedido
    private TextView txtFatura;
    private  int mesa;
    private String numeroMesa;
    private String usuarioApp;
    private String tamanho = "teste";//Variavel que recebe do dialog o tamanho selecionado
    private double vlrFatura;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));
    private ProdutoDAO produtoDAO;
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
        Button btnCadastrarUsuario = (Button) findViewById(R.id.btnCadastrarUsuario);

        //Teste dentro do onCreate
        TextView txtMesaAutal = findViewById(R.id.txtMesaAutal);
        TextView txtFatura = findViewById(R.id.txtFatura);
        TextView txtNomeGarcom = findViewById(R.id.txtNomeGarcom);
        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        numeroMesa = parametros.getString("numeroMesa");
        usuarioApp  = parametros.getString("usuarioApp");

        txtMesaAutal.setText(numeroMesa);
        txtNomeGarcom.setText(usuarioApp);

        Bundle parametroTamanho = intent.getExtras();
        String tamanho = parametroTamanho.getString("paramTamanho");

      mesa = Integer.parseInt(txtMesaAutal.getText().toString());
      usuarioApp = txtNomeGarcom.getText().toString();

        /*Toast.makeText(this,"tamanho que retornou do dialog "+tamanho, Toast.LENGTH_LONG).show();*/
        //teste para calcular a fatura
        produtoDAO = ProdutoDAO.getInstance(this);
        produtoDAO.consultaFaturaMesa(String.valueOf(mesa));
        /*String vlrFatura = String.valueOf(produtoDAO.consultaFaturaMesa(String.valueOf(mesa)));*/
        vlrFatura = Double.parseDouble(produtoDAO.consultaFaturaMesa(String.valueOf(mesa)));

        //Toast.makeText(this,"Fatura: "+ vlrFatura, Toast.LENGTH_LONG).show();
        txtFatura.setText(nf.format(vlrFatura));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater().inflate(R.menu.action_menu, menu);*/
        getMenuInflater().inflate(R.menu.context_menu_retornar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_mode_close_button) {
            //Toast.makeText(this, "Fechar essa tela e ir para MesasActivity", Toast.LENGTH_LONG).show();
            Bundle parametros = new Bundle();
            parametros.putString("usuarioApp", usuarioApp);
            parametros.putString("numeroMesa", numeroMesa);
            Intent intent = new Intent(this, MesasActivity.class);

            intent.putExtras(parametros);

            startActivity(intent);

            /*
            Intent intent = new Intent(getApplicationContext(), MesasActivity.class);
            startActivity(intent);*/
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,"Ainda precisa ser implementado esse método onItemClick ", Toast.LENGTH_LONG).show();
        if(listaCarregada == 1){
            PizzaActivity pizzaActivity = (PizzaActivity) parent.getItemAtPosition(position);
           /* Toast.makeText(this,"Pizza " + (position+1) + ": "
                    + pizzaActivity.nomePizza, Toast.LENGTH_SHORT).show();*/

///////////////////////////////////////////
            TamanhoDialog tamanhoDialog = new TamanhoDialog();
            Bundle data = new Bundle();
            data.putString("paramMesa", String.valueOf(mesa));
            data.putString("paramGarcom", String.valueOf(usuarioApp));
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
           /* Toast.makeText(this,"Porção " + (position+1) + ": "
                    + porcaoActivity.nomePorcao, Toast.LENGTH_SHORT).show();*/
            Bundle parametroProduto= new Bundle();
            parametroProduto.putString("paramMesa", String.valueOf(mesa));
            parametroProduto.putString("paramGarcom", usuarioApp);
            parametroProduto.putString("paramNome", porcaoActivity.nomePorcao);
            parametroProduto.putString("paramValor", String.valueOf(porcaoActivity.valor));
            Intent intent = new Intent(PedidoDaMesaActivity.this, EditarProdutoActivity.class);
            intent.putExtras(parametroProduto);
            startActivity(intent);
        }
        if(listaCarregada == 3){
            BebidaActivity bebidaActivity = (BebidaActivity) parent.getItemAtPosition(position);
           /* Toast.makeText(this,"Bebida " + (position+1) + ": "
                    + bebidaActivity.nomeBebida, Toast.LENGTH_SHORT).show();*/

            //Intent intent = new Intent(PedidoDaMesaActivity.this, SolicitacaoDaMesaActivity.class);
            //startActivity(intent);

            Bundle parametroProduto= new Bundle();
            parametroProduto.putString("paramMesa", String.valueOf(mesa));
            parametroProduto.putString("paramGarcom", usuarioApp);
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
        parametros.putString("usuarioApp", String.valueOf(usuarioApp));
        Intent intent = new Intent(PedidoDaMesaActivity.this, SolicitacaoDaMesaActivity.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }

    public void imprimirFatura(View view) {
        //////////////////////Parametros enviados para PdfCreatorActivity///////////////////////////

        Bundle parametros = new Bundle();
        parametros.putString("usuarioApp", usuarioApp);
        parametros.putString("numeroMesa", numeroMesa);
        parametros.putString("vlrFatura", nf.format(vlrFatura));
        Intent intent = new Intent(this, PdfCreatorActivity.class);

        intent.putExtras(parametros);

        startActivity(intent);
        Toast.makeText(this, "Ainda precisa de ajustes", Toast.LENGTH_LONG).show();
    }
    public void fecharFatura(View view){
        Toast.makeText(this,"Implementar esse metodo para chamar outra tela listando os itens da fatura, valor total e formas de pagamento disponiveis.", Toast.LENGTH_LONG).show();
    }
}

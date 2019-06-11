package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.MesasActivity;
import com.example.davidalexfarina.pedidosmobile.activity.PedidoDaMesaActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.adapter.ProdutoAdapter;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Usuario;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteDialog;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteUsuarioDialog;
import com.example.davidalexfarina.pedidosmobile.modulo_usuario.EditarUsuarioActivity;

import java.util.List;

public class SolicitacaoDaMesaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DeleteDialog.OnDeleteListener, ActionMode.Callback{

    private ListView lista;
    private ProdutoAdapter adapter;
    private ProdutoDAO produtoDAO;
    private static final int REQ_EDIT = 100;

    private boolean actionModeActive;
    int pos;//guarda a posição clicadano ListView
    private  String numeroMesa;
    private String usuarioApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao_da_mesa);
        ////////////////////////////////////
        Intent intent = getIntent();//recebe o numero da mesa usar na SQL e carregar apenas os pedidos da mesa selecionada
        Bundle parametros = intent.getExtras();
        numeroMesa = parametros.getString("numeroMesa");
        usuarioApp = parametros.getString("usuarioApp");
        Toast.makeText(this, "A carregar os pedidos da mesa: "+numeroMesa, Toast.LENGTH_SHORT).show();


        lista = findViewById(R.id.lista);
        adapter = new ProdutoAdapter(this);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
        lista.setOnItemLongClickListener(this);
        produtoDAO = ProdutoDAO.getInstance(this);
        produtoDAO.consultaPedidoMesa(numeroMesa);


        updateList();
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
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_EDIT && resultCode == RESULT_OK) {
            updateList();
        }
    }

    private void updateList() {
        List<Produto> produtos = produtoDAO.list();
        adapter.setItems(produtos);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(!actionModeActive){
            startActionMode(this);
            pos = position; //atribui a posição a variavel pos que sera utilizada por outros métodos
        }
        return;


        /*Intent intent = new Intent(getApplicationContext(), EditarProdutoActivity.class);
        intent.putExtra("produto", adapter.getItem(position));
        startActivityForResult(intent, REQ_EDIT);*/
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Produto produto = adapter.getItem(position);
        DeleteDialog dialog = new DeleteDialog();
        dialog.setProduto(produto);
        dialog.show(getSupportFragmentManager(), "deleteDialog");
        return true;
    }

    @Override
    public void onDelete(Produto produto) {
        produtoDAO.delete(produto);
        updateList();
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.act_edit) {

            Intent intent = new Intent(getApplicationContext(), EditarProdutoActivity.class);
            intent.putExtra("produto", adapter.getItem(pos));
            startActivityForResult(intent, REQ_EDIT);
            //mode.finish();
        }
        else if(item.getItemId() == R.id.act_delete){//verifica se a opção foi clicado
            Produto produto = adapter.getItem(pos);

            DeleteDialog dialog = new DeleteDialog();
            dialog.setProduto(produto);
            dialog.show(getSupportFragmentManager(), "deleteDialog");
            //mode.finish();
            return true;
        }
        mode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionModeActive = false;
    }
}
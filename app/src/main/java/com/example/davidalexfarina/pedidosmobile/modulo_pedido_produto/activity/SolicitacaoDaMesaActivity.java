package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.adapter.ProdutoAdapter;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteDialog;

import java.util.List;

public class SolicitacaoDaMesaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DeleteDialog.OnDeleteListener{

    private ListView lista;
    private ProdutoAdapter adapter;
    private ProdutoDAO produtoDAO;
    private static final int REQ_EDIT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao_da_mesa);

        lista = findViewById(R.id.lista);

        adapter = new ProdutoAdapter(this);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);
        lista.setOnItemLongClickListener(this);

        produtoDAO = ProdutoDAO.getInstance(this);

        updateList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Toast.makeText(this, "pedidos enviados para o servidor", Toast.LENGTH_SHORT).show();

            /*Intent intent = new Intent(getApplicationContext(), EditarProdutoActivity.class);
            startActivityForResult(intent, REQ_EDIT);*/
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
        Intent intent = new Intent(getApplicationContext(), EditarProdutoActivity.class);
        intent.putExtra("produto", adapter.getItem(position));
        startActivityForResult(intent, REQ_EDIT);
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

}
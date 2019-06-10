package com.example.davidalexfarina.pedidosmobile.modulo_usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.EditarProdutoActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Usuario;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.UsuarioDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteUsuarioDialog;

import java.util.List;

public class UsuariosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DeleteUsuarioDialog.OnDeleteListener{

    private ListView listaUsuario;
    private UsuarioAdapter usuarioAdapter;
    private UsuarioDAO usuarioDAO;
    private static final int REQ_EDIT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        listaUsuario = findViewById(R.id.listaUsuario);
        usuarioAdapter = new UsuarioAdapter(this);
        listaUsuario.setAdapter(usuarioAdapter);
        listaUsuario.setOnItemClickListener(this);
        listaUsuario.setOnItemLongClickListener(this);
        usuarioDAO = UsuarioDAO.getInstance(this);
        updateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Toast.makeText(this, "Adicionar usuário", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), EditarProdutoActivity.class);
            startActivityForResult(intent, REQ_EDIT);
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
        List<Usuario> usuarios = usuarioDAO.list();
        usuarioAdapter.setItems(usuarios);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), EditarUsuarioActivity.class);
        intent.putExtra("usuario", usuarioAdapter.getItem(position));
        startActivityForResult(intent, REQ_EDIT);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Usuario usuario = usuarioAdapter.getItem(position);

        DeleteUsuarioDialog deleteUsuarioDialog = new DeleteUsuarioDialog();
        deleteUsuarioDialog.setUsuario(usuario);
        deleteUsuarioDialog.show(getSupportFragmentManager(), "deleteUsuarioDialog");
        return true;
    }

    @Override
    public void onDelete(Usuario usuario) {
        usuarioDAO.delete(usuario);
        updateList();
    }

}
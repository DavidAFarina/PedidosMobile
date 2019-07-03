package com.example.davidalexfarina.pedidosmobile.modulo_usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.MainActivity;
import com.example.davidalexfarina.pedidosmobile.activity.MesasActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Usuario;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.UsuarioDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteUsuarioDialog;

import java.util.List;

public class UsuariosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DeleteUsuarioDialog.OnDeleteListener, ActionMode.Callback{

    private ListView listaUsuario;
    private UsuarioAdapter usuarioAdapter;
    private UsuarioDAO usuarioDAO;
    private static final int REQ_EDIT = 100;

    private boolean actionModeActive;
    int pos;//guarda a posição clicadano ListView
    private String usuarioApp;
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

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        usuarioApp = parametros.getString("usuarioApp");
        //Toast.makeText(this, "Nome: "+ usuarioApp, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu_retornar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_mode_close_button) {
            //Toast.makeText(this, "Fechar essa tela e ir para MesasActivity", Toast.LENGTH_SHORT).show();
            Bundle parametros = new Bundle();
            parametros.putString("usuarioApp", usuarioApp);
            Intent intent = new Intent(this,MesasActivity.class);

            intent.putExtras(parametros);

            startActivity(intent);

            /*
            Intent intent = new Intent(getApplicationContext(), MesasActivity.class);
            startActivity(intent);*/
            return true;
        }
        if (item.getItemId() == R.id.action_mode_exit_button) {
            Bundle parametros = new Bundle();
            Intent intent = new Intent(this, MainActivity.class);


            startActivity(intent);

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
        if(!actionModeActive){
            startActionMode(this);
            pos = position; //atribui a posição a variavel pos que sera utilizada por outros métodos
        }
        return;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Usuario usuario = usuarioAdapter.getItem(position);
/*
        DeleteUsuarioDialog deleteUsuarioDialog = new DeleteUsuarioDialog();
        deleteUsuarioDialog.setUsuario(usuario);
        deleteUsuarioDialog.show(getSupportFragmentManager(), "deleteUsuarioDialog");*/
        ////////////
        DeleteUsuarioDialog deleteUsuarioDialog = new DeleteUsuarioDialog();
        Bundle data = new Bundle();
        data.putString("usuarioApp", String.valueOf(usuarioApp));
        deleteUsuarioDialog.setArguments(data);
////////////////////////////////////////
        deleteUsuarioDialog.setUsuario(usuario);
        deleteUsuarioDialog.show(getSupportFragmentManager(),"deleteUsuarioDialog");
        return true;
    }

    @Override
    public void onDelete(Usuario usuario) {
        usuarioDAO.delete(usuario);
        updateList();
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu_editar_excluir, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.act_edit) {
            Intent intent = new Intent(getApplicationContext(), EditarUsuarioActivity.class);
            intent.putExtra("usuario", usuarioAdapter.getItem(pos));
            intent.putExtra("usuarioApp", usuarioApp);
            startActivityForResult(intent, REQ_EDIT);
            mode.finish();
        }
        else if(item.getItemId() == R.id.act_delete){//verifica se a opção foi clicado

            Usuario usuario = usuarioAdapter.getItem(pos);
            ////////////////////Método salvo para caso de necessidade///////////////////////////////////////////////////////////
            /*DeleteUsuarioDialog deleteUsuarioDialog = new DeleteUsuarioDialog();
            deleteUsuarioDialog.setUsuario(usuario);
            deleteUsuarioDialog.show(getSupportFragmentManager(), "deleteUsuarioDialog");// Chamar o método de remover o item clicado passando a posição a ser removida
            mode.finish();*/
            /////////////////////////////////////////////////////////////////////////////
            DeleteUsuarioDialog deleteUsuarioDialog = new DeleteUsuarioDialog();
            Bundle data = new Bundle();
            data.putString("usuarioApp", String.valueOf(usuarioApp));
            deleteUsuarioDialog.setArguments(data);
////////////////////////////////////////
            deleteUsuarioDialog.setUsuario(usuario);
            deleteUsuarioDialog.show(getSupportFragmentManager(),"deleteDialog");
            mode.finish();
        }
        mode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionModeActive = false;
    }
    @Override
    public void onBackPressed() {
        Bundle parametros = new Bundle();
        parametros.putString("usuarioApp", usuarioApp);
        Intent intent = new Intent(this, MesasActivity.class);
        intent.putExtras(parametros);

        startActivity(intent);
    }
}
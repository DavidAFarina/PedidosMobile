package com.example.davidalexfarina.pedidosmobile.modulo_usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Usuario;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.UsuarioDAO;

import java.text.NumberFormat;
import java.util.Locale;

public class EditarUsuarioActivity extends AppCompatActivity {


    private EditText edtLogin;
    private EditText edtSenha;
    private Button btSalvarUsuario;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btSalvarUsuario = (Button) findViewById(R.id.btSalvarUsuario);
        usuarioDAO = UsuarioDAO.getInstance(this);
        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        if (usuario!= null) { //executa quando a solicitação venha do editar um item do pedido

            edtLogin.setText(usuario.getNome_usuario());
            edtSenha.setText(usuario.getSenha_usuario());
            edtLogin.requestFocus();

        }
    }

    public void processarUsuario(View view) {
        String msg;
        if (edtLogin.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nome do usuário não pode ser vazio!", Toast.LENGTH_SHORT).show();
            edtLogin.requestFocus();
        } else {

            String nomeUsuario = edtLogin.getText().toString();
            String senhaUsuario = edtSenha.getText().toString();


            if (usuario == null) {
                Usuario usuario = new Usuario(nomeUsuario, senhaUsuario);
                usuarioDAO.save(usuario);
               // Toast.makeText(getApplicationContext(), "salvou login: "+nomeUsuario+"\nSenha: "+senhaUsuario, Toast.LENGTH_LONG).show();
                msg = "Usuário: "+usuario+ " gravado com ID = " + usuario.getId_usuario();

            } else {
                usuario.setNome_usuario(nomeUsuario);
                usuario.setSenha_usuario(senhaUsuario);
                usuarioDAO.update(usuario);
                msg = "Usuário atualizado com ID = " + usuario.getId_usuario();
            }

           // Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        }
    }

    public void cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
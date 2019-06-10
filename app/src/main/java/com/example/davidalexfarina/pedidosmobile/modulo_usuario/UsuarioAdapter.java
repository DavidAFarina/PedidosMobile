package com.example.davidalexfarina.pedidosmobile.modulo_usuario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.adapter.ProdutoAdapter;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Usuario;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.UsuarioDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteDialog;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteUsuarioDialog;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private List<Usuario> usuarios = new ArrayList<>();
    private UsuarioAdapter usuarioAdapter;
    private DeleteUsuarioDialog.OnDeleteListener listener;
    private UsuarioDAO usuarioDAO;

    public UsuarioAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Usuario getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return usuarios.get(position).getId_usuario();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_listprodutos, parent, false);

        EditText edtNomeUsuario = view.findViewById(R.id.edtLoginUsuario);
        EditText edtSenhaUsuario = view.findViewById(R.id.edtSenhaUsuario);
        final Usuario usuario = usuarios.get(position);

        edtNomeUsuario.setText(usuario.getNome_usuario());
        edtSenhaUsuario.setText(usuario.getSenha_usuario());

        return view;
    }

    public void setItems(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        notifyDataSetChanged();
    }
}

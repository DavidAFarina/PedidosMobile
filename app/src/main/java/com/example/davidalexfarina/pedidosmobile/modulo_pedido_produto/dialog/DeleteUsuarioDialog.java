package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.activity.MesasActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Usuario;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.UsuarioDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_usuario.UsuariosActivity;

public class DeleteUsuarioDialog extends AppCompatDialogFragment implements DialogInterface.OnClickListener {

    private Usuario usuario;
    private DeleteUsuarioDialog.OnDeleteListener listener;
    private String usuarioApp;
    private UsuarioDAO usuarioDAO;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof DeleteUsuarioDialog.OnDeleteListener)) {
            throw new RuntimeException("A activity deve implementar DialogUsuarioFragment.OnDeleteListener");
        }
        this.listener = (DeleteUsuarioDialog.OnDeleteListener) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Deseja excluir o usuário "  + usuario.getNome_usuario() + "?");
        builder.setPositiveButton("Sim", this);
        builder.setNegativeButton("Não", this);

        Bundle data = getArguments();
        usuarioApp = data.getString("usuarioApp");


        return builder.create();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE && listener != null) {

                listener.onDelete(usuario);
                usuarioDAO = UsuarioDAO.getInstance(getContext());
           if(usuarioDAO.list().size() <1){
                Bundle parametros = new Bundle();
                parametros.putString("usuarioApp", usuarioApp);
                Intent intent = new Intent(getContext(), MesasActivity.class);
                intent.putExtras(parametros);
                startActivity(intent);
            }else{
                Bundle parametros = new Bundle();
                parametros.putString("usuarioApp", usuarioApp);
                Intent intent = new Intent(getContext(), UsuariosActivity.class);
                intent.putExtras(parametros);
                startActivity(intent);
            }
        }
        if (which == DialogInterface.BUTTON_NEGATIVE && listener != null) {
            Bundle parametros = new Bundle();
            parametros.putString("usuarioApp", usuarioApp);
            Intent intent = new Intent(getContext(), UsuariosActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public interface OnDeleteListener {
        public void onDelete(Usuario usuario);
    }
}

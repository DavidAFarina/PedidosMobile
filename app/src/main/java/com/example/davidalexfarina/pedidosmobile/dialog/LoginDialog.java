package com.example.davidalexfarina.pedidosmobile.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.MesasActivity;

public class LoginDialog extends AppCompatDialogFragment implements DialogInterface.OnClickListener {


    private EditText edtLogin;
    private EditText edtSenha;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.titleDialog);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_login,null);
        builder.setView(view);

        edtLogin = (EditText) view.findViewById(R.id.edtLogin);
        edtSenha = (EditText) view.findViewById(R.id.edtSenha);




        builder.setPositiveButton(R.string.positive,this);
        builder.setNegativeButton(R.string.negative,this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if(which == DialogInterface.BUTTON_POSITIVE){
            String login = edtLogin.getText().toString();
            String senha = edtSenha.getText().toString();

            if(login.equals("admin")&&senha.equals("admin")){
                Intent intent = new Intent(getActivity(), MesasActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), R.string.loginOK, Toast.LENGTH_LONG).show();;

            }else{
                Toast.makeText(getActivity(), R.string.loginFail, Toast.LENGTH_SHORT).show();;
            }
        }
        else if(which == DialogInterface.BUTTON_NEGATIVE){
            Toast.makeText(getActivity(),R.string.loginCancel,Toast.LENGTH_SHORT).show();
        }

    }
}

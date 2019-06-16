package com.example.davidalexfarina.pedidosmobile.modulo_financeiro.dialog_pagamento;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.MesasActivity;
import com.example.davidalexfarina.pedidosmobile.activity.PedidoDaMesaActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_financeiro.gerar_pdf.PdfCreatorActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.EditarProdutoActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;

import java.text.NumberFormat;
import java.util.Locale;

public class FormaDePagamentoDialog extends AppCompatDialogFragment implements DialogInterface.OnClickListener {

    private RadioGroup rgFormaPagamento;
    private RadioButton rdbCartao;
    private RadioButton rdbDinheiro;
    private TextView txtMesa;
    private TextView txtFatura;
    private String usuarioApp;
    private String numeroMesa;
    private String vlrFatura;
    private ProdutoDAO produtoDAO;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.titlePagamento);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_forma_de_pagamento,null);
        builder.setView(view);

        rgFormaPagamento = (RadioGroup) view.findViewById(R.id.rgFormaPagamento);
        rdbDinheiro = (RadioButton) view.findViewById(R.id.rdbDinheiro);
        rdbCartao = (RadioButton) view.findViewById(R.id.rdbCartao);
        txtMesa = (TextView) view.findViewById(R.id.txtMesa);
        txtFatura = (TextView) view.findViewById(R.id.txtFatura);
                //////////////////////////Recupera informações enviados da lista de pizza
        Bundle data = getArguments();
        numeroMesa = data.getString("numeroMesa");
        usuarioApp = data.getString("usuarioApp");
        vlrFatura = data.getString("vlrFatura");

        /////////////////////////Seta os as informações vindas da lista de pizza nos campos do dialog de definição
        txtMesa.setText(numeroMesa);
        txtFatura.setText(vlrFatura);
        builder.setPositiveButton(R.string.positive,this);
        builder.setNegativeButton(R.string.negative,this);


        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {


        if(which == DialogInterface.BUTTON_POSITIVE){

            produtoDAO = ProdutoDAO.getInstance(this.getContext());
            produtoDAO.fecharFaturaMesa(String.valueOf(numeroMesa));

            Bundle parametros = new Bundle();
            parametros.putString("usuarioApp", usuarioApp);
            parametros.putString("numeroMesa", numeroMesa);
            Intent intent = new Intent(getActivity(), MesasActivity.class);
            intent.putExtras(parametros);

            startActivity(intent);


            Toast.makeText(getActivity(),R.string.btn_ok,Toast.LENGTH_SHORT).show();
        }
        else if(which == DialogInterface.BUTTON_NEGATIVE){
            Toast.makeText(getActivity(),R.string.pagamentoCancel,Toast.LENGTH_SHORT).show();
        }

    }

}

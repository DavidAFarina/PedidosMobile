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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.MesasActivity;
import com.example.davidalexfarina.pedidosmobile.activity.PedidoDaMesaActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.EditarProdutoActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class TamanhoDialog extends AppCompatDialogFragment implements DialogInterface.OnClickListener {


    private RadioGroup rgTamanho;
    private RadioButton rdbPequena;
    private RadioButton rdbMedia;
    private RadioButton rdbGrande;
    private TextView txtMesa;
    private TextView txtGarcom;
    private TextView txtPizza;
    private TextView txtValorP;
    private TextView txtValorM;
    private TextView txtValorG;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));
    String mesa;
    String garcom;
    String pizza ;
    String valorP;
    String valorM;
    String valorG;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.defenirTamanho);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_tamanho,null);
        builder.setView(view);

        rgTamanho = (RadioGroup) view.findViewById(R.id.rgTamanho);
        rdbPequena = (RadioButton) view.findViewById(R.id.rdbPequena);
        rdbMedia = (RadioButton) view.findViewById(R.id.rdbMedia);
        rdbGrande = (RadioButton) view.findViewById(R.id.rdbGrande);
        txtMesa = (TextView) view.findViewById(R.id.txtMesa);
        txtGarcom = (TextView) view.findViewById(R.id.txtGarcom);
        txtPizza = (TextView) view.findViewById(R.id.txtPizza);
        txtValorP = (TextView) view.findViewById(R.id.txtValorP);
        txtValorM = (TextView) view.findViewById(R.id.txtValorM);
        txtValorG = (TextView) view.findViewById(R.id.txtValorG);
        //////////////////////////Recupera informações enviados da lista de pizza
        Bundle data = getArguments();
        String mesa = data.getString("paramMesa");
        String garcom = data.getString("paramGarcom");
        String pizza = data.getString("paramNome");
        //double valorP = Double.parseDouble(data.getString("valorP"));
        valorP = data.getString("valorP");
        valorM = data.getString("valorM");
        valorG = data.getString("valorG");
        /////////////////////////Seta os as informações vindas da lista de pizza nos campos do dialog de definição
        txtMesa.setText(mesa);
        txtGarcom.setText(garcom);
        txtPizza.setText(pizza);
        txtValorP.setText(nf.format(Double.parseDouble(valorP)));
       //txtValorP.setText(valorP);
        txtValorM.setText(nf.format(Double.parseDouble(valorM)));
        txtValorG.setText(nf.format(Double.parseDouble(valorG)));


        builder.setPositiveButton(R.string.positive,this);
        builder.setNegativeButton(R.string.negative,this);


        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        Bundle parametroTamanho = new Bundle();

        if(which == DialogInterface.BUTTON_POSITIVE){
            String tamanho = "teste";
            Bundle parametroProduto= new Bundle();

            switch (rgTamanho.getCheckedRadioButtonId()) {
                case R.id.rdbPequena:
                    tamanho = "P";
                    //Bundle parametroProduto= new Bundle();
                    parametroProduto.putString("paramMesa", txtMesa.getText().toString());
                    parametroProduto.putString("paramGarcom", txtGarcom.getText().toString());
                    parametroProduto.putString("paramNome", txtPizza.getText().toString());
                    //parametroProduto.putString("paramValor", txtValorP.getText().toString());
                    parametroProduto.putString("paramValor", valorP);
                   /* Intent intent = new Intent(getActivity(), EditarProdutoActivity.class);
                    intent.putExtras(parametroProduto);
                    startActivity(intent);*/

                    break;
                case R.id.rdbMedia:
                    tamanho = "M";
                   // Bundle parametroProduto= new Bundle();
                    parametroProduto.putString("paramMesa", txtMesa.getText().toString());
                    parametroProduto.putString("paramGarcom", txtGarcom.getText().toString());
                    parametroProduto.putString("paramNome", txtPizza.getText().toString());
                    parametroProduto.putString("paramValor", valorM);
                   /* Intent intent = new Intent(getActivity(), EditarProdutoActivity.class);
                    intent.putExtras(parametroProduto);
                    startActivity(intent);*/


                    break;
                case R.id.rdbGrande:
                    tamanho = "G";

                    // Bundle parametroProduto= new Bundle();
                    parametroProduto.putString("paramMesa", txtMesa.getText().toString());
                    parametroProduto.putString("paramGarcom", txtGarcom.getText().toString());
                    parametroProduto.putString("paramNome", txtPizza.getText().toString());
                    parametroProduto.putString("paramValor", valorG);
                    //parametroProduto.putString("paramValor",  txtValorG.getText().toString());
                   /* Intent intent = new Intent(getActivity(), EditarProdutoActivity.class);
                    intent.putExtras(parametroProduto);
                    startActivity(intent);*/


                    break;
                    default: Toast.makeText(getActivity(),"Selecione o tamanho.",Toast.LENGTH_SHORT).show();


            }
            Intent intent = new Intent(getActivity(), EditarProdutoActivity.class);
            intent.putExtras(parametroProduto);
            startActivity(intent);

        }
        else if(which == DialogInterface.BUTTON_NEGATIVE){
            Toast.makeText(getActivity(),R.string.pedidoCancel,Toast.LENGTH_SHORT).show();
        }

    }

}

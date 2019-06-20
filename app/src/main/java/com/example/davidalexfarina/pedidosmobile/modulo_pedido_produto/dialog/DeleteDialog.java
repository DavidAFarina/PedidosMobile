package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.activity.PedidoDaMesaActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity.SolicitacaoDaMesaActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;
import com.itextpdf.awt.geom.Line2D;

public class DeleteDialog  extends AppCompatDialogFragment implements DialogInterface.OnClickListener {

    private Produto produto;
    private OnDeleteListener listener;
    private String usuarioApp;
    private String numeroMesa;
    private double vlrFatura;
    private ProdutoDAO produtoDAO;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof OnDeleteListener)) {
            throw new RuntimeException("A activity deve implementar DialogFragment.OnDeleteListener");
        }

        this.listener = (OnDeleteListener) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Deseja excluir o produto "  + produto.getNome() + "?");
        builder.setPositiveButton("Sim", this);
        builder.setNegativeButton("Não", this);

        Bundle data = getArguments();
        numeroMesa = data.getString("numeroMesa");
        usuarioApp = data.getString("usuarioApp");
       //Toast.makeText(getActivity(), "Usuario "+usuarioApp, Toast.LENGTH_SHORT).show();
//        produtoDAO.consultaFaturaMesa(numeroMesa);
        return builder.create();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE && listener != null) {
            listener.onDelete(produto);
            Bundle parametroProduto= new Bundle();
            parametroProduto.putString("numeroMesa", numeroMesa);
            parametroProduto.putString("usuarioApp", usuarioApp);
            produtoDAO = ProdutoDAO.getInstance(getContext());
            vlrFatura = Double.parseDouble(produtoDAO.consultaFaturaMesa(numeroMesa));

            if(vlrFatura == 0.0){
                Toast.makeText(getActivity(), "A mesa: "+numeroMesa+ " não tem mais pedidos.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), PedidoDaMesaActivity.class);
                intent.putExtras(parametroProduto);
                startActivity(intent);
            }else {

                Intent intent = new Intent(getActivity(), SolicitacaoDaMesaActivity.class);
                intent.putExtras(parametroProduto);
                startActivity(intent);
            }
        }
        if (which == DialogInterface.BUTTON_NEGATIVE && listener != null) {

            Bundle parametroProduto= new Bundle();
            parametroProduto.putString("numeroMesa", numeroMesa);
            parametroProduto.putString("usuarioApp", usuarioApp);
            Intent intent = new Intent(getActivity(), SolicitacaoDaMesaActivity.class);
            intent.putExtras(parametroProduto);
            startActivity(intent);
        }
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public interface OnDeleteListener {
        public void onDelete(Produto produto);
    }
}

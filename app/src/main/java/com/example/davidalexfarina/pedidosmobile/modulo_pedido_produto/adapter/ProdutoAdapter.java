package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.dialog.DeleteDialog;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProdutoAdapter extends BaseAdapter{
    private Context context;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));
    private List<Produto> produtos = new ArrayList<>();
    private ProdutoAdapter adapter;
    private ImageButton ib_edit;
    private ImageButton ib_delete;
    private DeleteDialog.OnDeleteListener listener;
    private ProdutoDAO produtoDAO;

    public ProdutoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Produto getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtos.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_listprodutos, parent, false);

        TextView txtMesa = view.findViewById(R.id.txt_mesa);
        TextView txtNome = view.findViewById(R.id.txt_nome);
        TextView txtGarcom = view.findViewById(R.id.txt_garcom);
        TextView txtValor = view.findViewById(R.id.txt_valor);
        TextView txtQuantidade = view.findViewById(R.id.txt_quantidade);
        TextView txtValorTotal = view.findViewById(R.id.txt_valorTotal);
        TextView txtObservacao = view.findViewById(R.id.txt_observacao);
/*

        ImageButton ib_edit = view.findViewById(R.id.ib_edit);
        ImageButton ib_delete = view.findViewById(R.id.ib_delete);

*/


        final Produto produto = produtos.get(position);
        txtMesa.setText(String.valueOf(produto.getMesa()));
        txtGarcom.setText(produto.getGarcom());
        txtNome.setText(produto.getNome());
        txtValor.setText(nf.format(produto.getValor()));
        txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
        txtValorTotal.setText(nf.format(produto.getValorTotal()));
        //txtValorTotal.setText(nf.format(produto.getValor()*produto.getQuantidade()));
        txtObservacao.setText(String.valueOf(produto.getObservacao()));

       /* ib_edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something

                notifyDataSetChanged();
            }
        });


        ib_delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //do something
                produtos.remove(position); //or some other task
                notifyDataSetChanged();


            }
        });*/

        return view;
    }

    public void setItems(List<Produto> produtos) {
        this.produtos = produtos;
        notifyDataSetChanged();
    }

}
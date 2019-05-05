package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProdutoAdapter extends BaseAdapter {
    private Context context;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));
    private List<Produto> produtos = new ArrayList<>();

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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_listprodutos, parent, false);

        TextView txtNome = view.findViewById(R.id.txt_nome);
        TextView txtValor = view.findViewById(R.id.txt_valor);
        TextView txtQuantidade = view.findViewById(R.id.txt_quantidade);
        TextView txtValorTotal = view.findViewById(R.id.txt_valorTotal);
        TextView txtObservacao = view.findViewById(R.id.txt_observacao);



        Produto produto = produtos.get(position);
        txtNome.setText(produto.getNome());
        txtValor.setText(nf.format(produto.getValor()));
        txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
        txtValorTotal.setText(nf.format(produto.getValorTotal()));
        //txtValorTotal.setText(nf.format(produto.getValor()*produto.getQuantidade()));
        txtObservacao.setText(String.valueOf(produto.getObservacao()));

        return view;
    }

    public void setItems(List<Produto> produtos) {
        this.produtos = produtos;
        notifyDataSetChanged();
    }

}
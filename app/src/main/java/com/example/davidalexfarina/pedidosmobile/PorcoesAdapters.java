package com.example.davidalexfarina.pedidosmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PorcoesAdapters extends BaseAdapter {
    private Context context;
    private List<Porcao> porcoes;

    public PorcoesAdapters(Context context, List<Porcao> porcoes) {
        this.context = context;
        this.porcoes = porcoes;
    }

    @Override
    public int getCount() {
        return porcoes.size();
    }

    @Override
    public Object getItem(int position) {
        return porcoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_porcao, parent,false);
        ImageView imgPorcao = view.findViewById(R.id.imgPorcao);
        TextView txtNomePorcao = view.findViewById(R.id.txtNomePorcao);
        TextView txtDescricao = view.findViewById(R.id.txtDescricao);
        TextView txtTamanho = view.findViewById(R.id.txtTamanho);
        TextView txtValor = view.findViewById(R.id.txtValor);


        Porcao porcao = porcoes.get(position);
        imgPorcao.setImageResource(porcao.img);
        txtNomePorcao.setText(porcao.nomePorcao);
        txtDescricao.setText(porcao.descricao);
        txtTamanho.setText(porcao.tamanho);
        txtValor.setText(String.valueOf(porcao.valor));


        return view;
    }
}

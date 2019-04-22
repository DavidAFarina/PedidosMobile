package com.example.davidalexfarina.pedidosmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BebidasAdapters extends BaseAdapter {
    private Context context;
    private List<Bebida> bebidas;

    public BebidasAdapters(Context context, List<Bebida> bebidas) {
        this.context = context;
        this.bebidas = bebidas;
    }

    @Override
    public int getCount() {
        return bebidas.size();
    }

    @Override
    public Object getItem(int position) {
        return bebidas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_bebida, parent,false);
        ImageView imgBebida = view.findViewById(R.id.imgBebida);
        TextView txtNomeBebida = view.findViewById(R.id.txtNomeBebida);
        TextView txtDescricao = view.findViewById(R.id.txtDescricao);
        TextView txtValor = view.findViewById(R.id.txtValor);


        Bebida bebida = bebidas.get(position);
        imgBebida.setImageResource(bebida.img);
        txtNomeBebida.setText(bebida.nomeBebida);
        txtDescricao.setText(bebida.descricao);
        txtValor.setText(String.valueOf(bebida.valor));


        return view;
    }
}

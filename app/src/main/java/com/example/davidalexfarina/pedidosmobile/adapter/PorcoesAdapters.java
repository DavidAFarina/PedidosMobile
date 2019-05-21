package com.example.davidalexfarina.pedidosmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.PorcaoActivity;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class PorcoesAdapters extends BaseAdapter {
    private Context context;
    private List<PorcaoActivity> porcoes;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));

    public PorcoesAdapters(Context context, List<PorcaoActivity> porcoes) {
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


        PorcaoActivity porcaoActivity = porcoes.get(position);
        imgPorcao.setImageResource(porcaoActivity.img);
        txtNomePorcao.setText(porcaoActivity.nomePorcao);
        txtDescricao.setText(porcaoActivity.descricao);
        txtTamanho.setText(porcaoActivity.tamanho);
        txtValor.setText(nf.format(porcaoActivity.valor));
        //txtValor.setText(String.valueOf(porcaoActivity.valor));



        return view;
    }
}

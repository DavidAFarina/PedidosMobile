package com.example.davidalexfarina.pedidosmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.BebidaActivity;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class BebidasAdapters extends BaseAdapter {
    private Context context;
    private List<BebidaActivity> bebidaActivities;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));

    public BebidasAdapters(Context context, List<BebidaActivity> bebidaActivities) {
        this.context = context;
        this.bebidaActivities = bebidaActivities;
    }

    @Override
    public int getCount() {
        return bebidaActivities.size();
    }

    @Override
    public Object getItem(int position) {
        return bebidaActivities.get(position);
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


        BebidaActivity bebidaActivity = bebidaActivities.get(position);
        imgBebida.setImageResource(bebidaActivity.img);
        txtNomeBebida.setText(bebidaActivity.nomeBebida);
        txtDescricao.setText(bebidaActivity.descricao);
        //txtValor.setText(String.valueOf(bebidaActivity.valor));
        txtValor.setText(nf.format(bebidaActivity.valor));

        return view;
    }
}

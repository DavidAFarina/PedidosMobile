package com.example.davidalexfarina.pedidosmobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class MesaAdapters extends BaseAdapter{
    private Context context;
    private List<Mesa> mesas;

    public MesaAdapters(Context context, List<Mesa> mesas) {
        this.context = context;
        this.mesas = mesas;
    }

    @Override
    public int getCount() {
        return mesas.size();
    }

    @Override
    public Object getItem(int position) {
        return mesas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_mesa, parent,false);
        ImageButton imgMesa = view.findViewById(R.id.imgMesa);
        ImageButton imgMesa_01 = view.findViewById(R.id.imgMesa_01);
        ImageButton imgMesa_02 = view.findViewById(R.id.imgMesa_02);

        Mesa mesa = mesas.get(position);
        imgMesa.setImageResource(mesa.btnMesa);
        imgMesa_01.setImageResource(mesa.btnMesa_01);
        imgMesa_02.setImageResource(mesa.btnMesa_02);

        imgMesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Você clicou na mesa 1", Toast.LENGTH_SHORT).show();
               /* Intent intent = new Intent(getActivity(), PedidoMesaActivity.class);
                startActivity(intent);*/
            }
        });
        imgMesa_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Você clicou na mesa 2", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}

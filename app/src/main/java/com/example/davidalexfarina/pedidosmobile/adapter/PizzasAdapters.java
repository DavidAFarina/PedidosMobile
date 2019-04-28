package com.example.davidalexfarina.pedidosmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.PizzaActivity;

import java.util.List;

public class PizzasAdapters extends BaseAdapter {
    private Context context;
    private List<PizzaActivity> pizzaActivities;

    public PizzasAdapters(Context context, List<PizzaActivity> pizzaActivities) {
        this.context = context;
        this.pizzaActivities = pizzaActivities;
    }

    @Override
    public int getCount() {
        return pizzaActivities.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzaActivities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_pizza, parent,false);
        ImageView imgPizza = view.findViewById(R.id.imgPizza);
        TextView txtNomePizza = view.findViewById(R.id.txtNomePizza);
        TextView txtIngredientes = view.findViewById(R.id.txtIngredientes);


        PizzaActivity pizzaActivity = pizzaActivities.get(position);
        imgPizza.setImageResource(pizzaActivity.img);
        txtNomePizza.setText(pizzaActivity.nomePizza);
        txtIngredientes.setText(pizzaActivity.ingredientes);


        return view;
    }
}

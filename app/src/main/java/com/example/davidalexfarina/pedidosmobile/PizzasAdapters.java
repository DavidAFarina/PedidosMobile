package com.example.davidalexfarina.pedidosmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PizzasAdapters extends BaseAdapter {
    private Context context;
    private List<Pizza> pizzas;

    public PizzasAdapters(Context context, List<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
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


        Pizza pizza = pizzas.get(position);
        imgPizza.setImageResource(pizza.img);
        txtNomePizza.setText(pizza.nomePizza);
        txtIngredientes.setText(pizza.ingredientes);


        return view;
    }
}

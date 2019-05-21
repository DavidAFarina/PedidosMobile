package com.example.davidalexfarina.pedidosmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.NumberFormat;
import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.PizzaActivity;

import java.util.List;
import java.util.Locale;

public class PizzasAdapters extends BaseAdapter {
    private Context context;
    private List<PizzaActivity> pizzaActivities;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));

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
        TextView txtPizzaP = view.findViewById(R.id.txtPizzaP);
        TextView txtPizzaM = view.findViewById(R.id.txtPizzaM);
        TextView txtPizzaG = view.findViewById(R.id.txtPizzaG);


        PizzaActivity pizzaActivity = pizzaActivities.get(position);
        imgPizza.setImageResource(pizzaActivity.img);
        txtNomePizza.setText(pizzaActivity.nomePizza);
        txtIngredientes.setText(pizzaActivity.ingredientes);
        //txtPizzaP.setText(String.valueOf(pizzaActivity.valor_p));
        //txtPizzaM.setText(String.valueOf(pizzaActivity.valor_m));
        //txtPizzaG.setText(String.valueOf(pizzaActivity.valor_g));
        txtPizzaP.setText(nf.format(pizzaActivity.valor_p));
        txtPizzaM.setText(nf.format(pizzaActivity.valor_m));
        txtPizzaG.setText(nf.format(pizzaActivity.valor_g));



        return view;
    }
}

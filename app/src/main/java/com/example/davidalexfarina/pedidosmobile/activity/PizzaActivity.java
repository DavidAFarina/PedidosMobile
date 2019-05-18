package com.example.davidalexfarina.pedidosmobile.activity;

import com.example.davidalexfarina.pedidosmobile.R;

import java.util.ArrayList;
import java.util.List;

public class PizzaActivity {
    public int img; //R.drawable.xxx
    public String nomePizza;
    public String ingredientes;
    public Double valor_p;
    public Double valor_m;
    public Double valor_g;


    public PizzaActivity(int img, String nomePizza, String ingredientes, Double valor_p, Double valor_m, Double valor_g) {
        this.img = img;
        this.nomePizza = nomePizza;
        this.ingredientes = ingredientes;
        this.valor_p = valor_p;
        this.valor_m = valor_m;
        this.valor_g = valor_g;


    }

    public static List<PizzaActivity> getPizzas(){
        List<PizzaActivity> pizzaActivities = new ArrayList<>();
        pizzaActivities.add(new PizzaActivity(R.drawable.al_caponi, "Pizza Al Caponi", "molho de tomate, mussarela, mortadela defumada (Ouro Perdigão), pimentão vermelho, orégano e azeite",36.90,46.90, 56.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.alho_e_oleo_e_bacon, "Pizza Alho e Óleo e Bacon", "molho de tomate, alho crocante, azeite, mussarela, bacon, orégano e azeitona", 32.90,42.90, 52.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.aos_cinco_formaggi, "Pizza Aos Cinco Formaggi","molho de tomate, catupiry, provolone prato, mussarela, gorgonzola, orégano e azeitona", 33.00,43.00, 53.00 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.aos_quatro_queijos,"Pizza Aos Quatro Quijos","molho de tomate, Catupiry, provolone prato, mussarela, orégano e azeitona", 35.00,45.00, 55.00 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.bacon,"Pizza Bacon","molho de tomate, catupiry, presunto, mussarela, bacon crocante, orégano e azeitona", 32.90,42.90, 52.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.baiana,"Pizza Baiana","molho apimentado, mussarela, calabreza, bacon, orégano e azeitona", 28.90,38.90, 48.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.bologna,"Pizza Bologna","molho de tomate, presunto, champignon, mussarela, bacon, orégano e azeitona", 39.90,49.90, 55.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.brocolis,"Pizza Brócolis","molho de tomate, brócolis, mussarela, orégano e azeitona", 28.99,35.99, 45.99 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.calabresa_ao_catupiry,"Pizza Calabresa ao Catupiry","molho de tomate, catupiry, mussarela, calabreza e orégano",36.90,43.90, 52.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.calabresa_tradicional,"Pizza Calabresa Tradicional","molho de tomate, mussarela, calabreza e orégano", 32.90,40.00, 45.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.catupiry,"Pizza Catupiry","molho de tomate, catupiry, mussarela, orégano e azeite", 36.75,42.75, 48.75 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.champignon_ao_catupiry,"Pizza Champignon ao Catupiry","molho de tomate, catupiry, champignon, mussarela, orégano e azeite", 36.50,49.50, 55.00 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.chilena,"Pizza Chilena","molho de tomate, atum, mussarela, orégano e azeite", 36.90,49.90, 55.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.frango_catupiry,"Pizza Frango com Catupiry","molho de tomate, frango, catupiry, mussarela, orégano e azeitona", 33.60,43.70, 48.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.frango_light,"Pizza Frango Light","molho de tomate, frango, mussarela, orégano e azeitona", 37.40,47.55, 53.50 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.margherita,"Pizza Margherita","molho de tomate, mussarela, tomate e manjericão", 29.90,35.90, 39.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.milho_verde,"Pizza Milho Verde","molho de tomate, milho verde, mussarela, orégano e azeitona", 29.90,35.90, 38.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.mussarela,"Pizza Mussarela","molho de tomate, mussarela, orégano e azeitona", 37.00,45.00, 48.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.napoli_in_calabria,"Pizza Napoli in Calábria","molho de tomate, calabresa e cebola", 30.00,33.00, 35.90 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.palmito_ao_catupiry,"Pizza Palmito ao Catupiry","molho de tomate, palmito, catupiry, mussarela, orégano e azeitona", 37.40,43.60, 47.40 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.tomate_seco_com_rucula,"Pizza Tomate Seco com Rucúla","molho de tomate, toamte seco, mussarela, orégano e azeitona", 29.90,34.45, 37.45 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.romeu_e_julieta,"Pizza Romeu e Julieta","goiabada e catupiry", 34.80,38.80, 43.80 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.prestigio,"Pizza Prestigio","creme de leite, coco ralado, leite condensado, leite de coc e chocolate ralado", 34.80,38.80, 43.80 ));
        pizzaActivities.add(new PizzaActivity(R.drawable.choco_delicia,"Pizza Choco Delícia","chocolate, leite condensado e granulado", 34.80,38.80, 43.80 ));



        return pizzaActivities;
    }
}

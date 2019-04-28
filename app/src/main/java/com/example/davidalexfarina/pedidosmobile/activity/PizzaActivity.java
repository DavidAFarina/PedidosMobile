package com.example.davidalexfarina.pedidosmobile.activity;

import com.example.davidalexfarina.pedidosmobile.R;

import java.util.ArrayList;
import java.util.List;

public class PizzaActivity {
    public int img; //R.drawable.xxx
    public String nomePizza;
    public String ingredientes;



    public PizzaActivity(int img, String nomePizza, String ingredientes) {
        this.img = img;
        this.nomePizza = nomePizza;
        this.ingredientes = ingredientes;


    }

    public static List<PizzaActivity> getPizzas(){
        List<PizzaActivity> pizzaActivities = new ArrayList<>();
        pizzaActivities.add(new PizzaActivity(R.drawable.al_caponi, "Al Caponi", "molho de tomate, mussarela, mortadela defumada (Ouro Perdigão), pimentão vermelho, orégano e azeite"));
        pizzaActivities.add(new PizzaActivity(R.drawable.alho_e_oleo_e_bacon, "Alho e Óleo e Bacon", "molho de tomate, alho crocante, azeite, mussarela, bacon, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.aos_cinco_formaggi, "Aos Cinco Formaggi","molho de tomate, catupiry, provolone prato, mussarela, gorgonzola, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.aos_quatro_queijos,"Aos Quatro Quijos","molho de tomate, Catupiry, provolone prato, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.bacon,"Bacon","molho de tomate, catupiry, presunto, mussarela, bacon crocante, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.baiana,"Baiana","molho apimentado, mussarela, calabreza, bacon, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.bologna,"Bologna","molho de tomate, presunto, champignon, mussarela, bacon, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.brocolis,"Brócolis","molho de tomate, brócolis, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.calabresa_ao_catupiry,"Calabresa ao Catupiry","molho de tomate, catupiry, mussarela, calabreza e orégano"));
        pizzaActivities.add(new PizzaActivity(R.drawable.calabresa_tradicional,"Calabresa Tradicional","molho de tomate, mussarela, calabreza e orégano"));
        pizzaActivities.add(new PizzaActivity(R.drawable.catupiry,"Catupiry","molho de tomate, catupiry, mussarela, orégano e azeite"));
        pizzaActivities.add(new PizzaActivity(R.drawable.champignon_ao_catupiry,"Champignon ao Catupiry","molho de tomate, catupiry, champignon, mussarela, orégano e azeite"));
        pizzaActivities.add(new PizzaActivity(R.drawable.chilena,"Chilena","molho de tomate, atum, mussarela, orégano e azeite"));
        pizzaActivities.add(new PizzaActivity(R.drawable.frango_catupiry,"Frango com Catupiry","molho de tomate, frango, catupiry, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.frango_light,"Frango Light","molho de tomate, frango, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.margherita,"Margherita","molho de tomate, mussarela, tomate e manjericão"));
        pizzaActivities.add(new PizzaActivity(R.drawable.milho_verde,"Milho Verde","molho de tomate, milho verde, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.mussarela,"Mussarela","molho de tomate, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.napoli_in_calabria,"Napoli in Calábria","molho de tomate, calabresa e cebola"));
        pizzaActivities.add(new PizzaActivity(R.drawable.palmito_ao_catupiry,"Palmito ao Catupiry","molho de tomate, palmito, catupiry, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.tomate_seco_com_rucula,"Tomate Seco com Rucúla","molho de tomate, toamte seco, mussarela, orégano e azeitona"));
        pizzaActivities.add(new PizzaActivity(R.drawable.romeu_e_julieta,"Romeu e Julieta","goiabada e catupiry"));
        pizzaActivities.add(new PizzaActivity(R.drawable.prestigio,"Prestigio","creme de leite, coco ralado, leite condensado, leite de coc e chocolate ralado"));
        pizzaActivities.add(new PizzaActivity(R.drawable.choco_delicia,"Choco Delícia","chocolate, leite condensado e granulado"));




        return pizzaActivities;
    }
}

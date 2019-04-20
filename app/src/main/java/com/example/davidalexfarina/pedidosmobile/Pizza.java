package com.example.davidalexfarina.pedidosmobile;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    public int img; //R.drawable.xxx
    public String nomePizza;
    public String ingredientes;



    public Pizza(int img, String nomePizza, String ingredientes) {
        this.img = img;
        this.nomePizza = nomePizza;
        this.ingredientes = ingredientes;


    }

    public static List<Pizza> getPizzas(){
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(R.drawable.al_caponi, "Al Caponi", "molho de tomate, mussarela, mortadela defumada (Ouro Perdigão), pimentão vermelho, orégano e azeite"));
        pizzas.add(new Pizza(R.drawable.alho_e_oleo_e_bacon, "Alho e Óleo e Bacon", "molho de tomate, alho crocante, azeite, mussarela, bacon, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.aos_cinco_formaggi, "Aos Cinco Formaggi","molho de tomate, catupiry, provolone prato, mussarela, gorgonzola, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.aos_quatro_queijos,"Aos Quatro Quijos","molho de tomate, Catupiry, provolone prato, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.bacon,"Bacon","molho de tomate, catupiry, presunto, mussarela, bacon crocante, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.baiana,"Baiana","molho apimentado, mussarela, calabreza, bacon, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.bologna,"Bologna","molho de tomate, presunto, champignon, mussarela, bacon, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.brocolis,"Brócolis","molho de tomate, brócolis, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.calabresa_ao_catupiry,"Calabresa ao Catupiry","molho de tomate, catupiry, mussarela, calabreza e orégano"));
        pizzas.add(new Pizza(R.drawable.calabresa_tradicional,"Calabresa Tradicional","molho de tomate, mussarela, calabreza e orégano"));
        pizzas.add(new Pizza(R.drawable.catupiry,"Catupiry","molho de tomate, catupiry, mussarela, orégano e azeite"));
        pizzas.add(new Pizza(R.drawable.champignon_ao_catupiry,"Champignon ao Catupiry","molho de tomate, catupiry, champignon, mussarela, orégano e azeite"));
        pizzas.add(new Pizza(R.drawable.chilena,"Chilena","molho de tomate, atum, mussarela, orégano e azeite"));
        pizzas.add(new Pizza(R.drawable.frango_catupiry,"Frango com Catupiry","molho de tomate, frango, catupiry, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.frango_light,"Frango Light","molho de tomate, frango, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.margherita,"Margherita","molho de tomate, mussarela, tomate e manjericão"));
        pizzas.add(new Pizza(R.drawable.milho_verde,"Milho Verde","molho de tomate, milho verde, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.mussarela,"Mussarela","molho de tomate, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.napoli_in_calabria,"Napoli in Calábria","molho de tomate, calabresa e cebola"));
        pizzas.add(new Pizza(R.drawable.palmito_ao_catupiry,"Palmito ao Catupiry","molho de tomate, palmito, catupiry, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.tomate_seco_com_rucula,"Tomate Seco com Rucúla","molho de tomate, toamte seco, mussarela, orégano e azeitona"));
        pizzas.add(new Pizza(R.drawable.romeu_e_julieta,"Romeu e Julieta","goiabada e catupiry"));
        pizzas.add(new Pizza(R.drawable.prestigio,"Prestigio","creme de leite, coco ralado, leite condensado, leite de coc e chocolate ralado"));
        pizzas.add(new Pizza(R.drawable.choco_delicia,"Choco Delícia","chocolate, leite condensado e granulado"));




        return pizzas;
    }
}

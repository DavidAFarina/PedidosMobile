package com.example.davidalexfarina.pedidosmobile;

import java.util.ArrayList;
import java.util.List;

public class Bebida {
    public int img; //R.drawable.xxx
    public String nomeBebida;
    public String descricao;
    public Double valor;



    public Bebida(int img, String nomeBebida, String descricao, Double valor) {
        this.img = img;
        this.nomeBebida = nomeBebida;
        this.descricao = descricao;
        this.valor = valor;


    }

    public static List<Bebida> getBebidas(){
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(new Bebida(R.drawable.cerveja_antarctica_600ml,"Cerveja Antartica","Garrafa 600 ml",8.50));
        bebidas.add(new Bebida(R.drawable.cerveja_antarctica_original_600ml,"Cerveja Antartica Original", "Garafa 600 ml", 11.50));
        bebidas.add(new Bebida(R.drawable.cerveja_brahma_600ml,"Cerveja Brahma","Garrafa 600 ml",9.80));
        bebidas.add(new Bebida(R.drawable.cerveja_brahma_extra_lager_600_ml,"Cerveja Brahma Extra Lager","Garrafa 600 ml",12.00));
        bebidas.add(new Bebida(R.drawable.cerveja_colorado_appia_600ml,"Cerveja Colorado Appia","Garrafa 600 ml",15.00));
        bebidas.add(new Bebida(R.drawable.cerveja_serramalte_600ml, "Cerveja Serramalte","Garrafa 600 ml",9.80));
        bebidas.add(new Bebida(R.drawable.cerveja_skol_600ml,"Cerveja Skol","Garrafa 600 ml",9.80));
        bebidas.add(new Bebida(R.drawable.cerveja_stella_artois_550ml,"Cerveja Stella","Garrafa 550 ml",12.50));
        bebidas.add(new Bebida(R.drawable.cerveja_amstel_lager_600ml,"Cerveja Amstel Lager","Garrafa 600 ml", 11.50));

        return bebidas;
    }
}

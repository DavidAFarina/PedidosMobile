package com.example.davidalexfarina.pedidosmobile.activity;

import com.example.davidalexfarina.pedidosmobile.R;

import java.util.ArrayList;
import java.util.List;

public class BebidaActivity {
    public int img; //R.drawable.xxx
    public String nomeBebida;
    public String descricao;
    public Double valor;



    public BebidaActivity(int img, String nomeBebida, String descricao, Double valor) {
        this.img = img;
        this.nomeBebida = nomeBebida;
        this.descricao = descricao;
        this.valor = valor;


    }

    public static List<BebidaActivity> getBebidas(){
        List<BebidaActivity> bebidaActivities = new ArrayList<>();
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_antarctica_600ml,"Cerveja Antartica","Garrafa 600 ml",8.50));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_antarctica_original_600ml,"Cerveja Antartica Original", "Garafa 600 ml", 11.50));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_brahma_600ml,"Cerveja Brahma","Garrafa 600 ml",9.80));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_brahma_extra_lager_600_ml,"Cerveja Brahma Extra Lager","Garrafa 600 ml",12.00));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_colorado_appia_600ml,"Cerveja Colorado Appia","Garrafa 600 ml",15.00));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_serramalte_600ml, "Cerveja Serramalte","Garrafa 600 ml",9.80));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_skol_600ml,"Cerveja Skol","Garrafa 600 ml",9.80));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_stella_artois_550ml,"Cerveja Stella","Garrafa 550 ml",12.50));
        bebidaActivities.add(new BebidaActivity(R.drawable.cerveja_amstel_lager_600ml,"Cerveja Amstel Lager","Garrafa 600 ml", 11.50));

        return bebidaActivities;
    }
}

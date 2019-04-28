package com.example.davidalexfarina.pedidosmobile.activity;

import com.example.davidalexfarina.pedidosmobile.R;

import java.util.ArrayList;
import java.util.List;

public class PorcaoActivity {
    public int img; //R.drawable.xxx
    public String nomePorcao;
    public String descricao;
    public String tamanho;
    public Double valor;



    public PorcaoActivity(int img, String nomePorcao, String descricao, String tamanho, Double valor) {
        this.img = img;
        this.nomePorcao = nomePorcao;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valor = valor;


    }

    public static List<PorcaoActivity> getPorcoes(){
        List<PorcaoActivity> porcoes = new ArrayList<>();
        porcoes.add(new PorcaoActivity(R.drawable.abracadinho,"Abraçadinho","Camarão com provolone à milanesa","20 unidades", 50.00));
        porcoes.add(new PorcaoActivity(R.drawable.aipim_frito,"Aipim Frito","Aipim fatiado em tiras tipo palito","500g",20.00));
        porcoes.add(new PorcaoActivity(R.drawable.batata_frita,"Batata Palito Frita","Batata fatiada em tiras tipo palito","500g",20.00));
        porcoes.add(new PorcaoActivity(R.drawable.batata_sorriso,"Batata Sorriso","Batata em formato de emoji sorrindo","500g",20.00));
        porcoes.add(new PorcaoActivity(R.drawable.bolinho_bacalhau,"Bolinho de Bacalhau","Frutos do Mar","12 unidades",50.00));
        porcoes.add(new PorcaoActivity(R.drawable.bolinho_siri,"Bolinho de Siri","Frutos do Mar","12 unidades",48.00));
        porcoes.add(new PorcaoActivity(R.drawable.camarao_alho_oleo, "Camarao ao Alho Óleo","Frutos do Mar", "500 g", 48.00));
        porcoes.add(new PorcaoActivity(R.drawable.camarao_bafo,"Camarão ao Bafo","Frutos do Mar","500 g",50.00));
        porcoes.add(new PorcaoActivity(R.drawable.camarao_milanesa,"Camarão a Milanesa","Frutos do Mar","500 g",75.00));
        porcoes.add(new PorcaoActivity(R.drawable.casquinha_siri,"Casquinha de Siri","Frutos do Mar","Unidade", 12.00));
        porcoes.add(new PorcaoActivity(R.drawable.contrafile,"Contrafile Grelhado","Contrafilé Grelhado á moda da casa","500 g",45.00));
        porcoes.add(new PorcaoActivity(R.drawable.deliciadefrango,"Delicia de Frango","Filé de Frango Grelhado","500 g",35.00));
        porcoes.add(new PorcaoActivity(R.drawable.deliciadefrangoamilanesa,"Delicia de Frango á Milanesa","Filé de Frango á Milanesa","500 g",38.00));
        porcoes.add(new PorcaoActivity(R.drawable.frangoapassarinho,"Frango á Passarinho","Pedaços de frangos fritos","1 Kg",42.00));
        porcoes.add(new PorcaoActivity(R.drawable.franguito,"Franguito","Frango com Bacon","20 unidades",38.00));
        porcoes.add(new PorcaoActivity(R.drawable.gratinado_camarao,"Gratinado de Camarão","Frutos do Mar","Unidade",30.00));
        porcoes.add(new PorcaoActivity(R.drawable.gratinado_siri,"Gratinado de Siri","Frutos do Mar","Unidade",28.00));
        porcoes.add(new PorcaoActivity(R.drawable.isca_de_peixe,"Isca de Peixe","Frutos do Mar","500 g",40.00));
        porcoes.add(new PorcaoActivity(R.drawable.juntoemisturado,"Junto e Misturado","Camarão e lula grelhados","500 g",55.00));
        porcoes.add(new PorcaoActivity(R.drawable.lula_a_milanesa,"Lula á Milanesa","Frutos do Mar","500 g",50.00));
        porcoes.add(new PorcaoActivity(R.drawable.ostra_gratinada,"Ostra Gratinada","Frutos do Mar","12 unidaes",50.00));
        porcoes.add(new PorcaoActivity(R.drawable.palitodelinguado,"Palitinhos Crocantes de Linguad","Frutos do Mar","300 g",40.00));
        porcoes.add(new PorcaoActivity(R.drawable.petiscamarao,"Petiscamarão","Camarão à Milanesa, Camarão ao Bafo e Camarão ao Alho & Óleo – 150g cada  + 2 Pastéis de Camarão + 10 Abraçadinhos ","Unidade",95.00));
        porcoes.add(new PorcaoActivity(R.drawable.polenta_frita,"Polenta Palito Frita","Polenta fatiada em tiras tipo palito","500 g",17.00));
        porcoes.add(new PorcaoActivity(R.drawable.salada,"salada","Salada Mista","Unidade",20.00));
        porcoes.add(new PorcaoActivity(R.drawable.tabua_carnes,"Tabua Mista de Carnes","Carne, Frango, Calabresa, Cebola e Pimentão","750",60.00));

        return porcoes;
    }
}

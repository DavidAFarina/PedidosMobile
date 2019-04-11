package com.example.davidalexfarina.pedidosmobile;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    public  int btnMesa; //R.drawable.xxx
    public  int btnMesa_01;
    public  int btnMesa_02;

    public Mesa(int btnMesa, int btnMesa_01, int btnMesa_02) {
        this.btnMesa = btnMesa;
        this.btnMesa_01 = btnMesa_01;
        this.btnMesa_02 = btnMesa_02;

    }

    public static List<Mesa> getMesas(){
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(new Mesa(R.drawable.mesa, R.drawable.mesa, R.drawable.mesa));
        mesas.add(new Mesa(R.drawable.mesa, R.drawable.mesa, R.drawable.mesa));
        mesas.add(new Mesa(R.drawable.mesa, R.drawable.mesa, R.drawable.mesa));
        mesas.add(new Mesa(R.drawable.mesa, R.drawable.mesa, R.drawable.mesa));
        mesas.add(new Mesa(R.drawable.mesa, R.drawable.mesa, R.drawable.mesa));
        mesas.add(new Mesa(R.drawable.mesa, R.drawable.mesa, R.drawable.mesa));
        mesas.add(new Mesa(R.drawable.mesa, R.drawable.mesa, R.drawable.mesa));


        return mesas;
    }

}


package com.example.davidalexfarina.pedidosmobile.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;

public class MesasActivity extends AppCompatActivity {
    private Button btMesa1;
    private Button btMesa2;
    private Button btMesa3;
    private Button btMesa4;
    private Button btMesa5;
    private Button btMesa6;
    private Button btMesa7;
    private Button btMesa8;
    private Button btMesa9;
    private Button btMesa10;
    private Button btMesa11;
    private Button btMesa12;
    private Button btMesa13;
    private Button btMesa14;
    private Button btMesa15;
    private Button btMesa16;
    private Button btMesa17;
    private Button btMesa18;
    private Button btMesa19;
    private Button btMesa20;
    private Button btMesa21;
    private Button btMesa22;
    private Button btMesa23;
    private Button btMesa24;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);

        Toast.makeText(this,"Selecione a mesa desejada",Toast.LENGTH_SHORT).show();

        btMesa1 = (Button) findViewById(R.id.btMesa1);
        btMesa2 = (Button) findViewById(R.id.btMesa2);
        btMesa3 = (Button) findViewById(R.id.btMesa3);
        btMesa4 = (Button) findViewById(R.id.btMesa4);
        btMesa5 = (Button) findViewById(R.id.btMesa5);
        btMesa6 = (Button) findViewById(R.id.btMesa6);
        btMesa7 = (Button) findViewById(R.id.btMesa7);
        btMesa8 = (Button) findViewById(R.id.btMesa8);
        btMesa9 = (Button) findViewById(R.id.btMesa9);
        btMesa10 = (Button) findViewById(R.id.btMesa10);
        btMesa11 = (Button) findViewById(R.id.btMesa11);
        btMesa12 = (Button) findViewById(R.id.btMesa12);
        btMesa13 = (Button) findViewById(R.id.btMesa13);
        btMesa14 = (Button) findViewById(R.id.btMesa14);
        btMesa15 = (Button) findViewById(R.id.btMesa15);
        btMesa16 = (Button) findViewById(R.id.btMesa16);
        btMesa17 = (Button) findViewById(R.id.btMesa17);
        btMesa18 = (Button) findViewById(R.id.btMesa18);
        btMesa19 = (Button) findViewById(R.id.btMesa19);
        btMesa20 = (Button) findViewById(R.id.btMesa20);
        btMesa21 = (Button) findViewById(R.id.btMesa21);
        btMesa22 = (Button) findViewById(R.id.btMesa22);
        btMesa23 = (Button) findViewById(R.id.btMesa23);
        btMesa24 = (Button) findViewById(R.id.btMesa24);
    }
    public void abrirPedidosDaMesa(View view){

      /* Intent intent = new Intent(this, PedidoDaMesaActivity.class);
        startActivity(intent);*/

        Bundle parametros = new Bundle();

        if(view.getId() == R.id.btMesa1){
            parametros.putString("param1", btMesa1.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }
        else if(view.getId() == R.id.btMesa2){
            parametros.putString("param1", btMesa2.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }
        else if(view.getId() == R.id.btMesa3){
            parametros.putString("param1", btMesa3.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa4){
            parametros.putString("param1", btMesa4.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa5){
            parametros.putString("param1", btMesa5.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa6){
            parametros.putString("param1", btMesa6.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa7){
            parametros.putString("param1", btMesa7.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa8){
            parametros.putString("param1", btMesa8.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa9){
            parametros.putString("param1", btMesa9.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa10){
            parametros.putString("param1", btMesa10.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
         }else if(view.getId() == R.id.btMesa11){
            parametros.putString("param1", btMesa11.getText().toString());
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa12) {
            parametros.putString("param1", btMesa12.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa13) {
            parametros.putString("param1", btMesa13.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa14) {
            parametros.putString("param1", btMesa14.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa15) {
            parametros.putString("param1", btMesa15.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa16) {
            parametros.putString("param1", btMesa16.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa17) {
            parametros.putString("param1", btMesa17.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa18) {
            parametros.putString("param1", btMesa18.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa19) {
            parametros.putString("param1", btMesa19.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa20) {
            parametros.putString("param1", btMesa20.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa21) {
            parametros.putString("param1", btMesa21.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa22) {
            parametros.putString("param1", btMesa22.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa23) {
            parametros.putString("param1", btMesa23.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa24) {
            parametros.putString("param1", btMesa24.getText().toString());
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }





    }



}

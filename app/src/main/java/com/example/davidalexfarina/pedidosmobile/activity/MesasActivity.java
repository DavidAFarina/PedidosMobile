package com.example.davidalexfarina.pedidosmobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
    private TextView txtNomeGarcom;
    private String tempUsuario;



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
        TextView txtNomeGarcom = findViewById(R.id.txtNomeGarcom);

        //Recebendo o nome do garçon e setando no xml das mesas
        TextView txtNome = findViewById(R.id.txtNomeGarcom);

        Intent intent = getIntent();
        Bundle parametro_garcom = intent.getExtras();
        String paramNome = parametro_garcom.getString("paramNome");


        txtNomeGarcom.setText(paramNome);
        tempUsuario = paramNome;//Variavel temporaria utilizada para guardar a string com o nome do garcom.
    }


    public void abrirPedidosDaMesa(View view){

      /* Intent intent = new Intent(this, PedidoDaMesaActivity.class);
        startActivity(intent);*/

        Bundle parametros = new Bundle();

        if(view.getId() == R.id.btMesa1){
           parametros.putString("numeroMesa", btMesa1.getText().toString());
           parametros.putString("garcom", tempUsuario);
           Intent intent = new Intent(this,PedidoDaMesaActivity.class);

            intent.putExtras(parametros);

            startActivity(intent);
        }
        else if(view.getId() == R.id.btMesa2){
            parametros.putString("numeroMesa", btMesa2.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }
        else if(view.getId() == R.id.btMesa3){
            parametros.putString("numeroMesa", btMesa3.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa4){
            parametros.putString("numeroMesa", btMesa4.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa5){
            parametros.putString("numeroMesa", btMesa5.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa6){
            parametros.putString("numeroMesa", btMesa6.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa7){
            parametros.putString("numeroMesa", btMesa7.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa8){
            parametros.putString("numeroMesa", btMesa8.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa9){
            parametros.putString("numeroMesa", btMesa9.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa10){
            parametros.putString("numeroMesa", btMesa10.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
         }else if(view.getId() == R.id.btMesa11){
            parametros.putString("numeroMesa", btMesa11.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this,PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa12) {
            parametros.putString("numeroMesa", btMesa12.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa13) {
            parametros.putString("numeroMesa", btMesa13.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa14) {
            parametros.putString("numeroMesa", btMesa14.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa15) {
            parametros.putString("numeroMesa", btMesa15.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa16) {
            parametros.putString("numeroMesa", btMesa16.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa17) {
            parametros.putString("numeroMesa", btMesa17.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa18) {
            parametros.putString("numeroMesa", btMesa18.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa19) {
            parametros.putString("numeroMesa", btMesa19.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa20) {
            parametros.putString("numeroMesa", btMesa20.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa21) {
            parametros.putString("numeroMesa", btMesa21.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa22) {
            parametros.putString("numeroMesa", btMesa22.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa23) {
            parametros.putString("numeroMesa", btMesa23.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.btMesa24) {
            parametros.putString("numeroMesa", btMesa24.getText().toString());
            parametros.putString("garcom", tempUsuario);
            Intent intent = new Intent(this, PedidoDaMesaActivity.class);
            intent.putExtras(parametros);
            startActivity(intent);
        }





    }



}

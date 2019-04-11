package com.example.davidalexfarina.pedidosmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PedidoMesaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido_mesa);

        /*Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.show(getSupportFragmentManager(), "loginDialog");

            }
        });*/
    }
}

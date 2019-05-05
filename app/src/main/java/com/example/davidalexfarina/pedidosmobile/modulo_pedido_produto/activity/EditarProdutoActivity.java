package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;

import java.text.NumberFormat;
import java.util.Locale;

public class EditarProdutoActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtValor;
    private EditText edtQuantidade;
    private EditText edtValorTotal;
    private EditText edtObservacao;
    private Produto produto;
    private ProdutoDAO produtoDAO;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        edtNome = (EditText) findViewById(R.id.edt_nome);

        edtValor = (EditText) findViewById(R.id.edt_valor);

        edtQuantidade = (EditText) findViewById(R.id.edt_quantidade);

        edtValorTotal = (EditText) findViewById(R.id.edt_valorTotal);

        edtObservacao = (EditText) findViewById(R.id.edt_observacao);

        produtoDAO = ProdutoDAO.getInstance(this);

        produto = (Produto) getIntent().getSerializableExtra("produto");

        if (produto != null){ //executa quando a solicitação vernha do editar um item do pedido
            edtNome.setText(produto.getNome());
            edtValor.setText(String.valueOf(produto.getValor()));
            edtQuantidade.setText(String.valueOf(produto.getQuantidade()));
            /*edtValorTotal.setText(String.valueOf(produto.getValorTotal()));*/
            edtValorTotal.setText(String.valueOf(produto.getValor()*produto.getQuantidade()));
            edtObservacao.setText(produto.getObservacao());
            edtQuantidade.requestFocus();

        }else{//executa caso o pedido venha do click no item do cardapio, recebendo valores do item clicado no cardapio
            Intent intent = getIntent();
            Bundle parametroProduto = intent.getExtras();
            String paramNome = parametroProduto.getString("paramNome");
            String paramValor = parametroProduto.getString("paramValor");

            Toast.makeText(this,paramNome,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"teste chegou dentro do edit",Toast.LENGTH_SHORT).show();

            edtNome.setText(paramNome);
            edtValor.setText(paramValor);
            edtQuantidade.requestFocus();



        }

        /*Intent intent = getIntent();
        Bundle parametroProduto = intent.getExtras();
        String paramNome = parametroProduto.getString("paramNome");
        String paramValor = parametroProduto.getString("paramValor");

        Toast.makeText(this,paramNome,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"teste chegou dentro do edit",Toast.LENGTH_SHORT).show();*/


           /* edtNome.setText(paramNome);
            edtValor.setText(paramValor);*/


    }

    public void processar(View view){
        String nome = edtNome.getText().toString();


        double valor = Double.parseDouble(edtValor.getText().toString());
        String msg; //Mensagem que informa o ID da linha atualizada.


        Integer qtd = Integer.parseInt(edtQuantidade.getText().toString());

        /*double valorTotal = Double.parseDouble(edtValorTotal.getText().toString());*/
        double valorTotal = valor * qtd; //caso o valor total necessite ser inserido manualmente, descomentar a linha acima e comentar essa.

        String observacao = edtObservacao.getText().toString();

        if (produto == null) {
            Produto produto = new Produto(nome, valor, qtd, valorTotal, observacao);
            produtoDAO.save(produto);
            msg = "Produto gravado com ID = " + produto.getId();

        } else {
            produto.setNome(nome);
            produto.setValor(valor);
            produto.setQuantidade(qtd);
            produto.setValorTotal(valor*qtd);
            produto.setObservacao(observacao);
            produtoDAO.update(produto);
            msg = "Produto atualizado com ID = " + produto.getId();
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }

    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
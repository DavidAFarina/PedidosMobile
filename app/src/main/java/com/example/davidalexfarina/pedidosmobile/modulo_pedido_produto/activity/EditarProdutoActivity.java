package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidalexfarina.pedidosmobile.R;
import com.example.davidalexfarina.pedidosmobile.activity.PedidoDaMesaActivity;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.Produto;
import com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data.ProdutoDAO;

import java.text.NumberFormat;
import java.util.Locale;

public class EditarProdutoActivity extends AppCompatActivity {

    private EditText edtMesa;
    private EditText edtGarcom;
    private EditText edtNome;
    private EditText edtValor;
    private EditText edtQuantidade;
    private EditText edtValorTotal;
    private EditText edtObservacao;
    private Button btProcessar;
    private Produto produto;
    private ProdutoDAO produtoDAO;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT","BR"));
    String paramMesa;
    String paramGarcom;
    String paramNome;
    String paramValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);
        edtMesa = (EditText) findViewById(R.id.edt_mesa);
        edtGarcom = (EditText) findViewById(R.id.edt_garcom);
        edtNome = (EditText) findViewById(R.id.edt_nome);
        edtValor = (EditText) findViewById(R.id.edt_valor);
        edtQuantidade = (EditText) findViewById(R.id.edt_quantidade);
        edtValorTotal = (EditText) findViewById(R.id.edt_valorTotal);
        edtObservacao = (EditText) findViewById(R.id.edt_observacao);
        btProcessar = (Button) findViewById(R.id.btProcessar);
        produtoDAO = ProdutoDAO.getInstance(this);
        produto = (Produto) getIntent().getSerializableExtra("produto");

        if (produto != null) { //executa quando a solicitação venha do editar um item do pedido
            paramValor = String.valueOf(produto.getValor());
            edtMesa.setText(String.valueOf(produto.getMesa()));
            edtGarcom.setText(produto.getGarcom());
            edtNome.setText(produto.getNome());
            //edtValor.setText(String.valueOf(produto.getValor()));
            edtValor.setText(nf.format(Double.parseDouble(String.valueOf(produto.getValor()))));
            //edtValor.setText(paramValor);
            edtQuantidade.setText(String.valueOf(produto.getQuantidade()));
            //edtValorTotal.setText(String.valueOf(produto.getValor() * produto.getQuantidade()));
            edtValorTotal.setText(nf.format(Double.parseDouble(String.valueOf(produto.getValor()*produto.getQuantidade()))));
            edtObservacao.setText(produto.getObservacao());
            edtQuantidade.requestFocus();

        } else {//executa caso o pedido venha do click no item do cardapio, recebendo valores do item clicado no cardapio
            Intent intent = getIntent();
            Bundle parametroProduto = intent.getExtras();
            String paramMesa = parametroProduto.getString("paramMesa");//valores recebidos da activity/TamanhoDialog
            String paramGarcom = parametroProduto.getString("paramGarcom");
            String paramNome = parametroProduto.getString("paramNome");
            paramValor = parametroProduto.getString("paramValor");

            /*Toast.makeText(this, paramNome, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "teste chegou dentro do edit", Toast.LENGTH_SHORT).show();
*/
            edtMesa.setText(paramMesa);
            edtGarcom.setText(paramGarcom);
            edtNome.setText(paramNome);
            //edtValor.setText(paramValor);
            edtValor.setText(nf.format(Double.parseDouble(paramValor)));
            edtQuantidade.requestFocus();
        }
    }

    public void processar(View view) {
        if (edtQuantidade.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Quantidade está vazio!", Toast.LENGTH_SHORT).show();
            edtQuantidade.requestFocus();
        } else {
            Integer mesa = Integer.parseInt(edtMesa.getText().toString());
            String garcom = edtGarcom.getText().toString();
            String nome = edtNome.getText().toString();
           //double valor = Double.parseDouble(edtValor.getText().toString());
            double valor = Double.parseDouble(paramValor);
            String msg; //Mensagem que informa o ID da linha atualizada.
            Integer qtd = Integer.parseInt(edtQuantidade.getText().toString());
            /*double valorTotal = Double.parseDouble(edtValorTotal.getText().toString());*/
            double valorTotal = valor * qtd; //caso o valor total necessite ser inserido manualmente, descomentar a linha acima e comentar essa.
            String observacao = edtObservacao.getText().toString();

            if (qtd < 1) {
                Toast.makeText(this, "Quantidade invalida.\nFavor informar a quantidade.", Toast.LENGTH_LONG).show();
                edtQuantidade.setFocusable(true);
            }
            else {

                if (produto == null) {
                    Produto produto = new Produto(mesa, garcom, nome, valor, qtd, valorTotal, observacao);
                    produtoDAO.save(produto);
                    msg = "Produto gravado com ID = " + produto.getId_produto_pedido();

                } else {
                    produto.setMesa(mesa);
                    produto.setGarcom(garcom);
                    produto.setNome(nome);
                    produto.setValor(valor);
                    produto.setQuantidade(qtd);
                    produto.setValorTotal(valor * qtd);
                    produto.setObservacao(observacao);
                    produtoDAO.update(produto);
                    msg = "Produto atualizado com ID = " + produto.getId_produto_pedido();
                }

                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        }
    }

    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
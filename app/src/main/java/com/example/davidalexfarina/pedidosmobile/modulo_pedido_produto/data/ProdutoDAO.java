package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private static ProdutoDAO instance;
    private SQLiteDatabase db;
    public Integer numeroMesa = 10;


    public ProdutoDAO(Context context) {
        DBHelper dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
    }


    //singleton
    public static ProdutoDAO getInstance(Context context) {
        if (instance == null) {
            instance = new ProdutoDAO(context.getApplicationContext());
        }
        return instance;
    }

    public List<Produto> list() {

        String[] columns = {
                ProdutosContract.Columns._ID,
                ProdutosContract.Columns.MESA,
                ProdutosContract.Columns.GARCOM,
                ProdutosContract.Columns.NOME,
                ProdutosContract.Columns.VALOR,
                ProdutosContract.Columns.QUANTIDADE,
                ProdutosContract.Columns.VALOR_TOTAL,
                ProdutosContract.Columns.OBSERVACAO
        };

        List<Produto> produtos = new ArrayList<>();
//essa codigo carrega todos os pedidos
       /* try (Cursor c = db.query(ProdutosContract.TABLE_NAME, columns, null, null, null, null, ProdutosContract.Columns.NOME)) {
            if (c.moveToFirst()) {
                do {
                    Produto p = ProdutoDAO.fromCursor(c);
                    produtos.add(p);
                } while (c.moveToNext());
            }
            return produtos;
        }*/

        //String sqlSelect = "SELECT * FROM produtosdb WHERE MESA= '10'";
        try (Cursor c = db.rawQuery("SELECT * FROM produto WHERE MESA= "+numeroMesa, null)) {
        //try (Cursor c = db.rawQuery("SELECT * FROM produto", null)) {
            if (c.moveToFirst()) {
                do {
                    Produto p = ProdutoDAO.fromCursor(c);
                    produtos.add(p);
                } while (c.moveToNext());
            }
            return produtos;
        }
    }

    private static Produto fromCursor(Cursor c) {
        int id = c.getInt(c.getColumnIndex(ProdutosContract.Columns._ID));
        int mesa = (int) c.getInt(c.getColumnIndex(ProdutosContract.Columns.MESA));
        String garcom = c.getString(c.getColumnIndex(ProdutosContract.Columns.GARCOM));
        String nome = c.getString(c.getColumnIndex(ProdutosContract.Columns.NOME));
        double valor = c.getDouble(c.getColumnIndex(ProdutosContract.Columns.VALOR));
        int quantidade = (int) c.getInt(c.getColumnIndex(ProdutosContract.Columns.QUANTIDADE));
        double valorTotal = c.getDouble(c.getColumnIndex(ProdutosContract.Columns.VALOR_TOTAL));
        String observacao = c.getString(c.getColumnIndex(ProdutosContract.Columns.OBSERVACAO));
        return new Produto(id, mesa, garcom, nome, valor, quantidade, valorTotal, observacao);
    }

    public void save(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(ProdutosContract.Columns.MESA, produto.getMesa());
        values.put(ProdutosContract.Columns.GARCOM, produto.getGarcom());
        values.put(ProdutosContract.Columns.NOME, produto.getNome());
        values.put(ProdutosContract.Columns.VALOR, produto.getValor());
        values.put(ProdutosContract.Columns.QUANTIDADE, produto.getQuantidade());
        values.put(ProdutosContract.Columns.VALOR_TOTAL, produto.getValorTotal());
        values.put(ProdutosContract.Columns.OBSERVACAO, produto.getObservacao());
        long id = db.insert(ProdutosContract.TABLE_NAME, null, values);
        produto.setId((int) id);
    }

    public void update(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(ProdutosContract.Columns.MESA, produto.getMesa());
        values.put(ProdutosContract.Columns.GARCOM, produto.getGarcom());
        values.put(ProdutosContract.Columns.NOME, produto.getNome());
        values.put(ProdutosContract.Columns.VALOR, produto.getValor());
        values.put(ProdutosContract.Columns.QUANTIDADE, produto.getQuantidade());
        values.put(ProdutosContract.Columns.VALOR_TOTAL, produto.getValorTotal());
        values.put(ProdutosContract.Columns.OBSERVACAO, produto.getObservacao());
        db.update(ProdutosContract.TABLE_NAME, values, ProdutosContract.Columns._ID + " = ?", new String[]{ String.valueOf(produto.getId()) });
    }

    public void delete(Produto produto) {
        db.delete(ProdutosContract.TABLE_NAME, ProdutosContract.Columns._ID + " = ?", new String[]{ String.valueOf(produto.getId()) });
    }
    public int consultaPedidoMesa(String mesa){
        numeroMesa = Integer.valueOf(mesa);
        return numeroMesa;
    }

    public void setNumeroMesa(String mesa) {
        this.numeroMesa = Integer.parseInt(mesa);
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }
}
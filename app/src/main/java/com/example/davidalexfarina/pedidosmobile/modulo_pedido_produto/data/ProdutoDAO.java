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
    public Double fatura= 0.0;


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
                PedidosMobileContract.Columns._ID_PRODUTO_PEDIDO,
                PedidosMobileContract.Columns.MESA,
                PedidosMobileContract.Columns.GARCOM,
                PedidosMobileContract.Columns.NOME,
                PedidosMobileContract.Columns.VALOR,
                PedidosMobileContract.Columns.QUANTIDADE,
                PedidosMobileContract.Columns.VALOR_TOTAL,
                PedidosMobileContract.Columns.OBSERVACAO
        };

        List<Produto> produtos = new ArrayList<>();
//essa codigo carrega todos os pedidos
       /* try (Cursor c = db.query(PedidosMobileContract.TABLE_PRODUTO_PEDIDO, columns, null, null, null, null, PedidosMobileContract.Columns.NOME)) {
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
       // try (Cursor c = db.rawQuery("SELECT * FROM produto", null)) {
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
        int id_produto_pedido = c.getInt(c.getColumnIndex(PedidosMobileContract.Columns._ID_PRODUTO_PEDIDO));
        int mesa = (int) c.getInt(c.getColumnIndex(PedidosMobileContract.Columns.MESA));
        String garcom = c.getString(c.getColumnIndex(PedidosMobileContract.Columns.GARCOM));
        String nome = c.getString(c.getColumnIndex(PedidosMobileContract.Columns.NOME));
        double valor = c.getDouble(c.getColumnIndex(PedidosMobileContract.Columns.VALOR));
        int quantidade = (int) c.getInt(c.getColumnIndex(PedidosMobileContract.Columns.QUANTIDADE));
        double valorTotal = c.getDouble(c.getColumnIndex(PedidosMobileContract.Columns.VALOR_TOTAL));
        String observacao = c.getString(c.getColumnIndex(PedidosMobileContract.Columns.OBSERVACAO));
        return new Produto(id_produto_pedido, mesa, garcom, nome, valor, quantidade, valorTotal, observacao);
    }

    public void save(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(PedidosMobileContract.Columns.MESA, produto.getMesa());
        values.put(PedidosMobileContract.Columns.GARCOM, produto.getGarcom());
        values.put(PedidosMobileContract.Columns.NOME, produto.getNome());
        values.put(PedidosMobileContract.Columns.VALOR, produto.getValor());
        values.put(PedidosMobileContract.Columns.QUANTIDADE, produto.getQuantidade());
        values.put(PedidosMobileContract.Columns.VALOR_TOTAL, produto.getValorTotal());
        values.put(PedidosMobileContract.Columns.OBSERVACAO, produto.getObservacao());
        long id = db.insert(PedidosMobileContract.TABLE_PRODUTO_PEDIDO, null, values);
        produto.setId_produto_pedido((int) id);
    }

    public void update(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(PedidosMobileContract.Columns.MESA, produto.getMesa());
        values.put(PedidosMobileContract.Columns.GARCOM, produto.getGarcom());
        values.put(PedidosMobileContract.Columns.NOME, produto.getNome());
        values.put(PedidosMobileContract.Columns.VALOR, produto.getValor());
        values.put(PedidosMobileContract.Columns.QUANTIDADE, produto.getQuantidade());
        values.put(PedidosMobileContract.Columns.VALOR_TOTAL, produto.getValorTotal());
        values.put(PedidosMobileContract.Columns.OBSERVACAO, produto.getObservacao());
        db.update(PedidosMobileContract.TABLE_PRODUTO_PEDIDO, values, PedidosMobileContract.Columns._ID_PRODUTO_PEDIDO + " = ?", new String[]{ String.valueOf(produto.getId_produto_pedido()) });
    }

    public void delete(Produto produto) {
        db.delete(PedidosMobileContract.TABLE_PRODUTO_PEDIDO, PedidosMobileContract.Columns._ID_PRODUTO_PEDIDO + " = ?", new String[]{ String.valueOf(produto.getId_produto_pedido()) });
    }
    public int consultaPedidoMesa(String mesa){
        numeroMesa = Integer.valueOf(mesa);
        return numeroMesa;
    }

    public String consultaFaturaMesa(String mesa){
        numeroMesa = Integer.valueOf(mesa);

       //Cursor fatura = db.rawQuery("SELECT 'VALOR_TOTAL' FROM produto WHERE MESA= "+numeroMesa, null);


        String[] columns = {
                PedidosMobileContract.Columns._ID_PRODUTO_PEDIDO,
                PedidosMobileContract.Columns.MESA,
                PedidosMobileContract.Columns.GARCOM,
                PedidosMobileContract.Columns.NOME,
                PedidosMobileContract.Columns.VALOR,
                PedidosMobileContract.Columns.QUANTIDADE,
                PedidosMobileContract.Columns.VALOR_TOTAL,
                PedidosMobileContract.Columns.OBSERVACAO
        };
        Cursor fatura = db.rawQuery("SELECT SUM(valorTotal) FROM produto WHERE MESA= "+numeroMesa, null);



        double  valorTotal = 0;
        int i = 0;
        if (fatura.getCount() > 0)
        {
            fatura.moveToFirst();

            valorTotal = fatura.getDouble(0);

                System.out.println("*************    Soma do valor total  *****************************************");
                System.out.println(valorTotal);
                System.out.println("*******************************************************");


        }

        return String.valueOf(valorTotal);
    }


}
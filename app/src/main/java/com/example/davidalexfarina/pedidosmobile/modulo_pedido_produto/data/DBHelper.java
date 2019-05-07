package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "produtosdb";
    public static final int DB_VERSION = 1;

    private static final String SQL_DROP = "DROP TABLE IF EXISTS " + ProdutosContract.TABLE_NAME;
    private static final String SQL_CREATE = String.format(
            "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s DOUBLE NOT NULL, %s INTEGER NOT NULL, %s DOUBLE NOT NULL, %s TEXT NOT NULL)", ProdutosContract.TABLE_NAME, ProdutosContract.Columns._ID, ProdutosContract.Columns.MESA, ProdutosContract.Columns.GARCOM, ProdutosContract.Columns.NOME, ProdutosContract.Columns.VALOR, ProdutosContract.Columns.QUANTIDADE, ProdutosContract.Columns.VALOR_TOTAL, ProdutosContract.Columns.OBSERVACAO);

    private static DBHelper instance;

    //singleton
    public static DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context, DB_NAME, null, DB_VERSION);
        }
        return instance;
    }

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_DROP);
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}

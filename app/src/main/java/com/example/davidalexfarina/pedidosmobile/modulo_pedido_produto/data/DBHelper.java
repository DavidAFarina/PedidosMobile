package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.davidalexfarina.pedidosmobile.modulo_usuario.UsuarioContract;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "bancoPedidosMobile"/*"produtosdb"*/;
    public static final int DB_VERSION = 1;

    private static final String SQL_DROP_PRODUTO_PEDIDO = "DROP TABLE IF EXISTS " + PedidosMobileContract.TABLE_PRODUTO_PEDIDO;
    private static final String SQL_CREATE_PRODUTO_PEDIDO = String.format(
            "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " + //Coluna ID
                    "%s INTEGER NOT NULL, " + //Coluna MESA
                    "%s TEXT NOT NULL, " + //Coluna GARCOM
                    "%s TEXT NOT NULL, " + //Coluna NOME
                    "%s DOUBLE NOT NULL, " + //Coluna VALOR
                    "%s INTEGER NOT NULL, " + //Coluna QUANTIDADE
                    "%s DOUBLE NOT NULL, " + //Coluna VALOR_TOTAL
                    "%s TEXT NOT NULL)", //Coluna OBSERVACAO
            PedidosMobileContract.TABLE_PRODUTO_PEDIDO, PedidosMobileContract.Columns._ID_PRODUTO_PEDIDO, PedidosMobileContract.Columns.MESA, PedidosMobileContract.Columns.GARCOM,
            PedidosMobileContract.Columns.NOME, PedidosMobileContract.Columns.VALOR, PedidosMobileContract.Columns.QUANTIDADE,
            PedidosMobileContract.Columns.VALOR_TOTAL, PedidosMobileContract.Columns.OBSERVACAO);


    private static final String SQL_DROP_USUARIO = "DROP TABLE IF EXISTS " + UsuarioContract.TABLE_USUARIO;
    private static final String SQL_CREATE_USUARIO = String.format(
            "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " + //Coluna ID
                    "%s TEXT NOT NULL, " + //Coluna GARCOM
                    "%s TEXT NOT NULL, ", //Coluna NOME
            UsuarioContract.TABLE_USUARIO, UsuarioContract.Columns._ID_USUARIO,
            UsuarioContract.Columns.NOME_USUARIO,
            UsuarioContract.Columns.SENHA_USUARIO);


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
        db.execSQL(SQL_DROP_PRODUTO_PEDIDO);
        db.execSQL(SQL_CREATE_PRODUTO_PEDIDO);
        db.execSQL(SQL_DROP_USUARIO);
        db.execSQL(SQL_CREATE_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}

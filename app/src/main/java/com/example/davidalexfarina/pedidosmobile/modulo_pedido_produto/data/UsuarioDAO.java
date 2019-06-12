package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static UsuarioDAO instance;
    private SQLiteDatabase db;
    String nomeP;

    public UsuarioDAO(Context context) {
        DBHelper dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
    }


    //singleton
    public static UsuarioDAO getInstance(Context context) {
        if (instance == null) {
            instance = new UsuarioDAO(context.getApplicationContext());
        }
        return instance;
    }

    public List<Usuario> list() {

        String[] columns = {
                PedidosMobileContract.Columns._ID_USUARIO,
                PedidosMobileContract.Columns.NOME_USUARIO,
                PedidosMobileContract.Columns.SENHA_USUARIO
        };

        List<Usuario> usuarios = new ArrayList<>();
//esse codigo carrega todos os usuarios
        System.out.println("*************    Chegou a listar o Array de usuarios  *****************************************");
        System.out.println(usuarios.toArray().length);
        System.out.println("*******************************************************");
        /*try (Cursor cursor = db.query(PedidosMobileContract.TABLE_USUARIO, columns, null, null, null, null, PedidosMobileContract.Columns.NOME_USUARIO)) {
            if (cursor.moveToFirst()) {
                do {
                    Usuario u = UsuarioDAO.fromCursor(cursor);
                    usuarios.add(u);
                    System.out.println(u);
                } while (cursor.moveToNext());
            }
            return usuarios;
        }*/



        /*try (Cursor c = db.rawQuery("SELECT * FROM usuario WHERE NOME_USUARIO= " + pesquisaNome, null)) {
            // try (Cursor c = db.rawQuery("SELECT * FROM usuario", null)) {
            if (c.moveToFirst()) {
                do {
                    Usuario u = UsuarioDAO.fromCursor(c);
                    usuarios.add(u);
                } while (c.moveToNext());
            }
            return usuarios;
        }*/
        try (Cursor c = db.rawQuery("SELECT * FROM usuario" , null)) {
            // try (Cursor c = db.rawQuery("SELECT * FROM usuario", null)) {
            if (c.moveToFirst()) {
                do {
                    Usuario u = UsuarioDAO.fromCursor(c);
                    usuarios.add(u);
                } while (c.moveToNext());
            }
            return usuarios;
        }
    }

    private static Usuario fromCursor(Cursor c) {
        int id_usuario = c.getInt(c.getColumnIndex(PedidosMobileContract.Columns._ID_USUARIO));
        String nome_usuario = c.getString(c.getColumnIndex(PedidosMobileContract.Columns.NOME_USUARIO));
        String senha_usuario = c.getString(c.getColumnIndex(PedidosMobileContract.Columns.SENHA_USUARIO));

        return new Usuario(id_usuario, nome_usuario, senha_usuario);
    }

    public void save(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put(PedidosMobileContract.Columns.NOME_USUARIO, usuario.getNome_usuario());
        values.put(PedidosMobileContract.Columns.SENHA_USUARIO, usuario.getSenha_usuario());
        long id = db.insert(PedidosMobileContract.TABLE_USUARIO, null, values);
        usuario.setId_usuario((int) id);
    }

    public void update(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put(PedidosMobileContract.Columns.NOME_USUARIO, usuario.getNome_usuario());
        values.put(PedidosMobileContract.Columns.SENHA_USUARIO, usuario.getSenha_usuario());
        db.update(PedidosMobileContract.TABLE_USUARIO, values, PedidosMobileContract.Columns._ID_USUARIO + " = ?", new String[]{String.valueOf(usuario.getId_usuario())});
    }

    public void delete(Usuario usuario) {
        db.delete(PedidosMobileContract.TABLE_USUARIO, PedidosMobileContract.Columns._ID_USUARIO + " = ?", new String[]{String.valueOf(usuario.getId_usuario())});
    }

    public boolean validaUsuario(String login, String senha){
        boolean autenticado = false;
        String[] columns = {
                PedidosMobileContract.Columns._ID_USUARIO,
                PedidosMobileContract.Columns.NOME_USUARIO,
                PedidosMobileContract.Columns.SENHA_USUARIO
        };

        Cursor valida = db.rawQuery("SELECT NOME_USUARIO, SENHA_USUARIO FROM usuario WHERE nome_usuario=? AND senha_usuario=?", new String[]{login.toString(), senha.toString()});
        String  user;
        if (valida.getCount() > 0)
        {
            valida.moveToFirst();
            user = valida.getString(0);
            if (user.equals(login)&&senha.equals(senha)){
                autenticado=true;
            }

            System.out.println("*************  teste de autenticação de usuario  *****************************************");
            System.out.println(user);
            System.out.println("*******************************************************");

        }
        return autenticado;
    }

}
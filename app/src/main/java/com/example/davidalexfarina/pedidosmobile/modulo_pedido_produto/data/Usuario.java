package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

import java.io.Serializable;

public class Usuario implements Serializable{

    private int id_usuario;
    private String nome_usuario;
    private String senha_usuario;

    public Usuario(int id_usuario, String nome_usuario, String senha_usuario) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.senha_usuario = senha_usuario;
    }



    public Usuario(String nome_usuario, String senha_usuario) {
        this.nome_usuario = nome_usuario;
        this.senha_usuario = senha_usuario;

    }

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario= id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }
    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }
    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
}

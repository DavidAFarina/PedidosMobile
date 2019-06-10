package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

import java.io.Serializable;

public class Produto implements Serializable {
    private int id_produto_pedido;
    private int mesa;
    private String garcom;
    private String nome;
    private double valor;
    private int quantidade;
    private double valorTotal;
    private String observacao;


    public Produto(int id_produto_pedido, int mesa, String garcom, String nome, double valor, int quantidade, double valorTotal, String observacao) {
        this.id_produto_pedido = id_produto_pedido;
        this.mesa = mesa;
        this.garcom = garcom;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }

    public Produto(int mesa, String garcom, String nome, double valor, int quantidade, double valorTotal, String observacao) {
        this.mesa = mesa;
        this.garcom = garcom;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }

    public int getId_produto_pedido() {
        return id_produto_pedido;
    }
    public void setId_produto_pedido(int id_produto_pedido) {
        this.id_produto_pedido = id_produto_pedido;
    }

    public int getMesa(){ return mesa; }
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getGarcom() {
        return garcom;
    }
    public void setGarcom(String garcom) { this.garcom = garcom; }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() { return valor; }
    public void setValor(double valor) {
        this.valor = valor;
    }


    public int getQuantidade(){ return quantidade; }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}

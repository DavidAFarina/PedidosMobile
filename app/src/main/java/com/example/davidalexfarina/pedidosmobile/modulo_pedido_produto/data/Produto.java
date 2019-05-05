package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

import java.io.Serializable;

public class Produto implements Serializable {
    private int id;
    private String nome;
    private double valor;
    private int quantidade;
    private double valorTotal;
    private String observacao;


    public Produto(int id, String nome, double valor, int quantidade, double valorTotal, String observacao) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }

    public Produto(String nome, double valor, int quantidade, double valorTotal, String observacao) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
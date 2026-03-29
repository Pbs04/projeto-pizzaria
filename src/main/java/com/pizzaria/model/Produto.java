package com.pizzaria.model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int idCategoria;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, double preco, int idCategoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

}

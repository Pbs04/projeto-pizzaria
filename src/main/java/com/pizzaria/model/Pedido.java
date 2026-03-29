package com.pizzaria.model;

public class Pedido {
    private int id;
    private int idUsuario;
    private int idProduto;
    private int quantidade;
    private String status; // CRIADO, EM_PREPARO, PRONTO, ENTREGUE

    public Pedido() {
    }

    public Pedido(int id, int idUsuario, int idProduto, int quantidade, String status) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public int getIdProduto() {
        return this.idProduto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public String getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

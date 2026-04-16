package com.pizzaria.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pedido extends Entidade {

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoItem> itens;

    public Pedido() {}

    public Pedido(Usuario usuario, String status) {
        this.usuario = usuario;
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getStatus() {
        return status;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }
}
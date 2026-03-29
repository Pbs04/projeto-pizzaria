package com.pizzaria.dao;

import java.sql.*;
import java.util.*;

import com.pizzaria.model.Pedido;

public class PedidoDAO implements GenericDAO<Pedido> {
    private Connection conexao = null;

    public PedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Pedido p) throws Exception {
        String sql = "INSERT INTO pedido (id_usuario, id_produto, quantidade, status) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p.getIdUsuario());
            stmt.setInt(2, p.getIdProduto());
            stmt.setInt(3, p.getQuantidade());
            stmt.setString(4, p.getStatus());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir pedido", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public List<Pedido> listar() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedido";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setIdUsuario(rs.getInt("id_usuario"));
                p.setIdProduto(rs.getInt("id_produto"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setStatus(rs.getString("status"));
                lista.add(p);
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao listar pedido", e);
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        }

        return lista;
    }

    public void atualizar(Pedido p) throws Exception {
        String sql = "UPDATE pedido SET id_usuario=?, id_produto=?, quantidade=?, status=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p.getIdUsuario());
            stmt.setInt(2, p.getIdProduto());
            stmt.setInt(3, p.getQuantidade());
            stmt.setString(4, p.getStatus());
            stmt.setInt(5, p.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar pedido", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM pedido WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar pedido", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

}

package com.pizzaria.dao;

import java.sql.*;
import java.util.*;

import com.pizzaria.model.Usuario;

public class UsuarioDAO implements GenericDAO<Usuario> {

    private Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Usuario u) throws Exception {
        String sql = "INSERT INTO usuario (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTipo());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir usuario", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public List<Usuario> listar() throws Exception {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setTipo(rs.getString("tipo"));
                lista.add(u);
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao listar usuario", e);
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        }

        return lista;
    }

    public void atualizar(Usuario u) throws Exception {
        String sql = "UPDATE usuario SET nome=?, email=?, senha=?, tipo=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTipo());
            stmt.setInt(5, u.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar usuario", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar usuario", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }
}
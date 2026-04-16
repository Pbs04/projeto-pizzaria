package com.pizzaria.dao;

import com.pizzaria.model.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria>
{
    public CategoriaDAO(){
        super(Categoria.class);
    }
}

/* 
public class CategoriaDAO implements GenericDAO<Categoria> {
    private Connection conexao = null;

    public CategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Categoria c) throws Exception {
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.execute();
            System.out.println("Categoria" + c.getNome() + "inserida com sucesso!");
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir categoria: ", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    @Override
    public List<Categoria> listar() throws Exception {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                categorias.add(c);
            }
            System.out.println("Categorias listadas com sucesso!");
        } catch (SQLException e) {
            throw new Exception("Erro ao listar categorias: ", e);
        } finally {
            if (stmt != null)
                stmt.close();
            if (rs != null)
                rs.close();
        }
        return categorias;
    }

    @Override
    public void atualizar(Categoria c) throws Exception {
        String sql = "UPDATE categoria SET nome = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getId());
            stmt.execute();
            System.out.println("Categoria" + c.getNome() + "atualizada com sucesso!");
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar categoria: ", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    @Override
    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM categoria WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Categoria com id: " + id + ". deletada com sucesso!");
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar categoria: ", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

}
*/
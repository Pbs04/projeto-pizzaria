package com.pizzaria.dao;

import com.pizzaria.model.Produto;

public class ProdutoDAO extends GenericDAO<Produto>{

    public ProdutoDAO(){
        super(Produto.class);
    }

}
/* 
public class ProdutoDAO implements GenericDAO<Produto> {

    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Produto p) throws Exception {
        String sql = "INSERT INTO produto (nome, descricao, preco, id_categoria) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getIdCategoria());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir produto", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public List<Produto> listar() throws Exception {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                lista.add(p);
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao listar produto", e);
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        }

        return lista;
    }

    public void atualizar(Produto p) throws Exception {
        String sql = "UPDATE produto SET nome=?, descricao=?, preco=?, id_categoria=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getIdCategoria());
            stmt.setInt(5, p.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar produto", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM produto WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar produto", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }
}
*/
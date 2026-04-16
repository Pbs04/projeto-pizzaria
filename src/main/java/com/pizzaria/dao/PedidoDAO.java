package com.pizzaria.dao;

import com.pizzaria.model.Pedido;

public class PedidoDAO extends GenericDAO<Pedido>{
    public PedidoDAO(){
        super(Pedido.class);
    }
}
/* 
public class PedidoDAO implements GenericDAO<Pedido> {
    private Connection conexao = null;

    public PedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Pedido p) throws Exception {
        String sql = "INSERT INTO Pedido (id_pedido, id_pedido, quantidade, status) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p.getIdPedido());
            stmt.setInt(2, p.getIdPedido());
            stmt.setInt(3, p.getQuantidade());
            stmt.setString(4, p.getStatus());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao inserir Pedido", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public List<Pedido> listar() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setIdPedido(rs.getInt("id_pedido"));
                p.setIdPedido(rs.getInt("id_pedido"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setStatus(rs.getString("status"));
                lista.add(p);
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao listar Pedido", e);
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        }

        return lista;
    }

    public void atualizar(Pedido p) throws Exception {
        String sql = "UPDATE Pedido SET id_pedido=?, id_pedido=?, quantidade=?, status=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p.getIdPedido());
            stmt.setInt(2, p.getIdPedido());
            stmt.setInt(3, p.getQuantidade());
            stmt.setString(4, p.getStatus());
            stmt.setInt(5, p.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar Pedido", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM Pedido WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar Pedido", e);
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }

}
*/
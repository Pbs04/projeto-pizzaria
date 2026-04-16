package com.pizzaria.controller.pedido;

import com.pizzaria.dao.PedidoDAO;
import com.pizzaria.dao.PedidoItemDAO;
import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.dao.UsuarioDAO;
import com.pizzaria.model.Pedido;
import com.pizzaria.model.PedidoItem;
import com.pizzaria.model.Produto;
import com.pizzaria.model.Usuario;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/pedido/inserir")
public class InserirPedidoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PedidoDAO pedidoDAO = new PedidoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();

            int usuarioId = Integer.parseInt(request.getParameter("id_usuario"));
            int produtoId = Integer.parseInt(request.getParameter("id_produto"));
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
            Produto produto = produtoDAO.buscarPorId(produtoId);

            Pedido pedido = new Pedido();
            pedido.setUsuario(usuario);
            pedido.setStatus(request.getParameter("status"));

            pedidoDAO.inserir(pedido);

            PedidoItem item = new PedidoItem();
            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            item.setPrecoUnitario(produto.getPreco());

            pedidoItemDAO.inserir(item);

            
            response.sendRedirect(request.getContextPath() + "/pedido");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
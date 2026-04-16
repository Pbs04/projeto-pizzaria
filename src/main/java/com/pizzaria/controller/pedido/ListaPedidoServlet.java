package com.pizzaria.controller.pedido;

import com.pizzaria.dao.PedidoDAO;
import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.dao.UsuarioDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/pedido")
public class ListaPedidoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PedidoDAO pedidoDAO = new PedidoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();

            request.setAttribute("pedidos", pedidoDAO.listarTodos());
            request.setAttribute("usuarios", usuarioDAO.listarTodos());
            request.setAttribute("produtos", produtoDAO.listarTodos());

            request.getRequestDispatcher("pedido.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
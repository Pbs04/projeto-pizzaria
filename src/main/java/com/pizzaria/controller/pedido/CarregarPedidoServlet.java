package com.pizzaria.controller.pedido;

import com.pizzaria.dao.PedidoDAO;
import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.dao.UsuarioDAO;
import com.pizzaria.model.Pedido;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/pedido/editar")
public class CarregarPedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PedidoDAO dao = new PedidoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            Pedido selecionado = dao.buscarPorId(id);

            request.setAttribute("pedido", selecionado);
            request.setAttribute("usuarios", usuarioDAO.listarTodos());
            request.setAttribute("produtos", new ProdutoDAO().listarTodos());

            request.getRequestDispatcher("/pedidoEditar.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
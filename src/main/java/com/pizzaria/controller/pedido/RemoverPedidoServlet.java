package com.pizzaria.controller.pedido;

import com.pizzaria.dao.PedidoDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/pedido/remover")
public class RemoverPedidoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PedidoDAO dao = new PedidoDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletar(id);

            response.sendRedirect(request.getContextPath() + "/pedido");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
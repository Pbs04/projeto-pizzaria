package com.pizzaria.controller.pedido;

import com.pizzaria.dao.PedidoDAO;
import com.pizzaria.model.Pedido;
import com.pizzaria.utils.Conexao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/pedido/editar")
public class CarregarPedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            PedidoDAO dao = new PedidoDAO(conn);

            int id = Integer.parseInt(request.getParameter("id"));

            Pedido selecionado = null;
            for (Pedido p : dao.listar()) {
                if (p.getId() == id) {
                    selecionado = p;
                    break;
                }
            }

            request.setAttribute("pedido", selecionado);

            conn.close();
            request.getRequestDispatcher("/pedidoEditar.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
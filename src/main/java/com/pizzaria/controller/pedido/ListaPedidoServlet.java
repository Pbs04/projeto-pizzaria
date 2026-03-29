package com.pizzaria.controller.pedido;

import com.pizzaria.dao.PedidoDAO;
import com.pizzaria.utils.Conexao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/pedido")
public class ListaPedidoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            PedidoDAO dao = new PedidoDAO(conn);

            request.setAttribute("pedidos", dao.listar());

            conn.close();
            request.getRequestDispatcher("pedido.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
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

@WebServlet("/pedido/inserir")
public class InserirPedidoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            PedidoDAO dao = new PedidoDAO(conn);

            Pedido p = new Pedido();
            p.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
            p.setIdProduto(Integer.parseInt(request.getParameter("id_produto")));
            p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            p.setStatus(request.getParameter("status"));

            dao.inserir(p);

            conn.close();
            response.sendRedirect("../pedido");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
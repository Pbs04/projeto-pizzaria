package com.pizzaria.controller.produto;

import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.utils.Conexao;

//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/produto/remover")
public class RemoverProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            ProdutoDAO dao = new ProdutoDAO(conn);

            int id = Integer.parseInt(request.getParameter("id"));

            dao.deletar(id);

            conn.close();

            response.sendRedirect("../produto");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
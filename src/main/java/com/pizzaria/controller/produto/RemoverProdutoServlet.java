package com.pizzaria.controller.produto;

import com.pizzaria.dao.ProdutoDAO;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/produto/remover")
public class RemoverProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ProdutoDAO dao = new ProdutoDAO();

            int id = Integer.parseInt(request.getParameter("id"));

            dao.deletar(id);

            response.sendRedirect(request.getContextPath() + "/produto");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
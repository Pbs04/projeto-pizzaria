package com.pizzaria.controller.produto;

import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.dao.CategoriaDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;

@WebServlet("/produto")
public class ListaProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            request.setAttribute("produtos", produtoDAO.listarTodos());
            request.setAttribute("categorias", categoriaDAO.listarTodos());

            request.getRequestDispatcher("produto.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
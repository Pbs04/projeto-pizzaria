package com.pizzaria.controller.produto;

import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.dao.CategoriaDAO;
import com.pizzaria.model.Produto;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/produto/editar")
public class CarregarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            int id = Integer.parseInt(request.getParameter("id"));

            Produto produto = produtoDAO.buscarPorId(id);

            request.setAttribute("produto", produto);
            request.setAttribute("categorias", categoriaDAO.listarTodos());

            request.getRequestDispatcher("/produtoEditar.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
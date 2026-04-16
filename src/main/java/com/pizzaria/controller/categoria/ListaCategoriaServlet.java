package com.pizzaria.controller.categoria;

import com.pizzaria.dao.CategoriaDAO;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/categoria")
public class ListaCategoriaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CategoriaDAO dao = new CategoriaDAO();

            request.setAttribute("categorias", dao.listarTodos());

            request.getRequestDispatcher("categoria.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
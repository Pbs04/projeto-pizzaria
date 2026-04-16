package com.pizzaria.controller.categoria;

import com.pizzaria.dao.CategoriaDAO;
import com.pizzaria.model.Categoria;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/categoria/inserir")
public class InserirCategoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CategoriaDAO dao = new CategoriaDAO();

            Categoria c = new Categoria();
            c.setNome(request.getParameter("nome"));

            dao.inserir(c);

            response.sendRedirect(request.getContextPath() + "/categoria");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
package com.pizzaria.controller.categoria;

import com.pizzaria.dao.CategoriaDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/categoria/remover")
public class RemoverCategoriaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CategoriaDAO dao = new CategoriaDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletar(id);
            response.sendRedirect(request.getContextPath() + "/categoria");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
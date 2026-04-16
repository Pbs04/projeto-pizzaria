package com.pizzaria.controller.categoria;

import com.pizzaria.dao.CategoriaDAO;
import com.pizzaria.model.Categoria;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
//import java.util.List;

@WebServlet("/categoria/editar")
public class CarregarCategoriaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CategoriaDAO dao = new CategoriaDAO();

            int id = Integer.parseInt(request.getParameter("id"));

            Categoria selecionada = null;

            for (Categoria c : dao.listarTodos()) {
                if (c.getId() == id) {
                    selecionada = c;
                    break;
                }
            }

            request.setAttribute("categoria", selecionada);

            request.getRequestDispatcher("/categoriaEditar.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
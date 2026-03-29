package com.pizzaria.controller.categoria;

import com.pizzaria.dao.CategoriaDAO;
import com.pizzaria.model.Categoria;
import com.pizzaria.utils.Conexao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/categoria/editar")
public class CarregarCategoriaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            CategoriaDAO dao = new CategoriaDAO(conn);

            int id = Integer.parseInt(request.getParameter("id"));

            Categoria selecionada = null;

            for (Categoria c : dao.listar()) {
                if (c.getId() == id) {
                    selecionada = c;
                    break;
                }
            }

            request.setAttribute("categoria", selecionada);

            conn.close();

            request.getRequestDispatcher("/categoriaEditar.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
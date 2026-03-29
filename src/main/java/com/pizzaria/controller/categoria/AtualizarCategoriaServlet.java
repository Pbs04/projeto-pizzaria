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

@WebServlet("/categoria/atualizar")
public class AtualizarCategoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            CategoriaDAO dao = new CategoriaDAO(conn);

            Categoria c = new Categoria();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setNome(request.getParameter("nome"));

            dao.atualizar(c);

            conn.close();

            response.sendRedirect("../categoria");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
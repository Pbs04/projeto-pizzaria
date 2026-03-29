package com.pizzaria.controller.categoria;

import com.pizzaria.dao.CategoriaDAO;
import com.pizzaria.utils.Conexao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/categoria/remover")
public class RemoverCategoriaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            CategoriaDAO dao = new CategoriaDAO(conn);
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletar(id);
            conn.close();
            response.sendRedirect("../categoria");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
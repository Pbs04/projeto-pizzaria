package com.pizzaria.controller.usuario;

import com.pizzaria.dao.UsuarioDAO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/usuario")

public class ListaUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UsuarioDAO dao = new UsuarioDAO();

            request.setAttribute("usuarios", dao.listarTodos());

            
            request.getRequestDispatcher("usuario.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
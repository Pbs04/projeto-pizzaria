package com.pizzaria.controller.usuario;

import com.pizzaria.dao.UsuarioDAO;
//import com.pizzaria.model.Usuario;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/usuario/remover")
public class RemoverUsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UsuarioDAO dao = new UsuarioDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletar(id);

            response.sendRedirect(request.getContextPath() + "/usuario");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
package com.pizzaria.controller.usuario;

import com.pizzaria.dao.UsuarioDAO;
import com.pizzaria.model.Usuario;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/usuario/inserir")
public class InserirUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UsuarioDAO dao = new UsuarioDAO();

            Usuario u = new Usuario();
            u.setNome(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));
            u.setSenha(request.getParameter("senha"));
            u.setTipo(request.getParameter("tipo"));

            dao.inserir(u);

            response.sendRedirect(request.getContextPath() + "/usuario");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

package com.pizzaria.controller.usuario;

import com.pizzaria.dao.UsuarioDAO;
import com.pizzaria.model.Usuario;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;

@WebServlet("/usuario/atualizar")
public class AtualizarUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UsuarioDAO dao = new UsuarioDAO();

            Usuario u = new Usuario();
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setNome(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));
            u.setSenha(request.getParameter("senha"));
            u.setTipo(request.getParameter("tipo"));

            dao.atualizar(u);

            response.sendRedirect(request.getContextPath() + "/usuario");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

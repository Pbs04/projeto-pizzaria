package com.pizzaria.controller.usuario;

import com.pizzaria.dao.UsuarioDAO;
import com.pizzaria.model.Usuario;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;

@WebServlet("/usuario/editar")
public class CarregarUsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UsuarioDAO dao = new UsuarioDAO();

            int id = Integer.parseInt(request.getParameter("id"));

            Usuario selecionado = null;
            for (Usuario u : dao.listarTodos()) {
                if (u.getId() == id) {
                    selecionado = u;
                    break;
                }
            }

            request.setAttribute("usuario", selecionado);

            request.getRequestDispatcher("/usuarioEditar.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

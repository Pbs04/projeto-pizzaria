package com.pizzaria.controller.usuario;

import com.pizzaria.dao.UsuarioDAO;
import com.pizzaria.model.Usuario;
import com.pizzaria.utils.Conexao;

//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/usuario/atualizar")
public class AtualizarUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);

            Usuario u = new Usuario();
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setNome(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));
            u.setSenha(request.getParameter("senha"));
            u.setTipo(request.getParameter("tipo"));

            dao.atualizar(u);

            conn.close();
            response.sendRedirect("../usuario");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

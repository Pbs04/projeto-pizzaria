package com.pizzaria.controller.usuario;

import com.pizzaria.dao.UsuarioDAO;
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

@WebServlet("/usuario")
public class ListaUsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);

            request.setAttribute("usuarios", dao.listar());

            conn.close();
            request.getRequestDispatcher("usuario.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
package com.pizzaria.controller.produto;

import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.model.Produto;
import com.pizzaria.utils.Conexao;

//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/produto/editar")
public class CarregarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            ProdutoDAO dao = new ProdutoDAO(conn);

            int id = Integer.parseInt(request.getParameter("id"));

            Produto selecionado = null;
            List<Produto> lista = dao.listar();

            for (Produto p : lista) {
                if (p.getId() == id) {
                    selecionado = p;
                    break;
                }
            }

            request.setAttribute("produto", selecionado);

            conn.close();

            request.getRequestDispatcher("/produtoEditar.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
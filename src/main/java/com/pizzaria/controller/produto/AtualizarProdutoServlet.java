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

@WebServlet("/produto/atualizar")
public class AtualizarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = Conexao.getConnection();
            ProdutoDAO dao = new ProdutoDAO(conn);

            Produto p = new Produto();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao"));
            p.setPreco(Double.parseDouble(request.getParameter("preco")));
            p.setIdCategoria(Integer.parseInt(request.getParameter("id_categoria")));

            dao.atualizar(p);

            conn.close();

            response.sendRedirect("../produto");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
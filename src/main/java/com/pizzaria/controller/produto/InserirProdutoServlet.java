package com.pizzaria.controller.produto;

import com.pizzaria.dao.CategoriaDAO;
import com.pizzaria.dao.ProdutoDAO;
import com.pizzaria.model.Categoria;
import com.pizzaria.model.Produto;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/produto/inserir")
public class InserirProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ProdutoDAO dao = new ProdutoDAO();
            CategoriaDAO dao2 = new CategoriaDAO();

            Produto p = new Produto();
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao"));
            p.setPreco(Double.parseDouble(request.getParameter("preco")));
            int categoriaId = (Integer.parseInt(request.getParameter("id_categoria")));
            Categoria categoria = dao2.buscarPorId(categoriaId);
            p.setCategoria(categoria);

            dao.inserir(p);

            response.sendRedirect(request.getContextPath() + "/produto");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
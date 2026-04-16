<%@ page import="java.util.List" %>
<%@ page import="com.pizzaria.model.Produto" %>
<%@ page import="com.pizzaria.model.Categoria" %>

    <% Produto p=(Produto) request.getAttribute("produto"); %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Editar Produtos</title>
        </head>

        <body>
            <h1>Editar Produto</h1>

            <form action="<%= request.getContextPath() %>/produto/atualizar" method="post">

                <input type="hidden" name="id" value="<%= p.getId() %>">

                Nome: <input type="text" name="nome" value="<%= p.getNome() %>"><br>
                Descrição: <input type="text" name="descricao" value="<%= p.getDescricao() %>"><br>
                Preço: <input type="text" name="preco" value="<%= p.getPreco() %>"><br>

                Categoria:
                <select name="id_categoria" required>
                    <option value="">Selecione</option>
                    <%
                    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                    if (categorias != null) {
                        for (Categoria c : categorias) {
                    %>
                            <option value="<%= c.getId() %>" <%= p.getCategoria() != null && p.getCategoria().getId() == c.getId() ? "selected" : "" %>><%= c.getNome() %></option>
                    <%
                        }
                    }
                    %>
                </select><br>

                <button type="submit">Atualizar</button>
            </form>

            <br>

            <a href="<%= request.getContextPath() %>/produto">Voltar</a>
        </body>

        </html>
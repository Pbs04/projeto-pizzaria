<%@ page import="java.util.List" %>
    <%@ page import="com.pizzaria.model.Produto" %>
        <%@ page import="com.pizzaria.model.Categoria" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Produtos</title>
            </head>

            <body>
                <h1>Produtos</h1>

                <form action="produto/inserir" method="post">
                    Nome: <input type="text" name="nome" required><br>
                    Descricao: <input type="text" name="descricao"><br>
                    Preco: <input type="text" name="preco" required><br>
                    Categoria ID: <input type="number" name="id_categoria" required><br>

                    <button type="submit">Salvar</button>
                </form>

                <hr>

                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Descricao</th>
                        <th>Preco</th>
                        <th>Categoria</th>
                        <th>Editar</th>
                        <th>Remover</th>
                    </tr>

                    <% List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");

                            if (produtos != null) {
                            for (Produto p : produtos) {
                            %>
                            <tr>
                                <td>
                                    <%= p.getId() %>
                                </td>
                                <td>
                                    <%= p.getNome() %>
                                </td>
                                <td>
                                    <%= p.getDescricao() %>
                                </td>
                                <td>
                                    <%= p.getPreco() %>
                                </td>
                                <td>
                                    <%= p.getIdCategoria() %>
                                </td>

                                <td>
                                    <a href="produto/editar?id=<%= p.getId() %>">Editar</a>
                                </td>

                                <td>
                                    <a href="produto/remover?id=<%= p.getId() %>">Remover</a>
                                </td>
                            </tr>
                            <% } } %>

                </table>
                <a href="index.jsp">Voltar ao Menu</a>
            </body>

            </html>
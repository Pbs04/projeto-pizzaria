<%@ page import="com.pizzaria.model.Produto" %>

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

            <form action="atualizar" method="post">

                <input type="hidden" name="id" value="<%= p.getId() %>">

                Nome: <input type="text" name="nome" value="<%= p.getNome() %>"><br>
                Descrição: <input type="text" name="descricao" value="<%= p.getDescricao() %>"><br>
                Preço: <input type="text" name="preco" value="<%= p.getPreco() %>"><br>
                Categoria ID: <input type="number" name="id_categoria" value="<%= p.getIdCategoria() %>"><br>

                <button type="submit">Atualizar</button>
            </form>

            <br>

            <a href="../produto">Voltar</a>
        </body>

        </html>
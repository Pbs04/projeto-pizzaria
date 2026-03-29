<%@ page import="com.pizzaria.model.Categoria" %>
    <% Categoria c=(Categoria) request.getAttribute("categoria"); %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Editar Categoria</title>
        </head>

        <body>

            <h1>Editar Categoria</h1>

            <form action="atualizar" method="post">

                <input type="hidden" name="id" value="<%= c.getId() %>">

                Nome:
                <input type="text" name="nome" value="<%= c.getNome() %>" required>

                <button type="submit">Atualizar</button>
            </form>

            <br>

            <a href="../categoria">Voltar</a>

        </body>

        </html>
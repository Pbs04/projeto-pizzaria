<%@ page import="com.pizzaria.model.Pedido" %>
    <% Pedido p=(Pedido) request.getAttribute("pedido"); %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>

        <body>
            <h1>Editar Pedido</h1>

            <form action="atualizar" method="post">
                <input type="hidden" name="id" value="<%= p.getId() %>">

                Usuario ID: <input type="number" name="id_usuario" value="<%= p.getIdUsuario() %>"><br>
                Produto ID: <input type="number" name="id_produto" value="<%= p.getIdProduto() %>"><br>
                Quantidade: <input type="number" name="quantidade" value="<%= p.getQuantidade() %>"><br>

                Status:
                <select name="status">
                    <option value="CRIADO" <%=p.getStatus().equals("CRIADO") ? "selected" : "" %>>CRIADO</option>
                    <option value="EM_PREPARO" <%=p.getStatus().equals("EM_PREPARO") ? "selected" : "" %>>EM_PREPARO
                    </option>
                    <option value="PRONTO" <%=p.getStatus().equals("PRONTO") ? "selected" : "" %>>PRONTO</option>
                    <option value="ENTREGUE" <%=p.getStatus().equals("ENTREGUE") ? "selected" : "" %>>ENTREGUE</option>
                </select><br>

                <button type="submit">Atualizar</button>
            </form>

            <a href="../pedido">Voltar</a>
        </body>

        </html>
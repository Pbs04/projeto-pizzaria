<%@ page import="java.util.List" %>
<%@ page import="com.pizzaria.model.Pedido" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos</title>
</head>
<body>
    <h1>Pedidos</h1>

<form action="pedido/inserir" method="post">
    Usuario ID: <input type="number" name="id_usuario" required><br>
    Produto ID: <input type="number" name="nome_produto" required><br>
    Quantidade: <input type="number" name="quantidade" required><br>
    Status:
    <select name="status">
        <option value="CRIADO">CRIADO</option>
        <option value="EM_PREPARO">EM_PREPARO</option>
        <option value="PRONTO">PRONTO</option>
        <option value="ENTREGUE">ENTREGUE</option>
    </select><br>

    <button type="submit">Salvar</button>
</form>

<hr>

<table border="1">
<tr>
    <th>ID</th>
    <th>Usuario iD</th>
    <th>Produto ID</th>
    <th>Quantidade</th>
    <th>Status</th>
    <th>Editar</th>
    <th>Remover</th>
</tr>

<%
List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
if (pedidos != null) {
    for (Pedido p : pedidos) {
%>
<tr>
    <td><%= p.getId() %></td>
    <td><%= p.getIdUsuario() %></td>
    <td><%= p.getIdProduto() %></td>
    <td><%= p.getQuantidade() %></td>
    <td><%= p.getStatus() %></td>
    <td>
        <a href="pedido/editar?id=<%= p.getId() %>">Editar</a>
    </td>
    <td>
        <a href="pedido/remover?id=<%= p.getId() %>">Remover</a>
    </td>
</tr>
<%
    }
}
%>

</table>
<a href="index.jsp">Voltar ao Menu</a>
</body>
</html>
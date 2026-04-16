<%@ page import="java.util.List" %>
<%@ page import="com.pizzaria.model.Pedido" %>
<%@ page import="com.pizzaria.model.Usuario" %>
<%@ page import="com.pizzaria.model.Produto" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pedidos</title>
</head>
<body>

<h1>Pedidos</h1>

<form action="<%= request.getContextPath() %>/pedido/inserir" method="post">
    Usuario:
    <select name="id_usuario" required>
        <option value="">Selecione</option>
        <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        if (usuarios != null) {
            for (Usuario u : usuarios) {
        %>
                <option value="<%= u.getId() %>"><%= u.getNome() %></option>
        <%
            }
        }
        %>
    </select><br>

    Produto:
    <select name="id_produto" required>
        <option value="">Selecione</option>
        <%
        List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
        if (produtos != null) {
            for (Produto prod : produtos) {
        %>
                <option value="<%= prod.getId() %>"><%= prod.getNome() %></option>
        <%
            }
        }
        %>
    </select><br>

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
    <th>Usuario</th>
    <th>Produto</th>
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
    <td><%= p.getUsuario() != null ? p.getUsuario().getNome() : "" %></td>
    <td><%= p.getItens() != null && !p.getItens().isEmpty() && p.getItens().get(0).getProduto() != null ? p.getItens().get(0).getProduto().getNome() : "" %></td>
    <td><%= p.getItens() != null && !p.getItens().isEmpty() ? p.getItens().get(0).getQuantidade() : "" %></td>
    <td><%= p.getStatus() %></td>
    <td>
        <a href="<%= request.getContextPath() %>/pedido/editar?id=<%= p.getId() %>">Editar</a>
    </td>
    <td>
        <a href="<%= request.getContextPath() %>/pedido/remover?id=<%= p.getId() %>">Remover</a>
    </td>
</tr>
<%
    }
}
%>

</table>

<a href="index.jsp">Voltar</a>

</body>
</html>
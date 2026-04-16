<%@ page import="java.util.List" %>
<%@ page import="com.pizzaria.model.Pedido" %>
<%@ page import="com.pizzaria.model.Usuario" %>
<%@ page import="com.pizzaria.model.Produto" %>
<% Pedido p = (Pedido) request.getAttribute("pedido"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Pedido</title>
</head>
<body>

<h1>Editar Pedido</h1>

<form action="<%= request.getContextPath() %>/pedido/atualizar" method="post">
    <input type="hidden" name="id" value="<%= p.getId() %>">

    Usuario:
    <select name="id_usuario" required>
        <option value="">Selecione</option>
        <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        if (usuarios != null) {
            for (Usuario u : usuarios) {
        %>
                <option value="<%= u.getId() %>" <%= p.getUsuario() != null && p.getUsuario().getId() == u.getId() ? "selected" : "" %>><%= u.getNome() %></option>
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
        Integer selectedProdutoId = null;
        if (p.getItens() != null && !p.getItens().isEmpty() && p.getItens().get(0).getProduto() != null) {
            selectedProdutoId = p.getItens().get(0).getProduto().getId();
        }
        if (produtos != null) {
            for (Produto prod : produtos) {
        %>
                <option value="<%= prod.getId() %>" <%= selectedProdutoId != null && selectedProdutoId.equals(prod.getId()) ? "selected" : "" %>><%= prod.getNome() %></option>
        <%
            }
        }
        %>
    </select><br>

    Quantidade: <input type="number" name="quantidade" value="<%= p.getItens() != null && !p.getItens().isEmpty() ? p.getItens().get(0).getQuantidade() : 1 %>" required><br>

    Status:
    <select name="status">
        <option value="CRIADO" <%= p.getStatus().equals("CRIADO") ? "selected" : "" %>>CRIADO</option>
        <option value="EM_PREPARO" <%= p.getStatus().equals("EM_PREPARO") ? "selected" : "" %>>EM_PREPARO</option>
        <option value="PRONTO" <%= p.getStatus().equals("PRONTO") ? "selected" : "" %>>PRONTO</option>
        <option value="ENTREGUE" <%= p.getStatus().equals("ENTREGUE") ? "selected" : "" %>>ENTREGUE</option>
    </select><br>

    <button type="submit">Atualizar</button>
</form>

<a href="<%= request.getContextPath() %>/pedido">Voltar</a>

</body>
</html>
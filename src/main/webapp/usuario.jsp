<%@ page import="java.util.List" %>
    <%@ page import="com.pizzaria.model.Usuario" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title> Usuarios </title>
        </head>

        <body>
            <h1>Usuarios</h1>

            <form action="<%= request.getContextPath() %>/usuario/inserir" method="post">
                Nome: <input type="text" name="nome"><br>
                Email: <input type="text" name="email"><br>
                Senha: <input type="text" name="senha"><br>
                Tipo:
                <select name="tipo">
                    <option value="cliente">Cliente</option>
                    <option value="funcionario">Funcionario</option>
                    <option value="administrador">Administrador</option>
                </select><br>

                <button type="submit">Salvar</button>
            </form>

            <hr>

            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Tipo</th>
                    <th>Editar</th>
                    <th>Remover</th>
                </tr>

                <%
                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");

                if (usuarios != null) {
                    for (Usuario u : usuarios) {
                %>
                        <tr>
                            <td>
                                <%= u.getId() %>
                            </td>
                            <td>
                                <%= u.getNome() %>
                            </td>
                            <td>
                                <%= u.getEmail() %>
                            </td>
                            <td>
                                <%= u.getTipo() %>
                            </td>
                            <td>
                                <a href="<%= request.getContextPath() %>/usuario/editar?id=<%= u.getId() %>">Editar</a>
                            </td>
                            <td>
                                <a href="<%= request.getContextPath() %>/usuario/remover?id=<%= u.getId() %>">Remover</a>
                            </td>
                        </tr>
                        <% } } %>
            </table>
            <a href="index.jsp">Voltar ao Menu</a>
        </body>

        </html>
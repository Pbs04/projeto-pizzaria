<%@ page import="com.pizzaria.model.Usuario" %>
    <% Usuario u=(Usuario) request.getAttribute("usuario"); %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title> Editar Usuarios </title>
        </head>

        <body>
            <h1>Editar Usuario</h1>

            <form action="atualizar" method="post">
                <input type="hidden" name="id" value="<%= u.getId() %>">

                Nome: <input type="text" name="nome" value="<%= u.getNome() %>"><br>
                Email: <input type="text" name="email" value="<%= u.getEmail() %>"><br>
                Senha: <input type="text" name="senha" value="<%= u.getSenha() %>"><br>

                Tipo:
                <select name="tipo">
                    <option value="cliente" <%=u.getTipo().equals("cliente") ? "selected" : "" %>>Cliente</option>
                    <option value="funcionario" <%=u.getTipo().equals("funcionario") ? "selected" : "" %>>Funcionario
                    </option>
                    <option value="administrador" <%=u.getTipo().equals("administrador") ? "selected" : "" %>
                        >Administrador</option>
                </select><br>

                <button type="submit">Atualizar</button>
            </form>
        </body>

        </html>
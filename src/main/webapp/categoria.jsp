<%@ page import="java.util.List" %>
    <%@ page import="com.pizzaria.model.Categoria" %>


        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Categorias</title>
        </head>

        <body>
            <h1> Gerenciar Categorias </h1>

            <h2> Adicionar Categoria </h2>
            <form action="categoria/inserir" method="post">
                Nome:
                <input type="text" name="nome" required>
                <button type="submit"> Salvar</button>
            </form>

            <hr>

            <h2> Lista de Categorias </h2>

            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Editar</th>
                    <th>Remover</th>
                </tr>

                <% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                        if(categorias != null){
                        for(Categoria c : categorias){

                        %>

                        <tr>
                            <td>
                                <%= c.getId() %>
                            </td>
                            <td>
                                <%= c.getNome() %>
                            </td>

                            <td>
                                <a href="categoria/editar?id=<%= c.getId() %>">Editar</a>
                            </td>

                            <td>
                                <a href="categoria/remover?id=<%= c.getId() %>">Remover</a>
                            </td>
                        </tr>
                        <% } } %>
            </table>
            <a href="index.jsp">Voltar ao Menu</a>
        </body>

        </html>
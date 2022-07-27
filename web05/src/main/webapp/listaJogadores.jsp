<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, net.maromo.web05.dao.*, net.maromo.web05.model.Jogador"
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Lista de Jogadores</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, td, th {
            border: 1px solid black
        }
    </style>
</head>
<body>
<h2>Jogadores</h2>
<table>
    <tr>
        <td>Nome do Jogador</td>
        <td>Apelido</td>
        <td>Posição</td>
        <td>Idade</td>
    </tr>
    <tr>
        <%
            JogadorDao dao = new JogadorDao();
            List<Jogador> lista = dao.listarJogadores();
            for (Jogador j : lista) {
        %>
        <td><%=j.getNome()%>
        </td>
        <td><%=j.getApelido()%>
        </td>
        <td><%=j.getPosicao()%>
        </td>
        <td><%=j.getIdade()%>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>

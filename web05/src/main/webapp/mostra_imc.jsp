<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html lang="pt-br">
<head>
    <title>Resultado</title>
</head>
<body>
    <p>Com base no seu peso: ${param.peso} seu imc calculado foi:</p>
    <%
        double peso = Double.parseDouble(request.getParameter("peso"));
        double altura = Double.parseDouble(request.getParameter("altura"));
        double imc = peso / (altura * altura);
    %>
    <p>Valor do imc calculado: <%=imc%></p>
</body>
</html>

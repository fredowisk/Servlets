<%-- 
    Document   : bemvindo
    Created on : Oct 5, 2019, 5:36:08 PM
    Author     : fredaum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body><center>
        <%-- comentário em JSP aqui: nossa primeira página --%>

        <%
            String mensagem = "Bem vindo ao sistema de agenda do FJ-21";
        %>

        <% out.println(mensagem); %>

        <br />

        <%
            String desenvolvido = "Desenvolvido por (<b>FRED</b>)";
        %>

        <%= desenvolvido%>

        <br />

        <%
            System.out.println("Tudo foi executado!");
        %>
    </center>
    </body>
</html>

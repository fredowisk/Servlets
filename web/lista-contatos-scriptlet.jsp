<%-- 
    Document   : lista-contatos-scriptlet
    Created on : Oct 7, 2019, 2:34:40 PM
    Author     : fredaum
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.caelum.Contato"%>
<%@page import="br.com.caelum.ContatoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <table>
            <% ContatoDAO dao = new ContatoDAO();
            List<Contato> contatos = dao.getLista();
            
            for (Contato contato : contatos) {
                %>
                <tr>
                    <td><%=contato.getNome() %></td>
                    <td><%=contato.getEmail() %></td>
                    <td><%=contato.getEndereco() %></td>
                    <td><%=contato.getDataNascimento().getTime() %></td>
                </tr>
                <%
                    }
                %>
        </table>
    </body>
</html>

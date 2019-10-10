<%-- 
    Document   : lista-contatos
    Created on : Oct 7, 2019, 5:25:07 PM
    Author     : fredaum
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/arquivo.js"></script>
        <link href="css/meuArquivo.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <jsp:useBean id="dao" class="br.com.caelum.ContatoDAO"/>

        <table>
            <!-- percorre contatos montando as linhas da tabela -->
            <c:forEach var="contato" items="${dao.lista}">
                <tr>
                    <td>${contato.nome}</td>
                    <td>
                        <c:choose>
                        <c:when test="${not empty contato.email}">
                            <a href="mailto:${contato.email}"> ${contato.email}</a>
                        </c:when>

                            <c:otherwise>
                            <b>E-mail não informado</b>
                        </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${contato.endereco}</td>
                    <td><fmt:formatDate value="${contato.dataNascimento.time}"
                                    pattern="dd/MM/yyyy" />
                        <f:campoData id="dataNascimento" /></td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="rodape.jsp" />
    </body>
</html>

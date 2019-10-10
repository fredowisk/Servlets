<%-- 
    Document   : cabecalho
    Created on : Oct 8, 2019, 5:36:54 PM
    Author     : fredaum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <%--<c:url value="imagens/caelum-ensino-inovacao.png" var ="imagem" />--%>
        <!--<img src="${imagem}" />-->
        <!--<img src="imagens/caelum-ensino-inovacao.png" />-->

<img src="<c:url value="/imagens/caelum-ensino-inovacao.png"/>"/>

        <h2>Agenda de Contatos do <b>Fred</b></h2>
        <hr />
    </body>
</html>

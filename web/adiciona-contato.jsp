<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" tagdir="/WEB-INF/tags" %>
<html>
    <head>
        <link href="css/jquery.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <form action="adicionaContato">
            Nome: <input type="text" name ="nome"/> <br />
            E-mail: <input type="text" name ="email" /><br />
            Endereço: <input type="text" name ="endereco" /><br />
            Data Nascimento: <f:campoData id="dataNascimento" /> <br />
            
            <input type="submit" value="Gravar" />
        </form>
        <c:import url="rodape.jsp" />
    </body>
</html>

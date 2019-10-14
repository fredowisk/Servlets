<%-- 
    Document   : campoData
    Created on : Oct 9, 2019, 8:18:19 PM
    Author     : fredaum
--%>

<%@tag description="tag campo de data" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id" required="true" %>
<input id="${id}" name="${id}" type="text">
<script>
    $("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>
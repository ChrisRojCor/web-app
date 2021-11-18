<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="co.edu.unbosque.tiendagenerica.Clientes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado CLientes</title>
</head>
<body>
<p align="center">LISTADO DE CLIENTES</p>
<p align="center">Hora de servidor es <%=new Date()%></p>
<table align="center">
    <tr>
        <td align="center"><label>Cédula</label></td>
        <td align="center"><label>Nombre</label></td>
        <td align="center"><label>Correo</label></td>
        <td align="center"><label>Teléfono</label></td>
        <td align="center"><label>Dirección</label></td>
    </tr>
        <%
		ArrayList<Clientes> lista = (ArrayList<Clientes>) request.getAttribute("lista");
		for (Clientes cliente : lista){
		%>
    <tr>
        <td><%=cliente.getCedula_cliente() %></td>
        <td><%=cliente.getNombre_cliente() %></td>
        <td><%=cliente.getEmail_cliente() %></td>
        <td><%=cliente.getTelefono_cliente() %></td>
        <td><%=cliente.getDireccion_cliente() %></td>
    </tr>
        <%
		}
		%>
</body>
</html>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="co.edu.unbosque.tiendagenerica.Proveedores" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado Proveedores</title>
</head>
<body>
<p>LISTADO DE PROVEEDORES</p>
<p>Hora de servidor es <%=new Date()%></p>
<table>
    <tr>
        <td><label>NIT</label>
        <td><label>Nombre</label>
        <td><label>Correo</label>
        <td><label>Teléfono</label>
        <td><label>Ciudad</label>
    </tr>
        <%
		ArrayList<Proveedores> lista = (ArrayList<Proveedores>) request.getAttribute("lista");
		for (Proveedores proveedor : lista){
		%>
    <tr>
        <td><%=proveedor.getNit() %></td>
        <td><%=proveedor.getNombre_proveedor() %></td>
        <td><%=proveedor.getEmail_proveedor() %></td>
        <td><%=proveedor.getTelefono_proveedor() %></td>
        <td><%=proveedor.getCiudad_proveedor() %></td>
    </tr>
        <%
		}
		%>
</body>
</html>

<%@ page import="java.util.Date" %>
<%@ page import="co.edu.unbosque.tiendagenerica.Usuarios" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado Usuarios</title>
</head>
<body>
      <p align="center">LISTADO DE USUARIOS</p>
      <p align="center">Hora de servidor es <%=new Date()%></p>
      <table align="center">
        <tr>
            <td align="center"><label>Cédula</label></td>
            <td align="center"><label>Nombre</label></td>
            <td align="center"><label>Correo</label></td>
            <td align="center"><label>Usuario</label></td>
            <td align="center"><label>Contraseña</label></td>
        </tr>
          <%
		ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
		for (Usuarios usuario : lista){
		%>
        <tr>
          <td><%=usuario.getCedula_usuario() %></td>
          <td><%=usuario.getNombre_usuario() %></td>
          <td><%=usuario.getEmail_usuario() %></td>
          <td><%=usuario.getUsuario() %></td>
          <td><%=usuario.getPassword() %></td>
        </tr>
          <%
		}
		%>
</body>
</html>
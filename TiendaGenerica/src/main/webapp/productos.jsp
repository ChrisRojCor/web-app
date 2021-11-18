<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productos</title>
</head>
<body>
<p>Tienda Generica</p>
<p><a href="usuarios.jsp">Usuarios</a>
    <a href="clientes.jsp">Clientes</a>
    <a href="proveedores.jsp">Proveedores</a>
    <a href="productos.jsp">Productos</a>
    <a href="ventas.jsp">Ventas</a>
    <a href="reportes.jsp">Reportes</a>
</p>
<p>
<h2 ALIGN="center">MODULO DE PRODUCTOS</h2>
</p>

<form align="center" action="./ProcesarArchivoServlet" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>
</body>
</html>

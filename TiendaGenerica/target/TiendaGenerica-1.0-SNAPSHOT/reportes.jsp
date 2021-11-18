<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reportes</title>
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
    <h2 ALIGN="center">MODULO DE REPORTES</h2>
    </p>
    <p>
    <form method="post" action="./ReportesServlet">
        <table align="center">
            <tr>
                <td align="center"><button type="submit" name="boton1" value="botonListadoUsuarios" >Listado de Usuarios</button></td>
            </tr>
            <tr>
                <td align="center"><button type="submit" name="boton2" value="botonListadoClientes">Listado de Clientes</button></td>
            </tr>
            <tr>
                <td align="center"><button type="submit" name="boton3" value="botonVentasCliente">Ventas por Cliente</button></td>
            </tr>
        </table>
    </form>
   </p>

</body>
</html>

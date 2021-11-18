<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
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
    <h2 ALIGN="center">MODULO DE USUARIOS</h2>
    </p>

    <form method="get" action="./UsuariosServlet">
        <table align="center">
            <tr>
                <td><label>Cédula</label></td>
                <td><input type="text" name="cedula"></td>
                <td><label>Nombre Completo</label></td>
                <td><input type="text" name="nombre"></td>
                <td><label>Correo Electrónico</label></td>
                <td><input type="text" name="correo"></td>
            </tr>
            <tr>
                <td><label>Usuario:</label></td>
                <td><input type="text" name="usuario"></td>
                <td><label>Contraseña:</label></td>
                <td><input type="text" name="contraseña"></td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><button type="submit" name="boton1" value="botonConsultar">Consultar</button></td>
                <td align="center"><button type="submit" name="boton2" value="botonCrear">Crear</button></td>
                <td align="center"><button type="submit" name="boton3" value="botonActualizar">Actualizar</button></td>
                <td align="center"><button type="submit" name="boton4" value="botonEliminar">Eliminar</button></td>
            </tr>
        </table>
    </form>
</body>
</html>
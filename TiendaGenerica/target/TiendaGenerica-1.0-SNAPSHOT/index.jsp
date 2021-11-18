<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p align="center">LOGIN DEL SISTEMA</p>
<form method="get" action="./LoginServlet">
    <table align="center">
        <tr>
            <td><label>Usuario:</label></td>
            <td><input type="text" name="usuario"></td>
        </tr>
        <tr>
            <td><label>Contraseña:</label></td>
            <td><input type="text" name="contraseña"></td>
        </tr>
        <tr>
            <td></td>
            <td align="center"><input type="submit" value="Aceptar"></td>
        </tr>
    </table>
</form>

</body>
</html>

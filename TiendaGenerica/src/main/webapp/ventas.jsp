<%@ page import="co.edu.unbosque.tiendagenerica.VentasServlet" %>
<%@ page import="java.util.NoSuchElementException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ventas</title>
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
        <h2 ALIGN="center">MODULO DE VENTAS</h2>
    </p>
    <p>
    <form method="post" action="">
        <table align="center">
            <%
                VentasServlet ventasServlet = new VentasServlet();
                String cedula = "";
                String nombre = "";
                String codigo_producto1 = "";
                String nombreProducto1 = "";
                int cantidad_producto1 = 1;
                double valor_producto1 = 0.0;
                double total_producto1 = 0.0;
                double iva = 0.19;
                String codigo_producto2 = "";
                String nombreProducto2 = "";
                int cantidad_producto2 = 1;
                double valor_producto2 = 0.0;
                double total_producto2 = 0.0;
                String codigo_producto3 = "";
                String nombreProducto3 = "";
                int cantidad_producto3 = 1;
                double valor_producto3 = 0.0;
                double total_producto3 = 0.0;

                double total_venta = 0.0;
                double total_iva = 0.0;
                double total_con_iva = 0.0;

                if(request.getParameter("boton6") != null){
                    try {
                        cedula = request.getParameter("cedula");
                        nombre = ventasServlet.buscarCliente(cedula);

                        codigo_producto1 = request.getParameter("codigoProducto1");
                        nombreProducto1 = ventasServlet.buscarProducto(codigo_producto1).getNombre_producto();
                        cantidad_producto1 = Integer.parseInt(request.getParameter("cantidadProducto1"));
                        valor_producto1 = Double.parseDouble(ventasServlet.buscarProducto(codigo_producto1).getPrecio_venta());

                        codigo_producto2 = request.getParameter("codigoProducto2");
                        nombreProducto2 = ventasServlet.buscarProducto(codigo_producto2).getNombre_producto();
                        cantidad_producto2 = Integer.parseInt(request.getParameter("cantidadProducto2"));
                        valor_producto2 = Double.parseDouble(ventasServlet.buscarProducto(codigo_producto2).getPrecio_venta());

                        codigo_producto3 = request.getParameter("codigoProducto3");
                        nombreProducto3 = ventasServlet.buscarProducto(codigo_producto3).getNombre_producto();
                        cantidad_producto3 = Integer.parseInt(request.getParameter("cantidadProducto3"));
                        valor_producto3 = Double.parseDouble(ventasServlet.buscarProducto(codigo_producto3).getPrecio_venta());

                    } catch (NumberFormatException | NoSuchElementException e) {
                        e.printStackTrace();
                    }
                    total_producto1 = valor_producto1 * cantidad_producto1;
                    total_producto2 = valor_producto2 * cantidad_producto2;
                    total_producto3 = valor_producto3 * cantidad_producto3;
                    total_venta = total_producto1 + total_producto2 + total_producto3;
                    total_iva = total_venta * iva;
                    total_con_iva = total_venta + total_iva;

                }
            %>
        </table>
    </form>
    </p>
    <p>
        <form method="post" action="">
        <table align="center">
            <tr>
                <td></td>
                <td></td>
                <td><label>Consecutivo</label></td>
                <td><input type="text" name="consecutivo" disabled></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><label>Cédula</label></td>
                <td><input type="text" name="cedula" value="<%=cedula%>"></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><label>Cliente</label></td>
                <td><input type="text" name="nombre" value="<%=nombre%>" disabled></td>
            </tr>
            <tr>
                <td align="center"><label align="center">Cod. Producto</label></td>
                <td align="center"><label>Nombre Producto</label></td>
                <td align="center"><label>Cant.</label></td>
                <td align="center"><label >Vlr. Total</label></td>
            </tr>
            <tr>
                <td><input type="text" name="codigoProducto1" value="<%=codigo_producto1%>"></td>
                <td><input type="text" name="nombreProducto1" value="<%=nombreProducto1%>" disabled></td>
                <td align="center"><input type="text" name="cantidadProducto1" value="<%=cantidad_producto1%>" size="2"></td>
                <td><input type="text" name="valorProducto1"  value="<%=total_producto1%>" disabled></td>
            </tr>
            <tr>
                <td><input type="text" name="codigoProducto2" value="<%=codigo_producto2%>"></td>
                <td><input type="text" name="nombreProducto2" value="<%=nombreProducto2%>" disabled></td>
                <td align="center"><input type="text" name="cantidadProducto2" value="<%=cantidad_producto2%>" size="2"></td>
                <td><input type="text" name="valorProducto2" value="<%=total_producto2%>" disabled></td>
            </tr>
            <tr>
                <td><input type="text" name="codigoProducto3" value="<%=codigo_producto3%>"></td>
                <td><input type="text" name="nombreProducto3" value="<%=nombreProducto3%>" disabled></td>
                <td align="center"><input type="text" name="cantidadProducto3" value="<%=cantidad_producto3%>" size="2"></td>
                <td><input type="text" name="valorProducto3" value="<%=total_producto3%>" disabled></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><label>Total Venta</label></td>
                <td><input type="text" name="totalVenta" value="<%=total_venta%>" disabled></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><label>Total IVA</label></td>
                <td><input type="text" name="totalIva" value="<%=total_iva%>" disabled></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><label>Total con IVA</label></td>
                <td><input type="text" name="totalConIva" value="<%=total_con_iva%>" disabled></td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><button type="submit" name="boton5" value="botonConfirmar">Confirmar</button></td>
                <td align="center"><button type="submit" name="boton6" value="botonConsultar">Consultar</button></td>
            </tr>
        </table>
    </form>
</body>
</html>

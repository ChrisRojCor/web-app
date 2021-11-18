package co.edu.unbosque.tiendagenerica;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

@WebServlet(name = "VentasServlet", value = "/VentasServlet")
public class VentasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Served at: Ventas ").append(request.getContextPath());
        String codigo_producto = request.getParameter("codigoProducto1");
        PrintWriter writer = response.getWriter();

        if(request.getParameter("boton2") != null){
            writer.println(" entra al if");
            String nombre = buscarProducto(codigo_producto).getNombre_producto();

            writer.println(nombre);
        }
    }


    public String buscarCliente(String cedula){
        String nombre = "";
        Clientes cliente;
        try{
            ArrayList<Clientes> clientes = ClientesJSON.getJSON();
            String finalCedula = cedula;
            cliente =  clientes.stream().filter(dbCliente -> dbCliente.getCedula_cliente().equals(finalCedula)).findFirst().get();
            nombre = cliente.getNombre_cliente();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    public Productos buscarProducto(String codigo_producto){
           Productos producto = new Productos();
        try{
            ArrayList<Productos> productos = ProductosJSON.getJSON();
            producto = productos.stream().filter(dbProductos -> dbProductos.getCodigo_producto().equals(codigo_producto)).findFirst().get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return producto;
    }
}

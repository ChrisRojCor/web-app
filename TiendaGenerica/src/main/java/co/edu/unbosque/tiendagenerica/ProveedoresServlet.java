package co.edu.unbosque.tiendagenerica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProveedoresServlet", value = "/ProveedoresServlet")
public class ProveedoresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter writer = response.getWriter();

        if(request.getParameter("boton1") != null){
            listarProveedores(request, response);
        }
        if(request.getParameter("boton2") != null){
            agregarProveedor(request, response);
        }
        if (request.getParameter("boton3") != null){
            actualizarProveedor(request, response);
        }
        if (request.getParameter("boton4") != null){
            eliminarProveedor(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void agregarProveedor(HttpServletRequest request, HttpServletResponse response) {
        Proveedores proveedor = new Proveedores();
        proveedor.setNombre_proveedor(request.getParameter("nombre"));
        proveedor.setNit(request.getParameter("nit"));
        proveedor.setEmail_proveedor(request.getParameter("correo"));
        proveedor.setTelefono_proveedor(request.getParameter("telefono"));
        proveedor.setCiudad_proveedor(request.getParameter("direccion"));
        int respuesta = 0;
        try {
            respuesta = ProveedoresJSON.postJSON(proveedor);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Agregado!");
                response.sendRedirect(request.getContextPath() + "/proveedores.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listarProveedores(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
            String pagina = "/resultadoProveedores.jsp";
            request.setAttribute("lista", lista);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("nit");
        int respuesta = 0;
        try{
            PrintWriter writer = response.getWriter();
            respuesta = ProveedoresJSON.deleteJSON(id);
            if (respuesta == 200){
                writer.println("proveedor eliminado");
                response.sendRedirect(request.getContextPath() + "/proveedores.jsp");
            }
            else{
                writer.println("Error: " + respuesta);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProveedor(HttpServletRequest request, HttpServletResponse response){
        Proveedores proveedor = new Proveedores();
        proveedor.setNombre_proveedor(request.getParameter("nombre"));
        proveedor.setNit(request.getParameter("nit"));
        proveedor.setEmail_proveedor(request.getParameter("correo"));
        proveedor.setTelefono_proveedor(request.getParameter("telefono"));
        proveedor.setCiudad_proveedor(request.getParameter("direccion"));
        int respuesta = 0;
        try {
            respuesta = ProveedoresJSON.postJSON(proveedor);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Actualizado!");
                response.sendRedirect(request.getContextPath() + "/proveedores.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

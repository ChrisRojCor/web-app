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

@WebServlet(name = "ClientesServlet", value = "/ClientesServlet")
public class ClientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter writer = response.getWriter();

        if(request.getParameter("boton1") != null){
            listarClientes(request, response);
        }
        if(request.getParameter("boton2") != null){
            agregarCliente(request, response);
        }
        if (request.getParameter("boton3") != null){
            actualizarCliente(request, response);
        }
        if (request.getParameter("boton4") != null){
            eliminarCliente(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void agregarCliente(HttpServletRequest request, HttpServletResponse response) {
        Clientes cliente = new Clientes();
        cliente.setNombre_cliente(request.getParameter("nombre"));
        cliente.setCedula_cliente(request.getParameter("cedula"));
        cliente.setEmail_cliente(request.getParameter("correo"));
        cliente.setTelefono_cliente(request.getParameter("telefono"));
        cliente.setDireccion_cliente(request.getParameter("direccion"));
        int respuesta = 0;
        try {
            respuesta = ClientesJSON.postJSON(cliente);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Agregado!");
                response.sendRedirect(request.getContextPath() + "/clientes.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listarClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<Clientes> lista = ClientesJSON.getJSON();
            String pagina = "/resultadoClientes.jsp";
            request.setAttribute("lista", lista);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("cedula");
        int respuesta = 0;
        try{
            PrintWriter writer = response.getWriter();
            respuesta = ClientesJSON.deleteJSON(id);
            if (respuesta == 200){
                writer.println("cliente eliminado");
                response.sendRedirect(request.getContextPath() + "/clientes.jsp");
            }
            else{
                writer.println("Error: " + respuesta);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCliente(HttpServletRequest request, HttpServletResponse response){
        Clientes cliente = new Clientes();
        cliente.setNombre_cliente(request.getParameter("nombre"));
        cliente.setCedula_cliente(request.getParameter("cedula"));
        cliente.setEmail_cliente(request.getParameter("correo"));
        cliente.setTelefono_cliente(request.getParameter("telefono"));
        cliente.setDireccion_cliente(request.getParameter("direccion"));
        int respuesta = 0;
        try {
            respuesta = ClientesJSON.postJSON(cliente);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Actualizado!");
                response.sendRedirect(request.getContextPath() + "/clientes.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

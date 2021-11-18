package co.edu.unbosque.tiendagenerica;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "UsuariosServlet", value = "/UsuariosServlet")
public class UsuariosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter writer = response.getWriter();

        if(request.getParameter("boton2") != null){
            agregarUsuario(request, response);
        }
        if(request.getParameter("boton1") != null){
            listarUsuarios(request, response);
        }
        if (request.getParameter("boton4") != null){
            eliminarUsuario(request, response);
        }
        if (request.getParameter("boton3") != null){
            actualizarUsuario(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
        Usuarios usuario = new Usuarios();
        usuario.setNombre_usuario(request.getParameter("nombre"));
        usuario.setCedula_usuario(request.getParameter("cedula"));
        usuario.setEmail_usuario(request.getParameter("correo"));
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setPassword(request.getParameter("contraseña"));
        int respuesta = 0;
        try {
            respuesta = UsuariosJSON.postJSON(usuario);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Agregado!");
                response.sendRedirect(request.getContextPath() + "/usuarios.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
            String pagina = "/resultadoUsuarios.jsp";
            request.setAttribute("lista", lista);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("cedula");
        int respuesta = 0;
        try{
            PrintWriter writer = response.getWriter();
            respuesta = UsuariosJSON.deleteJSON(id);
            if (respuesta == 200){
                writer.println("usuario eliminado");
                response.sendRedirect(request.getContextPath() + "/usuarios.jsp");
            }
            else{
                writer.println("Error: " + respuesta);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response){
        Usuarios usuario = new Usuarios();
        usuario.setNombre_usuario(request.getParameter("nombre"));
        usuario.setCedula_usuario(request.getParameter("cedula"));
        usuario.setEmail_usuario(request.getParameter("correo"));
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setPassword(request.getParameter("contraseña"));
        int respuesta = 0;
        try {
            respuesta = UsuariosJSON.postJSON(usuario);
            PrintWriter writer = response.getWriter();
            if (respuesta == 200) {
                writer.println("Registro Actualizado!");
                response.sendRedirect(request.getContextPath() + "/usuarios.jsp");
            }else {
                writer.println("Error: "+ respuesta);
            }
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

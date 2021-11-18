package co.edu.unbosque.tiendagenerica;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {


    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Served at: login").append(request.getContextPath());
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        try {
            ArrayList<Usuarios> usuarios = UsuariosJSON.getJSON();
            boolean userRegistered = usuarios.stream().anyMatch(dbUsuario -> dbUsuario.getUsuario().equals(usuario) && dbUsuario.getPassword().equals(contraseña));

            if(userRegistered){
                response.sendRedirect(request.getContextPath() + "/home.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }

        } catch (Exception e) {
            response.getWriter().append("Usuarios error" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
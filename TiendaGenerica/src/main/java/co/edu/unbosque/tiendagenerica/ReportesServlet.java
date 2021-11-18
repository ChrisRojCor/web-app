package co.edu.unbosque.tiendagenerica;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ReportesServlet", value = "/ReportesServlet")
public class ReportesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter writer = response.getWriter();
        if(request.getParameter("boton1") != null){
            listarUsuarios(request, response);
        }
        if(request.getParameter("boton2") != null){
            listarClientes(request, response);
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
}

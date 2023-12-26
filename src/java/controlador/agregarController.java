package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelo.Invitado;
import modeloDAO.InvitadoDAO;

@WebServlet(name = "agregarController", urlPatterns = {"/agregarController"})
public class agregarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        InvitadoDAO invitadoDAO = new InvitadoDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("vistas/agregar.jsp");

        } else if ("agregar".equals(accion)) {
            String invitado_nombre = request.getParameter("invitado_nombre");
            String invitado_estado = request.getParameter("invitado_estado");

            // Verificar si el nombre ya existe
            if (invitadoDAO.existeNombre(invitado_nombre)) {
                request.setAttribute("mensaje", "El nombre ya existe. Por favor, elige otro.");
            } else {
                // El nombre no existe, agregar el invitado
                Invitado invitado = new Invitado(0, invitado_nombre, invitado_estado);
                invitadoDAO.agregarInvitado(invitado);
                request.setAttribute("mensaje", "Invitado agregado con éxito.");
            }

            dispatcher = request.getRequestDispatcher("vistas/agregar.jsp"); // Página principal
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

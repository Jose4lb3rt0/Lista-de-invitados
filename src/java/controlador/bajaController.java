package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import modeloDAO.InvitadoDAO;


@WebServlet(name = "bajaController", urlPatterns = {"/bajaController"})
public class bajaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        InvitadoDAO invitadoDAO = new InvitadoDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("vistas/baja.jsp"); // Página principal
            
        } else if ("baja".equals(accion)){
            String invitado_nombre = request.getParameter("invitado_nombre");
            invitadoDAO.bajaInvitado(invitado_nombre);
            dispatcher = request.getRequestDispatcher("vistas/baja.jsp");
            
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
    }// </editor-fold>

}

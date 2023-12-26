package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import modelo.Invitado;
import modeloDAO.InvitadoDAO;


@WebServlet(name = "consultarController", urlPatterns = {"/consultarController"})
public class consultarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        InvitadoDAO invitadoDAO = new InvitadoDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("vistas/consultar.jsp"); // Página principal
            List<Invitado> listainvitado = invitadoDAO.listarInvitado();
            request.setAttribute("listaAlta", listainvitado);

            List<Invitado> listainvitadobaja = invitadoDAO.listarInvitadoBaja();
            request.setAttribute("listaBaja", listainvitadobaja);
            
        }else{
            List<Invitado> listainvitado = invitadoDAO.listarInvitado();
            request.setAttribute("listaAlta", listainvitado);

            List<Invitado> listainvitadobaja = invitadoDAO.listarInvitadoBaja();
            request.setAttribute("listaBaja", listainvitadobaja);
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

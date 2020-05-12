/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.dao.DAOFactory;
import ups.edu.ec.dao.TelefonoDAO;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;


@WebServlet(name = "EditarTelefono", urlPatterns = {"/editar-telefono"})
public class EditarTelefono extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sesion = request.getParameter("delete");
        String id = request.getParameter("idTelefono");
        if (sesion != null && id != null) {
            if (sesion.equals("true")) {  
                TelefonoDAO telefonoDao = DAOFactory.getDAOFactory().getTelefonoDAO();
                Telefono telefono = telefonoDao.findById(Integer.parseInt(id));
                telefonoDao.delete(telefono);
                
                response.sendRedirect("my-agenda");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String operadora = request.getParameter("operadora");
        String idTelefono = request.getParameter("idtel");

        TelefonoDAO telefonoDao = DAOFactory.getDAOFactory().getTelefonoDAO();
        Telefono telefono = telefonoDao.findById(Integer.parseInt(idTelefono));
        Usuario usuario = DAOFactory.getDAOFactory().getUsuarioDAO().findById(String.valueOf(request.getSession().getAttribute("userID")));
        telefono.setUsuario(usuario);
        telefono.setNumero(numero);
        telefono.setTipo(tipo);
        telefono.setOperadora(operadora);
        
        telefonoDao.update(telefono);

        response.sendRedirect("my-agenda");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

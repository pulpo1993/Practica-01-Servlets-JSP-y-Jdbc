/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.dao.DAOFactory;
import ups.edu.ec.dao.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;


@WebServlet(name = "MyAgenda", urlPatterns = {"/my-agenda"})
public class MyAgenda extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sesion = request.getParameter("logout");
        if (sesion != null) {
            if (sesion.equals("true")) {
                //System.out.println("Sesion cerrada de id " + request.getSession().getAttribute("sesionID"));
                request.getSession().invalidate();
                response.sendRedirect("/Practica-01-JSP-Servlets-Jdbc");

            }
        } else {
            UsuarioDAO usuarioDao = DAOFactory.getDAOFactory().getUsuarioDAO();
            Usuario usuario = usuarioDao.findById(String.valueOf(request.getSession().getAttribute("userID")));

            request.setAttribute("user", usuario);
            getServletContext().getRequestDispatcher("/views/jsp/my-agenda.jsp").forward(request, response);
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/views/jsp/my-agenda.jsp");
            //dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

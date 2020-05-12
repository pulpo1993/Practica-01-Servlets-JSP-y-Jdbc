/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.dao.DAOFactory;
import ups.edu.ec.dao.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;


@WebServlet(name = "Busqueda", urlPatterns = {"/busqueda"})
public class Busqueda extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String contexto = request.getParameter("usuario");
        
        UsuarioDAO usuarioDao = DAOFactory.getDAOFactory().getUsuarioDAO();
        List<Usuario> usuario = usuarioDao.findByIdOrMail(contexto);
        
        request.setAttribute("users", usuario);
        getServletContext().getRequestDispatcher("/views/jsp/busqueda.jsp").forward(request, response);
        //System.out.println("users: "+users.toString());
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

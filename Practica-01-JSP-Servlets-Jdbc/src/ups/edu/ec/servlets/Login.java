/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ups.edu.ec.dao.DAOFactory;
import ups.edu.ec.dao.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;


@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/html/form-login.html");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        
        UsuarioDAO usuarioDao = DAOFactory.getDAOFactory().getUsuarioDAO();
        Usuario usuario = usuarioDao.findUser(mail, pass);
        if (usuario != null && usuario.getActivo() == 1) {
            System.out.println("usuario encontrado");
            HttpSession session = request.getSession(true);
            System.out.println("Sesion iniciada con id " + request.getSession().getId());
            session.setAttribute("sesionID", String.valueOf(session.getId()));
            session.setAttribute("userID", usuario.getCedula());
            
            response.sendRedirect("my-agenda");
            
        }else{
            response.sendRedirect("login");
        }     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

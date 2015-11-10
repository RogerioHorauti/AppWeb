package edu.br.impacta.ads.aps.servlet;

import edu.br.impacta.ads.aps.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    
    private HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //Valores vindo do banco
        User usuarioBanco = new User();
        usuarioBanco.setUsername("Rogerio");
        usuarioBanco.setPassword("admin");
        
        //Valores vindo da JSP
        User uDig = new User();
        uDig.setUsername(request.getParameter("user"));
        uDig.setPassword(request.getParameter("password"));
        
        //Verificação de usuário e senha
        if(uDig.getUsername().equals(usuarioBanco.getUsername()) && uDig.getPassword().equals(usuarioBanco.getPassword())){
            
            User uSession = new User();
            uSession.setUsername(usuarioBanco.getUsername());
            //Quando crio a sessão com o objeto usuario o servidor envia o id da sessão para o cliente
            session = request.getSession();
            session.setAttribute("usuario", uSession);
            //30 min
            session.setMaxInactiveInterval(30*60);
            System.out.println("ID da Sessão : "+session.getId());
            
            response.sendRedirect(request.getContextPath()+"/principal");
        }else{
            //retorno
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

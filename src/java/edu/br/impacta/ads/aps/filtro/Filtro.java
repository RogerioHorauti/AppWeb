package edu.br.impacta.ads.aps.filtro;

import edu.br.impacta.ads.aps.model.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
         
        String newCurrentPage = ((HttpServletRequest) request).getServletPath();
        String uri = req.getRequestURI();
        String url = req.getContextPath();
        
        System.out.println("URI : "+uri);
        //System.out.println("Context : "+url);
        System.out.println("Current Page : "+newCurrentPage);
              
        // Caso haja cookies (O cookie sempre vai existir, o servidor cria a sessão)
        if(req.getCookies() != null){
            System.out.println("cookie recheado");
            for (Cookie valuesCookie : req.getCookies()) {
                System.out.println("Cookie : "+ valuesCookie.getValue());
            }                      
        }else{
            System.out.println("cookie vazio");      	
        }
        
        //Existe sessão
        if(req.getSession().getAttribute("usuario")!= null){
            
            User user = new User();
            user = (User) req.getSession().getAttribute("usuario");
            System.out.println("Sessão : "+user.getUsername()
                    +"\tid session : "+req.getSession().getId());
            
        //Não existe sessão na pagina inicial           
        }else if(req.getRequestURI().equals("/AppWeb/")){
            
            System.out.println("Não existe sessão na pagina inicial"); 
        
        //não existe sessão na principal
        }else if(newCurrentPage.equals("/principal")){
            
            System.out.println("Não existe Sessão na principal");
            res.sendRedirect(req.getContextPath()+"/index.jsp");
            
        }     
    chain.doFilter(request, response);     
    }
    
    @Override
    public void destroy() {
        
    }
    private void principal(){
        
    }
    
}

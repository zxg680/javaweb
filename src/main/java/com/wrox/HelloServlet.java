/**   
* @Title: HelloServlet.java 
* @Package com.wrox 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月28日 下午12:36:32 
* @version V1.0   
*/
package com.wrox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: HelloServlet 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月28日 下午12:36:32 
*  
*/
@WebServlet(name = "helloS", urlPatterns = { "/greeting1", "/solo" }, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    /** 
    * @Fields serialVersionUID : TODO 
    */ 
    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("Hello,the is my servlet!");
        response.getWriter().println("getRequestURL: " + request.getRequestURL());
        response.getWriter().println("getRequestURI:" + request.getRequestURI());
        response.getWriter().println("getServletPath:" + request.getServletPath());
    }
}

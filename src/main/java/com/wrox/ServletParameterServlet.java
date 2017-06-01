/**   
* @Title: ServletParameterServlet.java 
* @Package com.wrox 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月28日 下午4:07:37 
* @version V1.0   
*/
package com.wrox;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: ServletParameterServlet 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月28日 下午4:07:37 
*  
*/
public class ServletParameterServlet extends HttpServlet {
    
    /** 
    * @Fields serialVersionUID : TODO 
    */ 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,IOException
    {
        ServletConfig config = this.getServletConfig();
        PrintWriter writer = response.getWriter();
        
        writer.append("database: ")
        .append(config.getInitParameter("database"))
        .append(", server: ")
        .append(config.getInitParameter("server"));
        
    }

}

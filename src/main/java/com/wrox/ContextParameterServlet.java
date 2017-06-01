/**   
* @Title: ContextParameterServlet.java 
* @Package com.wrox 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月28日 下午3:59:26 
* @version V1.0   
*/
package com.wrox;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: ContextParameterServlet 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月28日 下午3:59:26 
*  
*/
@WebServlet(name = "contextParameterServlet", urlPatterns = { "/contextParameters" })
public class ContextParameterServlet extends HttpServlet {

    /** 
    * @Fields serialVersionUID : TODO 
    */ 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        PrintWriter writer = response.getWriter();

        writer.append("settingOne: ").append(context.getInitParameter("settingOne")).append(", settingTwo: ")
                .append(context.getInitParameter("settingTwo"));
    }

}

/**   
* @Title: NonAsyncServlet.java 
* @Package com.wrox 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月29日 下午5:04:28 
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
* @ClassName: NonAsyncServlet 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月29日 下午5:04:28 
*  
*/
@WebServlet(name="nonAsyncServlet", urlPatterns="/regular")
public class NonAsyncServlet extends HttpServlet {

    /** 
    * @Fields serialVersionUID : TODO 
    */ 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
        System.out.println("Entering NonAsyncServlet.doGet().");
        request.getRequestDispatcher("/WEB-INF/jsp/view/nonAsync.jsp")
        .forward(request, response);
        System.out.println("Leaving NonAsyncServlet.doGet");
        
    }
}

/**   
* @Title: AuthenticationFilter.java 
* @Package com.wrox.Filter 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月29日 下午8:14:12 
* @version V1.0   
*/
package com.wrox.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
* @ClassName: AuthenticationFilter 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月29日 下午8:14:12 
*  
*/
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session != null && session.getAttribute("username") == null) {
            ((HttpServletResponse) response).sendRedirect("login");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}

/**   
* @Title: AnyRequestFilter.java 
* @Package com.wrox 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月29日 下午4:40:59 
* @version V1.0   
*/
package com.wrox;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/** 
* @ClassName: AnyRequestFilter 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月29日 下午4:40:59 
*  
*/
public class AnyRequestFilter implements Filter {

    private String name;

    @Override
    public void init(FilterConfig config) {
        this.name = config.getFilterName();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Entering " + this.name + ".doFilter().");
        chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request),
                new HttpServletResponseWrapper((HttpServletResponse) response));
        if (request.isAsyncSupported() && request.isAsyncStarted()) {
            AsyncContext context = request.getAsyncContext();
            System.out.println("Leaving " + this.name + ".doFilter(), async "
                    + "context holds wrapped request/response = " + !context.hasOriginalRequestAndResponse());

        } else {
            System.out.println("Leaving " + this.name + ".doFilter().");
        }
    }

    @Override
    public void destroy() {
    }
}

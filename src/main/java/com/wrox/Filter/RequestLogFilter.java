/**   
* @Title: RequestLogFilter.java 
* @Package com.wrox.Filter 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月29日 下午7:48:15 
* @version V1.0   
*/
package com.wrox.Filter;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.StopWatch;

/** 
* @ClassName: RequestLogFilter 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月29日 下午7:48:15 
*  
*/
public class RequestLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Instant time = Instant.now();
        StopWatch timer = new StopWatch();
        try {
            timer.start();
            chain.doFilter(request, response);
        } finally {
            timer.stop();
            HttpServletRequest in = (HttpServletRequest) request;
            HttpServletResponse out = (HttpServletResponse) response;
            String length = out.getHeader("Content_length");
            if (length == null || length.length() == 0) {
                length = "-";
            }
            System.out.println(
                    in.getRemoteAddr() + " -- {" + time + "]" + " \"" + in.getMethod() + " " + in.getRequestURI() + " "
                            + in.getProtocol() + "\" " + out.getStatus() + " " + length + " " + timer);

        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

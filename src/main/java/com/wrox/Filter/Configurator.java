/**   
* @Title: Configurator.java 
* @Package com.wrox.Filter 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月29日 下午7:40:35 
* @version V1.0   
*/
package com.wrox.Filter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
* @ClassName: Configurator 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月29日 下午7:40:35 
*  
*/
public class Configurator implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();

        FilterRegistration.Dynamic registration = context.addFilter("requestLogFilter", new RequestLogFilter());
        registration.addMappingForUrlPatterns(null, false, "/*");

        /*
         * registration = context.addFilter("compressionFilter", new
         * CompressionFilter()); registration.setAsyncSupported(true);
         * registration.addMappingForUrlPatterns(null, false, "/*");
         */

        registration = context.addFilter("authenticationFilter", new AuthenticationFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null, false, "/sessions", "/tickets");

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}

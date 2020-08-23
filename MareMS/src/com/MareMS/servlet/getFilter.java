package com.MareMS.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

/**
 * Servlet Filter implementation class getFilter
 */
@WebFilter("/getFilter")
public class getFilter implements Filter {

    /**
     * Default constructor. 
     */
    public getFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;  
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;  
        String user = (String) httpServletRequest.getSession(true).getAttribute("username");
        if (!isExcludePages(httpServletRequest.getRequestURI())) {  
            if (user == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");  
                return;  
            }  
        }  
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	private boolean isExcludePages(String url) {  
        return url.indexOf("MareMS/index.jsp") != -1 
        		||url.indexOf("MareMS/register.jsp") != -1 
                || url.endsWith(".css")  
                || url.endsWith(".js")  
                || url.endsWith(".gif")  
                || url.endsWith(".jpg")  
                || url.endsWith(".png")
                || url.endsWith("servlet");  
    }  

}

package com.opensource.jiangbiao.agileTool.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by p2vdug on 9/27/2017.
 */

@Component
public class CorsFilter implements Filter {

    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","x-request-with");
        HttpServletRequest request= (HttpServletRequest)req;
        System.out.println("过滤器--| "+ request.getServletPath());
        chain.doFilter(req,res);
    }

    @Override
    public void init(FilterConfig filterConfig){}
    @Override
    public void destroy(){}
}

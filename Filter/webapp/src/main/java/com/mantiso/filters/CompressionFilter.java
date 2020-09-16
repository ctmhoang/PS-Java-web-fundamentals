package com.mantiso.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter()
public class CompressionFilter implements Filter
{
    static Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
            IOException, ServletException
    {
        if (servletRequest instanceof HttpServletRequest)
        {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String ae = request.getHeader("accept-encoding");
            if (ae != null && ae.contains("gzip"))
            {
                logger.info("[Compressed Fil] called");
                GZIPResponseWrapper wrapper = new GZIPResponseWrapper(response);
                filterChain.doFilter(servletRequest, wrapper);
                wrapper.finishResponse();
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy()
    {

    }
}

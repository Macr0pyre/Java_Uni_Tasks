package org.controller;

import javax.servlet.*;
import java.io.IOException;

public class NewStudentLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        String averageScore = servletRequest.getParameter("averageScore");
        String knowsBlockchain = servletRequest.getParameter("knowsBlockchain");

        if (name == null && averageScore == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Boolean blockchainBool = false;
        if (knowsBlockchain != null)
            blockchainBool = true;

        System.out.println(String.format("Added student: %s, %s, %s", name, averageScore, blockchainBool));

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

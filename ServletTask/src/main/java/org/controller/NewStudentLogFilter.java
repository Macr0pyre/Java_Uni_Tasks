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

        boolean blockchainBool = knowsBlockchain != null;

        System.out.printf("Added student: %s, %s, %s%n", name, averageScore, blockchainBool);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

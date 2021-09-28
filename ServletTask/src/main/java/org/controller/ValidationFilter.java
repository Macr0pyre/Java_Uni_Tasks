package org.controller;

import org.dao.StudentDAO;

import javax.servlet.*;
import java.io.IOException;

public class ValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        String averageMark = servletRequest.getParameter("averageScore");
        if (name == null && averageMark == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String errorMessage;
        if (name.equals("") || averageMark.equals("")) {
            errorMessage = "Error: Some fields are empty.";

            servletRequest.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/views/index.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else if (!StudentDAO.getStudent(name).getName().equals("")) {
            errorMessage = "Error: Student with such name is already in the list.";

            servletRequest.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/views/index.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else if (Float.parseFloat(averageMark) < 0 || Float.parseFloat(averageMark) > 5) {
            errorMessage = "Error: Invalid average mark. Should be in range from 0 to 5.";

            servletRequest.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/views/index.jsp");
            requestDispatcher.include(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

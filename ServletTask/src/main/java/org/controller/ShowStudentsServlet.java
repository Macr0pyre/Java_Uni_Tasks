package org.controller;

import org.dao.StudentDAO;
import org.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowStudentsServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        StudentDAO.loadData();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String blockchainFilter = req.getParameter("blockchainFilter");
        String averageScoreFilter = req.getParameter("averageScoreFilter");

        List<Student> studentList;

        if (blockchainFilter != null)
            studentList = StudentDAO.getStudentsBlockchain();
        else if (averageScoreFilter != null)
            studentList = StudentDAO.getExcellentStudents();
        else
            studentList = StudentDAO.getStudents();

        out.write("<div align=\"center\">");
        for (Student s : studentList) {
            out.write(s.toString() + "<br/>");
        }
        out.write("</div>");
    }
}

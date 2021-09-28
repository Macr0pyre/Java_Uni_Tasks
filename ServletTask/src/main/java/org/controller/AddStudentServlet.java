package org.controller;

import org.dao.StudentDAO;
import org.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String averageScore = req.getParameter("averageScore");
        String knowsBlockchain = req.getParameter("knowsBlockchain");

        addStudentToDAO(name, averageScore, knowsBlockchain);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(req, resp);
    }

    private void addStudentToDAO(String name, String averageScore, String knowsBlockchain) {
        Student student = new Student();
        student.setName(name);
        student.setAverageScore(Float.parseFloat(averageScore));
        if (knowsBlockchain != null)
            student.setKnowsBlockchain(true);
        else
            student.setKnowsBlockchain(false);
        StudentDAO.addStudent(student);
    }
}

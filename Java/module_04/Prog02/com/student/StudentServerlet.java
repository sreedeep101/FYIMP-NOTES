package com.student;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    StudentDAO dao;

    public void init() {
        dao = new StudentDAO();
    }


    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String action = request.getParameter("action");

            if ("edit".equals(action)) {

                int id = Integer.parseInt(
                    request.getParameter("id")
                );

                request.setAttribute(
                    "student", dao.getStudent(id)
                );

                request.getRequestDispatcher("edit.jsp")
                       .forward(request, response);

            } else {

                request.setAttribute(
                    "students", dao.getStudents()
                );

                request.getRequestDispatcher("index.jsp")
                       .forward(request, response);
            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }


    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String action = request.getParameter("action");

            if ("add".equals(action)) {

                dao.addStudent(
                    request.getParameter("name"),
                    request.getParameter("email")
                );

            } else if ("update".equals(action)) {

                dao.updateStudent(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name"),
                    request.getParameter("email")
                );

            } else if ("delete".equals(action)) {

                dao.deleteStudent(
                    Integer.parseInt(request.getParameter("id"))
                );
            }

            response.sendRedirect(
                request.getContextPath() + "/students"
            );

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

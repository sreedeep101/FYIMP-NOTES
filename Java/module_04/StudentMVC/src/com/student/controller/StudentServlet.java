package com.student.controller;

import com.student.model.Student;
import com.student.model.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            if ("edit".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));

                Student student = dao.getStudentById(id);

                if (student == null) {
                    response.sendError(
                            HttpServletResponse.SC_NOT_FOUND,
                            "Student not found"
                    );
                    return;
                }

                request.setAttribute("student", student);

            } else if ("delete".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));

                dao.deleteStudent(id);

                response.sendRedirect(
                        request.getContextPath() + "/students"
                );
                return;
            }

            request.setAttribute(
                    "students",
                    dao.getAllStudents()
            );

            request.getRequestDispatcher("/index.jsp")
                   .forward(request, response);

        } catch (NumberFormatException e) {

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid student ID"
            );

        } catch (SQLException e) {

            throw new ServletException(
                    "Database operation failed",
                    e
            );
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        try {

            if ("add".equals(action)) {

                Student student = new Student();

                student.setName(request.getParameter("name"));
                student.setEmail(request.getParameter("email"));
                student.setCourse(request.getParameter("course"));

                dao.addStudent(student);

            } else if ("update".equals(action)) {

                Student student = new Student();

                student.setId(
                        Integer.parseInt(request.getParameter("id"))
                );

                student.setName(request.getParameter("name"));
                student.setEmail(request.getParameter("email"));
                student.setCourse(request.getParameter("course"));

                dao.updateStudent(student);

            } else {

                response.sendError(
                        HttpServletResponse.SC_BAD_REQUEST,
                        "Invalid action"
                );
                return;
            }

            response.sendRedirect(
                    request.getContextPath() + "/students"
            );

        } catch (NumberFormatException e) {

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid student ID"
            );

        } catch (SQLException e) {

            throw new ServletException(
                    "Database operation failed",
                    e
            );
        }
    }
}

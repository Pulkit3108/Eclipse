package com.PM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PM.StudentDao;
import com.PM.Student;

@WebServlet("/register")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao StudentDao;

    public void init() {
        StudentDao = new StudentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");

        Student Student = new Student();
        Student.setFirstName(firstName);
        Student.setLastName(lastName);
        Student.setUsername(username);
        Student.setPassword(password);
        Student.setContact(contact);
        Student.setEmail(email);

        try {
            StudentDao.registerStudent(Student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("StudentDetail.jsp");
    }
}

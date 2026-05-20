package com.attendance.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import com.attendance.dao.AttendanceDAO;
import com.attendance.model.Student;
import java.io.IOException;
import java.util.List;

public class ViewAttendanceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String code = req.getParameter("code");

        try {
            List<Student> students = AttendanceDAO.getList(code);

            int total = (students != null) ? students.size() : 0;

            req.setAttribute("students", students);
            req.setAttribute("total", total);
            
            req.getRequestDispatcher("list.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
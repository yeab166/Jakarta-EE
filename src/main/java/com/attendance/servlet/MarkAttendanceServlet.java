package com.attendance.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import com.attendance.dao.AttendanceDAO;
import com.attendance.model.Student;
import java.io.IOException;

public class MarkAttendanceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("mark.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String code = req.getParameter("code");

        if (name == null || id == null || code == null ||
            name.isEmpty() || id.isEmpty() || code.isEmpty()) {

            resp.getWriter().write("<h3>All fields are required!</h3>");
            return;
        }

        // DEVICE DETECTION
        String ip = req.getRemoteAddr();
        String agent = req.getHeader("User-Agent");
        String deviceId = ip + "_" + agent;

        try {
            String result = AttendanceDAO.mark(code, new Student(id, name), deviceId);


            resp.setContentType("text/html");
            resp.getWriter().write(
                "<h3>" + result + "</h3>" +
                "<br><a href='index.jsp'>Back</a>"
            );
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("<h3>Error occurred while marking attendance</h3>");
        }
    }
}
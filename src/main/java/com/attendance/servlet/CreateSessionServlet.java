package com.attendance.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import com.attendance.dao.AttendanceDAO;
import java.io.IOException;

public class CreateSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int duration = Integer.parseInt(req.getParameter("duration"));

        try {
            String code = AttendanceDAO.createSession(duration);

            resp.setContentType("text/html");
            resp.getWriter().write(
                "<h2>Session Created!</h2>" +
                "<p>Code: <b>" + code + "</b></p>" +
                "<a href='index.jsp'>Back</a>"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
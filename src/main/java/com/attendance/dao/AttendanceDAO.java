package com.attendance.dao;

import com.attendance.config.DBConnection;
import com.attendance.model.Student;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class AttendanceDAO {

    // 🔹 Create session
    public static String createSession(int duration) throws Exception {
        Connection con = DBConnection.getConnection();

        String code = UUID.randomUUID().toString().substring(0,6);
        LocalDateTime expiry = LocalDateTime.now().plusMinutes(duration);

        String sql = "INSERT INTO sessions (code, expiry_time) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, code);
        ps.setTimestamp(2, Timestamp.valueOf(expiry));
        ps.executeUpdate();

        return code;
    }

    // 🔹 Mark attendance
    public static String mark(String code, Student student, String deviceId) throws Exception {
        Connection con = DBConnection.getConnection();

        // 1. Check session
        String sessionSql = "SELECT expiry_time FROM sessions WHERE code=?";
        PreparedStatement ps1 = con.prepareStatement(sessionSql);
        ps1.setString(1, code);
        ResultSet rs = ps1.executeQuery();

        if (!rs.next()) return "Invalid session!";

        Timestamp expiry = rs.getTimestamp("expiry_time");
        if (expiry.toLocalDateTime().isBefore(LocalDateTime.now())) {
            return "Session expired!";
        }

        // 2. Check duplicate student
        String checkStudent = "SELECT * FROM attendance WHERE session_code=? AND student_id=?";
        PreparedStatement ps2 = con.prepareStatement(checkStudent);
        ps2.setString(1, code);
        ps2.setString(2, student.getId());
        ResultSet rs2 = ps2.executeQuery();

        if (rs2.next()) return "Already marked!";

        // 3. Check device reuse
        String checkDevice = "SELECT * FROM attendance WHERE session_code=? AND device_id=?";
        PreparedStatement ps3 = con.prepareStatement(checkDevice);
        ps3.setString(1, code);
        ps3.setString(2, deviceId);
        ResultSet rs3 = ps3.executeQuery();

        if (rs3.next()) return "Device already used!";

        // 4. Insert student
        String insertStudent = "INSERT IGNORE INTO students (id, name) VALUES (?, ?)";
        PreparedStatement ps4 = con.prepareStatement(insertStudent);
        ps4.setString(1, student.getId());
        ps4.setString(2, student.getName());
        ps4.executeUpdate();

        // 5. Insert attendance
        String insert = "INSERT INTO attendance (session_code, student_id, device_id) VALUES (?, ?, ?)";
        PreparedStatement ps5 = con.prepareStatement(insert);
        ps5.setString(1, code);
        ps5.setString(2, student.getId());
        ps5.setString(3, deviceId);
        ps5.executeUpdate();

        return "Attendance marked!";
    }

    // 🔹 Get list
    public static List<Student> getList(String code) throws Exception {
        Connection con = DBConnection.getConnection();

        List<Student> list = new ArrayList<>();

        String sql = "SELECT s.id, s.name FROM attendance a JOIN students s ON a.student_id=s.id WHERE a.session_code=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, code);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Student(rs.getString("id"), rs.getString("name")));
        }

        return list;
    }
}
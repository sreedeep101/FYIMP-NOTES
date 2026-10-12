package com.student;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    Connection con;

    public StudentDAO() {
        try {
		
	    con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "Root",
                "Root@123"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void addStudent(String name, String email)
            throws SQLException {

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO student(name,email) VALUES(?,?)"
        );

        ps.setString(1, name);
        ps.setString(2, email);

        ps.executeUpdate();
    }

    
    public ArrayList<Student> getStudents()
            throws SQLException {

        ArrayList<Student> list = new ArrayList<>();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
            "SELECT * FROM student"
        );

        while (rs.next()) {
            list.add(new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email")
            ));
        }

        return list;
    }

    public Student getStudent(int id) throws SQLException {

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM student WHERE id=?"
        );

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email")
            );
        }

        return null;
    }

    public void updateStudent(int id, String name, String email)
            throws SQLException {

        PreparedStatement ps = con.prepareStatement(
            "UPDATE student SET name=?, email=? WHERE id=?"
        );

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setInt(3, id);

        ps.executeUpdate();
    }


    public void deleteStudent(int id) throws SQLException {

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM student WHERE id=?"
        );

        ps.setInt(1, id);

        ps.executeUpdate();
    }
}

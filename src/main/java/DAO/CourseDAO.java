/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CourseDAO extends DBConnection {

    public CourseDAO() {
        super();
        this.connectDB();
    }

    public ArrayList<Course> getCourseList() throws SQLException {
        ArrayList<Course> courseList = new ArrayList<Course>();

        String sql = "SELECT * FROM Course";
        ResultSet rs = this.doReadQuery(sql);
        while (rs.next()) {
            Course item = new Course(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentID")
            );
            
            courseList.add(item);
        }
        return courseList;
    }

}

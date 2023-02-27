/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.CourseDAO;
import Entity.Course;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CourseBLL {
    private CourseDAO courseDAO = new CourseDAO();
    
    public ArrayList<Course> getCourseList() throws SQLException {
        return courseDAO.getCourseList();
    }
}

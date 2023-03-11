/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.CourseDAO;
import Entity.Course;
import Entity.OnlineCourse;
import Entity.OnsiteCourse;
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
    public boolean updateCourse(Course course){
        return courseDAO.updateCourse(course);
    }
    public boolean deleteCourse(Course course){
        return courseDAO.deleteCourse(course);
    }
    public void addCourse(OnlineCourse course) {
        courseDAO.addCourseOnline(course);
    }
    public void addCourse(OnsiteCourse course) {
        courseDAO.addCourseOnsite(course);
    }
    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }
    public ArrayList<Course> getCourse(int id) throws SQLException, IllegalArgumentException {
        ArrayList<Course> list = courseDAO.getCourse(id);
        if (list.isEmpty())
            throw new IllegalArgumentException("Ma khong ton tai");
        return list;
    }

}

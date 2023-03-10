/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BLL;

import DAO.CourseInstructorDAO;
import Entity.CourseInstructor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class CourseInstructorBLL {
    private CourseInstructorDAO courseInstructorDAO = new CourseInstructorDAO();
    
    public ArrayList<CourseInstructor> getCourseInstructors(int CousreID) throws SQLException {
        return courseInstructorDAO.getCourseInstructors(CousreID);
    }
    public void addCourseInstructor(CourseInstructor dto) {
        courseInstructorDAO.addCourseInstructor(dto);
    }
    public void addCourseInstructor(int CourseID, int PersonId){
        courseInstructorDAO.addCourseInstructor(CourseID, PersonId);
    }
    public void deleteCourse(CourseInstructor dto){
        courseInstructorDAO.deleteCourse(dto);
    }
    public void deleteCourse(int CourseID, int PersonId){
        courseInstructorDAO.deleteCourse(CourseID, PersonId);
    }
}

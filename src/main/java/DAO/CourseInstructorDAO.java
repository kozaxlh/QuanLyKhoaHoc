/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.CourseInstructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class CourseInstructorDAO extends DBConnection{
    
    public CourseInstructorDAO(){
        super();
        this.connectDB();
    }
    
    public ArrayList<CourseInstructor> getCourseInstructors(int CousreID) throws SQLException {
        ArrayList<CourseInstructor> courseInstructorList = new ArrayList<CourseInstructor>();
        
        String sql = "SELECT * FROM courseinstructor WHERE CourseID = ?";
        
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,CousreID);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            CourseInstructor student = new CourseInstructor(
                    rs.getInt("CourseID"),
                    rs.getInt("PersonID")
                );
            courseInstructorList.add(student);
        }
        return courseInstructorList;
    }
    public void addCourseInstructor(CourseInstructor dto) {
        String sql = "INSERT INTO courseinstructor (CourseID, PersonID) "
                + "VALUES(?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ((CourseInstructor) dto).getCourseID());
            stmt.setInt(2, ((CourseInstructor) dto).getPersonId());
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void addCourseInstructor(int CourseID, int PersonId) {
        String addSQL = "INSERT INTO courseinstructor (CourseID, PersonID) "
                + "VALUES(?, ?)";

        try {
            stmt = conn.prepareStatement(addSQL);
            stmt.setInt(1, CourseID);
            stmt.setInt(2, PersonId);
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public void deleteCourse(CourseInstructor dto) {
        String deleteSQL = "delete from courseinstructor "
                + "where CourseID = ? AND PersonID = ?";
        try {
            stmt = conn.prepareStatement(deleteSQL);
            stmt.setInt(1, ((CourseInstructor) dto).getCourseID());
            stmt.setInt(2, ((CourseInstructor) dto).getPersonId());
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCourse(int CourseID, int PersonId) {
        String deleteSQL = "delete from courseinstructor "
                + "where CourseID = ? AND PersonID = ?";
        try {
            stmt = conn.prepareStatement(deleteSQL);
            stmt.setInt(1, CourseID);
            stmt.setInt(2, PersonId);
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

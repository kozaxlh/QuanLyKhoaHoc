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

    public boolean updateCourse(Course dto) {
        boolean flag;
        String updateSQL = "update Course "
                + "set Title = ?, "
                + "Credits = ?, "
                + "DepartmentID = ? "
                + "where CourseID = ?";
        try {
            stmt = conn.prepareStatement(updateSQL);
            stmt.setString(1, ((Course) dto).getTitle());
            stmt.setInt(2, ((Course) dto).getCredits());
            stmt.setInt(3, ((Course) dto).getDepartmentId());
            stmt.setInt(4, ((Course) dto).getCourseID());
            flag = stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }

    public boolean deleteCourse(Course dto) {
        boolean flag;
        String deleteSQL = "delete from Course "
                + "where CourseID = ?";
        try {
            stmt = conn.prepareStatement(deleteSQL);
            stmt.setInt(1, ((Course) dto).getCourseID());
            flag = stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public ArrayList<Course> getCourse(int id) throws SQLException {
        ArrayList<Course> CourseList = new ArrayList<>();

        String sql = "SELECT * FROM Course WHERE CourseID = ? ";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Course course;
            course = new Course(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentId")
            );
            CourseList.add(course);
        }
        return CourseList;

    }

    public void addCourse(Course dto) {
        String sql = "INSERT INTO Course (Title, Credits, DepartmentId) "
                + "VALUES(?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ((Course) dto).getTitle());
            stmt.setInt(2, ((Course) dto).getCredits());
            stmt.setInt(3, ((Course) dto).getDepartmentId());

            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        public ArrayList<CourseOnline> getCourseListOnline() throws SQLException {
        ArrayList<CourseOnline> courseListOnline = new ArrayList<CourseOnline>();

        String sql = "SELECT * FROM Course";
        ResultSet rs = this.doReadQuery(sql);
        while (rs.next()) {
            CourseOnline item = new CourseOnline(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentID"),
                    rs.getString("DeparmentName"),
                    rs.getString("URL")
            );

            courseListOnline.add(item);
        }
        return courseListOnline;
    }
    public ArrayList<CourseOnsite> getCourseListOnsite() throws SQLException {
        ArrayList<CourseOnsite> courseListOnsite = new ArrayList<CourseOnsite>();

        String sql = "SELECT * FROM Course";
        ResultSet rs = this.doReadQuery(sql);
        while (rs.next()) {
            CourseOnline item = new CourseOnline(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentID"),
                    rs.getString("DeparmentName"),
                    rs.getString("Location"),
                    rs.getString("days"),
                    rs.getDate("time")
            );

            courseListOnsite.add(item);
        }
        return courseListOnsite;
    }

    public boolean updateCourseOnline(CourseOnline dto) {
        boolean flag;
        String updateSQL = "update Course "
                + "set Title = ?, "
                + "Credits = ?, "
                + "DepartmentID = ? "
                + "DepartmentName = ? "
                + "URL = ? "
                + "where CourseID = ?";
        
        try {
            stmt = conn.prepareStatement(updateSQL);
            stmt.setString(1, ((CourseOnline) dto).getTitle());
            stmt.setInt(2, ((CourseOnline) dto).getCredits());
            stmt.setInt(3, ((CourseOnline) dto).getDepartmentId());
            stmt.setString(4, ((CourseOnline) dto).getDeparmentName());
            stmt.setString(5, ((CourseOnline) dto).getURL());
            stmt.setInt(6, ((CourseOnline) dto).getCourseID());
            flag = stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }
    public boolean updateCourseOnsite(CourseOnsite dto) {
        boolean flag;
        String updateSQL = "update Course "
                + "set Title = ?, "
                + "Credits = ?, "
                + "DepartmentID = ? "
                + "DepartmentName = ? "
                + "Location = ? "
                + "Days = ? "
                + "time = ? "
                + "where CourseID = ?";
        
        try {
            stmt = conn.prepareStatement(updateSQL);
            stmt.setString(1, ((CourseOnline) dto).getTitle());
            stmt.setInt(2, ((CourseOnline) dto).getCredits());
            stmt.setInt(3, ((CourseOnline) dto).getDepartmentId());
            stmt.setInt(4, ((CourseOnline) dto).getDeparmentName());
            stmt.setString(5, ((CourseOnline) dto).getLocation());
            stmt.setString(6, ((CourseOnline) dto).getDays());
            stmt.setDate(7, ((CourseOnline) dto).gettime());
            stmt.setInt(8, ((CourseOnline) dto).getCourseID());
            flag = stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }

    public boolean deleteCourseOnline(CourseOnline dto) {
        boolean flag;
        String deleteSQL = "delete from CourseOnline "
                + "where CourseID = ?";
        try {
            stmt = conn.prepareStatement(deleteSQL);
            stmt.setInt(1, ((CourseOnline) dto).getCourseID());
            flag = stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
    
    public boolean deleteCourseOnsite(CourseOnsite dto) {
        boolean flag;
        String deleteSQL = "delete from CourseOnsite "
                + "where CourseID = ?";
        try {
            stmt = conn.prepareStatement(deleteSQL);
            stmt.setInt(1, ((CourseOnsite) dto).getCourseID());
            flag = stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public ArrayList<CourseOnline> getCourseOnline(int id) throws SQLException {
        ArrayList<CourseOnline> CourseListOnline = new ArrayList<>();

        String sql = "SELECT * FROM CourseOnline WHERE CourseID = ? ";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CourseOnline course;
            course = new CourseOnline(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentId"),
                    rs.getString("DeparmentName"),
                    rs.getString("URL")
            );
            CourseListOnline.add(course);
        }
        return CourseListOnline;

    }

    public ArrayList<CourseOnsite> getCourseOnsite(int id) throws SQLException {
        ArrayList<CourseOnsite> CourseListOnsite = new ArrayList<>();

        String sql = "SELECT * FROM CourseOnsite WHERE CourseID = ? ";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CourseOnline course;
            course = new CourseOnline(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentId"),
                    rs.getString("DeparmentName"),
                    rs.getString("Location"),
                    rs.getString("Days"),
                    rs.getDate("time")
            );
            CourseListOnsite.add(course);
        }
        return CourseListOnsite;
    }
    public void addCourseOnline(CourseOnline dto) {
        String sql = "INSERT INTO CourseOnline (Title, Credits, DepartmentId,DeparmentName,URL) "
                + "VALUES(?, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ((CourseOnline) dto).getTitle());
            stmt.setInt(2, ((CourseOnline) dto).getCredits());
            stmt.setInt(3, ((CourseOnline) dto).getDepartmentId());
            stmt.setString(4, ((CourseOnline) dto).getDepartmentName());
            stmt.setString(5, ((CourseOnline) dto).getURL());
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
     public void addCourseOnsite(CourseOnsite dto) {
        String sql = "INSERT INTO CourseOnsite (Title, Credits, DepartmentId,DeparmentName,Location,Days,time) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ((CourseOnline) dto).getTitle());
            stmt.setInt(2, ((CourseOnline) dto).getCredits());
            stmt.setInt(3, ((CourseOnline) dto).getDepartmentId());
            stmt.setString(4, ((CourseOnline) dto).getDepartmentName());
            stmt.setString(5, ((CourseOnline) dto).getLocation());
            stmt.setString(6, ((CourseOnline) dto).getDays());
            stmt.setDate(7, ((CourseOnline) dto).gettime());
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<CourseOnline> getCourseList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

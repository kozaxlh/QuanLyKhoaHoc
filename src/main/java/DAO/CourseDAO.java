/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Course;
import Entity.OnlineCourse;
import Entity.OnsiteCourse;
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

        String sql = "SELECT * FROM Course "
                + "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID "
                + "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID;";

        ResultSet rs = this.doReadQuery(sql);
        while (rs.next()) {
            Course item = null;
            if (rs.getString("URL") != null) {
                item = new OnlineCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentId"),
                        rs.getString("URL")
                );
            }
            else {
                item = new OnsiteCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentId"),
                        rs.getString("Location"),
                        rs.getString("Days"),
                        rs.getTime("Time")
                );
            }

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

        String sql = "SELECT * FROM Course "
                + "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID "
                + "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID "
                + "WHERE course.CourseID = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Course item = null;
            if (rs.getString("URL") != null) {
                item = new OnlineCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentId"),
                        rs.getString("URL")
                );
            }
            else {
                item = new OnsiteCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentId"),
                        rs.getString("Location"),
                        rs.getString("Days"),
                        rs.getTime("Time")
                );
            };
            CourseList.add(item);
        }
        return CourseList;

    }

    public void addCourse(Course dto) {
        String sql = "INSERT INTO Course (Title, Credits, DepartmentId) "
                + "VALUES(?, ?, ?);";

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

    public ArrayList<OnlineCourse> getCourseListOnline() throws SQLException {
        ArrayList<OnlineCourse> courseListOnline = new ArrayList<>();

        String sql = "SELECT * FROM Course JOIN OnlineCourse "
                + "ON Course.CourseID = OnlineCourse.CourseID";
        ResultSet rs = this.doReadQuery(sql);
        while (rs.next()) {
            OnlineCourse item = new OnlineCourse(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentID"),
                    rs.getString("URL")
            );

            courseListOnline.add(item);
        }
        return courseListOnline;
    }

    public ArrayList<OnsiteCourse> getCourseListOnsite() throws SQLException {
        ArrayList<OnsiteCourse> courseListOnsite = new ArrayList<>();

        String sql = "SELECT * FROM Course JOIN OnsiteCourse "
                + "ON Course.CourseID = OnsiteCourse.CourseID";
        ResultSet rs = this.doReadQuery(sql);
        while (rs.next()) {
            OnsiteCourse item = new OnsiteCourse(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentID"),
                    rs.getString("Location"),
                    rs.getString("days"),
                    rs.getTime("time")
            );

            courseListOnsite.add(item);
        }
        return courseListOnsite;
    }

    public boolean updateCourseOnline(OnlineCourse dto) {
        boolean flag;
        String updateSQL = "update OnlineCourse SET "
                + "URL = ? "
                + "where CourseID = ?";

        try {
            boolean updateFlag = updateCourse(dto);
            stmt = conn.prepareStatement(updateSQL);
            stmt.setString(1, ((OnlineCourse) dto).getURL());
            stmt.setInt(2, ((OnlineCourse) dto).getCourseID());
            flag = stmt.execute() && updateFlag;
        }
        catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

        return flag;
    }

    public boolean updateCourseOnsite(OnsiteCourse dto) {
        boolean flag;
        String updateSQL = "update OnsiteCourse SET "
                + "Location = ?, Days = ?, time = ? "
                + "where CourseID = ?";

        try {
            boolean updateFlag = updateCourse(dto);
            stmt = conn.prepareStatement(updateSQL);
            stmt.setString(1, ((OnsiteCourse) dto).getLocation());
            stmt.setString(2, ((OnsiteCourse) dto).getDays());
            stmt.setTime(3, ((OnsiteCourse) dto).getTime());
            stmt.setInt(4, ((OnsiteCourse) dto).getCourseID());
            flag = stmt.execute() && updateFlag;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }

    public boolean deleteCourseOnline(OnlineCourse dto) {
        boolean flag;
        String deleteSQL = "delete from OnlineCourse "
                + "where CourseID = ?";
        try {
            stmt = conn.prepareStatement(deleteSQL);
            stmt.setInt(1, ((OnlineCourse) dto).getCourseID());
            flag = !stmt.execute() && deleteCourse(dto);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public boolean deleteCourseOnsite(OnsiteCourse dto) {
        boolean flag;
        String deleteSQL = "delete from OnsiteCourse "
                + "where CourseID = ?";
        try {
            stmt = conn.prepareStatement(deleteSQL);
            stmt.setInt(1, ((OnsiteCourse) dto).getCourseID());
            flag = !stmt.execute() && deleteCourse(dto);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public ArrayList<OnlineCourse> getCourseOnline(int id) throws SQLException {
        ArrayList<OnlineCourse> CourseListOnline = new ArrayList<>();

        String sql = "SELECT * FROM Course JOIN OnlineCourse "
                + "ON Course.CourseID = OnlineCourse.CourseID "
                + "WHERE CourseID = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            OnlineCourse course;
            course = new OnlineCourse(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentId"),
                    rs.getString("URL")
            );
            CourseListOnline.add(course);
        }
        return CourseListOnline;

    }

    public ArrayList<OnsiteCourse> getCourseOnsite(int id) throws SQLException {
        ArrayList<OnsiteCourse> CourseListOnsite = new ArrayList<>();

        String sql = "SELECT * FROM Course JOIN OnsiteCourse "
                + "ON Course.CourseID = OnsiteCourse.CourseID "
                + "WHERE CourseID = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            OnsiteCourse course;
            course = new OnsiteCourse(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentId"),
                    rs.getString("Location"),
                    rs.getString("Days"),
                    rs.getTime("time")
            );
            CourseListOnsite.add(course);
        }
        return CourseListOnsite;
    }

    public void addCourseOnline(OnlineCourse dto) {
        String sql = "INSERT INTO OnlineCourse (CourseID ,URL) "
                + "VALUES(@last_id_in_table1, ?)";

        try {
            addCourse(dto);
            setLastID();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ((OnlineCourse) dto).getURL());
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addCourseOnsite(OnsiteCourse dto) {
        String sql = "INSERT INTO OnsiteCourse (CourseID,Location,Days,time) "
                + "VALUES(@last_id_in_table1, ?, ?, ?)";

        try {
            addCourse(dto);
            setLastID();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ((OnsiteCourse) dto).getLocation());
            stmt.setString(2, ((OnsiteCourse) dto).getDays());
            stmt.setTime(3, ((OnsiteCourse) dto).getTime());

            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setLastID() {
        String sql = "SET @last_id_in_table1 = LAST_INSERT_ID();";
        this.doReadQuery(sql);
    }
}

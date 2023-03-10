/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.StudentGrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentGradeDAO extends DBConnection {

    public StudentGradeDAO() {
        super();
        this.connectDB();
    }

    public ArrayList<StudentGrade> getStudentGradeList() throws SQLException {
        ArrayList<StudentGrade> studentGradeList = new ArrayList<>();

        String sql = "SELECT * FROM StudentGrade";
        ResultSet rs = this.doReadQuery(sql);
        while (rs.next()) {
            StudentGrade item = new StudentGrade(
                    rs.getInt("EnrollmentID"),
                    rs.getInt("CourseID"),
                    rs.getInt("StudentID"),
                    rs.getFloat("Grade")
            );

            studentGradeList.add(item);
        }
        return studentGradeList;
    }

    public ArrayList<StudentGrade> getStudentGrade(int courseID) throws SQLException {
        ArrayList<StudentGrade> studentGradeList = new ArrayList<>();

        String sql = "SELECT * FROM StudentGrade WHERE CourseID = ?";

        stmt = conn.prepareStatement(sql);

        stmt.setInt(1, courseID);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            float grade = rs.getObject("Grade") != null ? rs.getFloat("Grade") : -1;
            StudentGrade item = new StudentGrade(
                    rs.getInt("EnrollmentID"),
                    rs.getInt("CourseID"),
                    rs.getInt("StudentID"),
                    grade
            );

            studentGradeList.add(item);
        }
        return studentGradeList;
    }

    public boolean addStudentGrade(StudentGrade grade) throws SQLException {
        String sql = "INSERT INTO StudentGrade (CourseID, StudentID, Grade) "
                + "VALUES (?,?,?)";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, grade.getCourseID());
        stmt.setInt(2, grade.getStudentID());
        stmt.setFloat(3, grade.getGrade());

        return stmt.execute();
    }
    public boolean addStudentGrade(int CourseID, int StudentID, float grade) throws SQLException {
        String sql = "INSERT INTO StudentGrade (CourseID, StudentID, Grade) "
                + "VALUES (?,?,?)";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, CourseID);
        stmt.setInt(2, StudentID);
        stmt.setFloat(3, grade);

        return stmt.execute();
    }

    public boolean addStudentGrade(ArrayList<StudentGrade> gradeList) throws SQLException {
        String sql = "INSERT INTO StudentGrade (CourseID, StudentID, Grade) VALUES ";

        for (StudentGrade item : gradeList) {
            sql += String.format("(%s, %s, %s)", item.getCourseID(), item.getStudentID(), item.getGrade());
            if (gradeList.indexOf(item) != gradeList.size() - 1) {
                sql += ", ";
            }
        }

        return stmt.execute(sql);
    }
    
    public boolean updateStudentGrade(StudentGrade grade) throws SQLException {
        String sql = "UPDATE StudentGrade SET "
                + "CourseID = ?, StudentID = ?, Grade = ? "
                + "WHERE EnrollmentID = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, grade.getCourseID());
        stmt.setInt(2, grade.getStudentID());
        stmt.setFloat(3, grade.getGrade());
        stmt.setInt(4, grade.getEnrollmentID());

        return stmt.execute();
    }
    public boolean updateStudentGrade(int CourseID, int StudentID, float Grade) throws SQLException {
        String sql = "UPDATE StudentGrade SET "
                + "Grade = ? "
                + "WHERE CourseID = ? AND StudentID = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setFloat(1, Grade);
        stmt.setInt(2, CourseID);
        stmt.setInt(3, StudentID);

        return stmt.execute();
    }
    
    public boolean deleteStudentGrade(StudentGrade grade) throws SQLException {
        String sql = "DELETE FROM StudentGrade "
                + "WHERE EnrollmentID = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, grade.getEnrollmentID());

        return stmt.execute();
    }
    public boolean deleteStudentGrade(int courseID, int studentID) throws SQLException {
        String sql = "DELETE FROM StudentGrade "
                + "WHERE CourseID = ? AND StudentID = ?";

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, courseID);
        stmt.setInt(2, studentID);
        return stmt.execute();
    }
}

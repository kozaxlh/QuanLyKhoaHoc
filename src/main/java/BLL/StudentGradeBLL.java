/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.StudentGradeDAO;
import Entity.StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentGradeBLL {

    private StudentGradeDAO studentGradeDAO = new StudentGradeDAO();

    public ArrayList<StudentGrade> getStudentGradeList() throws SQLException {
        return studentGradeDAO.getStudentGradeList();
    }

    public ArrayList<StudentGrade> getStudentInCourse(int id) throws SQLException {
        return studentGradeDAO.getStudentGrade(id);
    }

    public boolean addStudentGrade(StudentGrade grade) throws SQLException {
        return checkStudentGradeValid(grade) && studentGradeDAO.addStudentGrade(grade);
    }

    public boolean addStudentGrade(int CourseID, int StudentID, float Grade) throws SQLException {
        return checkStudentGradeValid(Grade) && studentGradeDAO.addStudentGrade(CourseID, StudentID, Grade);
    }

    public boolean addStudentGradeInCourse(ArrayList<StudentGrade> gradeList) throws SQLException {
        boolean flag = false;
        for (StudentGrade item : gradeList) {
            flag = checkStudentGradeValid(item);
            if(!flag)
                return false;
        }
        return studentGradeDAO.addStudentGrade(gradeList);
    }

    public boolean updateStudentGrade(StudentGrade grade) throws SQLException {
        return checkStudentGradeValid(grade) && studentGradeDAO.updateStudentGrade(grade);
    }

    public boolean updateStudentGrade(int CourseID, int StudentID, float Grade) throws SQLException {
        return checkStudentGradeValid(Grade) && studentGradeDAO.updateStudentGrade(CourseID, StudentID, Grade);
    }

    public boolean deleteStudentGrade(StudentGrade grade) throws SQLException {
        return studentGradeDAO.deleteStudentGrade(grade);
    }

    public boolean deleteStudentGrade(int courseID, int studentID) throws SQLException {
        return studentGradeDAO.deleteStudentGrade(courseID, studentID);
    }

    private boolean checkStudentGradeValid(StudentGrade grade) {
        if (grade.getGrade() > 4.0 || grade.getGrade() < 0) {
            System.out.println("Diem khong hop le. Diem phai tu 0 - 4 diem");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean checkStudentGradeValid(float grade) {
        if (grade > 4.0 || grade < 0) {
            System.out.println("Diem khong hop le. Diem phai tu 0 - 4 diem");
            return false;

        }
        else {
            return true;
        }
    }
}

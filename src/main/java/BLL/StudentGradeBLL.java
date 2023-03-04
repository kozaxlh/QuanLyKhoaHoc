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
        return studentGradeDAO.getStudentGradeInCourse(id);
    }

    public boolean addStudentGrade(StudentGrade grade) throws SQLException {
        checkStudentGradeValid(grade);
        return studentGradeDAO.addStudentGrade(grade);
    }

    public boolean addStudentGradeInCourse(ArrayList<StudentGrade> gradeList) throws SQLException {
        for(StudentGrade item : gradeList) {
            checkStudentGradeValid(item);
        }
        return studentGradeDAO.addStudentGradeInCourse(gradeList);
    }

    public boolean updateStudentGrade(StudentGrade grade) throws SQLException {
        checkStudentGradeValid(grade);
        return studentGradeDAO.updateStudentGrade(grade);
    }

    public boolean deleteStudentGrade(StudentGrade grade) throws SQLException {
        return studentGradeDAO.deleteStudentGrade(grade);
    }
    
    private boolean checkStudentGradeValid(StudentGrade grade) {
        if (grade.getGrade() > 4.0 || grade.getGrade() < 0) {
            throw new RuntimeException("Diem khong hop le. Diem phai tu 0 - 4 diem");
        }
        else
            return true;
    }
}

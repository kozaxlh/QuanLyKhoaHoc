/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import BLL.PersonBLL;
import BLL.StudentGradeBLL;
import Entity.Course;
import Entity.Person;
import Entity.StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Detail {

    Scanner sc = new Scanner(System.in);

    CourseBLL courseBLL = new CourseBLL();
    PersonBLL personBLL = new PersonBLL();
    StudentGradeBLL gradeBLL = new StudentGradeBLL();

    public void showScreen(int id) {
        System.out.println(showCourseHeader(id));
        showList(id);
        System.out.println("Nhan 0 de tro ve");
        sc.nextLine();
    }

    private String showCourseHeader(int courseID) throws IllegalArgumentException {
        Course course = null;
        ArrayList<Person> instructorList = null;

        try {
            course = courseBLL.getCourse(courseID).get(0);
            instructorList = personBLL.getInstructorsByCourse(courseID);
        }
        catch (SQLException ex) {
            System.out.println("Khong lay duoc du lieu");
            return null;
        }

        String result = null;

        result += "Ma khoa hoc:    " + course.getCourseID() + "\n";
        result += "Ten khoa hoc:   " + course.getTitle() + "\n";
        result += "So tin chi:     " + course.getCredits() + "\n";
        result += "Ma khoa day:    " + course.getDepartmentId() + "\n";
        result += "Ten giang vien: ";

        if (instructorList != null) {
            for (Person item : instructorList) {
                result += item.getName() + " ";
            }
        }

        return result;
    }

    private void showList(int courseID) {
        ArrayList<StudentGrade> gradeList = null;
        ArrayList<Person> studentList = null;

        try {
            gradeList = gradeBLL.getStudentInCourse(courseID);
            studentList = personBLL.getStudentsInCourse(courseID);

        }
        catch (SQLException ex) {
            System.out.println("Khong lay duoc du lieu");
            System.out.println(ex);
            return;
        }
        System.out.println("============Danh sach diem hoc vien===================");
        System.out.println("Ma hoc vien    |Ten hoc vien      | Diem thi   ");

        for (Person student : studentList) {
            for (StudentGrade grade : gradeList) {
                if (student.getId() == grade.getStudentID()) {
                    System.out.println(String.format("%-15s %-20s %s", student.getId(), student.getName(), grade.getGrade()));
                }
            }
        }
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import BLL.PersonBLL;
import BLL.StudentGradeBLL;
import Entity.Course;
import Entity.OnlineCourse;
import Entity.OnsiteCourse;
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
        Course course = null;
        
        try {
            course = courseBLL.getCourse(id).get(0);
        }
        catch (SQLException ex) {
            System.out.println("Khong lay duoc du lieu");
            return;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }
        
        showCourseHeader(course);
        showList(id);
        System.out.println("Nhan 0 de tro ve");
        sc.nextLine();
    }

    private void showCourseHeader(Course course) throws IllegalArgumentException {
        ArrayList<Person> instructorList = null;

        try {
            instructorList = personBLL.getInstructorsByCourse(course.getCourseID());
        }
        catch (SQLException ex) {
            System.out.println("Khong lay duoc du lieu header");
            return;
        }

        String result = "";

        result += "Ma khoa hoc:    " + course.getCourseID() + "\n";
        result += "Ten khoa hoc:   " + course.getTitle() + "\n";
        result += "So tin chi:     " + course.getCredits() + "\n";
        result += "Ma khoa day:    " + course.getDepartmentId() + "\n";

        if (course instanceof OnsiteCourse) {
            result += "Loai khoa:      Truc tiep\n"; 
            result += "Dia diem:       " + ((OnsiteCourse) course).getLocation() + "\n";
            result += "Ngay hoc:       " + ((OnsiteCourse) course).getDays() + "\n";
            result += "Gio hoc:        " + ((OnsiteCourse) course).getTime() + "\n";
        }
        else if(course instanceof OnlineCourse) {
            result += "Loai khoa:      Online\n"; 
            result += "URL:            " + ((OnlineCourse) course).getURL() + "\n";

        }
        
        result += "Ten giang vien: ";
        if (instructorList != null) {
            for (Person item : instructorList) {
                result += item.getName() + " ";
            }
            result += "\n";
        }

        System.out.println(result);
    }

    private void showList(int courseID) {
        ArrayList<StudentGrade> gradeList = null;
        ArrayList<Person> studentList = null;

        try {
            gradeList = gradeBLL.getStudentInCourse(courseID);
            studentList = personBLL.getStudentsInCourse(courseID);

        }
        catch (SQLException ex) {
            System.out.println("Khong lay duoc du lieu diem");
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

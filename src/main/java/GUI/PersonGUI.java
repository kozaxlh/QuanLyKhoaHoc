/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import BLL.PersonBLL;
import BLL.StudentGradeBLL;
import Entity.Course;
import Entity.CourseInstructor;
import Entity.Person;
import Entity.StudentGrade;
import BLL.CourseInstructorBLL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PersonGUI {

    static PersonBLL bll = new PersonBLL();
    public void showScreen(int courseID) throws SQLException {
        Scanner sc = new Scanner(System.in);
        CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
        StudentGradeBLL studentGradeBLL = new StudentGradeBLL();
        int choice = -1;
        do {
            System.out.println("===========Danh sach giang vien============");
            try {
                showInstructorList(courseInstructorBLL.getCourseInstructors(courseID));
            } catch (SQLException ex) {
                System.out.println("Không thể lấy dữ liệu");
            }
            System.out.println("===========Danh sach sinh vien=============");
            try {
                showStudentList(studentGradeBLL.getStudentInCourse(courseID));
            } catch (SQLException ex) {
                System.out.println("Không thể lấy dữ liệu");
            }
            System.out.println("===========Cap nhat giang day==============");
            System.out.println("1:Them giao vien                     ");
            System.out.println("2:Xoa giao vien                                  ");
            System.out.println("3:Them hoc viên                                     ");
            System.out.println("4:Xoa hoc vien                          ");
            System.out.println("5:Nhap diem                         ");
            System.out.println("0:Thoat                                             ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    addInstructorScreen(courseID);
                }
                case 2 -> {
                    deleteInstructorScreen(courseID);
                }
                case 0 -> {
                }
            }
        } while (choice != 0);
    }
    private static void showInstructorList(ArrayList<CourseInstructor> courseInstructors) throws SQLException {
        System.out.println("Ma khoa hoc|Ma giang vien");

        for (CourseInstructor item : courseInstructors) {
            System.out.println(String.format("%-11s %s",item.getCourseID(), item.getPersonId()));
        }
    }
    private void showStudentList(ArrayList<StudentGrade> students) throws SQLException {
        System.out.println("Ma hoc vien|Diem so");

        for (StudentGrade item : students) {
            System.out.println(String.format("%-11s %s",item.getStudentID(), item.getGrade()));
        }
    }
    private static void addInstructorScreen(int CourseID) throws SQLException {
        Scanner sc = new Scanner(System.in);
        PersonBLL instructorInfo = new PersonBLL();
        ArrayList<Person> instructors = new ArrayList<Person>();
        instructors = instructorInfo.getInstructors();
        int choice = -1;
        int instructorID;
        
        do {
            boolean flag = false;
            System.out.print("Nhap id giang vien: ");
            instructorID = sc.nextInt();
            for (Person person:instructors){
                if (instructorID == person.getId()){
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
                courseInstructorBLL.addCourseInstructor(CourseID, instructorID);
                System.out.println("Them du lieu thanh cong");
                System.out.println("Nhap 1 de them giang vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
            else{
                System.out.println("Id giang vien khong ton tai");
                System.out.println("Nhap 1 de tiep tuc them giang vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
        } while (choice != 0);
    }
    private static void deleteInstructorScreen(int CourseID) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int instructorID;
        System.out.print("Nhap id giang vien: ");
        instructorID = sc.nextInt();
        CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
        courseInstructorBLL.deleteCourse(CourseID, instructorID);
    }
}


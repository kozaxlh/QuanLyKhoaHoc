/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.PersonBLL;
import BLL.StudentGradeBLL;
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
                showInstructorInCourseList(courseInstructorBLL.getCourseInstructors(courseID));
            } catch (SQLException ex) {
                System.out.println("Không thể lấy dữ liệu");
            }
            System.out.println("===========Danh sach sinh vien=============");
            try {
                showStudentInCourseList(studentGradeBLL.getStudentInCourse(courseID));
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
                case 3 -> {
                    addStudentScreen(courseID);
                }
                case 4 -> {
                    deleteStudentScreen(courseID);
                }
                case 5 -> {
                    changeStudentGradeScreen(courseID);
                }
                case 0 -> {
                }
            }
        } while (choice != 0);
    }
    private static void showInstructorInCourseList(ArrayList<CourseInstructor> courseInstructors) throws SQLException {
        System.out.println("Ma khoa hoc|Ma giang vien");

        for (CourseInstructor item : courseInstructors) {
            System.out.println(String.format("%-11s %s",item.getCourseID(), item.getPersonId()));
        }
    }
    private static void showStudentInCourseList(ArrayList<StudentGrade> students) throws SQLException {
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
        int choice;
        boolean flag = false;
        do { 
            int instructorID;
            System.out.print("Nhap id giang vien: ");
            instructorID = sc.nextInt();
            CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
            ArrayList<CourseInstructor> courseInstructors = new ArrayList<CourseInstructor>();
            courseInstructors = courseInstructorBLL.getCourseInstructors(CourseID);
            for(CourseInstructor ci:courseInstructors){
                if(instructorID == ci.getPersonId()){
                    flag = true;
                    break;
                }
            }
            if (flag == true){
                courseInstructorBLL.deleteCourse(CourseID, instructorID);
                System.out.println("Nhap 1 de tiep tuc xoa giang vien hoac nhap 0 de thoat ra ");
                System.out.println("Xoa giang vien thanh cong");
                choice = sc.nextInt();
            }
            else{
                System.out.println("Khong ton tai giang vien ");
                System.out.println("Nhap 1 de tiep tuc xoa giang vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
        } while (choice==1);
    }
    private static void addStudentScreen(int CourseID) throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        PersonBLL StudentInfo = new PersonBLL();
        ArrayList<Person> Students1 = new ArrayList<Person>();
        Students1 = StudentInfo.getStudents();
        
        int choice = -1;
        int StudentID;
        
        do {
            int flag = 2;
            System.out.print("Nhap id hoc vien: ");
            StudentID = sc.nextInt();
            StudentGradeBLL studentGradeInfo = new StudentGradeBLL();
            ArrayList<StudentGrade> Students2 = new ArrayList<StudentGrade>();
            Students2 = studentGradeInfo.getStudentInCourse(CourseID);
            for (Person person:Students1){
                if (StudentID == person.getId()){
                    flag = 1;
                    break;
                }
            }
            for (StudentGrade person:Students2){
                if (StudentID == person.getStudentID()){
                    flag = 3;
                    break;
                }
            }
            if(flag == 1){
                StudentGradeBLL StudentgradeBLL = new StudentGradeBLL();
                System.out.print("Nhap diem hoc vien: "); 
                float grade = sc.nextFloat();
                StudentgradeBLL.addStudentGrade(CourseID, StudentID, grade);
                System.out.println("Them du lieu thanh cong");
                System.out.println("Nhap 1 de them hoc vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
            else if(flag == 2){
                System.out.println("Id hoc vien khong ton tai");
                System.out.println("Nhap 1 de tiep tuc them hoc vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
            else {
                System.out.println("Id hoc vien da ton tai");
                System.out.println("Nhap 1 de tiep tuc them hoc vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
        } while (choice != 0);
    }
    private static void deleteStudentScreen(int CourseID) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int studentID, choice;
        do {            
            boolean flag = false;
            System.out.print("Nhap id hoc vien: ");
            studentID = sc.nextInt();
            StudentGradeBLL studentGrade = new StudentGradeBLL();
            ArrayList<StudentGrade> students = new ArrayList<StudentGrade>();
            students = studentGrade.getStudentInCourse(CourseID);
            for(StudentGrade sg:students){
                if(studentID == sg.getStudentID()){
                    flag = true;
                    break;
                }
            }
            if (flag == true){
                studentGrade.deleteStudentGrade(CourseID, studentID);
                System.out.println("Xoa giang vien thanh cong");
                System.out.println("Nhap 1 de tiep tuc xoa hoc vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
            else{
                System.out.println("Khong ton tai giang vien ");
                System.out.println("Nhap 1 de tiep tuc xoa hoc vien hoac nhap 0 de thoat ra ");
                choice = sc.nextInt();
            }
        } while (choice == 1);
    }
    private static void changeStudentGradeScreen(int CourseID) throws SQLException {
        Scanner sc = new Scanner(System.in);
        StudentGradeBLL studentGradeInfo = new StudentGradeBLL();
        boolean flag = false;
        int studentID;
        float studentGrade;
        System.out.print("Nhap id hoc vien muon thay doi: ");
        studentID = sc.nextInt();
        ArrayList<StudentGrade> students = new ArrayList<StudentGrade>();
        students = studentGradeInfo.getStudentInCourse(CourseID);
        for(StudentGrade sg:students){
            if(studentID == sg.getStudentID()){
                flag = true;
                break;
            }
        }
        if (flag == true){
            System.out.print("Nhap so diem thay doi: ");
            studentGrade = sc.nextFloat();
            studentGradeInfo.updateStudentGrade(CourseID, studentID, studentGrade);
            System.out.println("Thay doi thanh cong");
            System.out.println("Bam phim bat ki de tiep tuc");
            new java.util.Scanner(System.in).nextLine();
        }
        else{
            System.out.println("Khong ton tai hoc vien");
            System.out.println("Bam phim bat ki de tiep tuc");
            new java.util.Scanner(System.in).nextLine();
        }
    }
}


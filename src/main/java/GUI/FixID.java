/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import Entity.Course;
import Entity.OnlineCourse;
import Entity.OnsiteCourse;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FixID {

    private CourseBLL courseBLL = new CourseBLL();

    public void showScreen(int id) {
        Scanner sc = new Scanner(System.in);
        Course course;
        try {
            course = courseBLL.getCourse(id).get(0);
        }
        catch (SQLException ex) {
            System.out.println("Khong lay duoc course");
            sc.nextLine();
            return;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            sc.nextLine();
            return;
        }

        int choice = -1;

        do {
            System.out.println("============Sua thong tin khoa hoc=============");
            System.out.println("1:Ma khoa day                                   ");
            System.out.println("2:Ten khoa hoc cua hoc vien                  ");
            System.out.println("3:So tin chi                                ");
            System.out.println("4:cap nhap chi tiet onsite/online            ");
            System.out.println("5:cap nhat khoa hoc                                    ");
            System.out.println("0:Thoát                                      ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Ma khoa day: ");
                    int departmentId = sc.nextInt();
                    course.setDepartmentId(departmentId);
                }

                case 2 -> {
                    sc.nextLine();
                    System.out.print("Ten khoa: ");
                    String courseName = sc.nextLine();
                    course.setTitle(courseName);
                }
                case 3 -> {
                    System.out.print("So tin chi: ");
                    int credit = sc.nextInt();
                    course.setCredits(credit);
                }
                case 4 -> {
                    if (course instanceof OnsiteCourse) {
                        int subChoice = -1;
                        do {
                            System.out.println("============Sua thong tin onsite=============");
                            System.out.println("1:Dia diem                                ");
                            System.out.println("2:Ngay hoc                  ");
                            System.out.println("3:Thoi gian                   ");
                            System.out.println("0:Thoat                                ");
                            subChoice = sc.nextInt();
                            switch (subChoice) {
                                case 1 -> {
                                    sc.nextLine();
                                    System.out.print("Dia diem: ");
                                    String location = sc.nextLine();
                                    ((OnsiteCourse) course).setLocation(location);
                                }
                                case 2 -> {
                                    sc.nextLine();
                                    System.out.print("Ngay hoc: ");
                                    String days = sc.nextLine();
                                    ((OnsiteCourse) course).setDays(days);
                                }
                                case 3 -> {
                                    sc.nextLine();
                                    System.out.print("Thoi gian (Nhap theo dinh dang hh:mm:ss): ");
                                    String time = sc.nextLine();
                                    ((OnsiteCourse) course).setTime(time);
                                }
                            }
                        } while (subChoice != 0);
                    }

                    else if (course instanceof OnlineCourse) {
                        sc.nextLine();
                        System.out.println("============Sua thong tin online=============");
                        System.out.print("URL: ");
                        String URL = sc.nextLine();
                        ((OnlineCourse) course).setURL(URL);
                    }
                }
                case 5 -> {
                    boolean flag = false;

                    if (course instanceof OnsiteCourse) {
                        flag = courseBLL.updateCourse((OnsiteCourse) course);
                    }
                    else if (course instanceof OnlineCourse) {
                        flag = courseBLL.updateCourse((OnlineCourse) course);
                    }

                    if (!flag) {
                        System.out.println("Sua thanh cong");
                    }
                    else {
                        System.out.println("Sua that bai");
                    }
                    sc.nextLine();
                    return;
                }
            }
        } while (choice != 0);
    }
}

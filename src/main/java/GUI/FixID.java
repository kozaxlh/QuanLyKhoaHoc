/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import Entity.Course;
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
            sc.next();
            return;
        }
        catch (IllegalArgumentException e) {
            System.out.println("Course khong ton tai");
            sc.next();
            return;
        }

        int choice = -1;

        do {
            System.out.println("============Sua thong tin khoa hoc=============");
            System.out.println("1:Ma khoa day                                   ");
            System.out.println("2:Ten khoa hoc cua hoc vien                  ");
            System.out.println("3:So tin chi                                ");
            System.out.println("4:cap nhat khoa hoc                                    ");
            System.out.println("0:Thoát                                      ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    int departmentId = sc.nextInt();
                    course.setDepartmentId(departmentId);
                }

                case 2 -> {
                    String courseName = sc.nextLine();
                    course.setTitle(courseName);
                }
                case 3 -> {
                    int credit = sc.nextInt();
                    course.setCredits(credit);
                }
                case 4 -> {
                    if (!courseBLL.updateCourse(course)) {
                        System.out.println("Sua thanh cong");
                        sc.next();
                    }
                    else {
                        System.out.println("Sưa that bai");
                        sc.next();
                    }
                    return;
                }
            }
        } while (choice != 0);
    }
}

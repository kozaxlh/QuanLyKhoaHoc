/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import Entity.Course;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Project1 {

    static Scanner sc = new Scanner(System.in);
    static CourseBLL courseBLL = new CourseBLL();

    public static void main(String[] args) {

        PersonGUI personGUI = new PersonGUI();

        int choice = -1;
        System.out.println("");
        do {
            showList();
            System.out.println("================Quan ly khoa hoc==================");
            System.out.println("=1:Them khoa hoc");
            System.out.println("=2:Sua thong tin");
            System.out.println("=3:Xoa khoa");
            System.out.println("=4:Tim kiem");
            System.out.println("=5:Xem chi tiet");
            System.out.println("=6:Cap nhat giang day");
            System.out.println("=0:Thoát");
            System.out.println("==================================================");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    addCourseScreen();
                }
                case 2 -> {

                }
                case 3 -> {
                    deleteCourseScreen();
                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 0 -> {
                }
            }
        } while (choice != 0);
    }

    private static void showList() {
        System.out.println("Ma khoa hoc|Ten khoa        | So tin chi  | Ma Khoa  ");
        
        try {
            ArrayList<Course> courseList = courseBLL.getCourseList();
            for (Course item : courseList) {
                System.out.println(String.format("%-11s %-20s %-10s %s",
                        item.getCourseID(), item.getTitle(), item.getCredits(), item.getDepartmentId()));
            }
        }
        catch (SQLException e) {
            System.out.println("Khong the them khoa hoc");
        }
    }

    private static void addCourseScreen() {
        Course course = new Course();

        int choice;

        do {
            sc.nextLine();

            System.out.print("Nhap ten khoa hoc: ");
            course.setTitle(sc.nextLine());
            System.out.print("Nhap so tin chi: ");
            course.setCredits(sc.nextInt());
            System.out.print("Nhap ma khoa: ");
            course.setDepartmentId(sc.nextInt());

            courseBLL.addCrouse(course);

            System.out.println("Nhap 1 de them khoa moi hoac nhap 0 de thoat ra ");
            choice = sc.nextInt();
        } while (choice != 0);

    }

    private static void deleteCourseScreen() {
        Course course = new Course();

        int choice;

        System.out.println("Nhap ma khoa hoc can xoa: ");
        course.setCourseID(sc.nextInt());
        System.out.println("Ban co chac chan se xoa khoa hoc nay ? Neu co thi nhan 1, neu khong thi nhan 0");
        choice = sc.nextInt();

        if (choice == 1) {
            if (courseBLL.deleteCourse(course)) {
                System.out.println("Xoa thanh cong");
            }
            else {
                System.out.println("Xoa that bai");
            }
        }

    }
}

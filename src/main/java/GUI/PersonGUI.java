/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.PersonBLL;
import Entity.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PersonGUI {

    PersonBLL bll = new PersonBLL();

    public void showScreen() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("============Quản lý học viên/giảng viên=============");
            System.out.println("1:Hiển thị danh sách học viên                       ");
            System.out.println("2:Hiển thị danh sách giảng viên                     ");
            System.out.println("3:Thêm giảng viên                                   ");
            System.out.println("4:Thêm học viên                                     ");
            System.out.println("5:Xóa học viên/giảng viên                           ");
            System.out.println("6:Sửa học viên/giảng viên                           ");
            System.out.println("6:Tìm kiếm học viên/giảng viên bằng mã              ");
            System.out.println("0:Thoát                                             ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    ArrayList<Person> students = bll.getStudents();
                    for (Person student : students) {
                        System.out.println(student.getName() + "    " + student.getEnrollmentDate());
                    }
                    sc.nextLine();
                }
                case 2 -> {
                    ArrayList<Person> instructors = bll.getInstructors();
                    for (Person item : instructors) {
                        System.out.println(item.getName() + "    " + item.getHireDate());
                    }
                    sc.nextLine();
                }
                case 0 -> {
                }
            }
        } while (choice != 0);
    }
}

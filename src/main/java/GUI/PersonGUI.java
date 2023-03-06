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
            System.out.println("============Cap nhat giang day=============");
            System.out.println("1:Them giao vien                     ");
            System.out.println("2:Sua giao vien                    ");
            System.out.println("3:Xoa giao vien                                  ");
            System.out.println("4:Them học viên                                     ");
            System.out.println("5:Xoa hoc vien                          ");
            System.out.println("6:Nhap diem                         ");
            System.out.println("0:Thoat                                             ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 0 -> {
                }
            }
        } while (choice != 0);
    }
}

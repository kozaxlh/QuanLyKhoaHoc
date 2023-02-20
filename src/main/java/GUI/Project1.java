/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package GUI;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Project1 {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        PersonGUI personGUI = new PersonGUI();

        int choice = -1;
        do {
            System.out.println("================Quản lý khóa học==================");
            System.out.println("=1:Quản lý học viên/giảng viên                   =");
            System.out.println("=2:Quản lý khóa học");
            System.out.println("=3:Quản lý phân công");
            System.out.println("=4:Quản lý kết quả");
            System.out.println("=0:Thoát=");
            System.out.println("==================================================");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    personGUI.showScreen();
                }
                case 2 -> {
                    
                }
                case 0 -> {
                }
            }
        } while (choice != 0);
    }
}

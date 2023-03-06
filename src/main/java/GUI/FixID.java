/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FixID {

    public void showScreen() {
        Scanner sc = new Scanner(System.in);

        int choice = -1;

        do {
            System.out.println("============Sua thong tin co ban=============");
            System.out.println("1:Ten khoa                                   ");
            System.out.println("2:Ten khoa hoc cua hoc vien                  ");
            System.out.println("3:So tien                                    ");
            System.out.println("0:Thoát                                      ");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package GUI;

import BLL.CourseBLL;
import Entity.Course;
import Entity.OnlineCourse;
import Entity.OnsiteCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Project1 {

    static Scanner sc = new Scanner(System.in);
    static CourseBLL courseBLL = new CourseBLL();

    public static void main(String[] args) throws SQLException {

        PersonGUI personGUI = new PersonGUI();

        int choice = -1;

        do {
            try {
                showList(courseBLL.getCourseList());
            }
            catch (SQLException ex) {
                System.out.println("Không thể lấy dữ liệu");
            }

            System.out.println("================Quan ly khoa hoc==================");
            System.out.println("=1:Them khoa hoc");
            System.out.println("=2:Sua thong tin khoa hoc");
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
                    FixID screen = new FixID();
                    int id;
                    System.out.println("Nhap ma khoa hoc can sua");
                    id = sc.nextInt();

                    screen.showScreen(id);
                }
                case 3 -> {
                    deleteCourseScreen();
                }
                case 4 -> {
                    searchCourseScreen();
                }
                case 5 -> {
                    Detail screen = new Detail();
                    int id;
                    System.out.println("Chon khoa hoc bang ma");
                    id = sc.nextInt();

                    screen.showScreen(id);
                }
                case 6 -> {
                    PersonGUI screen = new PersonGUI();
                    int id;
                    System.out.println("Nhap ma khoa hoc can sua");
                    id = sc.nextInt();

                    screen.showScreen(id);
                }
                case 0 -> {
                }
            }
        } while (choice != 0);
    }

    private static void showList(ArrayList<Course> courseList) {
        System.out.println("Ma khoa hoc|Ten khoa        | So tin chi  | Ma Khoa  | The loai");

        for (Course item : courseList) {
            String type = item instanceof OnlineCourse ? "Online" : "Truc tiep";
            System.out.println(String.format(
                    "%-11s %-20s %-10s %-10s %s",
                    item.getCourseID(),
                    item.getTitle(),
                    item.getCredits(),
                    item.getDepartmentId(),
                    type
            ));
        }
    }

    private static void addCourseScreen() {

        int choice;
        String title;
        int credits, departmentID;

        do {
            sc.nextLine();

            System.out.print("Nhap ten khoa hoc: ");
            title = sc.nextLine();
            System.out.print("Nhap so tin chi: ");
            credits = sc.nextInt();
            System.out.print("Nhap ma khoa: ");
            departmentID = sc.nextInt();

            System.out.print("Nhan so 1 de chon onsite hoac so 2 de chon online: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                OnsiteCourse course = new OnsiteCourse();
                course.setTitle(title);
                course.setCredits(credits);
                course.setDepartmentId(departmentID);

                System.out.print("Nhap dia diem: ");
                course.setLocation(sc.nextLine());
                System.out.print("Nhap ngay hoc: ");
                course.setDays(sc.nextLine());
                System.out.print("Nhap thoi gian theo mau hh:mm:ss: ");
                course.setTime(sc.nextLine());
                
                courseBLL.addCourse(course);
            }
            else if (choice == 2) {
                OnlineCourse course = new OnlineCourse();
                course.setTitle(title);
                course.setCredits(credits);
                course.setDepartmentId(departmentID);

                System.out.print("Nhap URL: ");
                course.setURL(sc.nextLine());
                
                courseBLL.addCourse(course);
            }

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

    private static void searchCourseScreen() {
        int courseID, choice;

        System.out.println("Nhap ma/ten khoa hoc can tim: ");
        courseID = sc.nextInt();

        try {
            showList(courseBLL.getCourse(courseID));
        }
        catch (SQLException ex) {
            System.out.println("Khong the lay du lieu");
            System.out.println(ex);
        }
        System.out.println("Nhan 1 de ve man hinh chinh");
        sc.next();
    }
}

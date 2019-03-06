/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static oop_project.ManageCustomer.customers;

/**
 *
 * @author tuan.nguyen1
 */
public class manageCourse extends Course {

    //public static ArrayList<Course> courseList = new ArrayList<Course>();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Course> courseList = new ArrayList<Course>();

    public void add() {

        int goback = 0;

        do {
            int IdCourse = (courseList.size() > 0) ? (courseList.size() + 1) : 1;
            System.out.println("Course's id = " + IdCourse);
            String t = scanner.nextLine();
            String nameCourse = inputName();
            String StartDay = inputStartDay();
            String Endday = inputEndday();
            float price = inputprice();
            String describe = inputDescription();
            Course course = new Course(IdCourse, nameCourse, StartDay, Endday, price, describe);
            courseList.add(course);

            System.out.println("Do you want to continues?");
            System.out.println("1: Continues");
            System.out.println("2: Go back");
            goback = scanner.nextInt();
        } while (goback == 1);
        choose();
    }

    /*
    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }
     */
    private String inputName() {
        System.out.print("Input course's name: ");
        return scanner.nextLine();
    }

    private String inputStartDay() {
        System.out.print("Input start day: ");
        return scanner.nextLine();
    }

    private String inputEndday() {
        System.out.print("Input end day: ");
        return scanner.nextLine();
    }

    private float inputprice() {
        System.out.print("Input course's price: ");
        while (true) {
            try {
                float price = Float.parseFloat((scanner.nextLine()));
                if (price < 0.0) {
                    throw new NumberFormatException();
                }
                return price;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input price again: ");
            }
        }
    }

    private String inputDescription() {
        System.out.print("Input description : ");
        return scanner.nextLine();
    }

    public void edit(int id) {
        boolean isExisted = false;

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getIdCourse() == id) {
                isExisted = true;
                //String t = scanner.nextLine();
                System.out.print("Input course's name: ");
                courseList.get(i).setNameCourse(new Scanner(System.in).nextLine());
                System.out.print("Input start day: ");
                courseList.get(i).setStartDay(new Scanner(System.in).nextLine());
                System.out.print("Input end day: ");
                courseList.get(i).setEndDay(new Scanner(System.in).nextLine());
                System.out.print("Input Price :");
                courseList.get(i).setPrice(new Scanner(System.in).nextFloat());
                System.out.print("Input Description : ");
                courseList.get(i).setDescribe(new Scanner(System.in).nextLine());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            //studentDao.write(courseList);
        }
    }

    public void delete(int id) {
        Course course = null;
        int size = courseList.size();
        for (int i = 0; i < size; i++) {
            if (courseList.get(i).getIdCourse() == id) {
                course = courseList.get(i);
                break;
            }
        }
        if (course != null) {
            System.out.println("Gia tri " + course + "da duoc xoa");
            courseList.remove(course);
             
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public void show() {
        System.out.println("\t\tID Course\tCourse's Name\tStart Day\tEnd Day\t\tPrice\t\tDescription");
        for (Course cou : courseList) {
            System.out.println(cou);
        }
    }

    public ArrayList<Course> getcourseList() {
        return courseList;
    }

    public void setcourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }
    TestProject test = new TestProject();

    public void exit() {
        System.out.println("Do you want to exit?");
        System.out.println("1: Back");
        System.out.println("2: Home page");
        System.out.println("3: Exit ");
        int exit;
        do {
            exit = scanner.nextInt();
            if (exit < 0 || exit > 3) {
                System.out.println("Your input is not invalid !");
            }

        } while (exit < 0 || exit > 3);
        switch (exit) {
            case 1:
                choose();
            case 2:
                test.menu();
                test.test();
            case 3:
                System.out.println("\t--------------------------------------------------------");
                System.out.println("\t===========  Thanks for using this program    =========== ");
                System.out.println("\t--------------------------------------------------------\n\n\n");
                System.exit(0);
        }
    }

    public static Comparator<Course> courceComparator = new Comparator<Course>() {

        @Override
        public int compare(Course o1, Course o2) {
            String nameo1 = o1.getNameCourse().toUpperCase();
            String nameo2 = o2.getNameCourse().toUpperCase();

            return nameo1.compareTo(nameo2);
        }

    };

    public void sortName() {
        String check = new String();
        System.out.print("Do you want sort list name course y/n: ");
        check = scanner.next();
        if (check.equals("y")) {
            if (courseList.size() > 1) {
                Collections.sort(courseList, courceComparator);
                for (Course courseList1 : courseList) {
                    System.out.println("" + courseList1);
                }
                exit();
            } else {
                System.out.println("Only one Course Please input new course");
                exit();
            }
        } else if (check.equals("n")) {
            exit();
        }
    }

    int numberChoose;

    public void choose() {
        System.out.println("  Pleace enter your choice : ");
        System.out.println("   1. Input new course ");
        System.out.println("   2. See Information");
        System.out.println("   3. Search ");
        System.out.println("   4. Delete");
        System.out.println("   5. Update");
        System.out.println("   6. Home page");
        System.out.println("   7. Exit");

        System.out.print("Pleace enter number from 1 to 7  :  ");
        do {
            numberChoose = scanner.nextInt();
            if (numberChoose <= 0 || numberChoose > 7) {
                System.out.println("Your choose is invalid, Pleace try again !");
            }
        } while (numberChoose <= 0 || numberChoose > 7);
        switch (numberChoose) {
            case 1:
                System.out.println("\n\t__________________   Input new Course  ____________________\n");
                add();
                exit();
                break;
            case 2:
                System.out.println("\n\t__________________   See Courses's Information  ____________________\n");
                show();
                sortName();
                exit();
                break;
            case 3:
                System.out.println("\n\t__________________   Search Course  ____________________\n");
                searchCourse(courseList);
                exit();
                break;
            case 4:
                System.out.println("\n\t__________________   Delete Course  ____________________\n");
                System.out.printf("Please enter customer's ID     :");
                int id_course = new Scanner(System.in).nextInt();
                delete(id_course);
                exit();
                break;
            case 5:
                System.out.println("\n\t__________________   Update Course  ____________________\n");
                System.out.print("\n\tNhap id : ");
                int id = scanner.nextInt();
                edit(id);
                exit();
                break;
            case 6:
                System.out.println("\n\t__________________   Home  ____________________\n");
                //delete(customers);
                test.menu();
                test.test();
                break;
            case 7:

                exit();
                break;
        }
    }

    public void searchCourse(ArrayList<Course> courseList) {
        String searchCourse = "";

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the course's name");
        searchCourse = scan.nextLine();
        System.out.println("\t\tID Course\tCourse's Name\tStart Day\tEnd Day\t\tPrice\t\tDescription");
        for (Course cou : courseList) {
            if (cou.getNameCourse().equals(searchCourse)) {

                System.out.println(cou.toString());

            }
        }

    }

    public static void main(String[] args) {
        manageCourse ma = new manageCourse();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println("Thời gian hiện tại của hệ thống là: " + date);
        ma.choose();
    }

}

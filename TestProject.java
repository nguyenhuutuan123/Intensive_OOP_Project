/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static oop_project.Course.courseList;
import static oop_project.ManageCustomer.customers;

/**
 *
 * @author tuan.nguyen1
 */
public class TestProject {

    int number, choose, numberChoose;
    private String userName = "admin";
    private String Password = "admin";
    private String Df_userName;
    private String Df_Password;

    Scanner scanner = new Scanner(System.in);

    public void menu() {

        System.out.println("\t\t ___________________________________________\t\t\n");
        System.out.println("\t\t    ************************************    ");
        System.out.println("\t\t    ***    Gym Management System     ***     ");
        System.out.println("\t\t    ************************************     ");
        System.out.println("\t\t ___________________________________________\n");
        System.out.println("\t===========================MENU============================\n");
        System.out.println("  Pleace enter your choice : ");
        System.out.println("   1. Members Management ");
        System.out.println("   2. Course management");
        System.out.println("   3. Machines");
        System.out.println("   4. Log Out ");
        System.out.println("   5. Exit Program \n");

        System.out.print("Pleace enter number from 1 to 6  :  ");
        do {
            number = scanner.nextInt();
            if (number <= 0 || number > 5) {
                System.out.println("Your choose is invalid, Pleace try again !");
            }
        } while (number <= 0 || number > 5);

    }

    public void Members_Management() {
        System.out.println("  Pleace enter your choice : ");
        System.out.println("   1. Input new member ");
        System.out.println("   2. View Information");
        System.out.println("   3. Search ");
        System.out.println("   4. Delete");
        System.out.println("   5. Exit");

        System.out.print("Pleace enter number from 1 to 5  :  ");
        do {
            numberChoose = scanner.nextInt();
            if (number <= 0 || number > 5) {
                System.out.println("Your choose is invalid, Pleace try again !");
            }
        } while (number <= 0 || number > 5);

    }

    public void continues() {
        System.out.println("Do you want to continues?");
        System.out.println("1: Continues");
        System.out.println("2: Go back");
        int goback;
        do {
            goback = scanner.nextInt();
            if (goback < 0 || goback > 2) {
                System.out.println("Your input is not invalid !");
            }

        } while (goback < 0 || goback > 2);
        int conti = scanner.nextInt();
    }

    public void test() {
        switch (number) {
            case 1:
                System.out.println("\n\t__________________   Members Management  ____________________\n");
                ManageCustomer cus = new ManageCustomer();
                cus.choose();
                //exit();
                break;
            case 2:
                System.out.println("\n\t__________________   Courses Management  ____________________\n");
                manageCourse cou = new manageCourse();
                cou.choose();
                //exit();
                break;
            case 3:
                System.out.println("\n\t__________________   Machines Management  ____________________\n");
                Machines machine = new Machines();

                machine.choose();
                //exit();
                break;
            case 4:
                TestProject test = new TestProject();
                test.enterAccount();

            case 5:
                exit();

        }
    }

    public void exit() {
        System.out.println("Do you want to exit?");
        System.out.println("1: Cancel");
        System.out.println("2: Exit ");
        int exit;
        do {
            exit = scanner.nextInt();
            if (exit < 0 || exit > 2) {
                System.out.println("Your input is not invalid !");
            }

        } while (exit < 0 || exit > 2);
        switch (exit) {
            case 1:
                menu();
                test();
            case 2:
                System.out.println("\t--------------------------------------------------------");
                System.out.println("\t===========  Thanks for using this program    =========== ");
                System.out.println("\t--------------------------------------------------------\n\n\n");
                System.exit(0);
        }
    }

    public void enterAccount() {

        System.out.println("\t\t\t ___________________________________________\t\t\n");
        System.out.println("\t\t\t    ************************************    ");
        System.out.println("\t\t\t    ***    Gym Management System     ***     ");
        System.out.println("\t\t\t    ************************************     ");
        System.out.println("\t\t\t ___________________________________________\n");
        System.out.println("\t=========================== Please enter your account ============================\n");
         
        System.out.print("\t\tEnter your user  : ");
        Df_userName = scanner.nextLine();
        System.out.print("\t\tEnter your password  : ");
        Df_Password = scanner.nextLine();

        if (Df_userName.contentEquals(userName) && Df_Password.contentEquals(Password)) {
            System.out.println("Login Successfuly!");
            menu();
            test();
        } else {
            System.out.println("Account is invalid! Please enter again ");
            enterAccount();
        }

    }

    public static void main(String[] args) {
        TestProject test = new TestProject();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println("Thời gian hiện tại của hệ thống là: " + date);
        System.out.println("Ngày hiện tại là " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + (cal.get(Calendar.YEAR)));

        test.enterAccount();

    }

}

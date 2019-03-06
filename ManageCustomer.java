/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tuan.nguyen1
 */
public class ManageCustomer extends Customer {

    int numberChoose;
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);
    TestProject test = new TestProject();
    

    public void add() {
        int goback;

        do {
            Customer cus = new Customer();
            System.out.printf("Enter member's id: ");
            cus.setIdCus(new Scanner(System.in).nextLine());

            System.out.print("Enter member's name: ");
            cus.setName(new Scanner(System.in).nextLine());

            System.out.print("Enter gender: ");
            cus.setGender(new Scanner(System.in).nextLine());

            System.out.print("Enter address: ");
            cus.setAddress(new Scanner(System.in).nextLine());

            System.out.print("Enter phone number: ");
            cus.setPhoneNumber(new Scanner(System.in).nextInt());

            System.out.print("Enter age: ");
            cus.setAge(new Scanner(System.in).nextInt());

            System.out.print("Study time : ");
            cus.setEndDay(new Scanner(System.in).nextInt());

            System.out.print("Enter course : ");
            cus.setCourse(new Scanner(System.in).nextLine());

            customers.add(cus);
            System.out.println("Do you want to continues?");
            System.out.println("1: Continues");
            System.out.println("2: Go back");
            goback = scanner.nextInt();
        } while (goback == 1);
        choose();
    }

    public void show() {
        System.out.println("\t\tID\t\tName\t\t\tAge\tPhone Number\t\tAddress\t\t\tGender\t\tStart Day\t\tEnd day\t\tCourse");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        
    }

    public void searchMember(ArrayList<Customer> customers) {
        String searchMembername = "";

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the member's name");
        searchMembername = scan.nextLine();
        System.out.println("\t\tID\t\tName\t\t\tAge\tPhone Number\t\tAddress\t\t\tGender\t\tStart Day\t\tEnd day\t\tCourse");
        for (Customer cus : customers) {

            if (cus.getName().equals(searchMembername)) {

                System.out.println(cus.toString());

            }
        }

    }

    public void delete(ArrayList<Customer> customers) {
        System.out.printf("Please enter customer's ID     :");
        String id_customer = new Scanner(System.in).nextLine();
        Customer tempCus = new Customer();
        for (Customer cus : customers) {
            if (cus.getIdCus().equals(id_customer)) {
                tempCus = cus;
            }
        }
        if (tempCus.getIdCus() != null) {
            System.out.println("Gia tri " + tempCus + "da duoc xoa");
            customers.remove(tempCus);
        } else {
            System.out.println("Not found");
        }
    }

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
    public static Comparator<Customer> custoComparator = new Comparator<Customer>() {

       @Override
       public int compare(Customer o1, Customer o2) {
           String nameo1 = o1.getName().toUpperCase();
           String nameo2  = o2.getName().toUpperCase();
           
           return nameo1.compareTo(nameo2);
       }
       
   };
    public void sortName() {
       String check = new String();
       System.out.print("do you want sort name list course y/n: ");
       check = scanner.next();
       if (check.equals("y")) {
           if (customers.size() > 1) {
               Collections.sort(customers, custoComparator);
               for (Customer custo : customers) {
                   System.out.println("" + custo);
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

    public void choose() {
        System.out.println("  Pleace enter your choice : ");
        System.out.println("   1. Input new member ");
        System.out.println("   2. View Information");
        System.out.println("   3. Search ");
        System.out.println("   4. Delete");
        System.out.println("   5. Home page");
        System.out.println("   6. Exit");

        System.out.print("Pleace enter number from 1 to 5  :  ");
        do {
            numberChoose = scanner.nextInt();
            if (numberChoose <= 0 || numberChoose > 6) {
                System.out.println("Your choose is invalid, Pleace try again !");
            }
        } while (numberChoose <= 0 || numberChoose > 6);
        switch (numberChoose) {
            case 1:
                System.out.println("\n\t__________________   Input new member  ____________________\n");
                add();
                exit();
                break;
            case 2:
                System.out.println("\n\t__________________   Member Information  ____________________\n");
                show();
                sortName();
                exit();
                break;
            case 3:
                System.out.println("\n\t__________________   Search Information  ____________________\n");
                searchMember(customers);
                exit();
                break;
            case 4:
                System.out.println("\n\t__________________   Delete Information  ____________________\n");
                delete(customers);
                exit();
                break;
            case 5:

                test.menu();
                test.test();
                break;
            case 6:
                exit();

        }
    }

    public static void main(String[] args) {
        System.out.println(customers.size());
        ManageCustomer ma = new ManageCustomer();
//        Calendar cal = Calendar.getInstance();
//        Date date = cal.getTime();
//        System.out.println("Thời gian hiện tại của hệ thống là: " + date);
//        System.out.println("Ngày hiện tại là " + cal.get(Calendar.DAY_OF_MONTH) + "/"+ (cal.get(Calendar.MONTH)+1) +"/"+ (cal.get(Calendar.YEAR)));
        ma.choose();

    }

}

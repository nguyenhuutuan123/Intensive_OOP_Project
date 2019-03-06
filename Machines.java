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
import java.util.Scanner;
import static oop_project.Course.courseList;
import static oop_project.ManageCustomer.customers;
import static oop_project.manageCourse.courseList;
import static oop_project.manageCourse.scanner;

public class Machines {

    int numberChoose;
    public static ArrayList<Machines> machines = new ArrayList<Machines>();
    Scanner scanner = new Scanner(System.in);
    TestProject test = new TestProject();

    private int id_mac;
    private String name_mac;
    private double price;
    private String status;

    public Machines() {

    }

    public Machines(int id_mac, String name_mac, double price, String status) {
        this.id_mac = id_mac;
        this.name_mac = name_mac;
        this.price = price;
        this.status = status;
    }

    public static ArrayList<Machines> getMachines() {
        return machines;
    }

    public static void setMachines(ArrayList<Machines> machines) {
        Machines.machines = machines;
    }

    public int getId_mac() {
        return id_mac;
    }

    public String getName_mac() {
        return name_mac;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
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

    public void add() {

        int goback;

        do {
            //int IdCourse = (courseList.size() > 0) ? (courseList.size() + 1) : 1;
            int id_mac = (machines.size() > 0) ? (machines.size() + 1) : 1;
            System.out.println("Machines's id = " + id_mac);
            scanner.nextLine();
            System.out.printf("Enter machine's name: ");
            name_mac = scanner.nextLine();

            price = inputprice();

            System.out.print("Enter status: ");
            status = scanner.nextLine();
            Machines mac = new Machines(id_mac, name_mac, price, status);

            machines.add(mac);
            System.out.println("Do you want to continues?");
            System.out.println("1: Continues");
            System.out.println("2: Go back");
            goback = scanner.nextInt();
        } while (goback == 1);
        choose();
    }

    @Override
    public String toString() {
        return "\t\t" + getId_mac() + "\t\t" + getName_mac() + "\t\t" + getPrice()
                + "\t" + getStatus() + "\n";
    }

    public void show() {
        System.out.println("\t\tID\t\tName\t\t\tPrice\tStatus");
        for (Machines mac : machines) {
            System.out.println(mac);
        }
    }

    public void searchMachines(ArrayList<Machines> machines) {
        String searchMachines = "";

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the machines's name");
        searchMachines = scan.nextLine();
        System.out.println("\t\tID\t\tName\t\t\tPrice\tStatus");
        for (Machines mach : machines) {
            if (mach.getName_mac().equals(searchMachines)) {

                System.out.println(mach.toString());

            }
        }

    }

    public void delete(int id) {
        Machines machine = null;
        int size = machines.size();
        for (int i = 0; i < size; i++) {
            if (machines.get(i).getId_mac() == id) {
                machine = machines.get(i);
                break;
            }
        }
        if (machine != null) {
            System.out.println("Gia tri " + machine + "da duoc xoa");
            machines.remove(machine);
            //studentDao.write(courseList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public void edit(int id) {
        boolean isExisted = false;

        for (int i = 0; i < machines.size(); i++) {
            if (machines.get(i).getId_mac() == id) {
                isExisted = true;
                //String t = scanner.nextLine();
                System.out.print("Input machine's status: ");
                machines.get(i).setStatus(new Scanner(System.in).nextLine());

                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            //studentDao.write(courseList);
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

    public void choose() {
        System.out.println("  Pleace enter your choice : ");
        System.out.println("   1. Input new machines ");
        System.out.println("   2. View Machines Information");
        System.out.println("   3. Search ");
        System.out.println("   4. Delete");
        System.out.println("   5. Update");
        System.out.println("   6. Home page");
        System.out.println("   7. Exit");

        System.out.print("Pleace enter number from 1 to 5  :  ");
        do {
            numberChoose = scanner.nextInt();
            if (numberChoose <= 0 || numberChoose > 7) {
                System.out.println("Your choose is invalid, Pleace try again !");
            }
        } while (numberChoose <= 0 || numberChoose > 7);
        switch (numberChoose) {
            case 1:
                System.out.println("\n\t__________________   Input new machines  ____________________\n");
                add();
                exit();
                break;
            case 2:
                System.out.println("\n\t__________________   Machines Information  ____________________\n");
                show();

                exit();
                break;
            case 3:
                System.out.println("\n\t__________________   Search Machines Information  ____________________\n");
                searchMachines(machines);
                exit();
                break;
            case 4:
                System.out.println("\n\t__________________   Delete Machines Information  ____________________\n");
                System.out.printf("Please enter machine's Id     :");
                int id_machine = new Scanner(System.in).nextInt();
                delete(id_machine);

                exit();
                break;
            case 5:
                System.out.println("\n\t__________________   Update Machines Information  ____________________\n");
                System.out.print("\n\tNhap id : ");
                int id = scanner.nextInt();
                edit(id);
                exit();
                break;
            case 6:
                System.out.println("\n\t__________________   Home page  ____________________\n");

                test.menu();
                test.test();
                break;
            case 7:
                exit();

        }
    }

    public static void main(String[] args) {
        System.out.println(machines.size());
        Machines mac = new Machines();
//        Calendar cal = Calendar.getInstance();
//        Date date = cal.getTime();
//        System.out.println("Thời gian hiện tại của hệ thống là: " + date);
//        System.out.println("Ngày hiện tại là " + cal.get(Calendar.DAY_OF_MONTH) + "/"+ (cal.get(Calendar.MONTH)+1) +"/"+ (cal.get(Calendar.YEAR)));

        mac.choose();
    }
}

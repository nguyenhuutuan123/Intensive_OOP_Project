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
import java.util.Scanner;
import static oop_project.ManageCustomer.customers;

/**
 *
 * @author tuan.nguyen1
 */
public class Customer extends Human {

    private String idCus;
    private int endDay;
    private String course;
    int numberChoose;
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);
    TestProject test = new TestProject();

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Customer() {
    }

    public Customer(String name, int age, int phoneNumber, String gender, String address) {
        super(name, age, phoneNumber, gender, address);
    }

     

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

//    public Date getEndDay() {
//        return cal.getTime();
//        cal.set(2016, Calendar.APRIL, 30, 20, 23, 8);
// 
//    System.out.println(cal.getTime());  
//    }
    public String setEndDay(int endDay) {
        this.endDay = endDay;
        int count = 1;
        if (this.endDay == 1) {
            count += 1;

        } else if (this.endDay == 2) {
            count += 2;
        } else if (this.endDay == 3) {
            count += 3;
        } else if (this.endDay == 4) {
            count += 4;
        } else if (this.endDay == 5) {
            count += 5;
        } else if (this.endDay == 6) {
            count += 6;
        } else if (this.endDay == 7) {
            count += 7;
        } else if (this.endDay == 8) {
            count += 8;
        } else if (this.endDay == 9) {
            count += 9;
        }

        return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + count) + "/" + (cal.get(Calendar.YEAR));
    }

    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();

    //System.out.println("Ngày hiện tại là " + cal.get(Calendar.DAY_OF_MONTH) + "/"+ (cal.get(Calendar.MONTH)+1) +"/"+ (cal.get(Calendar.YEAR)));
    @Override
    public String toString() {
        return "\t\t" + getIdCus() + "\t\t" + this.getName() + "\t\t" + this.getAge()
                + "\t" + this.getPhoneNumber() + "\t\t" + this.getAddress() + "\t\t\t" + this.getGender()
                + "\t\t" + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1)
                + "/" + (cal.get(Calendar.YEAR)) + "\t\t" + setEndDay(endDay) + "\t" + getCourse() + "\n";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
public class Course {

    private int IdCourse;
    private String nameCourse;
    private String startDay;
    private String endDay;
    private float price;
    private String describe;

    public Course(int IdCourse, String nameCourse, String startDay, String endDay, float price, String describe) {
        this.IdCourse = IdCourse;
        this.nameCourse = nameCourse;
        this.startDay = startDay;
        this.endDay = endDay;
        this.price = price;
        this.describe = describe;
    }

    Course() {

    }

    public int getIdCourse() {
        return IdCourse;
    }

    public void setIdCourse(int IdCourse) {
        this.IdCourse = IdCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String toString() {
        return "\t\t" + this.getIdCourse() + "\t\t" + this.getNameCourse() + "\t\t" + this.getStartDay() + "\t" + this.getEndDay()
                + "\t" + this.getPrice() + "\t\t" + this.getDescribe()
                + /*"\t\t"+ getRegisterDay()+ "\t\t"+ getEndDay()+*/ "\n";
    }

    //public static ArrayList<Course> courseList = new ArrayList<Course>();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Course> courseList = new ArrayList<Course>();

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
            courseList.remove(course);
            //studentDao.write(courseList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public ArrayList<Course> getcourseList() {
        return courseList;
    }

    public void setcourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }
    TestProject test = new TestProject();

}

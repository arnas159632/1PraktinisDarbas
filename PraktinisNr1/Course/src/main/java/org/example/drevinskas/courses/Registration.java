package org.example.drevinskas.courses;

import jakarta.xml.bind.annotation.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;


@XmlRootElement
@XmlType(propOrder = {"id", "date", "customers", "register"})
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "course_registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String date;

    @XmlElementWrapper(name="customers")
    @XmlElement(name="customer")
    @OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
    private List<Student> students;

    @XmlElementWrapper(name="courseName")
    @XmlElement(name="course")
    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    private List<Course> courses;

    public Registration(){}

    public Registration(int id, String date, List<Student> students, List<Course> courses) {
        this.id = id;
        this.date = date;
        this.students = students;
        this.courses = courses;
    }

    public Registration(String date, List<Student> students, List<Course> courses) {
        this.date = date;
        this.students = students;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Student> getCustomers() {
        return students;
    }

    public void setCustomers(List<Student> students) {
        this.students = students;
    }

    public List<Course> getRegister() {
        return courses;
    }

    public void setRegister(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return String.format("Order:\n\t Date = %s\n\t" +
                        "Customers: \n\t%s" +
                        "Register:\n\t\t%s",
                this.date,
                this.students,
                this.courses,
                constructCustomerString(),
                constructCourseString());
    }

    private String constructCustomerString(){
        String resultCustomer = "";
        for(Student student : this.students){
            resultCustomer += student.toString();
        }
        return resultCustomer;
    }

    private String constructCourseString(){
        String resultCourse = "";
        for(Course course : this.courses){
            resultCourse += course.toString();
        }
        return resultCourse;
    }
}

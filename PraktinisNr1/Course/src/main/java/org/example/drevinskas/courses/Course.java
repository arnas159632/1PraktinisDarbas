package org.example.drevinskas.courses;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String courseName; // book
    private String professor; // publisher
    private int price;

    public Course() {
    }


    public Course(String courseName, String professor, int studyLength, int price) {
        this.courseName = courseName;
        this.professor = professor;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("CourseName = %s\n\t\t\t\t" + "Professor = %s\n\t\t\t\t" +
                        "studylength = %s\n\t\t\t\t" + "Price = %s\n\t\t\t\t",
                this.courseName,
                this.professor,
                this.price);
    }
}

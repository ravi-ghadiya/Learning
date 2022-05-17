package org.example;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @Column(name = "s_name")
    private String name;

    @Column(name = "city")
    private String city;


    @Transient
    private double height;

    private Course course;

    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    @Lob
    private byte[] profileImg;

    public Student() {
    }

    public Student(String name, String city, double height, Course course, Date admissionDate, byte[] profileImg) {
        this.name = name;
        this.city = city;
        this.height = height;
        this.course = course;
        this.admissionDate = admissionDate;
        this.profileImg = profileImg;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public byte[] getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(byte[] profileImg) {
        this.profileImg = profileImg;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

package com.springcore.depInjection;

public class Example {
    private String subject;
    private Faculty faculty;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        System.out.println("setting faculty...");
        this.faculty = faculty;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        System.out.println("setting subject....");
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Example{" +
                "subject='" + subject + '\'' +
                ", faculty=" + faculty +
                '}';
    }

    public Example() {
        System.out.println("Bean Created!!");
    }


    public void init(){
        System.out.println("init: This method called after Bean properties has been set!!");
    }

    public void destroy(){
        System.out.println("destroy: This method called before destorying Bean!!");
    }

}

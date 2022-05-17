package com.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.*;

@Component
public class Person {
    @Value("${obj.name}")
    private String name;
    @Value("${obj.age}")
    private int age;
    private String primaryLanguage;

    String[] languages = {"Gujarati", "Hindi", "English"};

    List<String> colors = new ArrayList<>(Arrays.asList("Red","Green","Blue","Yellow","Black","White","Cyan","Violet","Grey","Orange","Silver"));

    Random random = new Random();

    File file = new File("colors.txt");

    @PostConstruct
    public void init(){

        //writing to a file
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < colors.size(); i++) {
                fileWriter.write(colors.get(i) + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading a file
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @PreDestroy
    public void destroy(){
        System.out.println("inside destroy method.........");
        if (file.delete()){
            System.out.println("File has been deleted : " + file.getName());
        }
        else {
            System.out.println("Some problem occurred while deleting the file.");
        }
    }

    public String getPrimaryLanguage(){
        int index = random.nextInt(languages.length);
        primaryLanguage = languages[index];
        return primaryLanguage;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", primaryLanguage=" + primaryLanguage +
                ", languages=" + Arrays.toString(languages) +
                ", random=" + random +
                '}';
    }
}

package com.example.fragmentonclick;

import com.example.fragmentonclick.Model.Student;

import java.util.ArrayList;

public class StoreClass {

    private static ArrayList<Student> studentList = new ArrayList<>();

    public static ArrayList<Student> getStudentList(){
        return studentList;
    }
    public static void addStudent(Student student){
        studentList.add(student);
    }

}

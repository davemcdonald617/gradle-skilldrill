package edu.isu.cs.cs2263.schedule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOManager {

    public static void main(String args[]) {

        List<Course> isaacCourses = new ArrayList<Course>();

        isaacCourses.add(new Course(1181, "CS", "Intro to Programming"));
        isaacCourses.add(new Course(2263, "CS", "Advanced OO Programming"));
        isaacCourses.add(new Course(4423, "CS", "Software Evolution"));

        List<Course> bobCourses = new ArrayList<Course>();

        bobCourses.add(new Course(1181, "CS", "Intro to Pro"));
        bobCourses.add(new Course(2263, "CS", "testval 1"));
        bobCourses.add(new Course(4423, "CS", "testval 2"));

        List<Course> sarahCourses = new ArrayList<Course>();

        sarahCourses.add(new Course(1181, "CS", "Intro to Pro"));
        sarahCourses.add(new Course(2263, "CS", "testval 1"));
        sarahCourses.add(new Course(4423, "CS", "testval 2"));

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Isaac", "Griffith",
                isaacCourses));

        students.add(new Student("Bob", "Sampson",
                bobCourses));

        students.add(new Student("Sarah", "James",
                bobCourses));

        // Call func to write out students list to students.json
        gsonSerializeList(students);
    }

    public static void gsonSerializeList(List<Student> students) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(students);

        //writes out to file students.json
        try { Files.writeString(Paths.get("./students.json"), json); }
        catch (IOException ex) { ex.printStackTrace(); }

        //System.out.println(json);


    }

}

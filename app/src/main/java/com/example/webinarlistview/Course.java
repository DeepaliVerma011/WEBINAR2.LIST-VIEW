package com.example.webinarlistview;

import java.util.ArrayList;
import java.util.Random;

public class Course {
    String name;
    String teachername;
    int lectures;

    public Course(String name, String teachername, int lectures) {
        this.name = name;
        this.teachername = teachername;
        this.lectures = lectures;
    }

    public String getName() {

        return name;
    }

    public String getTeachername() {
        return teachername;
    }

    public int getLectures() {
        return lectures;
    }

    public static final String[] teachers ={"Harshit","Arnav","Prateek","Ayush","Deepak","Garima"};
    public static final String[] courseNames ={"Launchpad","Crux","android","Nodejs","Angular","Python"};

    public static ArrayList<Course> generateNRandomCourses(int n){
ArrayList<Course> courses=new ArrayList<>();
Random r= new Random();
for(int i=0;i<=n;i++){
    Course course= new Course(

            teachers[r.nextInt(6)],
            courseNames[r.nextInt(6)],
            10+r.nextInt(10)

    );
    courses.add(course);
}
return courses;
    }
}

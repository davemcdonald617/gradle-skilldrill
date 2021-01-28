package edu.isu.cs.cs2263.schedule;

public class Course {

    int number;
    String subject;
    String title;

    public Course() {

    }

    public Course(int number, String subject, String title) {
        this.number = number;
        this.subject = subject;
        this.title = title;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return subject + '\'' +
                 number + '\'' +
                 title;
    }
}

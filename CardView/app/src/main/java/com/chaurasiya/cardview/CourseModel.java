package com.chaurasiya.cardview;

public class CourseModel {
    // Data needed to be inserted
    private String courseTitle;
    private int courseImage;
    // Constructor
    public CourseModel(String courseTitle, int courseImage) {
        this.courseTitle = courseTitle;
        this.courseImage = courseImage;
    }
    // Getters & Setters


    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

}

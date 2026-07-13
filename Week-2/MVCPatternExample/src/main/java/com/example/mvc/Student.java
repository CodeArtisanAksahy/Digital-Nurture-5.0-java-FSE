package com.example.mvc;

/**
 * Model class in the MVC Pattern.
 * 
 * The Model represents the data and business logic of the application.
 * It is independent of the user interface — it doesn't know about the
 * View or Controller. It simply holds the state and provides access to it.
 */
public class Student {

    // --- Student attributes (the data this model manages) ---
    private String name;
    private String id;
    private String grade;

    /**
     * Constructs a new Student with the given details.
     *
     * @param name  the student's name
     * @param id    the student's unique identifier
     * @param grade the student's current grade
     */
    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // ===================== Getters & Setters =====================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

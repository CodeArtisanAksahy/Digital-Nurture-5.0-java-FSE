package com.example.mvc;

/**
 * View class in the MVC Pattern.
 * 
 * The View is responsible for presenting data to the user.
 * It receives data from the Controller and renders it — but contains
 * NO business logic and does NOT directly access the Model.
 */
public class StudentView {

    /**
     * Displays student details in a nicely formatted block.
     * 
     * The View only knows HOW to display data; it doesn't know
     * WHERE the data comes from. The Controller feeds it.
     *
     * @param name  the student's name
     * @param id    the student's ID
     * @param grade the student's grade
     */
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║        STUDENT DETAILS           ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║  Name  : " + padRight(name, 23) + "║");
        System.out.println("║  ID    : " + padRight(id, 23) + "║");
        System.out.println("║  Grade : " + padRight(grade, 23) + "║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println();
    }

    /**
     * Helper to right-pad a string so the box stays aligned.
     */
    private String padRight(String text, int length) {
        if (text == null) {
            text = "N/A";
        }
        return String.format("%-" + length + "s", text);
    }
}

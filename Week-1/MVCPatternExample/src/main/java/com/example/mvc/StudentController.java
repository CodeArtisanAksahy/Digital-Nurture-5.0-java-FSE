package com.example.mvc;

/**
 * Controller class in the MVC Pattern.
 * 
 * The Controller acts as the intermediary between the Model and the View.
 * It:
 *   1. Receives input / commands (here, method calls).
 *   2. Manipulates the Model accordingly.
 *   3. Tells the View to refresh / re-render the data.
 * 
 * This separation means the Model never talks to the View directly,
 * and the View never modifies the Model directly.
 */
public class StudentController {

    // References to both the Model and the View
    private Student model;
    private StudentView view;

    /**
     * Constructs the controller with a Model and a View.
     *
     * @param model the Student model to manage
     * @param view  the StudentView to render data through
     */
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // ============ Delegated Getters (read from Model) ============

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentId() {
        return model.getId();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    // ============ Delegated Setters (write to Model) =============

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    // ============ View Refresh ===================================

    /**
     * Pulls the current data from the Model and pushes it to the View.
     * This is the key glue method that keeps everything in sync.
     */
    public void updateView() {
        view.displayStudentDetails(
            model.getName(),
            model.getId(),
            model.getGrade()
        );
    }
}

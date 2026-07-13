package com.example.mvc;

/**
 * Exercise 10 — MVC (Model-View-Controller) Pattern Demo
 * 
 * ┌────────────────────────────────────────────────────────────────┐
 * │                        MVC Pattern                            │
 * │                                                               │
 * │   User ──▶ Controller ──▶ Model                               │
 * │                │              │                                │
 * │                ▼              │ (data)                         │
 * │              View ◀───────────┘                                │
 * │                │                                               │
 * │                ▼                                               │
 * │            Display                                             │
 * └────────────────────────────────────────────────────────────────┘
 * 
 * Key Idea:
 *   • Model      – holds the data and business rules.
 *   • View       – renders the data for the user.
 *   • Controller – coordinates between Model and View.
 * 
 * Benefits:
 *   • Separation of concerns: each layer has one job.
 *   • The Model can change without touching the View, and vice versa.
 *   • Easy to unit-test each layer in isolation.
 */
public class MVCPatternTest {

    public static void main(String[] args) {

        System.out.println("=== Exercise 10: MVC Pattern Demo ===\n");

        // ────────── Step 1: Create the Model ──────────
        // The model is just raw data — it doesn't know how it will be displayed.
        Student model = retrieveStudentFromDatabase();

        // ────────── Step 2: Create the View ──────────
        // The view only knows how to print; it doesn't know where data comes from.
        StudentView view = new StudentView();

        // ────────── Step 3: Create the Controller ──────────
        // The controller wires the model and view together.
        StudentController controller = new StudentController(model, view);

        // ────────── Step 4: Display initial student details ──────────
        System.out.println(">>> Initial student details (via Controller):");
        controller.updateView();

        // ────────── Step 5: Update student data through the Controller ──────────
        // Notice: we NEVER touch the Model directly from the "user" side.
        // All mutations go through the Controller.
        System.out.println(">>> Updating student details via Controller...");
        System.out.println("    - Name  : Aarav → Priya");
        System.out.println("    - Grade : A     → A+\n");

        controller.setStudentName("Priya Sharma");
        controller.setStudentGrade("A+");

        // ────────── Step 6: Display updated student details ──────────
        System.out.println(">>> Updated student details (via Controller):");
        controller.updateView();

        // ────────── Bonus: Show that Model state changed correctly ──────────
        System.out.println(">>> Direct read from Controller getters:");
        System.out.println("    Name  = " + controller.getStudentName());
        System.out.println("    ID    = " + controller.getStudentId());
        System.out.println("    Grade = " + controller.getStudentGrade());
        System.out.println();

        System.out.println("=== MVC Pattern Demo Complete ===");
    }

    /**
     * Simulates fetching a student record from a database.
     * In a real app this would query a DB or call a REST API.
     */
    private static Student retrieveStudentFromDatabase() {
        return new Student("Aarav Kumar", "STU-1001", "A");
    }
}

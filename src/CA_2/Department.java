/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author Marwan
 */
public class Department {
    private String name; // Name of the department (e.g., FRONT_END, BACK_END)

    public Department(String name) {
        this.name = name.toUpperCase(); // Normalize to uppercase
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.replace("_", " "); // Clean display
    }
}

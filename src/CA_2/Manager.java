/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author Marwan
 */
public class Manager {
    private String type; // Type of the manager (e.g., CTO, TECHNICAL_LEAD)

    public Manager(String type) {
        this.type = type.toUpperCase(); // Normalize to uppercase for consistency
    }

    public String getType() {
        return type;
    }
    
    

    @Override
    public String toString() {
        return type.replace("_", " "); // Replace underscores for display
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author Marwan
 */
public class Employee {
    private String name;// Employee name
    private String lastname;
    private Manager manager; // Manager object
    private Department department; // Department object

    public Employee(String name,String lastname, Manager manager, Department department) {
        this.name = name;
        this.lastname = lastname;
        this.manager = manager;
        this.department = department;
    }

    public String getName() {
        return name;
    }
    
    public String getLsatname(){
    return lastname;
    }

    public Manager getManager() {
        return manager;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " - "+lastname+ " - " + manager + " - " + department; // Display format
    }
}

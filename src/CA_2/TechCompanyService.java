/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author Marwan
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class TechCompanyService {
     private List<Employee> employeeList = new ArrayList<>(); // Store employees from add or random

    // Handle sorting from file
    public void handleSort() {
        List<String> names = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File("Applicants_Form.txt"))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (!line.isEmpty() && !line.toLowerCase().startsWith("full name")) {
                    names.add(line);
                } // Read and trim each name
            }

            mergeSort(names, 0, names.size() - 1); // Sort using merge sort

            System.out.println("\nTop 20 Sorted Names:");
            for (int i = 0; i < Math.min(20, names.size()); i++) {
                System.out.println((i + 1) + ". " + names.get(i)); // Print first 20 names
            }

        } catch (FileNotFoundException e) {
            System.out.println("Applicants_Form.txt not found! Please make sure the file is in the root directory.");
        }
    }
  
    // Merge sort algorithm for sorting names
    private void mergeSort(List<String> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    // Merge helper function
    private void merge(List<String> list, int left, int mid, int right) {
        List<String> temp = new ArrayList<>(list.subList(left, right + 1));
        int i = 0, j = mid - left + 1, l = left;

        while (i <= mid - left && j <= right - left) {
            if (temp.get(i).compareToIgnoreCase(temp.get(j)) <= 0) {
                list.set(l++, temp.get(i++));
            } else {
                list.set(l++, temp.get(j++));
            }
        }

        while (i <= mid - left) {
            list.set(l++, temp.get(i++));
        }
        while (j <= right - left) {
            list.set(l++, temp.get(j++));
        }
    }

    
    

    

}

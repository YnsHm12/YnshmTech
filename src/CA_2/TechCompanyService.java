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
import java.io.FileWriter;
import java.io.IOException;


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
  
// Handle searching in file
    public void handleSearch(Scanner sc) {
        List<String> names = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File("Applicants_Form.txt"))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (!line.isEmpty() && !line.toLowerCase().startsWith("full name")) {
                    names.add(line);
                }
            }
            // Sort names by full name for binary search
            names.sort(Comparator.comparing(s -> {
                String[] parts = s.split(",");
                if (parts.length > 1) {
                    return (parts[0] + " " + parts[1]).toLowerCase(); // first + last
                } else {
                    return s.toLowerCase();
                }
            }));

            // Input from user
            System.out.print("Enter  the full name to search: ");
            String target = sc.nextLine().trim().toLowerCase(); // Get user input
            // Binary search
            int index = binarySearchName(names, target);
            if (index >= 0) {
                System.out.println("Found: " + names.get(index));
            } else {
                System.out.println("Not found! pleas try to enter the full name ");
            }

        } catch (FileNotFoundException e) {
            System.out.println(" Applicants_Form.txt not found! Please make sure the file is in the root directory.");
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

    // Binary search for names (String list)
    private int binarySearchName(List<String> list, String target) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            String[] parts = list.get(mid).split(",");
            String fullName = (parts[0] + " " + parts[1]).toLowerCase();

            int cmp = fullName.compareTo(target);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
}

package task1;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV1 {
    public static void main(String[] args) {
        try {
            // Load the unsorted file into an array
            //You will have to update this file path with the one from your computer
            Student[] students = FileUtils.readFile("C:\\Users\\User\\IdeaProjects\\DS-2022-2023-HW2_Task1_Without_Optional_Part\\Global_University_Students.csv");

            // Sort the array using merge sort
            MergeSort.sort(students);

            // Save the sorted array into a new CSV file
            FileUtils.writeToFile(students, "sorted_students.csv");

            System.out.println("Loading the students...");
            System.out.println("Sorting the student array...");
            System.out.println("Saving the sorted file...");
            System.out.println("==================================");
            System.out.println("System is ready.");
            System.out.println("\n");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Ask the user to type in a student ID they want to find, or -1 to close the program
                System.out.print("Enter the ID of the student you want to retrieve, or -1 to close the program: ");
                int id = scanner.nextInt();

                if (id == -1) {
                    System.out.println("Thank you for using the student search system.");
                    break;
                }

                // Reset numSteps counter before starting search
                BinarySearch.numSteps = 0;

                // Run binary search on the sorted student array
                int index = BinarySearch.search(students, id);

                // If the student is found
                if (index != -1) {
                    Student student = students[index];
                    System.out.println("Student ID: " + student.getId());
                    System.out.println("Name and surname " + student.getFullName());
                    System.out.println("Date of birth: " + student.getDob());
                    System.out.println("University: " + student.getUniversityName());
                    System.out.println("Department code: " + student.getDepartmentCode());
                    System.out.println("Department: " + student.getDepartmentName());
                    System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                    System.out.println("\n");
                    System.out.println("The student was retrieved in  " + BinarySearch.numSteps + " steps.");
                } else {
                    // If the student is not found
                    System.out.println("The student with the requested ID does not exist.\n The search was completed in " + BinarySearch.numSteps + " steps.");
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an error reading or writing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }
}

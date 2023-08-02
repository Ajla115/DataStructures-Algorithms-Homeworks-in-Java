package task2;
import task1.Student;

import java.io.FileNotFoundException;
import java.util.Scanner;
public class StudentSearchV2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RedBlackTree<Integer, Student> tree;

        // Load the file into the Red-Black Tree
        try {
            //You will have to update this file path with the one from your computer
            tree = FileUtils.readFile("C:\\Users\\User\\IdeaProjects\\DS-2022-2023_Homework2_Ajla_Korman\\Global_University_Students.csv");  // Replace with your actual file path
         } catch (FileNotFoundException e) {
            System.err.println("File not found. Please make sure the file exists and try again.");
            return;  // In case the file is not found, the program will be exited
        }

        System.out.println("Loading the students into the tree...");
        System.out.println("The tree was built with " + tree.countRedLinks() + " red links.");
        System.out.println("==================================");
        System.out.println("System is ready.");
        System.out.println("\n");

        while (true) {

            System.out.println("Enter the student ID you want to retrieve, or -1 to exit:");
            String input = scanner.nextLine();
            if (input.equals("-1")  || input.isEmpty()) {
                System.out.println("Thank you for using the student search system.");
                break;
            }
            try {
                int id = Integer.parseInt(input);
                Student student = tree.get(id);
                if (student != null) {
                    //If the student is found, print out all information regarding that student
                    System.out.println("Full Name: " + student.getFullName());
                    System.out.println("Date of Birth: " + student.getDateOfBirth());
                    System.out.println("University Name: " + student.getUniversityName());
                    System.out.println("Department Code: " + student.getDepartmentCode());
                    System.out.println("Department Name: " + student.getDepartmentName());
                    System.out.println("Year of Enrollment: " + student.getYearOfEnrollment() + "\n");
                    System.out.println("The student was retrieved in " + tree.numSteps + " steps.");
                } else {
                    //In case the student was not found
                    System.out.println("The student with the request ID does not exist..");
                    System.out.println("The search was completed in " + tree.numSteps + " steps.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid student ID.");
            }
        }
        scanner.close();
    }
}


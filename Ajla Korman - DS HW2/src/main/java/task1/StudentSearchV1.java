package task1;

import java.util.Comparator;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentSearchV1 {
    public static void main(String[] args) {
        try {
            // Load the unsorted file into an array
            //You will have to update this file path with the one from your computer
            Student[] students = FileUtils.readFile("C:\\Users\\User\\IdeaProjects\\DS-2022-2023_Homework2_Ajla_Korman\\Global_University_Students.csv");
            FileUtils.writeToFile(students, "sorted_students.csv"); //the result will be saved into this file

            System.out.println("Loading the students...");
            System.out.println("Sorting the student array...");
            System.out.println("Saving the sorted file...");
            System.out.println("==================================");
            System.out.println("System is ready.");
            System.out.println("\n");

            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.print("Enter -1 to quit or type in 'start' to continue: ");
                String input = scanner.nextLine();

                // Check if the user wants to exit the program
                if (input.equals("-1")) {
                    System.out.println("Thank you for using the student search system.");
                    break;
                }

                if (input.equals("start")) {

                    //Part 4. Ask user to input search criteria
                    System.out.print("Enter the field you want to search by (id, fullName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrollment). \nPlease write them the same way they are shown to you in this text here!\nYour chosen field is: ");
                    String field = scanner.nextLine();

                    System.out.print("Enter the value you want to search for: ");
                    String value = scanner.nextLine();

                    Student key;
                    Comparator<Student> comparator1 = null;

                    //Part 4. Using switch loop to cover each case that user might choose as field
                    switch (field) {
                        case "id":
                            key = new Student(Integer.parseInt(value), null, null, null, null, null, 0);
                            break;
                        case "fullName":
                            key = new Student(0, value, null, null, null, null, 0);
                            comparator1 = new FullNameComparator();
                            break;
                        case "dateOfBirth":
                            key = new Student(0, null, value, null, null, null, 0);
                            comparator1 = new DateOfBirthComparator();
                            break;
                        case "universityName":
                            key = new Student(0, null, null, value, null, null, 0);
                            comparator1 = new UniversityNameComparator();
                            break;
                        case "departmentCode":
                            key = new Student(0, null, null, null, value, null, 0);
                            comparator1 = new DepartmentCodeComparator();
                            break;
                        case "departmentName":
                            key = new Student(0, null, null, null, null, value, 0);
                            comparator1 = new DepartmentNameComparator();
                            break;
                        case "yearOfEnrollment":
                            key = new Student(0, null, null, null, null, null, Integer.parseInt(value));
                            comparator1 = new YearOfEnrollmentComparator();
                            break;
                        default:
                            System.out.println("Invalid field.\nPlease try again.\nAlso, choose one of the offered fields from above. ");
                            continue;
                    }

                    MergeSort.sort(students, comparator1);

                    // Reset numSteps counter before starting search
                    BinarySearch.numSteps = 0;

                    int index = BinarySearch.search(students, key, comparator1);


                    // If the student is found
                    if (index != -1) {
                        Student student = students[index];
                        System.out.println("Student ID: " + student.getId());
                        System.out.println("Name and surname " + student.getFullName());
                        System.out.println("Date of birth: " + student.getDateOfBirth());
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
            }

        } catch(FileNotFoundException e){
            System.out.println("File is not found: " + e.getMessage());
        } catch(IOException e){
            System.out.println("There was an error reading or writing file: " + e.getMessage());
        } catch(NumberFormatException e){
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }
}





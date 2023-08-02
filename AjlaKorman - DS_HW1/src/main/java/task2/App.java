package task2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        while (true) {  //infinitive loop so that input can be entered multiple times, and not just once
            System.out.println("Enter '1' to input an arithmetic expression or '2' to use a file or '3' to exit the program:");
            int choice = scanner.nextInt(); //this is used to read an integer
            scanner.nextLine();             //consumes the \n character which is left after clicking on the Enter

            if (choice == 1) {
                System.out.println("Enter an arithmetic expression:");
                String s2 = scanner.nextLine();
                try {
                    double result = Algorithm.calculate(s2);
                    System.out.println("Result: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice == 2) {
                System.out.println("Enter the whole and specific file path:");
                String filePath = scanner.nextLine();
                ArrayList<Double> results = Algorithm.calculateFromFile(filePath);
                System.out.println("The results of mathematics calculations from numbers saved in the file are:");
                for (double result : results) {
                    System.out.println(result);
                }
            } else if (choice == 3) {
                System.out.println("You have just exited the program.\nGoodbye and see you next time!");
                break;
            } else {
                System.out.println("Invalid choice. If you don't remember, possible options are:\n1-input an arithmetic expressions\n2-use a file\n3-exit the program");
            }
        }

        scanner.close();
    }
}

//C:\Users\User\IdeaProjects\DS-2022-2023_Homework1\src\test\resources\expressions.txt
package task2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class FileUtils {
    public static ArrayList<String> readFile(String filePath) throws FileNotFoundException {  //If the file doesn't exist, method will throw an exception

        ArrayList<String> lines = new ArrayList<>();
        //a string arraylist was created, that will store elements

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        //Scanner will be created that will read input from the file

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        /*while the files has elements, these elements will be inputted by the scanner and stored into variable line.
         Afterwards, they will be added to a String arraylist called lines.
         A built-in arraylist function add() will be used for that.*/

        scanner.close();
        //by closing the scanner, the system resources are freed

        return lines;
    }
}


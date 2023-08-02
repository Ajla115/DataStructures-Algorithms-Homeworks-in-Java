package task2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import task1.Student;

public class FileUtils {
    public static RedBlackTree<Integer, Student> readFile(String filePath) throws FileNotFoundException {
        RedBlackTree<Integer, Student> tree = new RedBlackTree<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] studentData = scanner.nextLine().split(";");
                int id = Integer.parseInt(studentData[0]);
                String fullName = studentData[1];
                String dateOfBirth = studentData[2];
                String universityName = studentData[3];
                String departmentCode = studentData[4];
                String departmentName = studentData[5];
                int yearOfEnrollment = Integer.parseInt(studentData[6]);

                Student student = new Student(id, fullName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrollment);
                tree.put(id, student);

                /*This block of code will read all lines from the file, then it will split each line into fields using
                the split(";") method, and it will create a new Student object from the fields, and adds the Student
                object to the tree with the student's id as the key. */
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    }
}

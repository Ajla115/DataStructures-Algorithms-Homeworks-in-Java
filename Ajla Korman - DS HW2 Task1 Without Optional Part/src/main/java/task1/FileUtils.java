package task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;

//FileUtils class which is used to open and read a file, and also to write into a new file
public class FileUtils {

    //This read function, will read all lines from the file whose file path was given in the main function,
    // and it will return an array containing the Student objects
    public static Student[] readFile(String filePath) throws FileNotFoundException {
        //the exception was specified in the case what to do if the file could not be found

        //Arraylist to store student objects that are read from the file
        List<Student> students = new ArrayList<>();

            //Try & Catch block
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;

                //Reading each line of the file (until we reach the end)
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    // Assumes CSV file structure matches Student class
                    //creating new student object and setting its properties and then adding it to the students array (to keep track of it)
                    Student student = new Student();
                    student.setId(Integer.parseInt(values[0]));
                    student.setFullName(values[1]);
                    student.setDob(values[2]);
                    student.setUniversityName(values[3]);
                    student.setDepartmentCode(values[4]);
                    student.setDepartmentName(values[5]);
                    student.setYearOfEnrollment(Integer.parseInt(values[6]));
                    students.add(student);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return students.toArray(new Student[0]);
        }


    //This function will create  a new CSV (Comma-Separated-Values) file that will contain array of Student objects
        public static void writeToFile (Student[]students, String filePath) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

                //Iterating over each student and then writing each value
                for (Student student : students) {
                    bw.write(String.join(";",
                            //here, we're joining them by the semi-colon (;) because in the read function we have seperated them by the same semi-colon
                            String.valueOf(student.getId()), student.getFullName(), student.getDob(),
                            student.getUniversityName(), student.getDepartmentCode(),
                            student.getDepartmentName(), String.valueOf(student.getYearOfEnrollment())));
                    bw.newLine();
                }
            }
        }
    }


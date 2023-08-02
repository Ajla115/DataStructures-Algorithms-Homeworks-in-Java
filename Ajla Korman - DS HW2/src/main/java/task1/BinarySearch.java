package task1;
import java.util.Comparator;



public class BinarySearch {

    // track the number of iterations needed for a search to complete
    public static int numSteps = 0;



    public static int search(Student[] students, Student key, Comparator<Student> comparator) {
        numSteps = 0; // Reset step counter for each new search
        int left = 0;
        int right = students.length - 1;

        while (left <= right) {
            numSteps++; // Counting the steps
            int mid = left + (right - left) / 2;
            int result;


            numSteps++; // Increment step count for each iteration

            if (comparator == null) {
                // If no comparator is provided, compare by ID
                result = students[mid].getId() - key.getId();
            } else {
                // If a comparator is provided, use it for comparison
                result = comparator.compare(students[mid], key);
            }

            // Check if the key is present at the mid index
            if (result == 0) {
                return mid;
            }

            // If key is greater, ignore the left half
            if (result < 0) {
                left = mid + 1;
            }
            // If key is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // If we have made it to this point without a match, it means that the element does not exist
        return -1;
    }
}
package task1;

public class BinarySearch {
    // track the number of iterations needed for a search to complete
    public static int numSteps = 0;

        public static int search(Student[] students, int key) {
            numSteps = 0; // Reset step counter for each new search
            int left = 0;
            int right = students.length - 1;

            while (left <= right) {
                numSteps++; // Count the step
                int mid = left + (right - left) / 2;

                // Check if the key is present at the mid index
                if (students[mid].getId() == key) { // direct comparison here
                    return mid;
                }

                // If key is greater, ignore the left half
                if (students[mid].getId() < key) { // and here
                    left = mid + 1;
                }
                // If key is smaller, ignore the right half
                else {
                    right = mid - 1;
                }
            }

            // If we reach here, then the element was not present
            return -1;
        }
    }
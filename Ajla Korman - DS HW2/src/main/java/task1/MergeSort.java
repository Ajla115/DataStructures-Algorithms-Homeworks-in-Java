package task1;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    public static void sort(Student[] students,  Comparator<Student> comparator) {
        if (students.length < 2) {
            return;
        }
        //if the length of the array is smaller than 2, then this array will already be sorted
        //if otherwise, split the array into two halves and perform sorting part on them
        //after, they are sorted, just merge them

        int mid = students.length / 2;
        Student[] left = Arrays.copyOfRange(students, 0, mid);
        Student[] right = Arrays.copyOfRange(students, mid, students.length);

        sort(left, comparator);
        sort(right, comparator);
        merge(students, left, right, comparator);
    }

    private static void merge(Student[] students, Student[] left, Student[] right,  Comparator<Student> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator != null) {

                // If comparator is provided, use it for sorting
                if (comparator.compare(left[i], right[j]) <= 0) {
                    students[k++] = left[i++];
                } else {
                    students[k++] = right[j++];
                }
            } else {
                // If no comparator provided, sort by id
                if (left[i].getId() <= right[j].getId()) {
                    students[k++] = left[i++];
                } else {
                    students[k++] = right[j++];
                }
            }
        }
        while (i < left.length) {
            students[k++] = left[i++];
        }

        while (j < right.length) {
            students[k++] = right[j++];
        }
    }
}





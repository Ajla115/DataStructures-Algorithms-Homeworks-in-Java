package task1;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

    public static void sort(Student[] students) {
        if (students.length < 2) {
            return;
        }

        //if the length of the array is smaller than 2, then this array will already be sorted
        //if otherwise, split the array into two halves and perform sorting part on them
        //after, they are sorted, just merge them

        int mid = students.length / 2;
        Student[] left = Arrays.copyOfRange(students, 0, mid);
        Student[] right = Arrays.copyOfRange(students, mid, students.length);

        sort(left);
        sort(right);
        merge(students, left, right);
    }

    private static void merge(Student[] students, Student[] left, Student[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                students[k++] = left[i++];
            } else {
                students[k++] = right[j++];
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

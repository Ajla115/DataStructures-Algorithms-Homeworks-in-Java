package task1;
import java.util.Comparator;



//Criteria: Year Of Enrollment
public class YearOfEnrollmentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getYearOfEnrollment(), s2.getYearOfEnrollment());
    }
}
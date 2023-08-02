package task1;
import java.util.Comparator;

//Criteria: Full Name
public class FullNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getFullName().compareTo(s2.getFullName());
    }

}

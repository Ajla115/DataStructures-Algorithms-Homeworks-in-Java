package task1;
import java.util.Comparator;

//Criteria: University Name
public class UniversityNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getUniversityName().compareTo(s2.getUniversityName());
    }
}

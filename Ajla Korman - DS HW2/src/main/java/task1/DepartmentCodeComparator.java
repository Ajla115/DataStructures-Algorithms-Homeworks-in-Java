package task1;
import java.util.Comparator;


//Criteria: Department Code
public class DepartmentCodeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getDepartmentCode().compareTo(s2.getDepartmentCode());
    }
}
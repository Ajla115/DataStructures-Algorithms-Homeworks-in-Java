package task1;
import java.util.Comparator;


//Criteria: Department Name
public class DepartmentNameComparator  implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getDepartmentName().compareTo(s2.getDepartmentName());
    }
}

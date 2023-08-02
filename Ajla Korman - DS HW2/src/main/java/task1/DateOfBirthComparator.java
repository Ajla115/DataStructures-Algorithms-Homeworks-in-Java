package task1;
import java.util.Comparator;

//Criteria: Date Of Birth
public class DateOfBirthComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getDateOfBirth().compareTo(s2.getDateOfBirth());
    }

}

/*This Comparator is a built-in Java interface for comparing.
In this case it will compare Students objects based on their date of birth.
First, these values are retrieved using the get methods.
For the comparison a built-in compareTo method of this interface is used.
How does this method work is that it will look at the ASCII chart to find the numerical values for the characters
 if they are written in form of a text,
if they are written like numbers, their ASCII chart value will be compared. And then character by character from each object is compared.
Character 0 from student s1, and character 0 from student s2. A negative integer will be returned if s1 is smaller than s2,
zero if they are equal and positive integer if s1 is bigger than s2.

The same process is in all other Comparator classes in this task.
 */

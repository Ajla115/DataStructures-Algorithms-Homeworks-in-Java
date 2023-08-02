package task1;

//Student class
public class Student implements Comparable<Student> {

    //attributes/properties of Student class
    private int id;
        private String fullName;
        private String dob;
        private String universityName;
        private String departmentCode;
        private String departmentName;
        private int yearOfEnrollment;

    // Getters (get methods) to retrieve values in other parts of the program
    public int getId() {
            return id;
        }

    public String getFullName() {
        return fullName;
    }

    public String getDob() {
        return dob;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    //Setters (set methods) to set new value for a certain variable
    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }

       /*This compareTo method compares the id of the current Student instance (this.id)
        with the id of the Student instance that is passed as a parameter (other.id).
        The return value is the difference between this.id and other.id.
        If the result is a negative number, that means this.id is less than other.id.
        If the result is zero, that means this.id is equal to other.id.
        If the result is a positive number, that means this.id is greater than other.id.
        */
}


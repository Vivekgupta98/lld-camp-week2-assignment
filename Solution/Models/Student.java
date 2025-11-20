package Solution.Models;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    List<Enrollment> enrollments;
    public Student(int id,String name, String email){
        super(id,name,email);
        enrollments = new ArrayList<Enrollment>();
    }
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }
}

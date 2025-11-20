package Solution.Service.EnrollmentRepo;

import Solution.Models.Course;
import Solution.Models.Enrollment;
import Solution.Models.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEnrollmentRepo implements IEnrollmentRepository{
    List<Enrollment> enrollments;

    public InMemoryEnrollmentRepo() {
        enrollments = new ArrayList<Enrollment>();
    }
    @Override
    public Enrollment findById(int id) {
        for(Enrollment enrollment : enrollments){
            if(enrollment.getId() == id){
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public Enrollment findByStudentAndCourse(Student student, Course course) {
        for(Enrollment enrollment : enrollments){
            if(enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course)){
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }
}

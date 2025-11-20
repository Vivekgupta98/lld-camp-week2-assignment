package Solution.Service.EnrollmentRepo;

import Solution.Models.Course;
import Solution.Models.Enrollment;
import Solution.Models.Student;

public interface IEnrollmentRepository {
    public Enrollment findById(int id);
    public Enrollment findByStudentAndCourse(Student student, Course course);
    public void save(Enrollment enrollment);
}

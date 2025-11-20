package Solution.Service.CourseRepo;

import Solution.Models.Course;
import Solution.Models.Instructor;

import java.util.List;

public interface ICourseRepository {
    public Course findById(int id);
    public List<Course> findByInstructor(Instructor instructor);
    public void save(Course course);

    public void addInstructor(Instructor instructor);
}

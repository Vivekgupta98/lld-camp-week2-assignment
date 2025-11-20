package Solution.Service.CourseRepo;

import Solution.Models.Course;
import Solution.Models.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCourseRepo implements ICourseRepository{
    List<Course>courses;
    List<Instructor> instructors;

    public InMemoryCourseRepo(){
        courses = new ArrayList<>();
        instructors = new ArrayList<>();
    }
    @Override
    public Course findById(int id) {
        for(Course course: courses){
            if(course.getId() == id){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByInstructor(Instructor instructor) {
        List<Course> courses = new ArrayList<>();
        for(Course course: courses){
            for(Instructor in: instructors){
                if(in.getId() == instructor.getId()){
                    courses.add(course);
                }
            }
        }
        return courses;
    }

    @Override
    public void save(Course course) {
        courses.add(course);
    }

    @Override
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }
}

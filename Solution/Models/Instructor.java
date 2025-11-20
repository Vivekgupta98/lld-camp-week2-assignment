package Solution.Models;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    private List<Course>courses;
    public Instructor(int id, String username, String email) {
        super(id, username, email);
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
    public List<Course> getCourses() {
        return courses;
    }
}

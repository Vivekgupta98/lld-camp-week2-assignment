package Solution.Models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enrollment {
    private int id;
    private Date enrollmentDate;
    private EnrollmentStatus status;
    private float progressPercentage;
    private Course course;
    private Student student;
    private Map<Module, EnrollmentStatus> moduleEnrollmentStatusMap;
    private Map<Lesson, EnrollmentStatus> lessonEnrollmentStatusMap;

    public Enrollment(int id, Date enrollmentDate, EnrollmentStatus status, Course course, Student student) {
        this.id = id;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.course = course;
        this.student = student;
        this.progressPercentage = 0;
        this.moduleEnrollmentStatusMap = new HashMap<>();
        this.lessonEnrollmentStatusMap = new HashMap<>();

        for(Module module : course.getModules()) {
            moduleEnrollmentStatusMap.put(module, EnrollmentStatus.ACTIVE);
            for(Lesson lesson : module.getLessons()) {
                lessonEnrollmentStatusMap.put(lesson, EnrollmentStatus.ACTIVE);
            }
        }

    }
    public float getProgressPercentage() {
        return progressPercentage;
    }
    public void markLessonCompleted(Lesson lesson) {
        List<Module> modules = course.getModules();
        for(Module module : modules) {
            if(module.getLessons().contains(lesson)) {
                lessonEnrollmentStatusMap.remove(lesson);
                lessonEnrollmentStatusMap.put(lesson, EnrollmentStatus.COMPLETED);
            }
        }
        updateEnrollmentStatus();
    }

    public void updateEnrollmentStatus(){
        List<Module> modules = course.getModules();
        boolean isAllModulesComplete = true;
        for(Module module : modules) {
           boolean isAllLessonsComplete = true;
            for(Lesson lesson : module.getLessons()) {
                if(lessonEnrollmentStatusMap.get(lesson).equals(EnrollmentStatus.ACTIVE)) {
                    isAllLessonsComplete = false;
                    break;
                }
            }
            if(isAllLessonsComplete) {
               moduleEnrollmentStatusMap.remove(module);
               moduleEnrollmentStatusMap.put(module, EnrollmentStatus.COMPLETED);
            }else {
                isAllModulesComplete = false;
            }
        }
        if(isAllModulesComplete) {
            status = EnrollmentStatus.COMPLETED;
        }
        updateEnrollmentPercentage();
    }

    public void updateEnrollmentPercentage(){
        int numberOfCompletedLessons = 0;
        for(Lesson lesson : lessonEnrollmentStatusMap.keySet()) {
            if(lessonEnrollmentStatusMap.get(lesson).equals(EnrollmentStatus.COMPLETED)) {
                numberOfCompletedLessons++;
            }
        }
        this.progressPercentage = (float) numberOfCompletedLessons / lessonEnrollmentStatusMap.size();
    }
    public int getId() {
        return id;
    }
    public Course getCourse() {
        return course;
    }
    public Student getStudent() {
        return student;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }
}

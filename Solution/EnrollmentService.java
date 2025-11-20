package Solution;

import Solution.Models.Course;
import Solution.Models.Enrollment;
import Solution.Models.EnrollmentStatus;
import Solution.Models.Instructor;
import Solution.Models.Lesson;
import Solution.Models.Student;
import Solution.Service.CourseRepo.ICourseRepository;
import Solution.Service.EnrollmentRepo.IEnrollmentRepository;
import Solution.Service.NotificationRepo.INotificationChannel;

import java.util.Date;

public class EnrollmentService {
    private ICourseRepository courseRepo;
    private IEnrollmentRepository enrollRepo;
    private INotificationChannel notificationChannel;
    private int enrollmentId;

    public EnrollmentService(ICourseRepository courseRepo, IEnrollmentRepository enrollRepo,
                             INotificationChannel notificationChannel) {
        this.courseRepo = courseRepo;
        this.enrollRepo = enrollRepo;
        this.notificationChannel = notificationChannel;
        this.enrollmentId = 1;
    }

    public Enrollment enroll(Student student, Course course) {
       //logic for Enrollment
        Enrollment enrollment = new Enrollment(this.enrollmentId++, new Date(), EnrollmentStatus.ACTIVE,course,student);
        student.addEnrollment(enrollment);
        enrollRepo.save(enrollment);
        String message = "Email to " + student.getName() + ": You have been enrolled in Course: "+ course.getTitle();
        sendMail(student,message);
        return enrollment;
    }
    public void completeLesson(Enrollment enrollment, Lesson lesson) {
        enrollment.markLessonCompleted(lesson);
        this.enrollRepo.save(enrollment);
        if(enrollment.getStatus().equals(EnrollmentStatus.COMPLETED)) {
            String message = "Email to " + enrollment.getStudent().getName() + ": You have been Completed the Course: "+ enrollment.getCourse().getTitle();
            sendMail(enrollment.getStudent(),message);
        }
    }

    public void addInstructor(Instructor instructor) {
        this.courseRepo.addInstructor(instructor);
    }

    public void addCourse(Course course) {
        this.courseRepo.save(course);
    }

    public void sendMail(Student student, String message) {
        this.notificationChannel.sendNotification(student,message);
    }
}

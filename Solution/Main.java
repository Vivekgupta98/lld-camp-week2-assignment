package Solution;

import Solution.Models.Course;
import Solution.Models.Enrollment;
import Solution.Models.EnrollmentStatus;
import Solution.Models.Instructor;
import Solution.Models.Lesson;
import Solution.Models.Module;
import Solution.Models.Student;
import Solution.Service.CourseRepo.ICourseRepository;
import Solution.Service.CourseRepo.InMemoryCourseRepo;
import Solution.Service.EnrollmentRepo.IEnrollmentRepository;
import Solution.Service.EnrollmentRepo.InMemoryEnrollmentRepo;
import Solution.Service.NotificationRepo.EmailNotificationChannel;
import Solution.Service.NotificationRepo.INotificationChannel;

public class Main {
    public static void main(String[] args) {
        ICourseRepository courseRepository = new InMemoryCourseRepo();
        IEnrollmentRepository enrollmentRepository = new InMemoryEnrollmentRepo();
        INotificationChannel notificationChannel = new EmailNotificationChannel();

        EnrollmentService service = new EnrollmentService(courseRepository, enrollmentRepository, notificationChannel);

        Instructor instructor = new Instructor(1, "david", "david@gmail.com");
        Course course = new Course(1,"java learning", "java learning");

        Module module = new Module(1,"variables");

        Lesson lesson1 = new Lesson(1,"what is variable?", "https://blob-storage.com",35);
        Lesson lesson2 = new Lesson(2,"how to use it?", "https://blob-storage.com", 20);

        module.addLesson(lesson1);
        module.addLesson(lesson2); //creating module with 2 lessons

        course.addModule(module); //creating course with 1 module

        service.addCourse(course); //Store the course using your InMemoryCourseRepository.

        Student student = new Student(1,"ambani", "ambani@gmail.com");

        service.addInstructor(instructor); //add instructor to inMemory repo

        //Call EnrollmentService.enroll(student, course).
        Enrollment enrollment = service.enroll(student,course);

        //Notification Sent to student

        //Call a method (e.g. completeLesson) multiple times to simulate the student finishing lessons.
        service.completeLesson(enrollment,lesson1);

        System.out.println("The current enrollment status is : " + enrollment.getStatus());
        System.out.println("The current completion percentage is: " + enrollment.getProgressPercentage());

        service.completeLesson(enrollment,lesson2);
        System.out.println("The current enrollment status is : " + enrollment.getStatus());
        System.out.println("The current completion percentage is: " + enrollment.getProgressPercentage());

//        String message;
//        if(enrollment.getStatus().equals(EnrollmentStatus.COMPLETED)) {
//            message = "Email to " + student.getName() + ": You have been Completed the Course: "+ course.getTitle();
//            service.sendMail(student,message);
//        }

    }
}

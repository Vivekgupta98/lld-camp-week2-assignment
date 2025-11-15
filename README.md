# Mini LMS – Implementation Task (Language of Your Choice)

## 1. Goal

Implement a **Mini Learning Management System (LMS)** using **any object-oriented language** you like (C++, Java, Python, C#, etc.).

You'll:

- Write a set of related classes and interfaces.
- Wire them together in a small **demo / `main`** program and run it.

Here is the UML Diagram:

![UML Design](UML_Design.png)

## 3. What to Run (Demo / Main Program)

Write a **demo program** (`main`, `App`, script, etc.) that does at least this:

1.**Create data**

- An `Instructor`
- A `Course` with:
- At least **1 `Module`**
- Each module with at least **2 `Lesson`s**

2.**Save data**

- Store the course using your `InMemoryCourseRepository`.

3.**Create a student**

- Make a `Student` object.

4.**Wire the service**

- Instantiate:

-`InMemoryCourseRepository`

-`InMemoryEnrollmentRepository`

-`EmailNotificationChannel` (and/or `SmsNotificationChannel`)

-`EnrollmentService` using the above.

5.**Enroll and complete lessons**

- Call `EnrollmentService.enroll(student, course)`.
- Call a method (e.g. `completeLesson`) multiple times to simulate the student finishing lessons.

6.**Print final state**

- Print enrollment status (e.g. `ACTIVE` → `COMPLETED`).
- Print final progress (e.g. `100%`).
- Ensure your notification classes print messages like:

-`Email to <student>: You have been enrolled in <course>`

-`Email to <student>: You have completed the course <course>`

---

## 4. Summary Checklist

You’re done when you have:

- [ ] All classes / interfaces listed above implemented.
- [ ] In-memory repository classes that store and retrieve objects.
- [ ] `EnrollmentService` that:
- [ ] Enrolls students.
- [ ] Updates progress when lessons are completed.
- [ ] Uses notification channels.
- [ ] A `main` / demo that:
- [ ] Creates instructor, student, course, module(s), lesson(s).
- [ ] Enrolls a student.
- [ ] Simulates completing lessons.
- [ ] Prints final status and progress.
- [ ] Shows notifications in console/log.

That’s it—**design in code, then run your demo** 🚀

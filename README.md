# Mini LMS – Implementation Task (Language of Your Choice)

## 1. Goal

Implement a **Mini Learning Management System (LMS)** using **any object-oriented language** you like (C++, Java, Python, C#, etc.).

You’ll:

- Write a set of related classes and interfaces.
- Wire them together in a small **demo / `main`** program and run it.

No UML file is given here; you just follow the type list and behaviour requirements.

---

## 2. What to Write (Classes / Interfaces)

### 2.1. User & Roles

Create these classes:

-`User`

-`Student` (inherits from `User`)

-`Instructor` (inherits from `User`)

> Make them represent the idea of a generic user, a learner, and a teacher.

---

### 2.2. Course Structure

Create these classes:

-`Course`

-`Module`

-`Lesson`

> Make `Course` contain modules, and `Module` contain lessons.

---

### 2.3. Enrollment & Status

Create:

-`Enrollment`

-`EnrollmentStatus` (enum / similar, e.g. `ACTIVE`, `COMPLETED`, `CANCELLED`)

> `Enrollment` should link a `Student` to a `Course` and track completion progress.

---

### 2.4. Notification

Create:

- Interface/abstract type: `INotificationChannel`
- Implementations:

-`EmailNotificationChannel`

-`SmsNotificationChannel`

> Each concrete notifier should have a method (e.g. `send(user, message)`) that **prints** to console/log to simulate a real notification.

---

### 2.5. Repositories (In-Memory)

Create interfaces:

-`ICourseRepository`

-`IEnrollmentRepository`

Then create simple in-memory implementations, e.g.:

-`InMemoryCourseRepository`

-`InMemoryEnrollmentRepository`

> Use lists/maps/arrays to store data in memory. No real database needed.

---

### 2.6. Service Layer

Create:

-`EnrollmentService`

This class should:

- Use the repositories.
- Use at least one `INotificationChannel`.
- Provide methods to:
- Enroll a student into a course.
- Mark a lesson as completed for an enrollment and update progress.

---

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

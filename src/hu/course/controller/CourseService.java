package hu.course.controller;

import hu.course.model.domain.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {

    private final List<Course> courses;

    public CourseService(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 2.feladat
     */
    public int getCourseCount() {
        return courses.size();
    }

    /**
     * 3. feldat
     */
    public int getTotalLessonCount() {
        return courses.stream()
                .mapToInt(Course::getWeeklyLessonNumber)
                .sum();
    }

    /**
     * 4. feladat
     */
    public int getTeacherWeeklyLesson(String teacher) {
        return courses.stream()
                .filter(i -> i.isTeacher(teacher))
                .mapToInt(Course::getWeeklyLessonNumber)
                .sum();
    }

    /**
     * 5. feladat
     */
    public List<String> getMasterTeachers() {
        return courses.stream()
                .filter(i -> i.isSubject("osztalyfonoki"))
                .map(Course::toString)
                .collect(Collectors.toList());
    }

    /**
     * 6. feladat
     */
    public String getCourseStatus(String classId, String subject) {
        long count = getCertainCourseCount(classId, subject);
        if (count == 0) {
            return "Nem";
        } else {
            return count == 1 ? "Osztályszinten" : "Csoportbontásban";
        }
    }

    private long getCertainCourseCount(String classId, String subject) {
        return courses.stream()
                .filter(i -> i.isClassAndSubject(classId, subject))
                .count();
    }

    /**
     * 7. feladat
     */
    public long getTeacherCount() {
        return courses.stream()
                .map(Course::getTeacher)
                .distinct()
                .count();
    }
}

package hu.course.model.domain;

public class Course {

    private final String teacher;
    private final String subject;
    private final String classId;
    private final int weeklyLessonNumber;

    public Course(String teacher, String subject, String classId, int weeklyLessonNumber) {
        this.teacher = teacher;
        this.subject = subject;
        this.classId = classId;
        this.weeklyLessonNumber = weeklyLessonNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public boolean isTeacher(String teacher) {
        return this.teacher.equals(teacher);
    }

    public boolean isSubject(String subject) {
        return this.subject.equals(subject);
    }

    public boolean isClassAndSubject(String classId, String subject) {
        return this.classId.equals(classId) && isSubject(subject);
    }

    public int getWeeklyLessonNumber() {
        return weeklyLessonNumber;
    }

    @Override
    public String toString() {
        return classId + " - " + teacher;
    }
}

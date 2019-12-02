package Model;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private List<Instructor> instructors;
    private List<Student> students;
    //                  student1    student2    student3
    // assignment1      90          80          70
    // assignment2      50          80          70
    // assignment3      60          80          99dw
    private List<Assignment> assignments;
    private List<Exam> exams;
    private double examContributes;
    private double assignmentContributes;
    private String courseName;
    private String courseNumber;

    public Roster(String courseName, String courseNumber,double examContributes, double assignmentContributes) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.examContributes = examContributes;
        this.assignmentContributes = assignmentContributes;
        this.instructors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.exams = new ArrayList<>();
    }



    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void addInstructor(Instructor instructor) {
        this.getInstructors().add(instructor);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        this.getStudents().add(student);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addAssignment(Assignment assignment) {
        this.getAssignments().add(assignment);
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void addExam(Exam exam) {
        this.getExams().add(exam);
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public double getExamContributes() {
        return examContributes;
    }

    public void setExamContributes(double examContributes) {
        this.examContributes = examContributes;
    }

    public double getAssignmentContributes() {
        return assignmentContributes;
    }

    public void setAssignmentContributes(double assignmentContributes) {
        this.assignmentContributes = assignmentContributes;
    }
}

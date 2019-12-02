package Model;

public class StudentAssignmentScore extends ScoreBase {
    private Student student;
    private double assignmentScore ;


    public StudentAssignmentScore(Student student, double assignmentScore) {
        this.student = student;
        this.assignmentScore = assignmentScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }
}

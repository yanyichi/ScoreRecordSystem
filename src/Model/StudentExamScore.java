package Model;

public class StudentExamScore extends ScoreBase {
    private Student student;
    private double examScore ;

    public StudentExamScore(Student student, double examScore) {
        this.student = student;
        this.examScore = examScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }
}

package Model;

import Service.GradeTool;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private int examId;
    private String examName;
    private List<StudentExamScore> studentExamScores;
    private Roster roster;

    public Exam(int examId, String examName,  Roster roster) {
        this.examId = examId;
        this.examName = examName;
        this.studentExamScores = new ArrayList<>();
        this.roster = roster;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public List<StudentExamScore> getStudentExamScores() {
        return studentExamScores;
    }

    public void addStudentExamScore(Student student,double studentExamScore) {
        this.studentExamScores.add(new StudentExamScore(student,studentExamScore));
        GradeTool.gradeToolSingleton().notifyObservers(student,this.roster);
    }

    public double getStudentExamScore(Student student){
        for(StudentExamScore studentExamScore:this.studentExamScores){
            if(student.getStudentId() == studentExamScore.getStudent().getStudentId()){
                return studentExamScore.getExamScore();
            }
        }
        return -1;
    }
}

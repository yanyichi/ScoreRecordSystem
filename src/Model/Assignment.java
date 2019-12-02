package Model;

import Service.GradeTool;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private int assignmentId;
    private String assignmentName;
    private List<StudentAssignmentScore> assignmentScores;
    private Roster roster;

    public Assignment(int assignmentId, String assignmentName, Roster roster) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentScores = new ArrayList<>();
        this.roster = roster;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public List<StudentAssignmentScore> getAssignmentScores() {
        return assignmentScores;
    }

    public void addAssignmentScore(Student student, double assignmentScore) {
        this.assignmentScores.add(new StudentAssignmentScore(student,assignmentScore));
        GradeTool.gradeToolSingleton().notifyObservers(student,this.roster);
    }
    public double getAssignmentScore(Student student){
        for(StudentAssignmentScore studentAssignmentScore:this.assignmentScores){
            if(student.getStudentId() == studentAssignmentScore.getStudent().getStudentId()){
                return studentAssignmentScore.getAssignmentScore();
            }
        }
        return -1;
    }

}

package Service;

import Model.*;

import java.util.*;

public class GradeTool {


    private List<GradeTrackerObserver> observers =new ArrayList<>();

    //singleton
    private static GradeTool gradeToolSingleton =new GradeTool();
    private GradeTool() {}

    public static GradeTool gradeToolSingleton() {
        return gradeToolSingleton;
    }


    //subscribe obs
    public void addObserver(GradeTracker obs) {
        observers.add(obs);
    }

    public void removeObserver(GradeTracker obs) {
        observers.remove(obs);
    }

    public void notifyObservers(Student student, Roster roster) {
        for (GradeTrackerObserver obs : observers) {
            System.out.println(student.getFirstName() +" " +student.getLastName() + " current score is "+ obs.currentScoreTracker(student,roster));
        }
    }



    private double getTotalExamScore(List<Exam> exams, Student student){
        double totalExamScore = 0;
        for(Exam exam: exams){
            for(StudentExamScore studentExamScore:exam.getStudentExamScores()) {
                if(studentExamScore.getStudent().getStudentId().equals(student.getStudentId())) {
                    totalExamScore += studentExamScore.getExamScore();
                }
            }
        }
        return totalExamScore;
    }

    private double getTotalAssignmentScore(List<Assignment> assignments, Student student){
        double totalAssignmentScore = 0;
        for(Assignment assignment: assignments){
            for(StudentAssignmentScore studentAssignmentScore: assignment.getAssignmentScores()){
                if(studentAssignmentScore.getStudent().getStudentId().equals(student.getStudentId())) {
                    totalAssignmentScore += studentAssignmentScore.getAssignmentScore();
                }
            }
        }
        return totalAssignmentScore;
    }


    public double findStudentRosterGrade(Student student, Roster roster){
        double totalExamScore = getTotalExamScore(roster.getExams(),student);
        double totalAssignmentScore = getTotalAssignmentScore(roster.getAssignments(), student);

        return totalExamScore/roster.getExams().size()*roster.getExamContributes() + totalAssignmentScore/roster.getAssignments().size()* roster.getAssignmentContributes();
    }

    public double findStudentRosterGradeWithDropAssignment(Student student, Roster roster, int dropDegree){

        //      s1  s2  s3
//        a1    80  85  90
//        a2    71  73  72
//        a3    90  95  100
        int assignmentSize =roster.getAssignments().size();
        List<StudentAssignmentScore> thisStudentAssignmentScores = new ArrayList<>();
        if(assignmentSize<=dropDegree){
            return findStudentRosterGrade( student, roster);
        }
        else {
            //find this student all assignment score => list
            for (Assignment assignment : roster.getAssignments()) {
                for (StudentAssignmentScore studentAssignmentScore : assignment.getAssignmentScores()) {
                    if (studentAssignmentScore.getStudent().getStudentId().equals( student.getStudentId())) {
                        thisStudentAssignmentScores.add(studentAssignmentScore);
                    }
                }
            }

//            sort this student assignmentScore list
            Collections.sort(thisStudentAssignmentScores, (StudentAssignmentScore s1, StudentAssignmentScore s2) -> {
                if (s1.getAssignmentScore() < s2.getAssignmentScore()) {
                    return -1;
                } else if (s1.getAssignmentScore() > s2.getAssignmentScore()) {
                    return 1;
                } else
                    return 0;
            });
            // 71 80 90
            //find total assignment score after drop lowest n assignment
            double newTotalStudentAssignmentScore = 0;
            for (int i = dropDegree; i < assignmentSize; i++) {
                newTotalStudentAssignmentScore += thisStudentAssignmentScores.get(i).getAssignmentScore();
            }

            double totalExamScore = getTotalExamScore(roster.getExams(), student);
            return totalExamScore / roster.getExams().size() * roster.getExamContributes() + newTotalStudentAssignmentScore / (roster.getAssignments().size()-dropDegree) * roster.getAssignmentContributes();

        }
    }

    public double findRosterAvg(Roster roster){
        double classTotalScore = 0;
        for(Student student: roster.getStudents()){
            classTotalScore+=findStudentRosterGrade(student,roster);
        }
        return classTotalScore/roster.getStudents().size();
    }


    public String getFinalGrade(Student student, Roster roster){
        double studentCurrentScore = GradeTool.gradeToolSingleton().findStudentRosterGrade(student, roster);
        if(studentCurrentScore>=90){
            return "A";
        }
        else if(studentCurrentScore<90 && studentCurrentScore>=80){
            return "B";
        }
        else if(studentCurrentScore<80 && studentCurrentScore>=70){
            return "C";
        }
        else if(studentCurrentScore<70 && studentCurrentScore>=60){
            return "D";
        }
        else{
            return "F";
        }
    }
}



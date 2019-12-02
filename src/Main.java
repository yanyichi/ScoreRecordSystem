import Model.*;
import Service.GradeTool;
import Service.GradeTracker;

public class Main {
    public static void main(String[] args) {

//        GradeTracker studentGradeTracker = new GradeTracker();
//        GradeTracker parentsGradeTracker = new GradeTracker();
//        GradeTracker teacherGradeTracker = new GradeTracker();

        GradeTool.gradeToolSingleton().addObserver(new GradeTracker());

        Roster roster = new Roster("cs101","100",0.6,0.4);
        Student student1 = new Student("Ryan",	"Roberts", "000001");
        Student student2 = new Student("Eric",	"Scott", "000002");
        Student student3 = new Student("Jack",	"Foster", "000003");

        Assignment assignment1 = new Assignment(13243242,"assignment1",roster);
        Assignment assignment2 = new Assignment(13243243,"assignment2",roster);
        Assignment assignment3 = new Assignment(13243244,"assignment3",roster);
        Assignment assignment4 = new Assignment(13243245,"assignment4",roster);
        Assignment assignment5 = new Assignment(13243246,"assignment5",roster);

        Exam exam1 = new Exam(423432123,"exam1",roster);
        Exam exam2 = new Exam(423432124,"exam2",roster);
        Exam exam3 = new Exam(423432125,"exam3",roster);

        roster.addStudent(student1);
        roster.addStudent(student2);
        roster.addStudent(student3);
        roster.addAssignment(assignment1);
        roster.addAssignment(assignment2);
        roster.addAssignment(assignment3);
        roster.addAssignment(assignment4);
        roster.addAssignment(assignment5);
        roster.addExam(exam1);
        roster.addExam(exam2);
        roster.addExam(exam3);


        assignment1.addAssignmentScore(student1,90);
        assignment2.addAssignmentScore(student1,88);
        assignment3.addAssignmentScore(student1,60);
        assignment4.addAssignmentScore(student1,85);
        assignment5.addAssignmentScore(student1,92);
//
//        assignment1.addAssignmentScore(student2,80);
//        assignment2.addAssignmentScore(student2,87);
//        assignment3.addAssignmentScore(student2,76);
//        assignment4.addAssignmentScore(student2,81);
//        assignment5.addAssignmentScore(student2,91);
//
//        assignment1.addAssignmentScore(student3,70);
//        assignment2.addAssignmentScore(student3,85);
//        assignment3.addAssignmentScore(student3,90);
//        assignment4.addAssignmentScore(student3,95);
//        assignment5.addAssignmentScore(student3,88);


        exam1.addStudentExamScore(student1,94);
        exam2.addStudentExamScore(student1,99);
        exam3.addStudentExamScore(student1,91);
//
//        exam1.addStudentExamScore(student2,81);
//        exam2.addStudentExamScore(student2,88);
//        exam3.addStudentExamScore(student2,95);
//
//
//        exam1.addStudentExamScore(student3,70);
//        exam2.addStudentExamScore(student3,75);
//        exam3.addStudentExamScore(student3,88);

        //(90+88+60+85+92)/5*0.4  + (94+99+91)/3*0.6 = 90.0
        System.out.println(GradeTool.gradeToolSingleton().findStudentRosterGrade(student1,roster));
        //(90+88+85+92)/4*0.4  + (94+99+91)/3*0.6 = 92.3
        System.out.println(GradeTool.gradeToolSingleton().findStudentRosterGradeWithDropAssignment(student1,roster,1));

        System.out.println(GradeTool.gradeToolSingleton().findRosterAvg(roster));


        System.out.println(GradeTool.gradeToolSingleton().getFinalGrade(student1,roster));

    }
}

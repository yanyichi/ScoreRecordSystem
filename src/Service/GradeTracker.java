package Service;

import Model.Roster;
import Model.Student;

public class GradeTracker implements GradeTrackerObserver {
    @Override
    public double currentScoreTracker(Student student, Roster roster) {
        return  GradeTool.gradeToolSingleton().findStudentRosterGrade(student, roster);
    }


}

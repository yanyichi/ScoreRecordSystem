package Service;

import Model.Roster;
import Model.Student;

public interface GradeTrackerObserver {
    double currentScoreTracker(Student student, Roster roster);

}

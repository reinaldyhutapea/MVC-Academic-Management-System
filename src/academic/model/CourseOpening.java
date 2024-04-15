package academic.model;
import java.util.ArrayList;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */

public class CourseOpening {
    private String courseCode;
    private String academicYear;
    private String semester;
    private ArrayList<String> lecturers;

    public CourseOpening(String courseCode, String academicYear, String semester, ArrayList<String> lecturers) {
        this.courseCode     = courseCode;
        this.academicYear   = academicYear;
        this.semester       = semester;
        this.lecturers      = lecturers;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getAcademicYear() {
        return academicYear;
    }
    public String getSemester() {
        return semester;
    }
    public ArrayList<String> getLecturers() {
        return lecturers;
    }
    @Override
    public String toString() {
        return courseCode + "|" + academicYear + "|" + semester + "|" + lecturers;
    }
}

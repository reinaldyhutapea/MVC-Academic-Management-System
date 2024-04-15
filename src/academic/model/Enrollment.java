package academic.model;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */

public class Enrollment {
    private String studentId;
    private String courseId;
    private String academicYear;
    private String semester;
    private String grade;
    private String previousGrade = null;

    public Enrollment(String studentId, String courseId, String academicYear, String semester) {
        this.studentId      = studentId;
        this.courseId       = courseId;
        this.academicYear   = academicYear;
        this.semester       = semester;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getCourseId() {
        return courseId;
    }
    public String getAcademicYear() {
        return academicYear;
    }
    public String getSemester() {
        return semester;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getPreviousGrade() {
        return previousGrade;
    }
    public void setPreviousGrade(String previousGrade) {
        this.previousGrade = previousGrade;
    }
    @Override
    public String toString() {
        if (previousGrade != null) {
            return courseId + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade + "(" + previousGrade + ")";
        } else {
            return courseId + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
        }
    }
}

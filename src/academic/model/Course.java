package academic.model;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */

public class Course {
    private String code;
    private String name;
    private String credits;
    private String grade;

    public Course(String code, String name, String credits, String grade) {
        this.code       = code;
        this.name       = name;
        this.credits    = credits;
        this.grade  = grade;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getCredits() {
        return credits;
    }
    public String getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}

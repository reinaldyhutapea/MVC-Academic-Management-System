package academic.model;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */

public class Lecturer<T extends PersonDetail> extends Person<T> {
    private String initial;
    private String email;
    private String studyprogram;

    public Lecturer(String id, String name, String initial, String email, String studyprogram) {
        super(id, name);
        this.initial        = initial;
        this.email          = email;
        this.studyprogram   = studyprogram;
    }
    public String getInitial() {
        return initial;
    }
    public String getEmail() {
        return email;
    }
    public String getStudyprogram() {
        return studyprogram;
    }
    @Override
    public String toString() {
        return getId() + "|" + getName() + "|" + initial + "|" + email + "|" + studyprogram;
    }
}

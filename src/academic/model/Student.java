package academic.model;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */

public class Student<T extends PersonDetail> extends Person<T> {
    private String year;
    private String major;

    public Student(String id, String name, String year, String major) {
        super(id, name);
        this.year   = year;
        this.major  = major;
    }
    public String getYear() {
        return year;
    }
    public String getMajor() {
        return major;
    }
    @Override
    public String toString() {
        return getId() + "|" + getName() + "|" + year + "|" + major;
    }
}

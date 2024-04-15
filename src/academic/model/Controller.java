package academic.model;
import java.util.HashMap;
import java.util.Map;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */
public class Controller {
    private final Executor model;
    private final Map<String, CommandProcessor> commandMap;

    public Controller(Executor model) {
        this.model = model;
        this.commandMap = initializeCommandMap();
    }

    public void processCommand(String command, String[] data) {
        CommandProcessor processor = commandMap.get(command);
        if (processor != null) {
            processor.process(data);
        } else {
            System.out.println("Invalid command: " + command);
        }
    }

    private Map<String, CommandProcessor> initializeCommandMap() {
        Map<String, CommandProcessor> map = new HashMap<>();
        map.put("course-add", data          -> model.addCourse(data));
        map.put("student-add", data         -> model.addStudent(data));
        map.put("enrollment-add", data      -> model.addEnrollment(data));
        map.put("lecturer-add", data        -> model.addLecturer(data));
        map.put("enrollment-grade", data    -> model.addEnrollmentGrade(data));
        map.put("student-details", data     -> model.studentDetails(data));
        map.put("enrollment-remedial", data -> model.enrollmentRemedial(data));
        map.put("course-open", data         -> model.courseOpen(data));
        map.put("course-history", data      -> model.courseHistory(data));
        return map;
    }

    // Functional interface for command processing
    @FunctionalInterface
    private interface CommandProcessor {
        void process(String[] data);
    }
}

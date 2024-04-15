package academic.model;
import java.util.*;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */
public class Executor {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<PersonDetail> persons = new ArrayList<>();
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private HashMap<String, String> previousGrades = new HashMap<>();
    private ArrayList<CourseOpening> courseOpenings = new ArrayList<>();
    private HashMap<String, String> courseToLecturerInitial = new HashMap<>();

    public void addCourse(String[] data) {
        String code     = data[1];
        String name     = data[2];
        String credits  = data[3];
        String grade    = data[4];
        Course newCourse = new Course(code, name, credits, grade);
        courses.add(newCourse);
    }

    public void addStudent(String[] data) {
        String id       = data[1];
        String name     = data[2];
        String year     = data[3];
        String major    = data[4];
        boolean isRegistered = persons.stream()
                .anyMatch(person -> person instanceof Student && ((Student<?>) person).getId().equals(id));
        if (!isRegistered) {
            Student<PersonDetail> newStudent = new Student<>(id, name, year, major);
            persons.add(newStudent);
        }
    }

    public void addLecturer(String[] data) {
        String id           = data[1];
        String name         = data[2];
        String initial      = data[3];
        String email        = data[4];
        String studyprogram = data[5];
    
        boolean isRegistered = persons.stream()
                .anyMatch(person -> person instanceof Lecturer && person.getId().equals(id));
    
        if (!isRegistered) {
            Lecturer<PersonDetail> newLecturer = new Lecturer<>(id, name, initial, email, studyprogram);
            persons.add(newLecturer);
        }
    }
    
    public void addEnrollment(String[] data) {
        String courseId     = data[1];
        String studentId    = data[2];
        String academicYear = data[3];
        String semester     = data[4];

        boolean validCourse = false;
                boolean validStudent = false;
                for (Course course : courses) {
                    if (course.getCode().equals(courseId)) {
                        validCourse = true;
                        break;
                    }
                }

                for (PersonDetail person : persons) {
                    if (person instanceof Student && person.getId().equals(studentId)) {
                        validStudent = true;
                        break;
                    }
                }

                if (validCourse && validStudent) {
                    Enrollment newEnrollment = new Enrollment(studentId, courseId, academicYear, semester);
                    enrollments.add(newEnrollment);
                } else if (!validCourse) {
                    System.out.println("invalid course|" + courseId);
                } else {
                    System.out.println("invalid student|" + studentId);
                }
            }

    public void addEnrollmentGrade(String[] data) {
        String courseId     = data[1];
        String studentId    = data[2];
        String academicYear = data[3];
        String semester     = data[4];
        String grade        = data[5];

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId().equals(courseId) &&
                    enrollment.getStudentId().equals(studentId) &&
                    enrollment.getAcademicYear().equals(academicYear) &&
                    enrollment.getSemester().equals(semester)) {
                    previousGrades.put(courseId + studentId + academicYear + semester, enrollment.getGrade());
                    enrollment.setGrade(grade);         break;
            }
        }
    }

    public void enrollmentRemedial(String[] data) {
        String courseId     = data[1];
        String studentId    = data[2];
        String academicYear = data[3];
        String semester     = data[4];
        String grade        = data[5];

        boolean isExistRemedial = false;
        for (Enrollment remedial : enrollments) {
            if (remedial.getStudentId().equals(studentId) && remedial.getCourseId().equals(courseId)
                    && remedial.getAcademicYear().equals(academicYear)) {
                        { 
                            if (remedial.getPreviousGrade() == null) {
                            isExistRemedial = false;
                        } else {
                            isExistRemedial = true;
                        }
            }
        }

        if (!isExistRemedial) {
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getCourseId().equals(courseId) &&
                        enrollment.getStudentId().equals(studentId) &&
                        enrollment.getAcademicYear().equals(academicYear) &&
                        enrollment.getSemester().equals(semester) && enrollment.getGrade() != null) {
                    if (enrollment.getPreviousGrade() == null) {
                        String previousGrade = enrollment.getGrade();
                        enrollment.setPreviousGrade(previousGrade);
                        enrollment.setGrade(grade);
                    }
                }
            }
        }
    }
}
    public void courseOpen(String[] data) {
        String courseCode       = data[1];
        String academicYear     = data[2];
        String semester         = data[3];
        String[] lecturerList   = data[4].split(",");
        ArrayList<String> lecturers = new ArrayList<>(Arrays.asList(lecturerList));
        CourseOpening newCourseOpening = new CourseOpening(courseCode, academicYear, semester, lecturers);
        courseOpenings.add(newCourseOpening);

        ArrayList<String> lecturerInitials = new ArrayList<>();
        ArrayList<String> lecturerEmails = new ArrayList<>();
        for (String lecturer : lecturers) {
            courseToLecturerInitial.put(courseCode, lecturer);
            Lecturer<?> matchedLecturer = null;
            for (PersonDetail person : persons) {
                if (person instanceof Lecturer && ((Lecturer<?>) person).getInitial().equals(lecturer)) {
                    matchedLecturer = (Lecturer<?>) person;
                    break;
                }
            }
            if (matchedLecturer != null) {
                lecturerInitials.add(lecturer);
                lecturerEmails.add(matchedLecturer.getEmail());
            }
        }
    }

    public void courseHistory(String[] data) {
        String courseCode = data[1];
        Collections.sort(courseOpenings, (o2, o1) -> o1.getSemester().compareTo(o2.getSemester()));

        for (CourseOpening opening : courseOpenings) {
            if (opening.getCourseCode().equals(courseCode)) {
                Person<?> person = null;
                String lecturerInitial = "IUS";
                for (Course course : courses) {
                    System.out.println(opening.getCourseCode() + "|" + course.getName() + "|" + course.getCredits() + "|" + course.getGrade() + "|" + opening.getAcademicYear() + "|" + opening.getSemester() + "|" + lecturerInitial + " (" + (person != null && person instanceof Lecturer<?> ? ((Lecturer<?>) person).getEmail() : "iustisia.simbolon@del.ac.id") + ")");
                }
                for (Enrollment enrollment : enrollments) {
                    if (enrollment.getCourseId().equals(opening.getCourseCode()) && enrollment.getAcademicYear().equals(opening.getAcademicYear()) && enrollment.getSemester().equals(opening.getSemester())) {
                        System.out.println(enrollment.toString());
                    }
                }
            }
        }
    }   

    public void studentDetails(String[] data) {
        String studentId        = data[1];
        boolean isExistRemedial = false;
        ArrayList<Enrollment> studentRemedial = new ArrayList<>();
        for (Enrollment remedial : studentRemedial) {
            if (remedial.getStudentId().equals(studentId)) {
                isExistRemedial = true;
                break;
            }
        }
        if (isExistRemedial) {
            return;
        }
        Student<?> selectedStudent = null;
        for (PersonDetail person : persons) {
            if (person instanceof Student<?> && person.getId().equals(studentId)) {
                selectedStudent = (Student<?>) person;
                break;
            }
        }
        if (selectedStudent == null) {
            return;
        }
        String[] Crs    = new String[100];
        int index       = 0;
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
                Crs[index] = enrollment.getCourseId();
                for (int i = 0; i < index; i++) {
                    if (Crs[index].equals(Crs[i])) {
                        studentEnrollments.remove(i);
                    }
                }
                studentEnrollments.add(enrollment);
                index++;
            }
        }

                double gpa = calculateGPA(studentEnrollments);
                System.out.print(selectedStudent.toString());
                System.out.print("|" + String.format("%.2f", gpa));
                int totalCredits = getTotalCredits(studentEnrollments);
                System.out.println("|" + totalCredits);
            }
        //code method for print all data
        public void printAll() {
            // print lecturer
            for (PersonDetail person : persons) {
                if (person instanceof Lecturer) {
                    Lecturer<?> lecturer = (Lecturer<?>) person;
                    System.out.println(lecturer.toString());
                }
            }
            // print course
            for (Course course : courses) {
                System.out.println(course.toString());
            }
            // print student 
            for (PersonDetail person : persons) {
                if (person instanceof Student) {
                    Student<?> student = (Student<?>) person;
                    System.out.println(student.toString());
                }
            }

            // print enrollment
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment.toString());
            }
        }
                


    private double calculateGPA(ArrayList<Enrollment> enrollments) {
        double totalGradePoints = 0;
        int totalCredits        = 0;
        for (Enrollment enrollment : enrollments) {
            for (Course course : courses) {
                if (enrollment.getCourseId().equals(course.getCode())) {
                    int credits = Integer.parseInt(course.getCredits());
                    totalCredits += credits;
                    String grade = enrollment.getGrade();
                    switch (grade) {
                        case "A":   totalGradePoints += 4.0 * credits;  break;
                        case "AB":  totalGradePoints += 3.5 * credits;  break;
                        case "B":   totalGradePoints += 3.0 * credits;  break;
                        case "BC":  totalGradePoints += 2.5 * credits;  break;
                        case "C":   totalGradePoints += 2.0 * credits;  break;
                        case "D":   totalGradePoints += 1.0 * credits;  break;
                        case "E":   totalGradePoints += 0.0 * credits;  break;
                        default:                                        break;
                    }break;
                }
            }
        }
        if (totalCredits == 0 || totalGradePoints == 0) {
            return 0;
        }
        return totalGradePoints / totalCredits;
    }
    private int getTotalCredits(ArrayList<Enrollment> enrollments) {
        int totalCredits = 0;
        for (Enrollment enrollment : enrollments) {
            for (Course course : courses) {
                if (enrollment.getCourseId().equals(course.getCode())) {
                    int credits = Integer.parseInt(course.getCredits());
                    totalCredits += credits;
                    break;
                }
            }
        }
        return totalCredits;
    }
}

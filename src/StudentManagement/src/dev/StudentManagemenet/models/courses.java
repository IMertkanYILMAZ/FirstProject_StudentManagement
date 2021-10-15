package StudentManagement.src.dev.StudentManagemenet.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private float creditScore;

    @ManyToMany
    private List<students> studentsList = new ArrayList<>();
    @ManyToOne
    private lecturers lecturer;

    // CONSTRUCTORS

    public courses(String courseName, String courseCode, float creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }
    public courses() {
    }


    // GETTER & SETTERS

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public float getCreditScore() {
        return creditScore;
    }
    public void setCreditScore(float creditScore) {
        this.creditScore = creditScore;
    }

    public List<students> getStudentsList() {
        return studentsList;
    }

    public lecturers getLecturer() {
        return lecturer;
    }

    public void setLecturer(lecturers lecturer) {
        this.lecturer = lecturer;
    }

    // EQUAL HASH toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        courses courses = (courses) o;
        return Float.compare(courses.creditScore, creditScore) == 0 && Objects.equals(courseName, courses.courseName) && Objects.equals(courseCode, courses.courseCode);
    }
    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, creditScore);
    }
    @Override
    public String toString() {
        return "courses{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }
}

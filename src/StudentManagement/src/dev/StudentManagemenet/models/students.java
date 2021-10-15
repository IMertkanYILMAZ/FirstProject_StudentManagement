package StudentManagement.src.dev.StudentManagemenet.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;

    @ManyToMany(mappedBy = "studentsList")
    private List<courses> coursesList = new ArrayList<>();

    //CONSTRUCTORS

    public students(String name, LocalDate birthDate, String address, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }
    public students() {
    }

    // GETTER & SETTERS

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<courses> coursesList) {
        this.coursesList = coursesList;
    }

// EQUAL HASH toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        students students = (students) o;
        return Objects.equals(name, students.name) && Objects.equals(birthDate, students.birthDate) && Objects.equals(address, students.address) && Objects.equals(gender, students.gender);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, address, gender);
    }
    @Override
    public String toString() {
        return "students{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

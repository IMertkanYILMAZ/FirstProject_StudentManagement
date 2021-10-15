package StudentManagement.src.dev.StudentManagemenet.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class lecturers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "lecturer")
    private List<courses> coursesList = new ArrayList<>();

    // CONSTRUCTORS

    public lecturers(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public lecturers() {
    }

    // GETTERS & SETTERS

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<courses> coursesList) {
        this.coursesList = coursesList;
    }

    // HASH STRING EQUAL

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        lecturers lecturers = (lecturers) o;
        return Objects.equals(name, lecturers.name) && Objects.equals(address, lecturers.address) && Objects.equals(phoneNumber, lecturers.phoneNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber);
    }
    @Override
    public String toString() {
        return "lecturers{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

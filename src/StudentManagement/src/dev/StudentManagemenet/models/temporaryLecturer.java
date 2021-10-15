package StudentManagement.src.dev.StudentManagemenet.models;

import javax.persistence.Entity;

@Entity
public class temporaryLecturer extends lecturers {

    private float hourlySalary;

    public temporaryLecturer(String name, String address, String phoneNumber, float salary) {
        super(name, address, phoneNumber);
        this.hourlySalary = salary;
    }
    public temporaryLecturer(float salary) {
        this.hourlySalary = salary;
    }
    public temporaryLecturer(){}

    public float getHourlySalary() {
        return hourlySalary;
    }
    public void setHourlySalary(float hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "temporaryLecturer{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}

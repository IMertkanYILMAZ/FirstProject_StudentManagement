package StudentManagement.src.dev.StudentManagemenet.models;

import javax.persistence.Entity;

@Entity
public class permanentLecturer extends lecturers {

    private float salary;

    public permanentLecturer(String name, String address, String phoneNumber, float salary) {
        super(name, address, phoneNumber);
        this.salary = salary;
    }
    public permanentLecturer(float salary) {
        this.salary = salary;
    }
    public permanentLecturer() {}

    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "permanentLecturer{" +
                "salary=" + salary +
                '}';
    }
}

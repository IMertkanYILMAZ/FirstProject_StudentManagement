package StudentManagement.Repository;

import StudentManagement.src.dev.StudentManagemenet.models.courses;

import java.util.List;

public interface studentRepository {
    void deleteStudentFromDB(int id);
    List<courses> findCoursesofStudent(int id);
}

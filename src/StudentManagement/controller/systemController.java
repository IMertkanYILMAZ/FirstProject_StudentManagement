package StudentManagement.controller;

import StudentManagement.service.systemService;
import StudentManagement.src.dev.StudentManagemenet.models.students;

import java.util.List;

public class systemController {


    private systemService SystemService = new systemService();

    public students findStudent(int stuID){
        return SystemService.findByID(stuID);
    }

    public List<students> findAllStudents(){
        return SystemService.findAll();
    }

    public void saveStudent(students Stud_x){
        SystemService.saveToDB(Stud_x);
    }

    public void deleteStudent(int stuID){
        SystemService.deleteFromDB(stuID);
    }

    public void deleteStudent(students Stud_x){
        SystemService.deleteFromDB(Stud_x);
    }

    public void updateStudent(students Stud_x, int Id){
        SystemService.updateOnDB(Stud_x, Id);
    }

    public void deleteStudentFromDB(int id){
        SystemService.deleteStudentFromDB(id);
    }


}

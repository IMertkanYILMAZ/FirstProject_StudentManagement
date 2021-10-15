package StudentManagement.submissionToSystem;

import StudentManagement.controller.systemController;
import StudentManagement.src.dev.StudentManagemenet.models.*;
import StudentManagement.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class submissionToSystemTest {

    public static void main(String[] args) {
        //testData();

        systemController controller = new systemController();

        //find all students
        List<students> studsList = controller.findAllStudents();
        for (students stud : studsList) {
            System.out.println(stud);
        }

        /*
        students student4 = new students("Ali Ali", LocalDate.of(1992,4,17), "Istanbul", "Male");
        controller.saveStudent(student4);
        */



    }

    private static void testData(){

        students student1 = new students("Mehmet Mehmet", LocalDate.of(1994,11,10), "Istanbul", "Male");
        students student2 = new students("Merve Merve", LocalDate.of(1993,9,2), "Istanbul", "Female");
        students student3 = new students("Kemal Kemal", LocalDate.of(1995,1,18), "Istanbul", "Male");

        lecturers lecturer1 = new permanentLecturer("Ahmet Ahmet", "Izmir", "05333333331", 1122);
        lecturers lecturer2 = new permanentLecturer("Fatma Fatma", "Balıkesir", "05333333332", 1500);
        lecturers lecturer3 = new temporaryLecturer("Canan Canan", "Istanbul", "05333333333", 1200);

        courses course1 = new courses("Physics", "1100", 4);
        courses course2 = new courses("Mathematics", "1101", 4);
        courses course3 = new courses("Art", "1102", 3);

        course1.setLecturer(lecturer1);
        course2.setLecturer(lecturer2);
        course3.setLecturer(lecturer3);

        course1.getStudentsList().add(student1);
        course1.getStudentsList().add(student2);
        course1.getStudentsList().add(student3);
        course2.getStudentsList().add(student2);
        course3.getStudentsList().add(student3);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);

            em.persist(lecturer1);
            em.persist(lecturer2);
            em.persist(lecturer3);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

}

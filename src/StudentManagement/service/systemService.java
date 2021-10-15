package StudentManagement.service;

import StudentManagement.Repository.CrudRepository;
import StudentManagement.Repository.studentRepository;
import StudentManagement.src.dev.StudentManagemenet.models.courses;
import StudentManagement.src.dev.StudentManagemenet.models.students;
import StudentManagement.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class systemService implements CrudRepository<students>, studentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<students> findAll() {
        return em.createQuery("from students", students.class).getResultList();
    }

    @Override
    public students findByID(int id) {
        return em.find(students.class, id);
    }

    @Override
    public void saveToDB(students student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDB(int id) {
        try {
            em.getTransaction().begin();

            students searchedStudent = em.find(students.class, id);
            em.remove(searchedStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void deleteFromDB(students student) {
        try {
            em.getTransaction().begin();

            students foundCustomer = em.createQuery("from Customer c WHERE c.ssid =:ssid", students.class).setParameter("ssid", student.getId()).getSingleResult();
            em.remove(foundCustomer);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDB(students student, int id) {
        try {
            em.getTransaction().begin();

            students foundStudent = em.find(students.class, id);
            foundStudent.setName(student.getName());
            foundStudent.setBirthDate(student.getBirthDate());
            foundStudent.setId(student.getId());
            foundStudent.setAddress(student.getAddress());
            foundStudent.setGender(student.getGender());
            em.merge(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteStudentFromDB(int id) {
        em.getTransaction().begin();

        students student = em.createQuery("from Customer c WHERE c.ssid =:ssid", students.class).setParameter("ssid", id).getSingleResult();
        em.remove(student);

        em.getTransaction().commit();
    }

    @Override
    public List<courses> findCoursesofStudent(int id) {
        return findCustomerBySSID(id).getCoursesList();
    }

    public students findCustomerBySSID(int id){
        return em.createQuery("from students c where c.ssid=:custSsid", students.class).setParameter("custSsid", id).getSingleResult();
    }
}

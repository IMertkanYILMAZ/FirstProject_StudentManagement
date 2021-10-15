package StudentManagement.Repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findByID(int id);
    void saveToDB(T object);
    void deleteFromDB(int id);
    void deleteFromDB(T object);
    void updateOnDB(T object, int id);

}



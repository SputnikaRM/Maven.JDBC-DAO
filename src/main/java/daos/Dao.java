package daos;

import models.Student;

import java.util.List;

public interface Dao<T> {

    public T findById(Integer id);
    public List findAll();
    public Boolean update(Student student);
    public T create(Student student);
    public Boolean delete(Integer id);



}

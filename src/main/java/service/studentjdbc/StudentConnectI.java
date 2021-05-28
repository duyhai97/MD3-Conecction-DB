package service.studentjdbc;

import model.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentConnectI {



    List<Student> selectAll();

    Student selectById(int id);

    void create(Student student);

    void edit(int id, Student student);

    void delete(int id);



}

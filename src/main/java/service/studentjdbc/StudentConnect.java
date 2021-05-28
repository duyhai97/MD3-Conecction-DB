package service.studentjdbc;

import model.Classed;
import model.Student;
import service.ConnectionJDBC;
import service.classjdbc.ClassConnect;
import service.classjdbc.ClassConnectInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentConnect implements StudentConnectI {

    Connection connection = ConnectionJDBC.getConnect();

    ClassConnectInterface classConnect = new ClassConnect();

    @Override
    public List<Student> selectAll() {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select s.id,s.name, s.dob,s.address, c.id as class_id , c.name as class_name,c.description from student s\n" +
                    "join classed c on s.id_lop = c.id");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String dob = set.getString("dob");
                String address = set.getString("address");

                int class_id = set.getInt("class_id");
                String class_name = set.getString("class_name");
                String description = set.getString("description");
                Classed classed = new Classed(class_id,class_name,description);
                Student student = new Student(id,name,dob,address,classed);
                studentList.add(student);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return studentList;
    }

    @Override
    public Student selectById(int id) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from student where id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name = set.getString("name");
                String dob = set.getString("dob");
                String address = set.getString("address");
                int id_lop = set.getInt("id_lop");
                Classed classed = this.classConnect.selectById(id_lop);
                student = new Student(id,name,dob,address,classed);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public void create(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert student (name ,dob,address, id_lop) " +
                    "values (?,?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getDob());
            statement.setString(3,student.getAddress());
            statement.setInt(4,student.getClassed().getId());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void edit(int id, Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("update student set name =? ," +
                    "dob = ?, address = ?, id_lop = ? where id = ?");

            statement.setInt(5,id);
           statement.setString(1,student.getName());
           statement.setString(2,student.getDob());
           statement.setString(3,student.getAddress());
           statement.setInt(4,student.getClassed().getId());
           statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from student where id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

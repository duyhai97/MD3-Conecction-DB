package service.classjdbc;

import model.Classed;
import service.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassConnect implements ClassConnectInterface {

    Connection connection = ConnectionJDBC.getConnect();

    @Override
    public List<Classed> selectAll() {
        List<Classed> classedList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from classed");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String description = set.getString("description");
                Classed classed = new Classed(id,name,description);
                classedList.add(classed);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classedList;
    }

    @Override
    public Classed selectById(int id) {

        Classed classed = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from classed where id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name = set.getString("name");
                String description = set.getString("description");
                 classed = new Classed(id,name,description);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classed;
    }

    @Override
    public void create(Classed classed) {

    }

    @Override
    public void edit(int id, Classed classed) {

    }

    @Override
    public void delete(int id) {

    }
}

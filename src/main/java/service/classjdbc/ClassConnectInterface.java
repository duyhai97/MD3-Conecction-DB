package service.classjdbc;

import model.Classed;
import model.Student;

import java.util.List;

public interface ClassConnectInterface {

    List<Classed> selectAll();

    Classed selectById(int id);

    void create(Classed classed);

    void edit(int id, Classed classed);

    void delete(int id);

}

package model;

public class Classed {
    private int id;
    private String name;
    private String describe;

    public Classed(int id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public Classed(int id_class) {
        this.id = id_class;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}

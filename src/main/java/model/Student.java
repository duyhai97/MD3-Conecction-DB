package model;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String address;
    private Classed classed;

    public Student(int id, String name, String dob, String address, Classed classed) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.classed = classed;
    }

    public Student(String name, String dob, String address, Classed classed) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.classed = classed;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classed getClassed() {
        return classed;
    }

    public void setClassed(Classed classed) {
        this.classed = classed;
    }
}

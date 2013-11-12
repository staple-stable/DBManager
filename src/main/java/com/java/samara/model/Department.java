package com.java.samara.model;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Department {
    private int deptno;
    private String name;
    private String location;

    public Department() {

    }

    public Department(int deptno, String name, String location) {
        this.location = location;
        this.name = name;
        this.deptno = deptno;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (deptno != that.deptno) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptno;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}

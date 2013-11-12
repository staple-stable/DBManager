package com.java.samara.model;

import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee {
    private int empno;
    private String name;
    private String job;
    private int manager;
    private Date hireDate;
    private int salary;
    private int commission;
    private int department;

    public Employee() {

    }

    public Employee(int empno, String name, String job, int manager, Date hireDate, int salary, int commission, int department) {
        this.empno = empno;
        this.name = name;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.department = department;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}

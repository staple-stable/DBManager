package com.java.samara.dao;

import com.java.samara.model.Employee;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeDAO {
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public Employee getEmployee(int empno);
}

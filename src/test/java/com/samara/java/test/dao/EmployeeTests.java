package com.samara.java.test.dao;

import com.java.samara.dao.DAOFactory;
import com.java.samara.model.Department;
import com.java.samara.model.Employee;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/12/13
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeTests {
    @Test
    public void getEmpTest() {
        Employee emp = DAOFactory.getFactory().getEmployeeDAO().getEmployee(7369);
        System.out.print(emp.getHireDate());
        assertNotEquals(emp, null);
    }

    //@Test
    public void addEmpTest() {
        Employee emp = new Employee(4424242, "alexandro", "Junior Java",7369 , new Date(), 24000, 3000, 10);
        DAOFactory.getFactory().getEmployeeDAO().addEmployee(emp);
    }

    @Test
    public void updateEmpTest() {
        Employee emp = new Employee(4424242, "alexandro", " Java",7369 , new Date(), 55000, 3000, 10);
        DAOFactory.getFactory().getEmployeeDAO().updateEmployee(emp);
    }
}

package com.samara.java.test.dao;

import com.java.samara.dao.DAOFactory;
import com.java.samara.model.Department;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/12/13
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentTests {
    @Test
    public void getDepTest() {
        Department dep = DAOFactory.getFactory().getDepartmentDAO().getDepartment(10);
        assertEquals(dep.getDeptno(), 10);
        assertEquals(dep.getLocation(), "NEW YORK");
        assertEquals(dep.getName(), "ACCOUNTING");
    }

    @Test
    public void addDepTest() {
        Department dep = new Department(4242, "Apochay Inc", "Samara");
        DAOFactory.getFactory().getDepartmentDAO().addDepartment(dep);                //add dep dep
        Department test = DAOFactory.getFactory().getDepartmentDAO().getDepartment(4242);
        assertEquals(dep, test);
    }

    @Test
    public void updateDepTest() {
        Department dep = new Department(42, "Apochay Inc", "Saratov");
        DAOFactory.getFactory().getDepartmentDAO().updateDepartment(dep);
        Department test = DAOFactory.getFactory().getDepartmentDAO().getDepartment(42);
        assertEquals(dep, test);
    }
}

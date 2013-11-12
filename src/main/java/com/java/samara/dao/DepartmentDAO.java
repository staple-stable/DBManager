package com.java.samara.dao;

import com.java.samara.model.Department;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentDAO {
    public List<Department> getAllDeps();
    public Department getDepartment(int deptno);
    public void addDepartment(Department department);
    public void updateDepartment(Department department);
}

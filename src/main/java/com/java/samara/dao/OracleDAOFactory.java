package com.java.samara.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class OracleDAOFactory extends DAOFactory {
    @Override
    public DepartmentDAO getDepartmentDAO() {
        return OracleDepartmentDAO.getInstance();
    }

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return OracleEmployeeDAO.getInstance();
    }
}

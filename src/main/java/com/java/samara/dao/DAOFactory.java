package com.java.samara.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class DAOFactory {

    public abstract DepartmentDAO getDepartmentDAO();
    public abstract EmployeeDAO getEmployeeDAO();

    public static DAOFactory getFactory() {
         return new OracleDAOFactory();
    }
}

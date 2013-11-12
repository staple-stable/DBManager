package com.java.samara.dao;

import com.java.samara.model.Department;
import com.java.samara.model.Employee;
import com.java.samara.util.DBConnection;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/12/13
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class OracleEmployeeDAO implements EmployeeDAO {
    private  static EmployeeDAO instance;
    private OracleEmployeeDAO() {

    }

    public static EmployeeDAO getInstance() {
        if (instance == null) {
            synchronized (OracleDepartmentDAO.class) {
                if (instance == null)
                    instance = new OracleEmployeeDAO();
            }
        }
        return instance;
    }

    @Override
    public void addEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "INSERT INTO sys.emp VALUES (?,?,?,?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getEmpno());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getJob());
            statement.setInt(4, employee.getManager());
            statement.setDate(5, new Date(employee.getHireDate().getTime()));
            statement.setInt(6, employee.getSalary());
            statement.setInt(7, employee.getCommission());
            statement.setInt(8, employee.getDepartment());
            boolean success = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "UPDATE sys.emp SET ename = ?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? WHERE empno = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getJob());
            statement.setInt(3, employee.getManager());
            statement.setDate(4, new Date(employee.getHireDate().getTime()));
            statement.setInt(5, employee.getSalary());
            statement.setInt(6, employee.getCommission());
            statement.setInt(7, employee.getDepartment());
            statement.setInt(8, employee.getEmpno());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Employee getEmployee(int empno) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        Employee employee = null;
        String query = "SELECT * FROM sys.emp WHERE empno = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, empno);
            ResultSet rs = statement.executeQuery();
            rs.next();
            employee = new Employee(rs.getInt("empno"),
                    rs.getString("ename"),
                    rs.getString("job"),
                    rs.getInt("mgr"),
                    rs.getDate("hiredate"),
                    rs.getInt("sal"),
                    rs.getInt("comm"),
                    rs.getInt("deptno"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return employee;
    }
}

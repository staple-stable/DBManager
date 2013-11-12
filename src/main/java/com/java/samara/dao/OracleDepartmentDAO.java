package com.java.samara.dao;

import com.java.samara.model.Department;
import com.java.samara.util.DBConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class OracleDepartmentDAO implements DepartmentDAO{
    private static DepartmentDAO instance;
    public static DepartmentDAO getInstance() {
        if (instance == null) {
            synchronized (OracleDepartmentDAO.class) {
                if (instance == null) {
                    instance = new OracleDepartmentDAO();
                }
            }
        }
        return instance;
    }

    private OracleDepartmentDAO() {

    }

    @Override
    public List<Department> getAllDeps() {
        List<Department> list = new LinkedList<Department>();
        Connection connection = DBConnection.getConnection();
        Statement statement = null;
        Department department = null;
        String query = "SELECT * FROM sys.dept";
        try {
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                department = new Department(rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc"));
                list.add(department);
            }
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
        return list;
    }

    @Override
    public Department getDepartment(int deptno) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        Department department = null;
        String query = "SELECT * FROM sys.dept WHERE deptno = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, deptno);
            ResultSet rs = statement.executeQuery();
            rs.next();
            department = new Department(rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc"));
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
        return department;
    }

    @Override
    public void addDepartment(Department department) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "INSERT INTO sys.dept VALUES (?,?,?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, department.getDeptno());
            statement.setString(2, department.getName());
            statement.setString(3, department.getLocation());
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
    public void updateDepartment(Department department) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "UPDATE sys.dept SET dname = ?, loc=? WHERE deptno = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, department.getName());
            statement.setString(2, department.getLocation());
            statement.setInt(3, department.getDeptno());
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
}

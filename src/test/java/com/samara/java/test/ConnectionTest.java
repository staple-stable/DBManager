package com.samara.java.test;

import com.java.samara.dao.DAOFactory;
import com.java.samara.dao.OracleDepartmentDAO;
import com.java.samara.model.Department;
import com.java.samara.util.DBConnection;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionTest {
    @Test
    public void connectionTest() throws Exception {
        Connection connection = DBConnection.getConnection();
        assertNotEquals(connection, null);
    }

}

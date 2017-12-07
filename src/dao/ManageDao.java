package dao;

import com.util.ConnectionConfiguration;

import java.sql.Connection;

public class ManageDao {
    public Connection getConnection() {
        return ConnectionConfiguration.getConnection();
    }
}

package Utilities;

/**
 * Created by prajapas on 7/13/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelper {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(Constants.UNAME);
            con = DriverManager.getConnection(Constants.URL, Constants.UID, Constants.PASSWORD);
            return con;
        } catch (SQLException e) {
            System.out.println("error connecting data base..!! try again..!! " + e.getMessage());
            return null;
        }
         catch (ClassNotFoundException e) {
            System.out.println("error connecting data base..!! try again..!! " + e.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close(Statement statement) {
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
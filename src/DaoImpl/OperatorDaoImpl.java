package DaoImpl;

import DAO.OperatorDao;
import Utilities.JDBCHelper;
import entities.Operator;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by prajapas on 7/13/2017.
 */
public class OperatorDaoImpl implements OperatorDao {

    public List<Operator> getAllOperators() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Operator> operatorList = null;
        try{
            con = JDBCHelper.getConnection();
            String sql = "select * from operators";
            ps = con.prepareStatement(sql);
            ps.execute();
            rs = ps.getResultSet();

            Operator op = null;
            operatorList = new ArrayList<Operator>();

            while(rs.next()) {
                op = new Operator(rs.getString("userName"), rs.getString("password"), rs.getBoolean("blocked"));
                operatorList.add(op);
            }
            return operatorList;
        } catch(SQLException e){
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return null;
        }
        finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public boolean addOpertor(Operator o) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);

            String sql = "insert into Operators(userName, password, blocked) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, o.getUserName());
            ps.setString(2,o.getPassword());
            ps.setBoolean(3, o.isBlocked());
            ps.executeUpdate();
            con.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return false;
        }
        finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public boolean blockOperator(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);
            String sql = "update Operators set blocked = ? where username = ?";
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setString(2, username);
            ps.executeUpdate();
            con.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return false;
        }
        finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public boolean validate(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCHelper.getConnection();
            String sql = "select * from operators where (username = ? && password = ? && blocked = ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setBoolean(3, true);
            ps.execute();
            rs = ps.getResultSet();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database  " + e.getMessage());
            return false;
        } finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }
}

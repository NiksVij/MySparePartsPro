package DaoImpl;

import DAO.AdminDao;
import Utilities.JDBCHelper;
import entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by prajapas on 7/13/2017.
 */
public class AdminDaoImpl implements AdminDao {

    public boolean validate(Admin a) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = JDBCHelper.getConnection();
            String sql = "Select * from admin where username = ? && password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getUserName());
            ps.setString(2, a.getPassword());
            ps.execute();
            rs = ps.getResultSet();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }

        } catch(SQLException e){
            System.out.println("SQL Error : "+e.getMessage());
            return false;
        }
        finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public boolean addAdmin(Admin a) {
        return false;
    }
}

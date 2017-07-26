package DaoImpl;

import DAO.SparePartsDao;
import Utilities.JDBCHelper;
import entities.SpareParts;
import entities.Vehicle;

import java.sql.*;
import java.util.List;


public class SparePartsDaoImpl implements SparePartsDao {

    public List<SpareParts> getAllSpareParts() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SpareParts> sparePartsList = null;
        try{
            con = JDBCHelper.getConnection();
            String sql = "select * from customer";
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.getResultSet();
            while(rs.next()){
                SpareParts sp = new SpareParts(rs.getString("sparepartId"), rs.getString("sparepartName"),
                        rs.getString("vehicle_model"),rs.getDouble("price"),
                        rs.getDouble("tax"), rs.getInt("units"));
                sparePartsList.add(sp);
            }
            return sparePartsList;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return null;
        } finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
        //return null;
    }

    public boolean addSparePart(SpareParts sparePart) {
        Connection con = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try{
            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);
            SpareParts sp = findSparePart(sparePart.getSparepart_ID());
            if(sp == null) {
                String sql = "insert into spareparts values (?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, sparePart.getSparepart_ID());
                ps.setString(2, sparePart.getSparepartName());
                ps.setDouble(3, sparePart.getPrice());
                ps.setDouble(4, sparePart.getTax());
                ps.setInt(5, sparePart.getNumbers());
                ps.setString(6, sparePart.getVehicle_model());
                ps.executeUpdate();
                con.commit();
            }
            else{
                double price = sp.getPrice();
                double tax = sp.getTax();
                double units = sp.getNumbers();
                String sql = "update spareparts set price = ?, tax = ?, units = ? where sparepartId = ?";
                ps = con.prepareStatement(sql);
                ps.setDouble(1, sp.getPrice()+sparePart.getPrice());
                ps.setDouble(2, sp.getTax()+sparePart.getTax());
                ps.setInt(3, sp.getNumbers()+sp.getNumbers());
                ps.setString(4, sparePart.getSparepart_ID());
                ps.executeUpdate();
                con.commit();
            }
            return true;
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return false;
        } finally {
            //JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
        //return null;
    }

    public boolean removeSpareParts(String id) {
            //String sql="UPDATE spareparts SET units = units -1 WHERE (sparepartid='tyre786' AND units>0);";
        Connection con = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try{
            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);
            SpareParts sp = findSparePart(id);
            if(sp == null) {
                System.out.println("sp id not found");
                return false;
            }
            else{
                String sql="update spareparts set units = units -1 where (sparepartid = ? and units>0);";

                //String sql = "update spareparts set price = ?, tax = ?, units = ? where sparepartId = ?";
                ps = con.prepareStatement(sql);

                ps.setString(1, id);
                int i=ps.executeUpdate();
                con.commit();
                System.out.println("sp i: "+ i);
                if(i==1)
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return false;
        } finally {
            //JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }

    public SpareParts findSparePart(String sparePartId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCHelper.getConnection();
            String sql = "Select * from spareparts where sparepartId = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, sparePartId);
            ps.execute();
            rs = ps.getResultSet();
            if(rs.next()) {
                SpareParts sp = new SpareParts(rs.getString("sparepartid"), rs.getString("sparepartName"), rs.getString("vehicle_model"), rs.getDouble("price"), rs.getDouble("tax"), rs.getInt("units"));
                return sp;
            }
            else{
                return null;
            }

        } catch (SQLException e) {
            System.out.print("Data Base Error"+e.getMessage());
            return null;
        } finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
    }
}

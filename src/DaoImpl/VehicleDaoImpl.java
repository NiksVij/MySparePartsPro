package DaoImpl;

import DAO.VehicleDao;
import Utilities.JDBCHelper;
import entities.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by prajapas on 7/13/2017.
 */
public class VehicleDaoImpl implements VehicleDao {
    public List<Vehicle> getAllVehicles() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Vehicle> vehicleList = null;
        try{
            con = JDBCHelper.getConnection();
            String sql = "select * from vehicle";
            ps = con.prepareStatement(sql);
            ps.execute();
            rs = ps.getResultSet();

            while(rs.next()){
                Vehicle vehicle = new Vehicle(rs.getString("vehicle_model"), rs.getInt("units"), rs.getDouble("price"), rs.getDouble("tax"));
                vehicleList.add(vehicle);
            }
            return vehicleList;
        } catch(SQLException e){
            System.out.println("OOPs error occured in connecting database " + e.getMessage());
            return null;
        }
        finally {
            JDBCHelper.close(rs);
            JDBCHelper.close(ps);
            JDBCHelper.close(con);
        }
        //return null;
    }

    public boolean addVehicle(Vehicle vehicle) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);
            Vehicle vh = findVehicle(vehicle.getVehicle_model());
            if(vh == null) {
                String sql  = "insert into vehicle values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setDouble(1, vehicle.getPrice());
                ps.setInt(2, vehicle.getNumber());
                ps.setString(3, vehicle.getVehicle_model());
                ps.setDouble(4, vehicle.getTax());
                ps.executeUpdate();
                con.commit();
            }
            else{
                double price = vh.getPrice();
                double tax = vh.getTax();
                double units = vh.getNumber();
                String sql = "update vehicle set price = ?, units = ?, tax = ? where vehicle_model = ?";
                ps = con.prepareStatement(sql);
                ps.setDouble(1, vehicle.getPrice() + vh.getPrice());
                ps.setInt(2, vehicle.getNumber()+ vh.getNumber());
                ps.setDouble(3, vehicle.getTax()+vh.getTax());
                ps.setString(4, vehicle.getVehicle_model());
                ps.executeUpdate();
                con.commit();
            }

        } catch (SQLException e) {
            System.out.println("SQL Error :"+e.getMessage());
            return false;
        } finally {
            JDBCHelper.close(con);
            JDBCHelper.close(ps);
        }
        return false;
    }

    public boolean removeVehicles(String model, int number) {
        return false;
    }

    public Vehicle findVehicle(String model) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCHelper.getConnection();
            String sql = "Select * from vehicle where vehicle_model = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, model);
            ps.execute();
            rs = ps.getResultSet();
            if(rs.next()) {
                Vehicle vehicle = new Vehicle(rs.getString("vehicle_model"), rs.getInt("units"),
                        rs.getDouble("price"), rs.getDouble("tax"));
                return vehicle;
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

package DAO;

import entities.VehicleService;

import java.util.Date;
import java.util.List;

/**
 * Created by vijayn on 7/28/2017.
 */
public interface VehicleServiceDao {
    boolean addVService(String reg_no, String owner_name, String make_model, String odo_reading, String serv_no, String paid, Date purchase_date);
    List<VehicleService> getAllVehicles();
}

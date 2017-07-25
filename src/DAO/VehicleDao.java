package DAO;

import entities.Vehicle;

import java.util.List;

/**
 * Created by prajapas on 7/13/2017.
 */
public interface VehicleDao {
    public List<Vehicle> getAllVehicles();
    public boolean addVehicle(Vehicle vehicle);
    public boolean removeVehicles(String model, int number);
    public Vehicle findVehicle(String model);
}

package com.virtualpairprogrammers.services;



import com.virtualpairprogrammers.dao.VehicleDAO;
import com.virtualpairprogrammers.domain.Vehicle;

import java.util.List;

public class VehicleService
{
    private VehicleDAO vehicleDAO;

    public VehicleService()
    {
        vehicleDAO=new VehicleDAO();
    }

    public List<Vehicle> getAllvehicle(){ return this.vehicleDAO.getAllvehicle();}
    public boolean insertVehicle(Vehicle vehicle){return this.vehicleDAO.insertVehicle(vehicle);}

}

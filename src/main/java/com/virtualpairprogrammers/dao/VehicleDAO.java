package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.domain.Vehicle;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import main.controller.GestoreEccezioni;

public class VehicleDAO
{
    private String QUERY_ALL ="select * from Vehicle";
    private String QUERY_INSERT="INSERT INTO vehicle (idVehicle,brand,model,fuel,version,capacity) VALUES (NULL,?,?,?,?,?);";
    public VehicleDAO() {}

    public List<Vehicle> getAllvehicle()
    {
        List<Vehicle> vehicles= new ArrayList<Vehicle>();
        Connection connection = ConnectionSingleton.getInstance();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next())
            {
                Integer idVehicle=resultSet.getInt("idVehicle");
                String brand=resultSet.getString("brand");
                String model=resultSet.getString("model");
                String fuel=resultSet.getString("fuel");
                vehicles.add(new Vehicle(idVehicle,brand,model,fuel));
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        return  vehicles;
    }
    public boolean insertVehicle(Vehicle vehicle)
    {
        Connection connection = ConnectionSingleton.getInstance();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

            preparedStatement.setString(1,vehicle.getBrand());
            preparedStatement.setString(2,vehicle.getModel());
            preparedStatement.setString(3,vehicle.getFuel());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            e.printStackTrace();
            return false;
        }

    }


}

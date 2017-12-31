package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.domain.Gomma;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import main.controller.GestoreEccezioni;

public class GommaDAO {

    private final String QUERY_ALL = "select * from gomme";
    private final String QUERY_INSERT = "insert into gomme (idGomme, model, manufacturer,price,width,height,diameter,weight,speed,season,typeVehicle,quantity) values (NULL,?,?,?,?,?,?,?,?,?,?,?)";

    public GommaDAO() {

    }

    public List<Gomma> getAllGomme ()
    {
        List<Gomma> gomme = new ArrayList<Gomma>();
        Connection connection = ConnectionSingleton.getInstance();
        try
        {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next())
           {
               int idGomme= resultSet.getInt("idGomme");
               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               double price = resultSet.getDouble("price");
               double width = resultSet.getDouble("width");
               double height = resultSet.getDouble("height");
               double diameter = resultSet.getDouble("diameter");
               double weight = resultSet.getDouble("weight");
               String speed = resultSet.getString("speed");
               String season = resultSet.getString("season");
               String typeVehicle = resultSet.getString("typeVehicle");
               int quantity = resultSet.getInt("quantity");
               gomme.add(new Gomma(idGomme, model, manufacturer,price));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public boolean insertGomma(Gomma gomma)
    {
        Connection connection = ConnectionSingleton.getInstance();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);

            preparedStatement.setString(1, gomma.getModel());
            preparedStatement.setString(2, gomma.getManufacturer());
            preparedStatement.setDouble(3, gomma.getPrice());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            e.printStackTrace();
            return false;
        }

    }
}

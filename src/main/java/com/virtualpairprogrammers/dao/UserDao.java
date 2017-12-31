package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.domain.User;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import main.controller.GestoreEccezioni;

public class UserDao
{
    private final String QUERY_ALL = "select * from users where role=\"user\"";
    private final String QUERY_INSERT ="INSERT INTO users (idUser,username,password,firstname,lastname,dateofbirth,fiscalcode,businessname,vat,municipality,post,city,address,telephone,role) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    public UserDao() {}

    public boolean insertUser(User user)
    {
        Connection connection = ConnectionSingleton.getInstance();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(14,"user");

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            e.printStackTrace();
            return false;
        }
    }
    public List<User> getAllUser()
    {
        List <User> users=new ArrayList<User>();
        Connection connection = ConnectionSingleton.getInstance();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next())
            {
                int idUser=resultSet.getInt("idUser");
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");

                String role=resultSet.getString("role");
                users.add(new User(idUser,username,password,role));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  users;
    }
}

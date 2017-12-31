package com.virtualpairprogrammers.services;


import com.virtualpairprogrammers.dao.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO;
    private static LoginService reference;

    public static LoginService getService()
    {
        if (reference == null)
            reference = new LoginService();
        return reference;
    }

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public void login (String username, String password) {
         this.loginDAO.login(username, password);
    }
}

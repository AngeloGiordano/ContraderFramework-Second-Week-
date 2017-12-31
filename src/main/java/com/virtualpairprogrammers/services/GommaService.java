package com.virtualpairprogrammers.services;



import com.virtualpairprogrammers.dao.GommaDAO;
import com.virtualpairprogrammers.domain.Gomma;

import java.util.List;

public class GommaService {

    private GommaDAO gommaDAO;

    private static GommaService reference;

    public static GommaService getService() {
        if (reference == null)
            reference = new GommaService();
        return reference;
    }

    public GommaService() {
        this.gommaDAO = new GommaDAO();
    }

    public List<Gomma> getAllGomme () {
        return this.gommaDAO.getAllGomme();
    }

    public boolean insertGomma (Gomma gomma) {
        return this.gommaDAO.insertGomma(gomma);
    }


}



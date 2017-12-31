package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Gomma;
import com.virtualpairprogrammers.services.GommaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class GommaServlet  extends HttpServlet
{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        Integer choice = (Integer) session.getAttribute("choice");
        String role = (String) session.getAttribute("role");

        GommaService gommaService= GommaService.getService();

        if ("user".equals(role)) {
            switch (choice) {
                case 1: {
                    session.setAttribute("view", "GommaView.jsp");

                    MainDispatcherServlet.getInstance(request).callView(request, response);
                }
                break;
                case 2: {
                    session.setAttribute("view", "GommaView.jsp");
                    MainDispatcherServlet.getInstance(request).callView(request, response);
                }
                break;
                case 3: {
                    session.setAttribute("view", "GommaView.jsp");
                    MainDispatcherServlet.getInstance(request).callView(request, response);
                }
            }

        } else if ("admin".equals(role)) {
            switch (choice) {
                case 1: {
                    session.setAttribute("view", "GommaView.jsp");
                    session.setAttribute("mode", "insert");
                    MainDispatcherServlet.getInstance(request).callView(request, response);
                }
                break;
                case 2: {
                    List<Gomma> gomme = gommaService.getAllGomme();
                    session.setAttribute("view", "GommaView.jsp");
                    session.setAttribute("mode", "all");
                    session.setAttribute("gomme", gomme);
                    MainDispatcherServlet.getInstance(request).callView(request, response);
                }
                break;
                case 3: {
                    String model = request.getParameter("model");
                    String manufacturer = request.getParameter("manufacturer");
                    double price = Double.parseDouble(request.getParameter("price"));
                    gommaService.insertGomma(new Gomma(null, model, manufacturer, price));
                    session.setAttribute("view", "homeMenu.jsp");
                    MainDispatcherServlet.getInstance(request).callView(request, response);
                }
            }
        }
    }
}

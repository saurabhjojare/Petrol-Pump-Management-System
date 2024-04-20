package com.petrolpump.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petrolpump.admin.model.FuelTypeModel;
import com.petrolpump.admin.service.FuelService;
import com.petrolpump.admin.service.FuelTypeServiceImpl;

@WebServlet("/fueltype")
public class FuelTypeController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fuelType = request.getParameter("fueltype");
        FuelTypeModel model = new FuelTypeModel();
        model.setName(fuelType);
        FuelService fService = new FuelTypeServiceImpl();
        boolean isAdded = fService.isAddFuelModel(model);
        String typemessage;
        if (isAdded) {
            typemessage = "Fuel Type Added";
        } else {
            typemessage = "Fuel Type Not Added";
        }
        request.setAttribute("typemessage", typemessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-type.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

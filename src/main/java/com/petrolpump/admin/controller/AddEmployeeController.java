package com.petrolpump.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petrolpump.admin.model.EmployeeModel;
import com.petrolpump.admin.service.EmployeeService;
import com.petrolpump.admin.service.EmployeeServiceImpl;

@WebServlet("/addemployee")
public class AddEmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        int sal = Integer.parseInt(request.getParameter("sal"));
        EmployeeModel empModel = new EmployeeModel();
        empModel.setName(name);
        empModel.setEmail(email);
        empModel.setContact(contact);
        empModel.setAddress(address);
        empModel.setSal(sal);
        EmployeeService empService = new EmployeeServiceImpl();
        boolean isSuccess = empService.isAddNewEmployee(empModel);
        if (isSuccess) {
            request.setAttribute("EmployeeAddMessage", "Employee Added");
        } else {
            request.setAttribute("EmployeeAddMessage", "Employee Not Added");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-employee.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

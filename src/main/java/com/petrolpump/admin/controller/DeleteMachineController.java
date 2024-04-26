package com.petrolpump.admin.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.petrolpump.admin.service.MachineService;
import com.petrolpump.admin.service.MachineServiceImpl;

@WebServlet("/delete")
public class DeleteMachineController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int mid = Integer.parseInt(request.getParameter("machineid"));
        MachineService mService = new MachineServiceImpl();
        boolean b = mService.isDeleteMachineById(mid);
        if (b) {
            request.setAttribute("successMessage", "Dispensers Deleted");
            RequestDispatcher r = request.getRequestDispatcher("view-machine.jsp");
            r.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Dispensers Not Deleted");
            RequestDispatcher r = request.getRequestDispatcher("view-machine.jsp");
            r.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}

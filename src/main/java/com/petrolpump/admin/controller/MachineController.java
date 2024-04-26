package com.petrolpump.admin.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.service.*;

@WebServlet("/newmachine")
public class MachineController extends HttpServlet {
    MachineService machineService = new MachineServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String machineCode = request.getParameter("machineCode");
        String ftypeid[] = request.getParameterValues("ftype");
        String capArray[] = request.getParameterValues("capacity");
        MachineModel model = new MachineModel();
        model.setMachineCode(machineCode);
        boolean flag = false;

        try {
            boolean b = machineService.isAddNewMachine(model, ftypeid, capArray);
            if (b) {
                request.setAttribute("message", "Pump Added");
            } else {
                request.setAttribute("message", "Pump Not Added");
            }
            request.getRequestDispatcher("add-machine.jsp").forward(request, response);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

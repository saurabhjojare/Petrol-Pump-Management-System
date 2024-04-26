package com.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petrolpump.admin.model.MachineModel;
import com.petrolpump.admin.service.MachineService;
import com.petrolpump.admin.service.MachineServiceImpl;

@WebServlet("/update")
public class UpdateMachineController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int mid = Integer.parseInt(request.getParameter("mid"));
        String machineCode = request.getParameter("mcode");
        RequestDispatcher r = request.getRequestDispatcher("admin_dashboard.jsp");
        r.include(request, response);

        // Now, generate your HTML content with the title
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Update Pump</title>");
        out.println(
                "<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"content\">");
        out.println("<form name='form' action='update' method='POST'>"); // Changed action to 'update'
        out.println("<div class=\"container mt-5\">");
        out.println("<div class=\"row justify-content-center\">");
        out.println("<div class=\"col-md-6\">");
        out.println("<h5 id=\"installPumpHeader\">Update Pump Code</h5>");
        out.println("<div class=\"input-group\">");
        out.println("<h6>Dispenser ID: " + mid + "</h6>");
        out.println("</div>");
        out.println("<div class=\"input-group\">");
        out.println("<input type=\"hidden\" name=\"mid\" value='" + mid + "' />"); // Hidden input to submit mid to
                                                                                   // server
        out.println("<input type=\"text\" name=\"mcode\" value='" + machineCode
                + "' class=\"form-control\" placeholder=\"Enter Machine Code\" aria-label=\"Enter your text here\" aria-describedby=\"button-addon\">");
        out.println("</div>");
        out.println("<div class=\"text-center mt-3\">");
        out.println("<button class=\"btn btn-light mr-2\" type=\"button\" onclick=\"history.back()\">Back</button>");
        out.println(
                "<button class=\"btn btn-light\" type=\"submit\" name=\"update\" value=\"update\" id=\"button-addon\">Update</button>");
        out.println("</div>");
        out.println("<br>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
        out.println(
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int mid = Integer.parseInt(request.getParameter("mid"));
        String machineCode = request.getParameter("mcode");
        MachineModel model = new MachineModel();
        model.setId(mid);
        model.setMachineCode(machineCode);
        MachineService mService = new MachineServiceImpl();
        boolean b = mService.isUpdateMachine(model);
        if (b) {
            RequestDispatcher r = request.getRequestDispatcher("view-machine.jsp");
            r.forward(request, response);
        } else {
            out.println("Code Not Updated");
        }
    }
}

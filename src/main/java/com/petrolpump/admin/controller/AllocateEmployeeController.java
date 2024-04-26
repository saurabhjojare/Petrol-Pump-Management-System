package com.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.petrolpump.admin.service.EmployeeService;
import com.petrolpump.admin.service.EmployeeServiceImpl;
import com.petrolpump.admin.service.MachineService;
import com.petrolpump.admin.service.MachineServiceImpl;

@WebServlet("/allocatemachine")
public class AllocateEmployeeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher r = request.getRequestDispatcher("admin_dashboard.jsp");
        r.include(request, response);
        MachineService mService = new MachineServiceImpl();
        List<Object[]> list = mService.getAllMachines();
        LinkedHashMap<Integer, String> hs = new LinkedHashMap<Integer, String>();
        for (Object obj[] : list) {
            hs.put((Integer) obj[3], obj[0].toString());
        }

        int empId = Integer.parseInt(request.getParameter("empid"));
        String empName = request.getParameter("empName");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Allocate Employee</title>");
        out.println(
                "<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"content\">");
        out.println("<form name='form' action='allocatemachine' method='POST'>");
        out.println("<div class=\"container mt-5\">");
        out.println("<div class=\"row justify-content-center\">");
        out.println("<div class=\"col-md-6\">");

        out.println("<h5 id=\"installPumpHeader\">Allocate Machine To " + empName + "</h5>");
        out.println("<div class=\"input-group\">");
        out.println("</div>");
        out.println("<div class=\"input-group\">");

        out.println("<select name=\"mid\" class=\"form-control custom-select\">");
        Set<Map.Entry<Integer, String>> s = hs.entrySet();
        for (Map.Entry<Integer, String> m : s) {
            out.println("<option value = '" + m.getKey() + "' >");
            out.println(m.getValue());
            out.println("</option>");
        }
        out.println("</select>");

        out.println("</div>");

        out.println("<div class=\"input-group mt-2\" style =\"gap:5px\">");
        out.println(
                "<input type=\"time\" name=\"startTime\" class=\"form-control \" placeholder=\"Enter Time\" value=\"12:00\">");
        out.println(
                "<input type=\"time\" name=\"endTime\" class=\"form-control\" placeholder=\"Enter Time\" value=\"03:00\">");
        out.println("</div>");

        out.println("<div class=\"input-group mt-2\">");
        out.println(
                "<input type=\"date\" name=\"dateInput\" class=\"form-control\" placeholder=\"Enter Date\" value=\"2024-04-24\">");
        out.println("</div>");

        out.println("<div class=\"input-group\">");
        out.println("<input type='hidden' name='empid' value='" + empId + "' />");
        out.println("</div>");
        out.println("<div class=\"text-center mt-3\">");
        out.println(
                "<button class=\"btn btn-light mr-2\" type=\"button\" onclick=\"history.back()\">Back</button>");
        out.println(
                "<button class=\"btn btn-light\" type=\"submit\" name=\"update\" value=\"allocate\" id=\"button-addon\">Allocate</button>");
        out.println("</div>");
        out.println("<br>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println(
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
        out.println(
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
        out.println(
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int empId = Integer.parseInt(request.getParameter("empid"));
        int mid = Integer.parseInt(request.getParameter("mid"));
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String date = request.getParameter("dateInput");
        EmployeeService empService = new EmployeeServiceImpl();
        boolean machineAllocated = empService.allocateMachine(empId, mid, startTime, endTime, date);
        if(machineAllocated) {
			out.println("Machine Allocated");
		} else {
			out.println("Machine Not Allocated");
		}
     
    }
}

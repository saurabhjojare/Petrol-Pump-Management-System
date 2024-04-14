<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="com.petrolpump.admin.service.*" %>
		<%@ page import="java.util.*" %>
			<%@ page import="com.petrolpump.admin.model.*" %>

				<!DOCTYPE html>
				<html lang="en">

				<head>
					<meta charset="UTF-8">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<title>View Pumps</title>
					<!-- Bootstrap CSS -->
					<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
					<!-- Custom CSS -->
					<link rel="stylesheet" type="text/css" href="css\style.css">
					<link rel="icon" type="image/png" href="img\favicon.png">
					<style>
					</style>
				</head>

				<body>
					<%!MachineService machineService=new MachineServiceImpl();%>
						<%@ include file="admin_dashboard.jsp" %>
							<!-- Content -->
							<div class="content">

								<div id="errorMessage" style="display: none;" class="h3" role="alert">
									<%-- Check if an error message is set --%>
										<% if (request.getAttribute("errorMessage") !=null) { %>
											<%=request.getAttribute("errorMessage")%>
												<% } %>
								</div>

								<div id="successMessage" style="display: none;" class="h3" role="alert">
									<%-- Check if a success message is set --%>
										<% if (request.getAttribute("successMessage") !=null) { %>
											<%=request.getAttribute("successMessage")%>
												<% } %>
								</div>

								<h3 id="dispensersHeading">Available Dispensers</h3>
								<table class="table">
									<thead>
										<tr>
											<th scope="col">#</th>
											<th scope="col">Name</th>
											<th scope="col">Delete</th>
											<th scope="col">Update</th>
										</tr>
									</thead>
									<tbody>
										<% List<MachineModel> list = machineService.getAllMachines();
											int count = 0;

											// Check if the list is not null before proceeding
											if (list != null) {
											for (MachineModel m : list) {
											%>
											<tr>
												<th scope="row">
													<%=++count%>
												</th>
												<td>
													<%=m.getMachineCode()%>
												</td>
												<td><a href='delete?machineid=<%=m.getId()%>'>Delete</a></td>
												<td><a
														href='update?mid=<%=m.getId()%>&mcode=<%=m.getMachineCode()%>'>Update</a>
												</td>
											</tr>
											<% } } %>
									</tbody>

								</table>
							</div>

							<script>
								// Show success or error message for 3 seconds before displaying the heading again
								window.onload = function () {
									var successMessageDiv = document.getElementById("successMessage");
									var errorMessageDiv = document.getElementById("errorMessage");
									var dispensersHeading = document.getElementById("dispensersHeading");

									// Check if success message is present
									if (successMessageDiv.innerHTML.trim() !== "") {
										successMessageDiv.style.display = "block";
										dispensersHeading.style.display = "none";

										// Set timeout to display heading again after 3 seconds
										setTimeout(function () {
											successMessageDiv.style.display = "none";
											dispensersHeading.style.display = "block";
										}, 3000);
									}

									// Check if error message is present
									if (errorMessageDiv.innerHTML.trim() !== "") {
										errorMessageDiv.style.display = "block";
										dispensersHeading.style.display = "none";

										// Set timeout to display heading again after 3 seconds
										setTimeout(function () {
											errorMessageDiv.style.display = "none";
											dispensersHeading.style.display = "block";
										}, 3000);
									}
								};
							</script>


							<!-- Bootstrap JS -->
							<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
							<script
								src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
							<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
				</body>

				</html>
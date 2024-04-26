<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.petrolpump.admin.service.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.petrolpump.admin.model.*"%>
<%@ page import="com.petrolpump.admin.repository.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Pumps</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css\style.css">
<link rel="icon" type="image/png" href="img\favicon.png">
<style>
</style>
</head>

<body>
	<%!MachineService machineService = new MachineServiceImpl();%>
	<%@ include file="admin_dashboard.jsp"%>
	<!-- Content -->
	<div class="content">

		<div id="errorMessage" style="display: none;" class="h3" role="alert">
			<%-- Check if an error message is set --%>
			<%
			if (request.getAttribute("errorMessage") != null) {
			%>
			<%=request.getAttribute("errorMessage")%>
			<%
			}
			%>
		</div>

		<div id="successMessage" style="display: none;" class="h3"
			role="alert">
			<%-- Check if a success message is set --%>
			<%
			if (request.getAttribute("successMessage") != null) {
			%>
			<%=request.getAttribute("successMessage")%>
			<%
			}
			%>
		</div>

		<h3 id="dispensersHeading">Available Dispensers</h3>
		<table class="table">
			<thead>

				<tr class="empTableDesktop">

					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Fuel Type</th>
					<th scope="col">Capacity</th>
					<th scope="col">Delete</th>
					<th scope="col">Update</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Object[]> list = machineService.getAllMachines();
				int count = 0;

				int count2 = 0; 

				if (list != null) {
					for (Object obj[] : list) {
				%>

				<tr class="empTableDesktop">

					<th scope="row"><%=++count%></th>
					<td><%=obj[0]%></td>
					<td><%=obj[1]%></td>
					<td><%=obj[2]%></td>
					<td><a href='delete?machineid=<%=(int)obj[3]%>'>Delete</a></td>
					<td><a
						href='update?mid=<%=(int)obj[3]%>&mcode=<%=obj[0].toString()%>'>Update</a>
					</td>
				</tr>
				
				<tr class="empTableMobile">
					<td scope="col" class = "font-weight-bold" style="border:none">#</td>
					<td style="border:none"><%=++count2%></td>
				</tr>
				
				<tr class="empTableMobile">
					<td class = "font-weight-bold">Name</td>
					<td><%=obj[0]%></td>
				</tr>
				<tr class="empTableMobile">
					<td class = "font-weight-bold">Fuel Type</td>
					<td><%=obj[1]%></td>
				</tr>
				<tr class="empTableMobile">
					<td class = "font-weight-bold">Capacity</td>
					<td><a href="#"><%=obj[2]%></a></td>
				</tr>
				<tr class="empTableMobile">
					<td class = "font-weight-bold">Update</td>
					<td><a href='update?mid=<%=(int)obj[3]%>&mcode=<%=obj[0].toString()%>'>Update</a></td>
				</tr>
				<tr class="empTableMobile">
					<td class = "font-weight-bold">Delete</td>
					<td><a href='delete?machineid=<%=(int)obj[3]%>'>Delete</a></td>
				</tr>
				<tr class="empTableMobile emptyRow">
					<td colspan="2"></td>
				</tr>

				<%
				}
				}
				%>
			</tbody>

		</table>
	</div>

	<script>
		window.onload = function() {
			var successMessageDiv = document.getElementById("successMessage");
			var errorMessageDiv = document.getElementById("errorMessage");
			var dispensersHeading = document
					.getElementById("dispensersHeading");

			if (successMessageDiv.innerHTML.trim() !== "") {
				successMessageDiv.style.display = "block";
				dispensersHeading.style.display = "none";

				setTimeout(function() {
					successMessageDiv.style.display = "none";
					dispensersHeading.style.display = "block";
				}, 3000);
			}

			if (errorMessageDiv.innerHTML.trim() !== "") {
				errorMessageDiv.style.display = "block";
				dispensersHeading.style.display = "none";

				setTimeout(function() {
					errorMessageDiv.style.display = "none";
					dispensersHeading.style.display = "block";
				}, 3000);
			}
		};
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>

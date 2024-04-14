<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<% String currentPage=request.getRequestURI(); // Get the current page URI boolean
		isIndexPage=currentPage.endsWith("admin_dashboard.jsp"); // Check if it's the admin_dashboard page %>

		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<% if (isIndexPage) { %>
				<title>Dashboard</title>
				<% } %>
					<!-- Bootstrap CSS -->
					<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
					<!-- Custom CSS -->
					<link rel="stylesheet" type="text/css" href="css\style.css">
					<link rel="icon" type="image/png" href="img\favicon.png">
					<style>
					</style>
		</head>

		<body>

			<!-- Sidebar -->
			<div class="sidebar">
				<nav class="navbar navbar-dark">
					<span class="navbar-brand mb-0 h1 font-weight-bold">Dashboard</span>
				</nav>
				<ul class="nav flex-column">
					<li class="nav-item"><a class="nav-link" data-toggle="collapse" href="#homeSubMenu" role="button"
							aria-expanded="false" aria-controls="homeSubMenu">Fuel Dispenser</a>
						<div class="collapse" id="homeSubMenu">
							<ul class="nav flex-column">
								<li class="nav-item"><a class="nav-link" href="add-machine.jsp">Add Pumps</a></li>
								<li class="nav-item"><a class="nav-link" href="view-machine.jsp">View
										Pumps</a></li>
							</ul>
						</div>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Settings</a></li>
				</ul>
			</div>

			<% if (isIndexPage) { %>
				<!-- Content -->
				<div class="content">
					<center>
						<h1>Welcome to Your Dashboard</h1>
					</center>
				</div>
				<% } %>

					<!-- Bootstrap JS -->
					<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
					<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
					<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		</body>

		</html>
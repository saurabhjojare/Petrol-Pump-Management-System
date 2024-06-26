<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="com.petrolpump.admin.model.*" %>
<%@ page import="com.petrolpump.admin.service.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Pumps</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="css\style.css">
<link rel="icon" type="image/png" href="img\favicon.png">

<style>
   
</style>
</head>

<body onload="hideMessage()">
	<%@ include file="admin_dashboard.jsp"%>
	<!-- Content -->
	<div class="content">
    <form name="form" action="newmachine" method="POST">
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <h5 id="installPumpHeader">Install New Pump</h5>

                    <div class="input-group">
                        <input type="text" name="machineCode" class="form-control"
                            placeholder="Enter Machine Code"
                            aria-label="Enter your text here"
                            aria-describedby="button-addon">
                    </div>
                   
                    <% 
                    FuelService fService = new FuelTypeServiceImpl();
                    List<FuelTypeModel> list = fService.getAllFuelTypes();
                    for(FuelTypeModel m:list) {
                    %>
                    
                   <!-- Add checkbox for petrol -->
                    <div class="form-check mt-3">
                        <input class="form-check-input" type="checkbox" value="<%=m.getId()%>" id="petrolCheckbox_<%=m.getId()%>" name="ftype">
                        <label class="form-check-label" for="petrolCheckbox_<%=m.getId()%>">
                            <%=m.getName()%>
                        </label>
                    </div>
                    
                    <!-- Input field for liters if petrol selected -->
                    <div class="input-group mt-3" id="petrolInput_<%=m.getId()%>" style="display: none;">
                        <input type="text" name="capacity" class="form-control"
                            placeholder="Enter Quantity"
                            aria-label="Enter liters"
                            aria-describedby="button-addon"
                            value="35"
                            style="width: 200px;"> <!-- Adjust width here -->
                    </div>
                    <%
                    }
                    %>
                   
                    <div class="text-center mt-3">
                        <button class="btn btn-light" type="submit" value="Submit"
                            id="button-addon">Add</button>
                    </div>
                    <br>

                </div>
            </div>
        </div>
    </form>
</div>


	<script>
		function hideMessage() {
			var headerElement = document.getElementById("installPumpHeader");
			var originalHeaderText = headerElement.innerHTML;
			var message = "${message}";
			if (message) {
				headerElement.innerHTML = message;
				setTimeout(function() {
					headerElement.innerHTML = originalHeaderText;
				}, 2000);
			}
		}
	</script>
	<script>
    // Script to show/hide input field based on checkbox and validate input
    <% 
    for(FuelTypeModel m:list) {
    %>
    document.getElementById('petrolCheckbox_<%=m.getId()%>').addEventListener('change', function() {
        var petrolInput = document.getElementById('petrolInput_<%=m.getId()%>');
        petrolInput.style.display = this.checked ? 'block' : 'none';
        if (this.checked) {
            validateInput('liters_<%=m.getId()%>');
        } else {
            resetInput('liters_<%=m.getId()%>');
        }
    });
    <%
    }
    %>

    // Function to validate input if checkbox is selected
    function validateInput(inputId) {
        var inputField = document.getElementById(inputId);
        inputField.required = true;
    }

    // Function to reset input field if checkbox is unchecked
    function resetInput(inputId) {
        var inputField = document.getElementById(inputId);
        inputField.required = false;
        inputField.value = '';
    }
</script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>

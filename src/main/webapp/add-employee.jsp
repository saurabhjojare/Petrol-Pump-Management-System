<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="image/png" href="img/favicon.png">
    <style></style>
</head>
<body onload="hideMessage()">
    <%@ include file="admin_dashboard.jsp"%>
    <!-- Content -->
    <div class="content">
        <form name="form" action='addemployee' method="POST">
            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <h5 id="installPumpHeader">Add Employee</h5>
                        <label for="username">Name</label>
                        <div class="input-group">
                            <input type="text" name="name" class="form-control" placeholder="John Doe" aria-label="Enter your text here" aria-describedby="button-addon">
                        </div>
                        <label for="username" class="mt-1">Email</label>
                        <div class="input-group">
                            <input type="text" name="email" class="form-control" placeholder="example@example.com" aria-label="Enter your text here" aria-describedby="button-addon">
                        </div>
                        <label for="username" class="mt-1">Contact</label>
                        <div class="input-group">
                            <input type="text" name="contact" class="form-control" placeholder="+1234567890" aria-label="Enter your text here" aria-describedby="button-addon">
                        </div>
                        <label for="username" class="mt-1">Address</label>
                        <div class="input-group">
                            <input type="text" name="address" class="form-control" placeholder="123 Main Street, City, Country" aria-label="Enter your text here" aria-describedby="button-addon">
                        </div>
                        <label for="username" class="mt-1">Salary</label>
                        <div class="input-group">
                            <input type="text" name="sal" class="form-control" placeholder="$4000" aria-label="Enter your text here" aria-describedby="button-addon">
                        </div>
                        <div class="text-center mt-3">
                            <button class="btn btn-light" type="submit" value="Submit" id="button-addon">Add Employee</button>
                        </div>
                        <br>
                        <% String message = (String) request.getAttribute("EmployeeAddMessage"); %>
                        <% if (message != null) { %>
                            <script>
                                function hideMessage() {
                                    var headerElement = document.getElementById("installPumpHeader");
                                    var originalHeaderText = headerElement.innerHTML;
                                    var typemessage = "<%= message %>";
                                    if (typemessage) {
                                        headerElement.innerHTML = typemessage;
                                        setTimeout(function() {
                                            headerElement.innerHTML = originalHeaderText;
                                        }, 3000); 
                                    }
                                }
                            </script>
                        <% } %>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fuel Type</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" type="image/png" href="img/favicon.png">
    <style>
    </style>
</head>

<body onload="hideMessage()">
    <%@ include file="admin_dashboard.jsp"%>
    <!-- Content -->
    <div class="content">
        <form name="form" action='fueltype' method="POST">
            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <h5 id="installPumpHeader">Add Fuel Type</h5>

                        <div class="input-group">
                            <input type="text" name="fueltype" class="form-control" placeholder="Enter Fuel Type"
                                aria-label="Enter your text here" aria-describedby="button-addon">
                        </div>
                        <div class="text-center mt-3">
<<<<<<< HEAD
                            <button class="btn btn-light" type="submit" value="Submit" id="button-addon">Add Type</button>
=======
                            <button class="btn btn-light" type="submit" value="Submit" id="button-addon">Add</button>
>>>>>>> 922f3e42ba33c3984688868195c65cb1f732ff5b
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
            var typemessage = "${typemessage}";
            if (typemessage) {
                headerElement.innerHTML = typemessage;
                setTimeout(function() {
                    headerElement.innerHTML = originalHeaderText;
                }, 2000);
            }
        }
    </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>

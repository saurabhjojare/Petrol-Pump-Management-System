<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">
s
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Pumps</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css\style.css">
    <link rel="icon" type="image/png" href="img\favicon.png">
    <style>
    </style>
  </head>

  <body onload="hideMessage()">
    <%@ include file="admin_dashboard.jsp" %>
      <!-- Content -->
      <div class="content">
        <form name="form" action='newmachine' method="POST">
        <div class="container mt-5">
          <div class="row justify-content-center">
            <div class="col-md-6">
              <h5>Install New Pump</h5>

              <div class="input-group">
                <input type="text" name="machineCode" class="form-control" placeholder="Enter Machine Code"
                  aria-label="Enter your text here" aria-describedby="button-addon">
              </div>
              <div class="text-center mt-3">
                <button class="btn btn-light" type="submit" value="Submit" id="button-addon">Add</button>
              </div>
              <br>
              <center><p id="message">${message}</p></center>
 
            </div>
          </div>
        </div>
        </form>
      </div>
      
      <script>
        // Function to hide the message after 3 seconds
        function hideMessage() {
            setTimeout(function() {
                var messageElement = document.getElementById("message");
                messageElement.style.display = "none";
            }, 3000); // 3000 milliseconds = 3 seconds
        }
    </script>

      <!-- Bootstrap JS -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>

  </html>
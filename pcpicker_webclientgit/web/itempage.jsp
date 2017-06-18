<%-- 
    Document   : itempage
    Created on : 06 3, 17, 9:01:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="css/test.css">
         <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAcA9vCw-f0B8M61ei7LkO-u2tvo0l7m5A&libraries=places"></script>
    </head>
    <body>
    
    
    <label for="locationTextField">Location</label>
        <input id="locationTextField" type="text" size="50">
         
        <script>
            function init() {
                var input = document.getElementById('locationTextField');
                var autocomplete = new google.maps.places.Autocomplete(input);
            }
 
            google.maps.event.addDomListener(window, 'load', init);
        </script>
    
    </body>
    
   
</html>

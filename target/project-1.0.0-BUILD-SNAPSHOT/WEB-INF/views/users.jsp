<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Added User</title>
      <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
   </head>
   <body>

      <h2>Submitted User Information</h2>
      <table>
         <tr>
            <td>Username</td>
            <td>${username}</td>
             <td><form:errors path="username" cssClass="error" /></td>
         </tr>
         <tr>
            <td>Age</td>
            <td>${password}</td>
         </tr>    
         <tr>
            <td>Address</td>
            <td>${address}</td>
         </tr>  
         <tr>
            <td>Subscribed to Newsletter</td>
            <td>${receivePaper}</td>
         </tr>    
         <tr>
            <td>Favorite Web Frameworks</td>
            <td> <% String[] favoriteFrameworks = (String[])request.getAttribute("favoriteFrameworks");
            for(String framework: favoriteFrameworks) {
               out.println(framework);
            }
            %></td>
         </tr>     	  
      </table>  
   </body>
</html>
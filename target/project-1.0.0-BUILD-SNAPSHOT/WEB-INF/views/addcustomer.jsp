<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Adding user ${name}</title>
      <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
   </head>
   <body>

      <h2>User Information</h2>
      <form:form commandName="userinfo" method = "POST" action = "/project/addUser">
         <table>
            <tr>
               <td><form:label path = "username">User Name</form:label></td>
               <td><form:input path = "username" /></td>
               <td><form:errors path="username" cssClass="error" /></td>
            </tr>
            <tr>
               <td><form:label path = "age">Age</form:label></td>
               <td><form:input path = "age" /></td>
            </tr>  
            <tr>
               <td><form:label path = "address">Address</form:label></td>
               <td><form:textarea path = "address" rows = "5" cols = "30" /></td>
            </tr>  
            <tr>
               <td><form:label path = "receivePaper">Subscribe Newsletter</form:label></td>
               <td><form:checkbox path = "receivePaper" /></td>
            </tr> 
            <tr>
               <td><form:label path = "favoriteFrameworks">Favorite Web Frameworks</form:label></td>
               <td><form:checkboxes items = "${webFrameworkList}" path = "favoriteFrameworks" /></td>       
            </tr> 
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>
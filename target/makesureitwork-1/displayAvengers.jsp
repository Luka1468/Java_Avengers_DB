<%-- 
    Document   : displayAvengers
    Created on : Nov 8, 2019, 12:34:03 PM
    Author     : oicr1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Putting the include tag in order to use JSTL in the page--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Avengers</title>
    </head>

    <body>

        <%-- This will check to see if an error has occured, and if
        it has it will display the error then give the user the option
        to go back to the index page--%>
        <c:choose>
            <c:when test="${error != null}">
                <h1>An Error Has Occurred</h1>
                <%-- This is the error attribute that was set in the
                GetAvengers servlet--%>
                <h2>${error}</h2>
                <br>
            </c:when>
            <%-- If there is no error then this block will display the Avengers--%>
            <c:otherwise>
                <h1>Here are the Avengers</h1>
                <c:forEach var="var" items="${avengers}">
                    <%-- This will display the name of the aveneger and their description--%>
                    <h2>${var.name}, ${var.description}</h2>
                    <%-- This will display the avenger's power source--%>
                    <h3>Power Source: ${var.powerSource.description}</h3> 
                </c:forEach>
            </c:otherwise>
        </c:choose>

        <%-- This link will, when clicked will take the user back to the index page--%>
        <p><a href="index.html">Back to index page</a></p>   
    </body>
</html>

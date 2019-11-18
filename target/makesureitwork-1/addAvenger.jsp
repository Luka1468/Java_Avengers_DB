<%-- 
    Document   : AddAvenger
    Created on : Nov 8, 2019, 12:40:37 PM
    Author     : oicr1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ps" uri="/WEB-INF/tlds/PowerSourceHandler_library.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment 2</title>
    </head>
    <body>
        <h1>Add an Avenger</h1>

        <form action="AddAvenger.do" method="POST">
            Name: <input type="text" name="name" required>
            <br><br>
            Description: <input type="text" name="description" required>
            <br><br>

            <ps:PowerSourceHandler />

            <br><br>

            <input type="submit" value="Submit">
        </form>


    </body>
</html>

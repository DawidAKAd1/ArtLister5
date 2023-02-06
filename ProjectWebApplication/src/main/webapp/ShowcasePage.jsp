<%-- 
    Document   : ShowcasePage
    Created on : 19-Nov-2022, 20:26:56
    Author     : SethJ
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.VSProject"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Showcase</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
    </style>
    <body>
        <h1>Projects</h1>
        
        <form id="form1" action="VSArtListerController" method="GET">
            <input type="hidden" name="ACTION" value="HOME">
                <table>
                    <tbody>
                        <tr>
                            <th>Project ID</th>
                            <th>Project Name</th>
                            <th>Project Description</th>
                             <th>First Name</th>
                        <th>Surname</th>
                        <th>Email Address</th>
                        <th>Username</th>
                            <th>View</th>
                        </tr>
                        <tr>
                    <c:forEach var="sProjects" items="${ShowcaseProjects}">
                        <tr>
                            <td><c:out value="${sProjects.projectID}"></c:out></td>
                            <td><c:out value="${sProjects.projectName}"></c:out></td>
                            <td><c:out value="${sProjects.projectDescription}"></c:out></td>
                             <td><c:out value="${sProjects.userObject.firstName}"></c:out></td>
                            <td><c:out value="${sProjects.userObject.surname}"></c:out></td>
                            <td><c:out value="${sProjects.userObject.emailAddress}"></c:out></td>
                            <td><c:out value="${sProjects.userObject.userName}"></c:out></td>
                            <td><a href="VSArtListerController?ACTION=GETPROJETCINFO&ProjectID=<c:out value='${sProjects.projectID}'/>">view</a></td>
                            
                        </tr>

                    </c:forEach>
                        
                    </tr>
                </table>
        </form>
        
    </body>
</html>
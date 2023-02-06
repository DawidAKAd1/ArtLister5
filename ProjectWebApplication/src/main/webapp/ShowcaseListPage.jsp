<%-- 
    Document   : ShowcaseListPage
    Created on : 19-Nov-2022, 20:26:38
    Author     : SethJ
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Showcase List</title>
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
        <h1>Showcases</h1>
        
        <form id="form1" action="VSArtListerController" method="GET">
            <input type="hidden" name="ACTION" value="HOME">
                <table>
                <tbody>
                    <tr>
                        <th>ShowCase ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Image</th>
                        <th>Status</th>
                        <th>View</th>
                    </tr>
                    <tr>
                <c:forEach var="b1" items="${AllShowCases}">
                    <tr>
                        <td><c:out value="${b1.showCaseID}"></c:out></td>
                        <td><c:out value="${b1.name}"></c:out></td>
                        <td><c:out value="${b1.description}"></c:out></td>
                        <td><c:out value="${b1.image}"></c:out></td>
                        <td><c:out value="${b1.status}"></c:out></td>
                        <td><a href="VSArtListerController?ACTION=GETSHOWCASEPROJETCS&ShowcaseID=<c:out value='${b1.showCaseID}'/>">view</a></td>
                    </tr>

                </c:forEach>
                </tr>
            </table>
        </form>
    </body>
</html>

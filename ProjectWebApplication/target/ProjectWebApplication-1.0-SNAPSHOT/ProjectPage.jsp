<%-- 
    Document   : ProjectPage
    Created on : 28 Nov 2022, 10:21:21
    Author     : k00262792
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.VSProjectAsset"%>
<%@page import="Model.VSUser"%>
<%@page import="Model.VSComments"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Page</title>
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
                        <th>Asset ID</th>
                        <th>Project ID</th>
                        <th>Asset Name</th>
                        <th>Asset Description</th>
                        <th>Asset Type</th>
                        <th>Asset</th>
                    </tr>
                    <tr>
                        <c:forEach var="iProjects" items="${ProjectsInfo}">
                        <tr>
                            <td><c:out value="${iProjects.assetID}"></c:out></td>
                            <td><c:out value="${iProjects.projectID}"></c:out></td>
                            <td><c:out value="${iProjects.assetName}"></c:out></td>
                            <td><c:out value="${iProjects.assetDescription}"></c:out></td>
                            <td><c:out value="${iProjects.assetType}"></c:out></td>
                            <td><c:out value="${iProjects.asset}"></c:out></td>
                            </tr>

                    </c:forEach>
                    </tr>
                    
                    
            </table>
        </form>
        
        <br>
        
        <form id="form1" action="VSArtListerController" method="GET">
            <input type="hidden" name="ACTION" value="HOME">
            <table>
                <tbody>
                    <tr>
                        <th>Comment ID</th>
                        <th>Comment Details</th>
                        <th>Approved</th>
                        <th>User ID</th>
                        <th>Project ID</th>
                    </tr>
                    <tr>
                        <c:forEach var="cProjects" items="${ProjectsComment}">
                        <tr>
                            <td><c:out value="${cProjects.commentID}"></c:out></td>
                            <td><c:out value="${cProjects.commentDetails}"></c:out></td>
                            <td><c:out value="${cProjects.approved}"></c:out></td>
                            <td><c:out value="${cProjects.userID}"></c:out></td>
                            <td><c:out value="${cProjects.projectID}"></c:out></td>
                        </tr>

                    </c:forEach>
                    </tr>
                    
                    
            </table>
        </form>
        
        
    </body>
</html>

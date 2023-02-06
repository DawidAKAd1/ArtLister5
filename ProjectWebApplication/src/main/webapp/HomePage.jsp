<%-- 
    Document   : HomePage
    Created on : 13-Nov-2022, 19:03:22
    Author     : SethJ
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/CSS/styles.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter">
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
    <div class="grid">

        <div class="logo"><p style="font-weight: bolder; color: #1B7164;">ART</p><p style="font-weight: 400; color: #1B7164;">LISTER</p></div>

        <div class="topnav">
                <ul class = "nav">
                    <li><a href="/ProjectWebApplication/VSArtListerController" class="current">HOME</a></li>
                    <li><a href="/ProjectWebApplication/VSArtListerController?ACTION=SHOWCASELISTPAGE" class="current">SHOWCASES</a></li>
                    <li><a href="#About" class="current">ABOUT</a></li>
                    <li><a href="#Contact" class="current">CONTACT</a></li>
                </ul>
        </div>

        <div class="user"><h1>user</h1></div>


        <div class="content">
            <form id="form1" action="VSArtListerController" method="GET">
                <button type="submit" name="ACTION" value="SHOWCASELISTPAGE">View</button>
            </form>
        
            <br>
        
            <h2>Live Showcases</h2>

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
                        </tr>
                        <tr>
                           <c:forEach var="b2" items="${AllLiveShowCases}">
                        <tr>
                            <td><c:out value="${b2.showCaseID}"></c:out></td>
                            <td><c:out value="${b2.name}"></c:out></td>
                            <td><c:out value="${b2.description}"></c:out></td>
                            <td><c:out value="${b2.image}"></c:out></td>
                            <td><img src="Images${b2.image}" width="100" height="100"></td>
                            <td><c:out value="${b2.status}"></c:out></td>
                        </tr>

                        </c:forEach>
                        </tr>
                </table>

              <br>
                <h2>Projects</h2>

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
                            <c:forEach var="d" items="${AllProjectAsset}">
                            <tr>
                                <td><c:out value="${d.assetID}"></c:out></td>
                                <td><c:out value="${d.projectID}"></c:out></td>
                                <td><c:out value="${d.assetName}"></c:out></td>
                                <td><c:out value="${d.assetDescription}"></c:out></td>
                                <td><c:out value="${d.assetType}"></c:out></td>
                                <td><c:out value="${d.asset}"></c:out></td>
                            </tr>

                            <div class="card" data-aos="fade-in">
                                <img id="disappear" src="#"/>
                                <div>
                                  <h2><c:out value="${d.assetName}"></c:out></h2>
                                  <p>
                                    <c:out value="${d.assetDescription}"></c:out>
                                  </p>
                                  <a href="VSArtListerController?ACTION=GETPROJETCINFO&ProjectID=<c:out value='${d.projectID}' />" class="btn">Read More</a>
                                </div>
                            </div>

                        </c:forEach>
                        </tr>
                </table>
            </form>

        </div>

        <div class="footer">
            <footer>		
                <a href="index.html">Home</a>
                <a href="html/UnderConstruction.html">About</a>
                <a href="html/UnderConstruction.html">Services</a>
                <a href="html/UnderConstruction.html" >Contact</a>
            </footer>
        </div>

    </div>

    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
      AOS.init({
          offset: 400, // offset (in px) from the original trigger point
          delay: 0, // values from 0 to 3000, with step 50ms
          duration: 1000 // values from 0 to 3000, with step 50ms
        });
    </script>
    </body>
</html>

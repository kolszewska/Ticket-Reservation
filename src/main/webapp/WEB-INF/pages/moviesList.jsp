<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="timeTag" uri="/timeTag"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
    </head>
    <body><div class="container">
        <jsp:include page="navbar.jsp"/>
    </div>
    <div class="description">
        <h1>Ticket Reservation</h1>
        <p class="lead">If you want to reserve a ticket just pick the show you are interested from the list below.</p>
    </div>
        <div class="container">
            <table id="shows" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Genre</th>
                        <th>Screening time</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="moviesList" items="${moviesList}">
                        <tr>
                            <td>${moviesList.name}</td>
                            <td>${moviesList.genre}</td>
                            <td id = "screeningDate">
                                <c:forEach var="screeningList" items="${screeningList}">
                                    <c:if test="${screeningList.movie_id.id == moviesList.id}">
                                        <span onclick="reservation(${screeningList.id})" class="screeningHour"><timeTag:TimeTag date="${screeningList.time}"></timeTag:TimeTag></span>
                                    </c:if>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
    <script>
        function reservation(screeningId) {
            location.href="reservation/screening/" + screeningId;
        }
    </script>
    </body>
</html>
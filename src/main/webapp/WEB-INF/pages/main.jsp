<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
        <p class="lead">If you wan to reserve a ticket just pick the show you are interested from the list below.</p>
    </div>
        <div class="container">
            <table id="shows" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Genre</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="showList" items="${showList}">
                        <tr>
                            <td>${showList.name}</td>
                            <td>${showList.date}</td>
                            <td>${showList.genre}</td>
                            <td width="100px"><button type="button" style="width: auto" class="btn btn-warning col-lg-3"  onclick="">Book tickets</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
    </body>
</html>


<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <p class="lead">Confirm your reservation</p>
</div>
<table>
    <tr>
        <td>FirstName</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>LastName</td>
        <td>${lastName}</td>
    </tr>
    <tr>
        <td>email</td>
        <td>${email}</td>
    </tr>
    <tr>
        <td>telephone</td>
        <td>${telephone}</td>
    </tr>
    <tr>
        <td>showId</td>
        <td>${showId}</td>
    </tr>
    <tr>
        <td>numberOfTickets</td>
        <td>${numberOfTickets}</td>
    </tr>
</table>

<jsp:include page="footer.jsp"/>
</body>
</html>


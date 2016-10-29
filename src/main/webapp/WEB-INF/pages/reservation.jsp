<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <p class="lead">Fill in every field below to reserve your tickets</p>
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
            <tr>
                <td>${show.name}</td>
                <td>${show.date}</td>
                <td>${show.genre}</td>
            </tr>
        </tbody>
    </table>
</div>
<div class=container>
    <form:form action="/addReservation/${show.id}" name="form" method="POST">
        <div class="form-group row">
            <label for="name-input" class="col-xs-2 col-form-label">First name</label>
            <div class="col-xs-10">
                <input class="form-control" type="text"  id="name-input" name="firstName">
            </div>
        </div>
        <div class="form-group row">
            <label for="surname-input" class="col-xs-2 col-form-label">Last Name</label>
            <div class="col-xs-10">
                <input class="form-control" type="search" id="surname-input" name="lastName">
            </div>
        </div>
        <div class="form-group row">
            <label for="email-input" class="col-xs-2 col-form-label">Email</label>
            <div class="col-xs-10">
                <input class="form-control" type="email" id="email-input" name="email">
            </div>
        </div>
        <div class="form-group row">
            <label for="tel-input" class="col-xs-2 col-form-label">Telephone</label>
            <div class="col-xs-10">
                <input class="form-control" type="tel" id="tel-input" name="telephone">
            </div>
        </div>
        <div class="form-group row">
            <label for="tickets-number-input" class="col-xs-2 col-form-label">Number of tickets</label>
            <div class="col-xs-10">
                <input class="form-control" type="number" id="tickets-number-input" name="numberOfTickets">
            </div>
        </div>
        <button type="submit" class="btn btn-warning pull-right">Book tickets</button>
    </form:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>


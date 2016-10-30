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
    <p class="lead">Confirm your data</p>
</div>
<div class=container>
    <form:form action="/confirmReservation/${reservation.screening_id.id}" name="form" method="POST">
        <div class="form-group row">
            <label for="name-input" class="col-xs-2 col-form-label">First name</label>
            <div class="col-xs-10">
                <input class="form-control" type="text"  id="name-input" name="firstName"  readonly="readonly" value="${reservation.firstName}">
            </div>
        </div>
        <div class="form-group row">
            <label for="surname-input" class="col-xs-2 col-form-label">Last Name</label>
            <div class="col-xs-10">
                <input class="form-control" type="search" id="surname-input" name="lastName"  readonly = "readonly" value="${reservation.lastName}">
            </div>
        </div>
        <div class="form-group row">
            <label for="email-input" class="col-xs-2 col-form-label">Email</label>
            <div class="col-xs-10">
                <input class="form-control" type="email" id="email-input" name="email" readonly = "readonly" value="${reservation.email}">
            </div>
        </div>
        <div class="form-group row">
            <label for="tel-input" class="col-xs-2 col-form-label">Telephone</label>
            <div class="col-xs-10">
                <input class="form-control" type="tel" id="tel-input" name="telephone" readonly = "readonly" value="${reservation.telephone}">
            </div>
        </div>
        <div class="form-group row">
            <label for="tickets-number-input" class="col-xs-2 col-form-label">Number of tickets</label>
            <div class="col-xs-10">
                <input class="form-control" type="number" id="tickets-number-input" min="1" max="10" readonly = "readonly" name="numberOfTickets" value="${reservation.numberOfTickets}">
            </div>
        </div>
        <button type="submit" class="btn btn-warning pull-right">Confirm data</button>
    </form:form>
</div>
<jsp:include page="footer.jsp"/>

</body>
</html>


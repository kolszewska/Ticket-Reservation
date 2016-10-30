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
<div class=col-lg-12>
    <div class="container">
        <table id="reservation" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>E-mail</th>
                <th>Telephone</th>
                <th>Number of tickets</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${firstName}</td>
                <td>${lastName}</td>
                <td>${email}</td>
                <td>${telephone}</td>
                <td>${numberOfTickets}</td>
            </tr>
            </tbody>
        </table>
    </div>
<div class="description">
    <p class="lead">Note: An e-mail with confirmation link will be send on the address you provided<br/>You have 15 minutes to confirm reservation</p>
</div>
    <div class="col-xs-9">
        <button type="button" style="" class="btn btn-warning pull-right">Confirm reservation</button>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>


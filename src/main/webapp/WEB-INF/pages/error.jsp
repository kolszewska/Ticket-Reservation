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
        <body>
            <div class="container">
                <jsp:include page="navbar.jsp"/>
            </div>
            <div class="description">
                <h1>Uh oh! Something went wrong!</h1>
                <p class="lead">Handling errors and exceptions not yet implemented. Ooops.</p>
            </div>
        <jsp:include page="footer.jsp"/>
        </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search Venues</title>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="center">
        <h1>Search Venues</h1>
   	</div>

   	<div class="center">
   	    <form:form method="POST" modelAttribute="searchForm" id="searchForm">
                <div>
                     <form:input class="formInput" type="search" path="location" id="location" placeholder="Search location..." required="true" maxlength="30" />
                </div>
                <div class="checkBox">
                     <form:checkbox  path="recommended" id="recommended" /><label for="recommended">Recommended</label>
                </div>
        </form:form>
    </div>

    <c:if test="${not empty venues}">
    <!-- <p class="center">Results: ${fn:length(venues)}</p> -->
    <div>
        <c:forEach items="${venues}" var="venue">
                <div class="box effect1">
                    <c:if test="${not empty venue.categories}">
                        <c:if test="${not empty venue.categories[0].icon}">
                            <img src="${venue.categories[0].icon.prefix}bg_88${venue.categories[0].icon.suffix}" />
                        </c:if>
                    </c:if>
                    <h3>${venue.name}</h3>
                    <c:if test="${not empty venue.location}">
                        <p>${venue.location.address}, ${venue.location.city}, ${venue.location.state}, ${venue.location.postalCode}, ${venue.location.country}</p>
                    </c:if>
                    <c:if test="${not empty venue.contact}">
                        <p>${venue.contact.phone} <a class="venueUrl" href="${venue.url}" target="_blank">${venue.url}</a></p>
                    </c:if>
                    <c:if test="${empty venue.contact}">
                        <p><a class="venueUrl" href="${venue.url}" target="_blank">${venue.url}</a></p>
                    </c:if>
                    <c:if test="${not empty venue.categories}">
                        <p class="inline">Category: <b>${venue.categories[0].name}</b> - Rating: <b>${venue.rating}</b></p>
                    </c:if>
                    <c:if test="${empty venue.categories}">
                        <p class="inline">Rating: ${venue.rating}</p>
                    </c:if>
                    <c:if test="${not empty venue.contact}">
                        <c:if test="${not empty venue.contact.twitter}">
                          <a class="floater" href="http://www.twitter.com/${venue.contact.twitter}" target="_blank">
                            <img width="35" src="<c:url value='/static/twitter_icon.png' />" />
                          </a>
                        </c:if>
                        <c:if test="${not empty venue.contact.facebookUsername}">
                          <a class="floater" href="http://www.facebook.com/${venue.contact.facebookUsername}" target="_blank">
                            <img width="35" src="<c:url value='/static/facebook_icon.png' />" />
                          </a>
                        </c:if>
                    </c:if>
                </div>
        </c:forEach>
    </div>
    </c:if>
</body>
</html>
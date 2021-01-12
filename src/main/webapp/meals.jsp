<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<%--<%@taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>--%>
<html>
<head>
    <title>List Meals</title>
    <style>
        .normal {color: green}
        .excess {color: red}
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a> </h3>
    <hr/>
    <h2>Meals</h2>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Data</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
        </thead>
        <tr>
            <c:forEach var="meal" items="${mealTos}">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
                <tr class="${meal.excess ? 'excess' : 'normal'}">
                <td>${fn:formatDateTime(meal.dateTime)}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                </tr>
            </c:forEach>
        </tr>
    </table>
</section>
</body>
</html>

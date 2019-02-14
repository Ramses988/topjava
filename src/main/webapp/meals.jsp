<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Meals List</title>
</head>
<body>
    <h3>Meals List</h3>

    <table cellpadding=10>
        <tr>
        <th>Date/Time</th>
        <th>Description</th>
        <th>Calories</th>
        <th colspan=2>Action</th>
        </tr>
            <c:forEach items="${requestScope.mealsList}" var="mealto">
                <tr bgcolor="${mealto.isExcess() ? '#f08080' : '#90ee90'}">
                    <fmt:parseDate value="${mealto.getDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}" /></td>
                <td>${mealto.getDescription()}</td>
                <td>${mealto.getCalories()}</td>
                    <td><a href="meals?action=edit&id=${mealto.getId()}">Edit</a></td>
                    <td><a href="meals?action=delete&id=${mealto.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
    </table>

    <p><a href="meals?action=add">Добавить</a></p>

</body>
</html>
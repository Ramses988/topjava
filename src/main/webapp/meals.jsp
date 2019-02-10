<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Meals List</title>
</head>
<body>
    <h3>Meals List</h3>

    <table border="1px" cellpadding=10>
        <tr>
        <th>Date/Time</th>
        <th>Description</th>
        <th>Calories</th>
        </tr>
            <c:forEach items="${requestScope.mealsList}" var="mealto">
                <tr bgcolor="${mealto.isExcess() ? '#f08080' : '#90ee90'}">
                    <fmt:parseDate value="${mealto.getDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}" /></td>
                <td>${mealto.getDescription()}</td>
                <td>${mealto.getCalories()}</td>
                </tr>
            </c:forEach>
    </table>

</body>
</html>
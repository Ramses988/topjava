<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create/Edit</title>
</head>
<body>
    <h3>Create / Edit</h3>

    <form method="post" action="meals" name="addMeals">
        <input type="hidden" name="id" value="${requestScope.meal.getId()}"><br />
        Date: <input type="datetime-local" name="dateTime" value="${requestScope.meal.getDateTime()}"><br />
        Description: <input type="text" name="description" value="${requestScope.meal.getDescription()}"><br />
        Calories: <input type="text" name="calories" value="${requestScope.meal.getCalories()}"><br />
        <input type="submit" value="Submit">
    </form>
</body>
</html>

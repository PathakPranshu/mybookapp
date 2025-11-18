<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="cont">
        <h2>Add New Book</h2>
        <c:if test="${not empty error}">
            <div class="err">${error}</div>
        </c:if>
        <form action="/save" method="post">
            <div class="form-g">
                <label>Title:</label>
                <input type="text" name="title" required />
            </div>
            <div class="form-g">
                <label>Price:</label>
                <input type="number" step="0.01" name="price" required />
            </div>
            <div class="form-g">
                <label>Author:</label>
                <select name="authorId">
                    <c:forEach items="${listAuthors}" var="auth">
                        <option value="${auth.id}">${auth.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-s">Save Book</button>
            <a href="/" class="btn btn-p">Cancel</a>
        </form>
    </div>
    <footer><span>Shri Harivansh. 2025 MyBookApp. 2023EBCS037</span></footer>
</body>
</html>
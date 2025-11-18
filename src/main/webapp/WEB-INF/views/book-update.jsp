<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="cont">
        <h2>Update Book</h2>
        <form action="/update" method="post">
            <input type="hidden" name="id" value="${book.id}" />
            <div class="form-g">
                <label>Title:</label>
                <input type="text" name="title" value="${book.title}" required />
            </div>
            <div class="form-g">
                <label>Price:</label>
                <input type="number" step="0.01" name="price" value="${book.price}" required />
            </div>
            <div class="form-g">
                <label>Author:</label>
                <select name="authorId">
                    <c:forEach items="${listAuthors}" var="auth">
                        <option value="${auth.id}" ${auth.id == book.author.id ? 'selected' : ''}>${auth.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-p">Update</button>
        </form>
    </div>
    <footer><span>Shri Harivansh. 2025 MyBookApp. 2023EBCS037</span></footer>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 10/01/2022
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<c:import url="header.jsp"/>
<c:if test="${user != null }">
    <div>Bonjour ${user.getPrenom()} !</div>
</c:if>
<div class="m-5">
    <h1>${post.getTitre()}</h1>
    <h2>${post.getResume()}</h2>
    <h3>${post.getContenu()}</h3>
    <h4>${post.getCreated_at()}</h4>
    <h5>${post.getNomAuteur()} ${post.getPrenomAuteur()}</h5>
</div>
<c:if test="${user != null }">
<form class="container mt-5 w-25 d-inline-block" action="${pageContext.request.contextPath}/detailpost-servlet" method="post">
    <input type="hidden" name="purpose" value="C">
    <input type="hidden" name="post" value="${post.getId()}">
    <div class="form-group">
        <label for="commentInput">Commentaire</label>
        <input type="text" class="form-control" id="commentInput" name="comment">
    </div>
    <button type="submit" class="btn btn-primary mt-3">Ajouter un commentaire</button>
</form>
</c:if>
<c:if test="${commentList != null }">
    <c:forEach items= "${ commentList }" var="element">
        <div class="m-5">
            <h3>${element.getNomAuteur()} ${element.getPrenomAuteur()}</h3>
            <h5>${element.getContenu()}</h5>
        </div>
    </c:forEach>
</c:if>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 12/01/2022
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
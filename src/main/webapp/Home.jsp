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
<c:if test="${postList != null }">
    <c:forEach items= "${ postList }" var="element">
        <div class="m-5">
            <h1>${element.getTitre()}</h1>
            <h2>${element.getResume()}</h2>
            <h3>${element.getContenu()}</h3>
            <h4>${element.getCreated_at()}</h4>
            <h5>${element.getNomAuteur()} ${element.getPrenomAuteur()}</h5>
            <form action="${pageContext.request.contextPath}/detailpost-servlet" method="post">
                <input type="hidden" name="post" value="${element.getId()}">
                <input type ="submit" value = "Détails">
            </form>
        </div>
    </c:forEach>
</c:if>
<script>
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }
</script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

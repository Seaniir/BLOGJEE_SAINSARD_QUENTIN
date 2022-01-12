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
    <div class="d-flex justify-content-center">
        <form class="container mt-5 w-25 d-inline-block" action="${pageContext.request.contextPath}/createpost-servlet" method="post">
            <input type="hidden" name="purpose" value="C">
            <div class="form-group">
                <label for="titreInpute">Titre</label>
                <input type="text" class="form-control" id="titreInpute" name="titre">
            </div>
            <div class="form-group">
                <label for="resumeInput">Résumé</label>
                <input type="text" class="form-control" id="resumeInput" name="resume">
            </div>
            <div class="form-group">
                <label for="contenuInpute">Contenu</label>
                <textarea type="text" class="form-control" id="contenuInpute" name="contenu"></textarea>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Créer un article</button>
        </form>
    </div>
</c:if>
<c:if test="${user == null }">
    <h1>Vous devez être connecté pour créer un article !</h1>
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

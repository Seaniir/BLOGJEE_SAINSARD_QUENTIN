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
<c:if test="${user == null }">
<div class="d-flex justify-content-center">
<form class="container mt-5 w-25 d-inline-block" action="${pageContext.request.contextPath}/signup-servlet" method="post">
    <input type="hidden" name="purpose" value="C">
    <div class="form-group">
        <label for="nameInput">Nom</label>
        <input type="text" class="form-control" id="nameInput" name="nom">
    </div>
    <div class="form-group">
        <label for="prenomInput">Prenom</label>
        <input type="text" class="form-control" id="prenomInput" name="prenom">
    </div>
    <div class="form-group">
        <label for="emailInput">Email</label>
        <input type="email" class="form-control" id="emailInput" name="email">
    </div>
    <div class="form-group">
        <label for="pwdInput">Mot de passe</label>
        <input type="password" class="form-control" id="pwdInput" name="password">
    </div>
    <button type="submit" class="btn btn-primary mt-3">Créer un compte</button>
</form>
<form class="container mt-5 w-25 d-inline-block" action="${pageContext.request.contextPath}/signup-servlet" method="post">
    <input type="hidden" name="purpose" value="L">
    <div class="form-group">
        <label for="emailInputLogin">Email</label>
        <input type="text" class="form-control" id="emailInputLogin" name="email">
    </div>
    <div class="form-group">
        <label for="pwdInputLogin">Mot de passe</label>
        <input type="password" class="form-control" id="pwdInputLogin" name="password">
    </div>
    <button type="submit" class="btn btn-primary mt-3">Connexion</button>
</form>
</div>
</c:if>
<c:if test="${user != null }">
    <form class="container mt-5 w-25" action="${pageContext.request.contextPath}/signup-servlet" method="post">
        <input type="hidden" name="purpose" value="D">
        <button type="submit">Deconnexion !</button>
    </form>
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

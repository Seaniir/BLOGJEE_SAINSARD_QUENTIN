<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/signup-servlet" var="signup"></c:url>
<c:url value="/createpost-servlet" var="createPost"></c:url>
<c:url value="/home-servlet" var="home"></c:url>

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active mx-5 text-light" href="${home}">Accueil</a>
            <c:if test="${user != null }">
                <a class="nav-item nav-link active mx-5 text-light" href="${createPost}">Creer article</a>
            </c:if>
            <a class="nav-item nav-link active mx-5 text-light" href="${signup}">Inscription/Connexion/Deconnexion</a>
        </div>
    </div>
</nav>